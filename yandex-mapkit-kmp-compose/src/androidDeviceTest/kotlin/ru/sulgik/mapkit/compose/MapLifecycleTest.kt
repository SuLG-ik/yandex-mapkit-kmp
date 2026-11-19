package ru.sulgik.mapkit.compose

import android.os.Bundle
import android.os.SystemClock
import android.view.InputDevice
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.test.interaction.AnimateAndClose
import ru.sulgik.mapkit.test.interaction.CoverToggle
import ru.sulgik.mapkit.test.interaction.LifecycleMapTag
import ru.sulgik.mapkit.test.interaction.LifecycleOverlay
import ru.sulgik.mapkit.test.interaction.MapLifecycleFixture
import ru.sulgik.mapkit.test.interaction.MapLifecycleScenario
import ru.sulgik.mapkit.test.interaction.OpenLifecycleMap
import ru.sulgik.mapkit.test.interaction.SaveViewport
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

private class LifecycleRun {
    val fixture = MapLifecycleScenario()
    val windows = mutableMapOf<Int, MapWindow>()
    val positions = mutableMapOf<String, LayoutCoordinates>()
}

private var activeRun: LifecycleRun? = null

public class MapLifecycleTestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDeviceTestMapKitApiKey()
        val run = checkNotNull(activeRun)
        run.positions.clear()
        run.fixture.customCamera = savedInstanceState?.getBoolean("customCamera") ?: false
        run.fixture.selected = savedInstanceState?.getBoolean("selected") ?: false
        setContent {
            MapLifecycleFixture(
                scenario = run.fixture,
                onWindowAttached = { id, window -> run.windows[id] = window },
                onPositioned = { name, coordinates -> run.positions[name] = coordinates },
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val fixture = checkNotNull(activeRun).fixture
        outState.putBoolean("customCamera", fixture.customCamera)
        outState.putBoolean("selected", fixture.selected)
    }
}

public class MapLifecycleTest {

    @Test
    public fun coveredAndRecreatedMapKeepsSavedViewportAndReleasesOldWindows() {
        val run = LifecycleRun()
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        instrumentation.runOnMainSync { activeRun = run }
        try {
            ActivityScenario.launch(MapLifecycleTestActivity::class.java).use { host ->
                val driver = Driver(host, run)
                driver.tapMap(id = 1, saved = false)
                driver.waitForEvent("tap 1")

                driver.tapButton(CoverToggle)
                driver.waitForOverlay(visible = true)
                driver.tapMap(id = 1, saved = false)
                driver.waitForEvent("overlay 1")
                driver.tapButton(CoverToggle)
                driver.waitForOverlay(visible = false)
                driver.tapMap(id = 1, saved = false)
                driver.waitForEvent("tap 1", occurrences = 2)
                host.onActivity { assertTrue(run.windows.getValue(1).isValid) }

                driver.tapButton(SaveViewport)
                driver.waitForEvent("ready 1 camera=true selected=true")
                host.moveToState(Lifecycle.State.CREATED)
                host.moveToState(Lifecycle.State.RESUMED)
                driver.tapMap(id = 1, saved = true)
                driver.waitForEvent("tap 1", occurrences = 3)
                host.onActivity { assertTrue(run.windows.getValue(1).isValid) }

                for (id in 1..2) {
                    driver.tapButton(AnimateAndClose)
                    driver.waitForWindowRelease(id)
                    driver.tapButton(OpenLifecycleMap)
                    driver.tapMap(id = id + 1, saved = true)
                    driver.waitForEvent("tap ${id + 1}")
                }

                host.recreate()
                driver.waitForWindowRelease(3)
                driver.tapMap(id = 4, saved = true)
                driver.waitForEvent("tap 4")
                host.onActivity {
                    assertTrue(run.windows.getValue(4).isValid)
                    assertEquals(
                        listOf(
                            "attach 1", "ready 1 camera=false selected=false", "tap 1", "overlay 1", "tap 1",
                            "ready 1 camera=true selected=true", "tap 1", "animate 1", "detach 1",
                            "attach 2", "ready 2 camera=true selected=true", "tap 2", "animate 2", "detach 2",
                            "attach 3", "ready 3 camera=true selected=true", "tap 3", "detach 3",
                            "attach 4", "ready 4 camera=true selected=true", "tap 4",
                        ),
                        run.fixture.events.toList(),
                    )
                }
            }
        } finally {
            instrumentation.runOnMainSync { activeRun = null }
        }
    }

