package ru.sulgik.mapkit.compose

import android.os.SystemClock
import android.view.MotionEvent
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.test.interaction.FixtureClose
import ru.sulgik.mapkit.test.interaction.FixtureKey
import ru.sulgik.mapkit.test.interaction.FixtureMapTag
import ru.sulgik.mapkit.test.interaction.FixtureOpen
import ru.sulgik.mapkit.test.interaction.MapInteractionFixture
import ru.sulgik.mapkit.test.interaction.MapInteractionTrace
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
public class MapInteractionTest {

    @Test
    public fun mapAcceptsTouchAfterMountAndReopen() {
        runComposeUiTest {
            val trace = MapInteractionTrace()
            runOnUiThread { MapKit.setApiKey(FixtureKey) }
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

    private fun tap(x: Float, y: Float) {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val start = SystemClock.uptimeMillis()
        for (action in listOf(MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP)) {
            val event = MotionEvent.obtain(start, SystemClock.uptimeMillis(), action, x, y, 0)
            try {
                instrumentation.sendPointerSync(event)
            } finally {
                event.recycle()
            }
        }
    }
}
