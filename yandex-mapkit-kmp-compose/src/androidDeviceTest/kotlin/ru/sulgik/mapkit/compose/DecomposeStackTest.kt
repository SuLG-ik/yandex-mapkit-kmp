package ru.sulgik.mapkit.compose

import android.os.Bundle
import android.os.SystemClock
import android.view.InputDevice
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.test.interaction.DecomposeBack
import ru.sulgik.mapkit.test.interaction.DecomposeFinish
import ru.sulgik.mapkit.test.interaction.DecomposeFrontA
import ru.sulgik.mapkit.test.interaction.DecomposeFrontB
import ru.sulgik.mapkit.test.interaction.DecomposePushB
import ru.sulgik.mapkit.test.interaction.DecomposeReplace
import ru.sulgik.mapkit.test.interaction.DecomposeSaveCamera
import ru.sulgik.mapkit.test.interaction.DecomposeStackFixture
import ru.sulgik.mapkit.test.interaction.DecomposeTrace
import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

private var runningTrace: DecomposeTrace? = null

public class DecomposeStackTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDeviceTestMapKitApiKey()
        val trace = checkNotNull(runningTrace)
        setContent { DecomposeStackFixture(trace) }
    }
}

public class DecomposeStackTest {
    @Test
    public fun stoppedChildrenRetainStateAndDestroyedChildrenReleaseTheMap() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val trace = DecomposeTrace()
        instrumentation.runOnMainSync { runningTrace = trace }
        try {
            ActivityScenario.launch(DecomposeStackTestActivity::class.java).use { host ->
                val driver = StackDriver(host, trace)
                driver.ready("A1.1", initialA)
                driver.tapButton(DecomposeSaveCamera)
                driver.ready("A1.1", savedA)
                driver.tapMap("A1.1")
                driver.waitFor("show D1", "tap A1.1", "stop A1", "unsubscribe A1.1", "overlap A1 D1", "release A1.1")
                driver.tapButton(DecomposeBack)
                driver.waitFor("destroy D1", "hide D1")
                driver.ready("A1.2", savedA.copy(marker = markerA))

                driver.tapMap("A1.2")
                driver.waitFor("show D2", "tap A1.2", "unsubscribe A1.2", "release A1.2")
                driver.tapButton(DecomposeBack)
                driver.waitFor("destroy D2", "hide D2")
                driver.ready("A1.3", savedA.copy(marker = markerA))

                driver.tapButton(DecomposePushB)
                driver.waitFor("release A1.3", "overlap A1 B1")
                driver.ready("B1.1", initialB)
                driver.tapMap("B1.1")
                driver.waitFor("show D3", "tap B1.1", "release B1.1")
                driver.tapButton(DecomposeBack)
                driver.waitFor("destroy D3", "hide D3")
                driver.ready("B1.2", initialB.copy(marker = markerB))

                driver.tapButton(DecomposeFrontA)
                driver.waitFor("release B1.2")
                driver.ready("A1.4", savedA.copy(marker = markerA))
                driver.tapButton(DecomposeFrontB)
                driver.waitFor("release A1.4")
                driver.ready("B1.3", initialB.copy(marker = markerB))
                driver.tapButton(DecomposeReplace)
                driver.waitFor("stop B1", "destroy B1", "unsubscribe B1.3", "overlap B1 C1", "overlap windows B1.3 C1.1", "fade held")
                driver.ready("C1.1", initialC)
                driver.tapMap("C1.1")
                driver.waitFor("overlap tap B1.3 C1.1")
                host.onActivity { assertFalse("release B1.3" in trace.events, trace.events.toString()) }
                driver.tapButton(DecomposeFinish)
                driver.waitFor("release B1.3")

                host.moveToState(Lifecycle.State.CREATED)
                driver.waitFor("parent stop", "stop C1", "unsubscribe C1.1")
                host.moveToState(Lifecycle.State.RESUMED)
                driver.waitForCount("parent start", 2)
                driver.waitForCount("start C1", 2)
                driver.waitForCount("subscribe C1.1", 2)
                driver.tapMap("C1.1")
                driver.waitFor("show D4", "tap C1.1", "release C1.1")
                driver.expectButton(DecomposeBack)

                host.onActivity {
                    val events = trace.events.toList()
                    assertEquals(
                        listOf("tap A1.1", "tap A1.2", "tap B1.1", "tap C1.1"),
                        events.filter { it.startsWith("tap ") },
                        events.toString(),
                    )
                    assertEquals(2, events.count { it == "unsubscribe C1.1" }, events.toString())
                    assertEquals(1, events.count { it == "attach C1.1" }, events.toString())
                    assertEquals(1, events.count { it == "parent stop" }, events.toString())
                    assertEquals(2, events.count { it == "parent start" }, events.toString())
                    assertEquals(1, events.count { it == "overlap tap B1.3 C1.1" }, events.toString())
                    assertEquals(1, events.count { it == "unsubscribe B1.3" }, events.toString())
                    assertTrue(events.indexOf("unsubscribe B1.3") < events.indexOf("destroy B1"), events.toString())
                    assertTrue(events.indexOf("overlap tap B1.3 C1.1") < events.indexOf("release B1.3"), events.toString())
                    assertTrue(events.indexOf("destroy B1") < events.indexOf("release B1.3"), events.toString())
                    assertTrue(events.none { it.startsWith("unexpected") || it == "destroy A1" }, events.toString())
                }
            }
        } finally {
            instrumentation.runOnMainSync { runningTrace = null }
        }
    }

    private class StackDriver(
        private val host: ActivityScenario<DecomposeStackTestActivity>,
        private val trace: DecomposeTrace,
    ) {
        fun ready(id: String, expected: Scene) {
            waitFor("subscribe $id")
            await("native scene for $id: $expected") {
                val line = trace.events.lastOrNull { it.startsWith("scene $id ") }
                line != null && expected.matches(line)
            }
        }

        fun waitFor(vararg events: String) {
            await(events.joinToString()) { events.all { it in trace.events } }
        }

        fun waitForCount(event: String, count: Int) {
            await("$event count=$count") { trace.events.count { it == event } >= count }
        }

        fun tapButton(name: String) {
            tap(name) { screenPoint(name, Offset(0.5f, 0.5f)) }
        }

        fun expectButton(name: String) {
            await("displayed button $name") { screenPoint(name, Offset(0.5f, 0.5f)) != null }
        }

        fun tapMap(id: String) {
            tap(id) { trace.targets[id]?.let { screenPoint(id.substringBefore('.'), it) } }
        }

        private fun screenPoint(name: String, normalized: Offset): Offset? {
            val layout = trace.layouts[name]?.takeIf { it.isAttached } ?: return null
            val point = layout.localToScreen(Offset(normalized.x * layout.size.width, normalized.y * layout.size.height))
            return point.takeIf { it.x.isFinite() && it.y.isFinite() }
        }

        private fun tap(label: String, position: () -> Offset?) {
            var screen: Offset? = null
            await("focused position for $label") { activity ->
                screen = if (activity.hasWindowFocus()) position() else null
                screen != null
            }
            val point = assertNotNull(screen)
            val instrumentation = InstrumentationRegistry.getInstrumentation()
            val down = SystemClock.uptimeMillis()
            for (action in listOf(MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP)) {
                val event = MotionEvent.obtain(down, SystemClock.uptimeMillis(), action, point.x, point.y, 0)
                try {
                    event.source = InputDevice.SOURCE_TOUCHSCREEN
                    instrumentation.sendPointerSync(event)
                } finally {
                    event.recycle()
                }
            }
        }

        private fun await(label: String, condition: (DecomposeStackTestActivity) -> Boolean) {
            val deadline = SystemClock.uptimeMillis() + 10_000L
            var events = emptyList<String>()
            while (SystemClock.uptimeMillis() < deadline) {
                var ready = false
                host.onActivity {
                    ready = condition(it)
                    events = trace.events.toList()
                }
                if (ready) return
                SystemClock.sleep(20L)
            }
            throw AssertionError("Waiting for $label. Events: $events")
        }
    }
}