    private class Driver(
        private val host: ActivityScenario<MapLifecycleTestActivity>,
        private val run: LifecycleRun,
    ) {
        private var lastTouch = "no pointer injected"
        private var previousMap: Int? = null
        private var previousMapTapUp = 0L

        fun tapMap(id: Int, saved: Boolean) {
            waitForEvent("ready $id camera=$saved selected=$saved")
            if (previousMap == id) waitForSingleTapInterval()
            touch("map $id") {
                val target = run.fixture.target
                if (target?.id != id) null else screenPoint(LifecycleMapTag, target.x, target.y)
            }
            previousMap = id
            previousMapTapUp = SystemClock.uptimeMillis()
        }

        private fun waitForSingleTapInterval() {
            val doubleTapTimeout = maxOf(ViewConfiguration.getDoubleTapTimeout().toLong(), 300L)
            val nextSingleTap = previousMapTapUp + doubleTapTimeout + 1L
            val remaining = nextSingleTap - SystemClock.uptimeMillis()
            if (remaining > 0L) SystemClock.sleep(remaining)
        }

        fun tapButton(button: String) {
            touch(button) { screenPoint(button, 0.5f, 0.5f) }
        }

        fun waitForOverlay(visible: Boolean) {
            waitUntil("overlay visible=$visible") {
                (run.positions[LifecycleOverlay]?.isAttached == true) == visible
            }
            val frame = CountDownLatch(1)
            host.onActivity { activity ->
                val decor = activity.window.decorView
                decor.postOnAnimation { decor.postOnAnimation { frame.countDown() } }
            }
            assertTrue(frame.await(5L, TimeUnit.SECONDS), "No frame after overlay visible=$visible")
        }

        fun waitForWindowRelease(id: Int) {
            waitForEvent("detach $id")
            waitUntil("window $id release") { !run.windows.getValue(id).isValid }
            host.onActivity { assertFalse(run.windows.getValue(id).isValid) }
        }

        fun waitForEvent(event: String, occurrences: Int = 1) {
            waitUntil("'$event' ($occurrences)") { run.fixture.events.count { it == event } >= occurrences }
        }

        private fun screenPoint(name: String, x: Float, y: Float): Offset? {
            val layout = run.positions[name] ?: return null
            if (!layout.isAttached) return null
            val point = layout.localToScreen(Offset(layout.size.width * x, layout.size.height * y))
            return if (point.x.isFinite() && point.y.isFinite()) point else null
        }

        private fun waitUntil(label: String, predicate: (MapLifecycleTestActivity) -> Boolean) {
            val deadline = SystemClock.uptimeMillis() + 10_000L
            var events = emptyList<String>()
            while (SystemClock.uptimeMillis() < deadline) {
                var ready = false
                host.onActivity {
                    ready = predicate(it)
                    events = run.fixture.events.toList()
                }
                if (ready) return
                SystemClock.sleep(20L)
            }
            throw AssertionError("Waiting for $label. Last input: $lastTouch. Events: $events")
        }

        private fun touch(name: String, position: () -> Offset?) {
            var point: Offset? = null
            waitUntil("focused screen position of $name") { activity ->
                point = if (activity.hasWindowFocus()) position() else null
                point != null
            }
            val target = assertNotNull(point)
            lastTouch = "$name at screen $target"
            val instrumentation = InstrumentationRegistry.getInstrumentation()
            val start = SystemClock.uptimeMillis()
            for (action in listOf(MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP)) {
                val event = MotionEvent.obtain(start, SystemClock.uptimeMillis(), action, target.x, target.y, 0)
                try {
                    event.source = InputDevice.SOURCE_TOUCHSCREEN
                    instrumentation.sendPointerSync(event)
                } finally {
                    event.recycle()
                }
            }
        }
    }
}
