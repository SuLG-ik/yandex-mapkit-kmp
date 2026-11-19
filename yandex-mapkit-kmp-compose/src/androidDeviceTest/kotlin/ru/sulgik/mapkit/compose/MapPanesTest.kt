package ru.sulgik.mapkit.compose

import android.os.SystemClock
import android.view.InputDevice
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.test.interaction.MapPanesFixture
import ru.sulgik.mapkit.test.interaction.MapPanesTrace
import ru.sulgik.mapkit.test.interaction.PaneA
import ru.sulgik.mapkit.test.interaction.PaneB
import ru.sulgik.mapkit.test.interaction.PaneDismissSheet
import ru.sulgik.mapkit.test.interaction.PaneMoveA
import ru.sulgik.mapkit.test.interaction.PaneMoveB
import ru.sulgik.mapkit.test.interaction.PaneOpenSheet
import ru.sulgik.mapkit.test.interaction.PaneRemoveB
import ru.sulgik.mapkit.test.interaction.PaneResizeA
import ru.sulgik.mapkit.test.interaction.PaneSheetAction
import ru.sulgik.mapkit.test.interaction.PaneSheetSlider
import ru.sulgik.mapkit.test.interaction.PaneShowSecond
import ru.sulgik.mapkit.test.interaction.PaneTarget
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

public class MapPanesTest {

    @Test
    public fun modalSheetOwnsInputAndResizedPanesKeepIndependentNativeWindows() {
        val trace = MapPanesTrace()
        ActivityScenario.launch(ComponentActivity::class.java).use { host ->
            host.onActivity { activity ->
                setDeviceTestMapKitApiKey()
                activity.setContent { MapPanesFixture(trace) }
            }
            val driver = PaneDriver(host, trace)
            val exposed = driver.mapPoint(PaneA, 1)
            driver.tap(exposed)
            driver.waitForTrace("attach A", "tap A 1")

            driver.tapControl(PaneOpenSheet)
            driver.waitForTrace("sheet-open")
            val sheetTop = driver.point(PaneSheetSlider, 0.5f, 0f)
            assertTrue(exposed.y < sheetTop.y, "Exposed map point $exposed is under the sheet at $sheetTop")
            driver.tap(exposed)
            driver.dragSlider()
            driver.waitForTrace("sheet-drag")
            driver.tapControl(PaneSheetAction)
            driver.waitForTrace("sheet-action")
            driver.tapControl(PaneDismissSheet)
            driver.waitForTrace("sheet-dismiss")
            driver.await("sheet detached and host focused") {
                Unit.takeIf { hasWindowFocus() && trace.layouts[PaneSheetSlider]?.isAttached != true }
            }
            driver.tapMap(PaneA, 1)
            driver.waitForTrace("tap A 1")

            driver.tapControl(PaneShowSecond)
            driver.waitForTrace("attach B")
            driver.tapMap(PaneA, 2)
            driver.waitForTrace("tap A 2")
            driver.tapMap(PaneB, 1)
            driver.waitForTrace("tap B 1")
            driver.tapControl(PaneMoveA)
            driver.tapMap(PaneA, 3)
            driver.waitForTrace("tap A 3")
            driver.tapMap(PaneB, 1)
            driver.waitForTrace("tap B 1")
            driver.tapControl(PaneMoveB)
            driver.tapMap(PaneB, 2)
            driver.waitForTrace("tap B 2")
            driver.tapMap(PaneA, 3)
            driver.waitForTrace("tap A 3")

            val splitTarget = driver.target(PaneA, 3)
            driver.tapControl(PaneResizeA)
            val resizedTarget = driver.target(PaneA, 4)
            assertTrue(resizedTarget.width < splitTarget.width && resizedTarget.height < splitTarget.height)
            assertTrue(resizedTarget.x < splitTarget.x && resizedTarget.y > splitTarget.y)
            driver.tapMap(PaneA, 4)
            driver.waitForTrace("tap A 4")
            driver.tapMap(PaneB, 2)
            driver.waitForTrace("tap B 2")

            driver.tapControl(PaneRemoveB)
            driver.waitForTrace("detach B")
            driver.await("B native window released") { Unit.takeIf { !trace.windows.getValue(PaneB).isValid } }
            driver.tapMap(PaneA, 5)
            driver.waitForTrace("tap A 5")
            host.onActivity {
                assertTrue(trace.windows.getValue(PaneA).isValid)
                assertFalse(trace.windows.getValue(PaneB).isValid)
            }
        }
    }

