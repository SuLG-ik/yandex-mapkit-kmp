package ru.sulgik.mapkit.compose

import android.os.SystemClock
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.mapview.toCommon
import ru.sulgik.mapkit.test.interaction.MapObjectMembershipFixture
import ru.sulgik.mapkit.test.interaction.MapObjectMembershipTrace
import ru.sulgik.mapkit.test.interaction.MembershipStage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import com.yandex.mapkit.mapview.MapView as NativeMapView

public class MapObjectMembershipTest {

    @Test
    public fun keyedObjectsKeepIdentityAndClustersFollowTheCurrentDataset() {
        val trace = MapObjectMembershipTrace()
        val expected = mutableListOf<String>()

        ActivityScenario.launch(ComponentActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                setDeviceTestMapKitApiKey()
                activity.setContent { MapObjectMembershipFixture(trace) }
            }

            val singleTapInterval = maxOf(ViewConfiguration.getDoubleTapTimeout().toLong(), 300L) + 1L
            var lastTapUp = 0L
            for (stage in MembershipStage.entries) {
                if (stage != MembershipStage.Initial) scenario.onActivity { trace.advance() }
                expected.add("ready ${stage.name}")
                awaitTrace(scenario, trace, expected)
                val remaining = lastTapUp + singleTapInterval - SystemClock.uptimeMillis()
                if (remaining > 0L) SystemClock.sleep(remaining)
                tapMapTarget(scenario, stage)
                lastTapUp = SystemClock.uptimeMillis()
                expected.add("tap ${stage.name} ${stage.expectedTap}")
                awaitTrace(scenario, trace, expected)
            }
        }
    }

    private fun awaitTrace(
        scenario: ActivityScenario<ComponentActivity>,
        trace: MapObjectMembershipTrace,
        expected: List<String>,
    ) {
        val deadline = SystemClock.uptimeMillis() + 10_000L
        var actual = emptyList<String>()
        while (SystemClock.uptimeMillis() < deadline) {
            scenario.onActivity { actual = trace.events.toList() }
            if (actual == expected) return
            if (actual.size >= expected.size || actual != expected.take(actual.size)) break
            SystemClock.sleep(20L)
        }
        Log.e("MapObjectMembershipTest", "Expected native events: $expected. Actual: $actual")
        assertEquals(expected, actual, "Native map object trace")
    }

    private fun tapMapTarget(scenario: ActivityScenario<ComponentActivity>, stage: MembershipStage) {
        val target = stage.camera().target
        val deadline = SystemClock.uptimeMillis() + 3_000L
        var point: Offset? = null
        while (point == null && SystemClock.uptimeMillis() < deadline) {
            scenario.onActivity { activity ->
                val view = activity.window.decorView.findNativeMap()
                if (view == null || !view.isShown || !view.hasWindowFocus() || view.width == 0 || view.height == 0) {
                    return@onActivity
                }
                val window = view.toCommon().mapWindow
                if (!window.isValid || window.width == 0 || window.height == 0) return@onActivity
                val projected = window.worldToScreen(target) ?: return@onActivity
                if (projected.x !in 0f..window.width.toFloat() || projected.y !in 0f..window.height.toFloat()) {
                    return@onActivity
                }
                val location = IntArray(2)
                view.getLocationOnScreen(location)
                point = Offset(
                    x = location[0] + projected.x / window.width * view.width,
                    y = location[1] + projected.y / window.height * view.height,
                )
            }
            if (point == null) SystemClock.sleep(20L)
        }
        val screenPoint = assertNotNull(point, "No projected target for ${stage.name} at $target")
        Log.d("MapObjectMembershipTest", "Tap ${stage.name} at $screenPoint for $target")
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val start = SystemClock.uptimeMillis()
        for (action in listOf(MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP)) {
            val event = MotionEvent.obtain(start, SystemClock.uptimeMillis(), action, screenPoint.x, screenPoint.y, 0)
            try {
                instrumentation.sendPointerSync(event)
            } finally {
                event.recycle()
            }
        }
    }

    private fun View.findNativeMap(): NativeMapView? {
        if (this is NativeMapView) return this
        if (this is ViewGroup) {
            for (index in 0 until childCount) {
                getChildAt(index).findNativeMap()?.let { return it }
            }
        }
        return null
    }
}
