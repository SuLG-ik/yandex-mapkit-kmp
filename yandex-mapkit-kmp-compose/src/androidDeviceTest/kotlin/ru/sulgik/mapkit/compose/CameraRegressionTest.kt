package ru.sulgik.mapkit.compose

import android.os.SystemClock
import android.view.InputDevice
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.test.interaction.CameraRegressionFixture
import ru.sulgik.mapkit.test.interaction.CameraRegressionMode
import ru.sulgik.mapkit.test.interaction.CameraRegressionProbe
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

public class CameraRegressionTest {

    @Test
    public fun panAndPinchSettleAndRespectGestureFlags() {
        scenario(CameraRegressionMode.Gestures) {
            expect("gestures enabled")
            drag()
            expect("pan finished")
            pinch()
            expect("zoom finished")
            advance()
            expect("gestures disabled")
            drag()
            pinch()
            advance()
            expect("disabled gestures held camera")
        }
    }

    @Test
    public fun supersededAndDisposedMovesKeepTheirMapIdentity() {
        scenario(CameraRegressionMode.Animation) {
            expect("animation ready 1")
            advance()
            expect("first animation moving 1", "first animation cancelled 1", "replacement finished 1")
            advance()
            expect("leaving while moving 1", "animation detached 1")
            advance()
            expect("animation ready 2")
            advance()
            expect("new animation finished 2")
        }
    }

    @Test
    public fun simulatedPositionDrivesBothMountedMapsWithoutGps() {
        scenario(CameraRegressionMode.Location) {
            expect("location applied 1")
            advance()
            expect("location hidden 1")
            advance()
            expect("location applied 2")
        }
    }

    private fun scenario(mode: CameraRegressionMode, block: Driver.() -> Unit) {
        val probe = CameraRegressionProbe()
        ActivityScenario.launch(ComponentActivity::class.java).use { activity ->
            activity.onActivity {
                setDeviceTestMapKitApiKey()
                it.setContent { CameraRegressionFixture(mode, probe) }
            }
            val driver = Driver(activity, probe)
            try {
                driver.block()
            } catch (failure: Throwable) {
                throw AssertionError("$mode failed. Events: ${driver.events()}", failure)
            }
        }
    }

    private class Driver(
        private val activity: ActivityScenario<ComponentActivity>,
        private val probe: CameraRegressionProbe,
    ) {
        private val expected = mutableListOf<String>()

        fun events(): List<String> {
            var result = emptyList<String>()
            activity.onActivity { result = probe.events.toList() }
            return result
        }

        fun expect(vararg expectedEvents: String) {
            expected.addAll(expectedEvents)
            val deadline = SystemClock.uptimeMillis() + 15_000L
            var actual = events()
            while (actual == expected.take(actual.size) && actual.size < expected.size &&
                SystemClock.uptimeMillis() < deadline
            ) {
                SystemClock.sleep(25)
                actual = events()
            }
            assertEquals(expected, actual, "Camera regression events")
        }

        fun advance() {
            activity.onActivity { assertNotNull(probe.advance, "No active camera action").invoke() }
        }

        fun drag() {
            val start = point(0.34f)
            val end = point(0.70f)
            val time = SystemClock.uptimeMillis()
            touch(time, MotionEvent.ACTION_DOWN, start)
            repeat(12) { index ->
                SystemClock.sleep(18)
                touch(time, MotionEvent.ACTION_MOVE, start + (end - start) * ((index + 1) / 12f))
            }
            touch(time, MotionEvent.ACTION_UP, end)
        }

        fun pinch() {
            val startLeft = point(0.42f)
            val startRight = point(0.58f)
            val endLeft = point(0.24f)
            val endRight = point(0.76f)
            val time = SystemClock.uptimeMillis()
            touch(time, MotionEvent.ACTION_DOWN, startLeft)
            touch(time, MotionEvent.ACTION_POINTER_DOWN or SecondPointer, startLeft, startRight)
            repeat(12) { index ->
                val progress = (index + 1) / 12f
                SystemClock.sleep(18)
                touch(
                    time,
                    MotionEvent.ACTION_MOVE,
                    startLeft + (endLeft - startLeft) * progress,
                    startRight + (endRight - startRight) * progress,
                )
            }
            touch(time, MotionEvent.ACTION_POINTER_UP or SecondPointer, endLeft, endRight)
            touch(time, MotionEvent.ACTION_UP, endLeft)
        }

        private fun point(x: Float): Offset {
            var result = Offset.Unspecified
            activity.onActivity {
                val layout = assertNotNull(probe.mapLayout, "Map has no measured layout")
                check(layout.isAttached)
                result = layout.localToScreen(Offset(layout.size.width * x, layout.size.height * 0.5f))
            }
            check(result.x.isFinite() && result.y.isFinite()) { "Invalid screen point for the map" }
            return result
        }

        private fun touch(startTime: Long, action: Int, vararg points: Offset) {
            val properties = Array(points.size) { index ->
                MotionEvent.PointerProperties().apply {
                    id = index
                    toolType = MotionEvent.TOOL_TYPE_FINGER
                }
            }
            val coords = Array(points.size) { index ->
                MotionEvent.PointerCoords().apply {
                    x = points[index].x
                    y = points[index].y
                    pressure = 1f
                    size = 1f
                }
            }
            val event = MotionEvent.obtain(
                startTime,
                SystemClock.uptimeMillis(),
                action,
                points.size,
                properties,
                coords,
                0,
                0,
                1f,
                1f,
                0,
                0,
                InputDevice.SOURCE_TOUCHSCREEN,
                0,
            )
            try {
                InstrumentationRegistry.getInstrumentation().sendPointerSync(event)
            } finally {
                event.recycle()
            }
        }
    }

    private companion object {
        val SecondPointer = 1 shl MotionEvent.ACTION_POINTER_INDEX_SHIFT
    }
}
