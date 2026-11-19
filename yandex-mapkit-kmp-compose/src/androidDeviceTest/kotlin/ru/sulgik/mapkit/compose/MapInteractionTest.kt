package ru.sulgik.mapkit.compose

import android.os.SystemClock
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.Window
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
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.mapview.toCommon
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
import kotlin.test.assertTrue
import com.yandex.mapkit.mapview.MapView as NativeMapView

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
        val receivedTouches = mutableListOf<Offset>()

        ActivityScenario.launch(ComponentActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                setDeviceTestMapKitApiKey()
                activity.setContent { MapTapFixture(trace) }
                val callback = activity.window.callback
                activity.window.callback = object : Window.Callback by callback {
                    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
                        val handled = callback.dispatchTouchEvent(event)
                        if (event.actionMasked == MotionEvent.ACTION_UP) {
                            val touch = Offset(event.rawX, event.rawY)
                            receivedTouches.add(touch)
                            Log.d("MapInteractionTest", "Activity received ACTION_UP at $touch. Handled: $handled")
                        }
                        return handled
                    }
                }
            }

            fun tapAndVerifyDelivery(point: Offset, holdMillis: Long = 0L) {
                var previousCount = 0
                scenario.onActivity { previousCount = receivedTouches.size }
                tap(point.x, point.y, holdMillis)
                scenario.onActivity {
                    assertEquals(previousCount + 1, receivedTouches.size, "Activity ACTION_UP count at $point")
                    val received = receivedTouches.last()
                    assertTrue((received - point).getDistance() <= 1f, "Sent $point, received $received")
                }
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
                Log.e("MapInteractionTest", "Expected native map events: $expected. Actual events: $actual")
                assertEquals(expected, actual, "Native map event trace")
            }

            fun advanceCase() {
                var point = Offset.Zero
                scenario.onActivity { activity ->
                    val target = assertNotNull(trace.nextCaseCenter, "Next case control is not laid out")
                    val decor = activity.window.decorView
                    val screen = IntArray(2)
                    val window = IntArray(2)
                    decor.getLocationOnScreen(screen)
                    decor.getLocationInWindow(window)
                    point = Offset(target.x + screen[0] - window[0], target.y + screen[1] - window[1])
                }
                Log.d("MapInteractionTest", "Next case control is at $point")
                tapAndVerifyDelivery(point)
            }

            val singleTapInterval = maxOf(ViewConfiguration.getDoubleTapTimeout().toLong(), 300L) + 1L
            var lastMapTapUp = 0L

            fun tapProjectedPoint(holdMillis: Long = 0L) {
                val remaining = lastMapTapUp + singleTapInterval - SystemClock.uptimeMillis()
                if (remaining > 0L) SystemClock.sleep(remaining)
                val deadline = SystemClock.uptimeMillis() + 3_000L
                var point: Offset? = null
                while (point == null && SystemClock.uptimeMillis() < deadline) {
                    scenario.onActivity { activity ->
                        val target = assertNotNull(trace.target, "The fixture did not provide a tap target")
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
                        Log.d(
                            "MapInteractionTest",
                            "Native tap target $target projects to $projected, screen $point in " +
                                "view ${view.width}×${view.height} at (${location[0]}, ${location[1]}), " +
                                "map window ${window.width}×${window.height}",
                        )
                    }
                    if (point == null) SystemClock.sleep(20L)
                }
                val screenPoint = assertNotNull(point, "The map did not project a touch target. Events: $expected")
                tapAndVerifyDelivery(screenPoint, holdMillis)
                lastMapTapUp = SystemClock.uptimeMillis()
            }

            fun touchProjectedPoint(vararg events: String, holdMillis: Long = 0L) {
                tapProjectedPoint(holdMillis)
                expected.addAll(events)
                awaitTrace()
            }

            fun diagnoseMissingMapTap() {
                val probeEvents = mutableListOf<String>()
                val probe = InputListener(
                    onMapTap = { _, point -> probeEvents.add("tap $point") },
                    onMapLongTap = { _, point -> probeEvents.add("long tap $point") },
                )
                scenario.onActivity { activity ->
                    val view = assertNotNull(activity.window.decorView.findNativeMap())
                    view.toCommon().mapWindow.map.addInputListener(probe.asWeakRef())
                }
                try {
                    tapProjectedPoint()
                    val deadline = SystemClock.uptimeMillis() + 1_000L
                    var delivered = false
                    while (!delivered && SystemClock.uptimeMillis() < deadline) {
                        scenario.onActivity { delivered = probeEvents.isNotEmpty() }
                        if (!delivered) SystemClock.sleep(20L)
                    }
                } finally {
                    scenario.onActivity { activity ->
                        val map = activity.window.decorView.findNativeMap()?.toCommon()?.mapWindow?.map
                        if (map?.isValid == true) map.removeInputListener(probe.asWeakRef())
                        Log.e("MapInteractionTest", "Direct MapKit listener: $probeEvents. Compose trace: ${trace.events}")
                    }
                }
            }

            fun ready(case: String, advance: Boolean = true) {
                if (advance) advanceCase()
                expected.add("ready $case")
                awaitTrace()
            }

            ready("Disabled", advance = false)
            touchProjectedPoint()
            ready("Empty")
            try {
                touchProjectedPoint("map")
            } catch (failure: AssertionError) {
                runCatching { diagnoseMissingMapTap() }.onFailure {
                    Log.e("MapInteractionTest", "Could not query the direct MapKit listener", it)
                }
                throw failure
            }
            touchProjectedPoint("long", holdMillis = 900L)
            ready("PolygonOnly")
            touchProjectedPoint("polygon", "collection", "map")
            ready("PlacemarkConsumes")
            touchProjectedPoint("placemark")
            ready("PlacemarkPropagates")
            touchProjectedPoint("placemark", "collection")
            ready("PlacemarkHidden")
            touchProjectedPoint("polygon")
            ready("PlacemarkRestored")
            touchProjectedPoint("placemark")
            ready("PlacemarkRemoved")
            touchProjectedPoint("polygon", "collection", "replacement")
            ready("HandlerRemoved")
            touchProjectedPoint("polygon", "collection")
            ready("HandlerRestored")
            touchProjectedPoint("polygon", "collection", "restored")
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

    private fun View.findNativeMap(): NativeMapView? {
        if (this is NativeMapView) return this
        if (this is ViewGroup) {
            for (index in 0 until childCount) {
                getChildAt(index).findNativeMap()?.let { return it }
            }
        }
        return null
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
