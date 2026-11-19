package ru.sulgik.mapkit.compose

import android.graphics.Bitmap
import android.graphics.Color
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
            expect("pan moved west")
            pinch()
            expect("zoom moved in")
            advance()
            expect("scroll disabled")
            drag()
            advance()
            expect("blocked pan held camera")
            pinch()
            expect("zoom moved in with scroll disabled")
            advance()
            expect("zoom disabled")
            pinch()
            advance()
            expect("blocked zoom held camera")
            drag()
            expect("pan moved west with zoom disabled")
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
            expect("animation ready 2 on a new native map")
            advance()
            expect("new animation finished 2", "retired move deadline passed 1")
        }
    }

    @Test
    public fun simulatedPositionDrivesBothMountedMapsWithoutGps() {
        scenario(CameraRegressionMode.Location) {
            expect("location applied 1")
            expectLocationPin(visible = true)
            advance()
            expect("location hide requested 1")
            expectLocationPin(visible = false)
            advance()
            expect("location applied 2")
            expectLocationPin(visible = true)
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

        fun expectLocationPin(visible: Boolean) {
            val deadline = SystemClock.uptimeMillis() + 10_000L
            do {
                val screen = assertNotNull(
                    InstrumentationRegistry.getInstrumentation().uiAutomation.takeScreenshot(),
                    "Could not capture the location layer",
                )
                val sample = Bitmap.createScaledBitmap(screen, 256, 256, false)
                val readable = if (sample.config == Bitmap.Config.HARDWARE) {
                    assertNotNull(sample.copy(Bitmap.Config.ARGB_8888, false))
                } else {
                    sample
                }
                try {
                    val pixels = IntArray(256 * 256)
                    readable.getPixels(pixels, 0, 256, 0, 0, 256, 256)
                    val hasPin = pixels.count { pixel ->
                        Color.red(pixel) >= 175 && Color.green(pixel) <= 90 && Color.blue(pixel) >= 125
                    } >= 4
                    if (hasPin == visible) return
                } finally {
                    if (readable !== sample) readable.recycle()
                    sample.recycle()
                    if (sample !== screen) screen.recycle()
                }
                SystemClock.sleep(100)
            } while (SystemClock.uptimeMillis() < deadline)
            error("Location pin did not become ${if (visible) "visible" else "hidden"}")
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
            val deadline = SystemClock.uptimeMillis() + 5_000L
            do {
                var result: Offset? = null
                activity.onActivity {
                    val layout = probe.mapLayout
                    if (it.hasWindowFocus() && layout?.isAttached == true) {
                        result = layout.localToScreen(Offset(layout.size.width * x, layout.size.height * 0.5f))
                    }
                }
                result?.let {
                    if (it.x.isFinite() && it.y.isFinite()) return it
                }
                SystemClock.sleep(25)
            } while (SystemClock.uptimeMillis() < deadline)
            error("Map did not receive focus and a valid screen position")
        }

        private fun touch(startTime: Long, action: Int, first: Offset, second: Offset? = null) {
            val points = listOfNotNull(first, second)
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