private data class Geo(val latitude: Double, val longitude: Double) {
    fun matches(latitudeField: String, longitudeField: String): Boolean {
        val actualLatitude = latitudeField.toDoubleOrNull() ?: return false
        val actualLongitude = longitudeField.toDoubleOrNull() ?: return false
        return abs(latitude - actualLatitude) < 0.0001 && abs(longitude - actualLongitude) < 0.0001
    }
}

private data class Scene(val target: Geo, val zoom: Float, val marker: Geo? = null) {
    fun matches(line: String): Boolean {
        val fields = line.split(' ')
        if (fields.size !in 6..7 || !target.matches(fields[2], fields[3])) return false
        val actualZoom = fields[4].toFloatOrNull() ?: return false
        if (abs(zoom - actualZoom) >= 0.01f) return false
        if (marker == null) return fields.size == 6 && fields[5] == "none"
        return fields.size == 7 && marker.matches(fields[5], fields[6])
    }
}

private val initialA = Scene(Geo(55.751225, 37.629540), 16f)
private val savedA = Scene(Geo(55.751525, 37.629840), 17f)
private val markerA = Geo(55.751625, 37.629540)
private val initialB = Scene(Geo(59.939800, 30.314600), 16f)
private val markerB = Geo(59.940200, 30.314600)
private val initialC = Scene(Geo(56.838900, 60.605700), 16f)