    private class PaneDriver(
        private val host: ActivityScenario<ComponentActivity>,
        private val trace: MapPanesTrace,
    ) {
        private val expected = mutableListOf<String>()
        private val instrumentation = InstrumentationRegistry.getInstrumentation()
        private val tapInterval = maxOf(350L, ViewConfiguration.getDoubleTapTimeout().toLong() + 20L)
        private var lastRelease = 0L

        fun target(id: String, revision: Int): PaneTarget {
            return await("projection $id $revision") { trace.targets[id]?.takeIf { it.revision == revision } }
        }

        fun mapPoint(id: String, revision: Int): Offset {
            val target = target(id, revision)
            return point(id, target.x, target.y)
        }

        fun tapMap(id: String, revision: Int) {
            await("host focus") { Unit.takeIf { hasWindowFocus() } }
            tap(mapPoint(id, revision))
        }

        fun point(tag: String, x: Float, y: Float): Offset {
            return await("screen position $tag") {
                val layout = trace.layouts[tag]?.takeIf { it.isAttached } ?: return@await null
                layout.localToScreen(Offset(layout.size.width * x, layout.size.height * y))
                    .takeIf { it.x.isFinite() && it.y.isFinite() }
            }
        }

        fun tapControl(label: String) {
            tap(point(label, 0.5f, 0.5f))
        }

        fun tap(point: Offset) {
            val remaining = tapInterval - (SystemClock.uptimeMillis() - lastRelease)
            if (remaining > 0) SystemClock.sleep(remaining)
            val downTime = SystemClock.uptimeMillis()
            send(downTime, MotionEvent.ACTION_DOWN, point)
            send(downTime, MotionEvent.ACTION_UP, point)
            lastRelease = SystemClock.uptimeMillis()
        }

        fun dragSlider() {
            val start = point(PaneSheetSlider, 0.2f, 0.5f)
            val end = point(PaneSheetSlider, 0.8f, 0.5f)
            val downTime = SystemClock.uptimeMillis()
            send(downTime, MotionEvent.ACTION_DOWN, start)
            for (step in 1..8) {
                SystemClock.sleep(16L)
                send(downTime, MotionEvent.ACTION_MOVE, start + (end - start) * (step / 8f))
            }
            send(downTime, MotionEvent.ACTION_UP, end)
        }

        fun waitForTrace(vararg events: String) {
            expected.addAll(events)
            val actual = await("events $expected") {
                trace.events.toList().takeIf { it.size >= expected.size }
            }
            assertEquals(expected, actual, "Native pane event trace")
        }

        fun <T : Any> await(label: String, value: ComponentActivity.() -> T?): T {
            val deadline = SystemClock.uptimeMillis() + 10_000L
            var lastEvents = emptyList<String>()
            while (SystemClock.uptimeMillis() < deadline) {
                var result: T? = null
                host.onActivity {
                    result = value(it)
                    lastEvents = trace.events.toList()
                }
                result?.let { return it }
                SystemClock.sleep(20L)
            }
            throw AssertionError("Waiting for $label. Events: $lastEvents")
        }

        private fun send(downTime: Long, action: Int, point: Offset) {
            val event = MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), action, point.x, point.y, 0)
            try {
                event.source = InputDevice.SOURCE_TOUCHSCREEN
                instrumentation.sendPointerSync(event)
            } finally {
                event.recycle()
            }
        }
    }
}
