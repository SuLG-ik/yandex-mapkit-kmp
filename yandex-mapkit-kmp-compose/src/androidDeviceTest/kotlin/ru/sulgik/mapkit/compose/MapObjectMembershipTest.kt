package ru.sulgik.mapkit.compose

import android.os.SystemClock
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.test.interaction.MapObjectMembershipFixture
import ru.sulgik.mapkit.test.interaction.MapObjectMembershipTrace
import ru.sulgik.mapkit.test.interaction.MembershipStage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

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

            for (stage in MembershipStage.entries) {
                if (stage != MembershipStage.Initial) scenario.onActivity { trace.advance() }
                expected.add("ready ${stage.name}")
                awaitTrace(scenario, trace, expected)
                tapMapCenter(scenario, trace)
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
        assertEquals(expected, actual, "Native map object trace")
    }

    private fun tapMapCenter(scenario: ActivityScenario<ComponentActivity>, trace: MapObjectMembershipTrace) {
        var point = Offset.Zero
        scenario.onActivity { activity ->
            val target = assertNotNull(trace.mapCenter, "Map view is not laid out")
            val decor = activity.window.decorView
            val screen = IntArray(2)
            val window = IntArray(2)
            decor.getLocationOnScreen(screen)
            decor.getLocationInWindow(window)
            point = Offset(target.x + screen[0] - window[0], target.y + screen[1] - window[1])
        }
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val start = SystemClock.uptimeMillis()
        for (action in listOf(MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP)) {
            val event = MotionEvent.obtain(start, SystemClock.uptimeMillis(), action, point.x, point.y, 0)
            try {
                instrumentation.sendPointerSync(event)
            } finally {
                event.recycle()
            }
        }
    }
}
