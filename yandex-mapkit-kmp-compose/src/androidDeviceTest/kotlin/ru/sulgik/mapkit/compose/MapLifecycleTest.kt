package ru.sulgik.mapkit.compose

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.InputDevice
import android.view.MotionEvent
import android.view.PixelCopy
import android.view.SurfaceView
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.geometry.Point
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
import com.yandex.mapkit.mapview.MapView as NativeMapView

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
            Box(Modifier.safeDrawingPadding()) {
                MapLifecycleFixture(
                    scenario = run.fixture,
                    onWindowAttached = { id, window -> run.windows[id] = window },
                    onPositioned = { name, coordinates -> run.positions[name] = coordinates },
                )
            }
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
                driver.backgroundAndTapMap(id = 1)
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

        fun backgroundAndTapMap(id: Int) {
            var savedTarget: Point? = null
            host.onActivity { savedTarget = run.windows.getValue(id).map.cameraPosition.target }
            val worldPoint = assertNotNull(savedTarget)

            host.moveToState(Lifecycle.State.CREATED)
            host.moveToState(Lifecycle.State.RESUMED)
            waitForMapSurfaceFrame()
            waitForFrame("map resume")
            waitForSingleTapInterval()
            touch("resumed map $id") { activity ->
                val surface = activity.window.decorView.mapSurface() ?: return@touch null
                if (!surface.isShown || !surface.holder.surface.isValid) return@touch null
                val window = run.windows.getValue(id)
                if (!window.isValid || window.width == 0 || window.height == 0) return@touch null
                val projected = window.worldToScreen(worldPoint) ?: return@touch null
                val origin = IntArray(2)
                surface.getLocationOnScreen(origin)
                val point = Offset(
                    x = origin[0] + projected.x / window.width * surface.width,
                    y = origin[1] + projected.y / window.height * surface.height,
                )
                if (point.x.isFinite() && point.y.isFinite()) point else null
            }
            previousMap = id
            previousMapTapUp = SystemClock.uptimeMillis()
        }

        private fun waitForMapSurfaceFrame() {
            val probe = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
            val main = Handler(Looper.getMainLooper())
            var copyInProgress = false
            var copyResult: Int? = null
            waitUntil("a rendered frame on the resumed native map") { activity ->
                val surface = activity.window.decorView.mapSurface()
                if (surface == null || !activity.hasWindowFocus() || !surface.isShown) return@waitUntil false
                if (!surface.holder.surface.isValid || surface.width == 0 || surface.height == 0) return@waitUntil false
                if (copyResult == PixelCopy.SUCCESS) return@waitUntil true
                if (!copyInProgress) {
                    copyInProgress = true
                    PixelCopy.request(
                        surface,
                        probe,
                        { result ->
                            copyResult = result
                            copyInProgress = false
                        },
                        main,
                    )
                }
                false
            }
            probe.recycle()
        }

        private fun View.mapSurface(): SurfaceView? {
            if (this is NativeMapView) return getChildAt(0) as? SurfaceView
            if (this !is ViewGroup) return null
            return (0 until childCount).firstNotNullOfOrNull { getChildAt(it).mapSurface() }
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
            waitForFrame("overlay visible=$visible")
        }

        private fun waitForFrame(after: String) {
            val frame = CountDownLatch(1)
            host.onActivity { activity ->
                val decor = activity.window.decorView
                decor.postOnAnimation { decor.postOnAnimation { frame.countDown() } }
            }
            assertTrue(frame.await(5L, TimeUnit.SECONDS), "No frame after $after")
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

        private fun touch(name: String, position: (MapLifecycleTestActivity) -> Offset?) {
            var point: Offset? = null
            waitUntil("focused screen position of $name") { activity ->
                point = if (activity.hasWindowFocus()) position(activity) else null
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
