package ru.sulgik.mapkit.compose

import android.os.SystemClock
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.test.interaction.FixtureClose
import ru.sulgik.mapkit.test.interaction.FixtureMapTag
import ru.sulgik.mapkit.test.interaction.FixtureOpen
import ru.sulgik.mapkit.test.interaction.MapInteractionFixture
import ru.sulgik.mapkit.test.interaction.MapInteractionTrace
import ru.sulgik.mapkit.test.interaction.MapTapFixture
import ru.sulgik.mapkit.test.interaction.MapTapTrace
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@OptIn(ExperimentalTestApi::class)
public class MapInteractionTest {

    @Test
    public fun mapAcceptsTouchAfterMountAndReopen() {
        runComposeUiTest {
            val trace = MapInteractionTrace()
            runOnUiThread { setDeviceTestMapKitApiKey() }
            setContent { MapInteractionFixture(trace) }

            tapReadyMap(1, trace)
            onNodeWithText(FixtureClose).performClick()
            waitForEvent(trace, "unmount screen=1 map=1")
            onNodeWithText(FixtureOpen).performClick()
            tapReadyMap(2, trace)

            runOnIdle {
                assertEquals(
                    listOf(
                        "mount screen=1 map=1",
                        "ready screen=1 map=1",
                        "tap screen=1 map=1",
                        "unmount screen=1 map=1",
                        "mount screen=2 map=2",
                        "ready screen=2 map=2",
                        "tap screen=2 map=2",
                    ),
                    trace.events.toList(),
                )
            }
        }
    }

    @Test
    public fun mapTapsRespectHitOrderConsumptionAndCurrentCallbacks() {
        val trace = MapTapTrace()
        val expected = mutableListOf<String>()

        ActivityScenario.launch(ComponentActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                setDeviceTestMapKitApiKey()
                activity.setContent { MapTapFixture(trace) }
            }

            fun awaitTrace() {
                val deadline = SystemClock.uptimeMillis() + 10_000L
                var actual = emptyList<String>()
                while (SystemClock.uptimeMillis() < deadline) {
                    scenario.onActivity { actual = trace.events.toList() }
                    if (actual == expected) return
                    if (actual.size >= expected.size || actual != expected.take(actual.size)) break
                    SystemClock.sleep(20L)
                }
                assertEquals(expected, actual, "Native map event trace")
            }

            fun touch(center: () -> Offset?, holdMillis: Long = 0L) {
                var point = Offset.Zero
                scenario.onActivity { activity ->
                    val target = assertNotNull(center(), "Touch target is not laid out")
                    val decor = activity.window.decorView
                    val screen = IntArray(2)
                    val window = IntArray(2)
                    decor.getLocationOnScreen(screen)
                    decor.getLocationInWindow(window)
                    point = Offset(target.x + screen[0] - window[0], target.y + screen[1] - window[1])
                }
                tap(point.x, point.y, holdMillis)
            }

            fun touchCenter(vararg events: String, holdMillis: Long = 0L) {
                touch({ trace.mapCenter }, holdMillis)
                expected.addAll(events)
                awaitTrace()
            }

            fun ready(case: String, advance: Boolean = true) {
                if (advance) touch({ trace.nextCaseCenter })
                expected.add("ready $case")
                awaitTrace()
            }

            ready("Disabled", advance = false)
            touchCenter("polygon", "collection")
            ready("Empty")
            touchCenter("map")
            touchCenter("long", holdMillis = 900L)
            ready("PlacemarkConsumes")
            touchCenter("placemark")
            ready("PlacemarkPropagates")
            touchCenter("placemark", "collection")
            ready("PlacemarkHidden")
            touchCenter("polygon")
            ready("PlacemarkRestored")
            touchCenter("placemark")
            ready("PlacemarkRemoved")
            touchCenter("polygon", "collection", "replacement")
            ready("HandlerRemoved")
            touchCenter("polygon", "collection")
            ready("HandlerRestored")
            touchCenter("polygon", "collection", "restored")
        }
    }

    private fun ComposeUiTest.tapReadyMap(screen: Int, trace: MapInteractionTrace) {
        val identity = "screen=$screen map=$screen"
        waitForEvent(trace, "ready $identity")
        val node = onNodeWithTag(FixtureMapTag).fetchSemanticsNode()
        val target = node.config[SemanticsProperties.ContentDescription].single().split(' ')
        assertEquals(listOf("fixture-target", "screen=$screen", "map=$screen"), target.take(3), trace.events.toString())
        val bounds = node.boundsInWindow
        tap(
            x = bounds.left + bounds.width * target[3].toFloat(),
            y = bounds.top + bounds.height * target[4].toFloat(),
        )
        waitForEvent(trace, "tap $identity")
    }

    private fun ComposeUiTest.waitForEvent(trace: MapInteractionTrace, expected: String) {
        try {
            waitUntil(timeoutMillis = 10_000L) { expected in trace.events }
        } catch (failure: Throwable) {
            throw AssertionError("Waiting for '$expected'. Events: ${trace.events}", failure)
        }
    }

    private fun tap(x: Float, y: Float, holdMillis: Long = 0L) {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val start = SystemClock.uptimeMillis()
        for (action in listOf(MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP)) {
            val event = MotionEvent.obtain(start, SystemClock.uptimeMillis(), action, x, y, 0)
            try {
                instrumentation.sendPointerSync(event)
            } finally {
                event.recycle()
            }
            if (action == MotionEvent.ACTION_DOWN && holdMillis > 0L) SystemClock.sleep(holdMillis)
        }
    }
}
