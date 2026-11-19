package ru.sulgik.mapkit.compose

import android.os.Bundle
import android.os.SystemClock
import android.view.InputDevice
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.test.interaction.Nav3Fixture
import ru.sulgik.mapkit.test.interaction.Nav3Main
import ru.sulgik.mapkit.test.interaction.Nav3Move
import ru.sulgik.mapkit.test.interaction.Nav3Other
import ru.sulgik.mapkit.test.interaction.Nav3Probe
import ru.sulgik.mapkit.test.interaction.Nav3PushB
import ru.sulgik.mapkit.test.interaction.Nav3Select
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNotSame

private var activeProbe: Nav3Probe? = null

public class Nav3TestActivity : ComponentActivity() {
    internal val navigationHost = Any()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDeviceTestMapKitApiKey()
        val probe = checkNotNull(activeProbe)
        setContent { Nav3Fixture(probe, navigationHost) }
    }
}

public class Nav3MapTest {

    @Test
    public fun hardwareBackAndActivityRecreationRestoreOnlyRetainedEntries() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val probe = Nav3Probe()
        instrumentation.runOnMainSync { activeProbe = probe }
        try {
            ActivityScenario.launch(Nav3TestActivity::class.java).use { scenario ->
                val driver = NavDriver(scenario, probe)
                driver.waitForMap("main-A", "default", selected = false)
                driver.button(Nav3Move)
                driver.tapMap("main-A", "custom", selected = false)
                driver.waitForDetails("main-A")
                driver.back()

                driver.waitForMap("main-A", "custom", selected = false)
                driver.button(Nav3PushB)
                driver.waitForMap("main-B", "default", selected = false)
                driver.button(Nav3Select)
                driver.tapMap("main-B", "default", selected = true)
                driver.waitForDetails("main-B")
                driver.back()
                driver.waitForMap("main-B", "default", selected = true)
                driver.back()

                driver.waitForMap("main-A", "custom", selected = false)
                driver.tapMap("main-A", "custom", selected = false)
                driver.waitForDetails("main-A")
                driver.back()
                driver.waitForMap("main-A", "custom", selected = false)
                driver.button(Nav3PushB)
                driver.tapMap("main-B", "default", selected = false)
                driver.waitForDetails("main-B")
                driver.back()
                driver.waitForMap("main-B", "default", selected = false)

                driver.button(Nav3Other)
                driver.waitForMap("other-B", "default", selected = false)
                driver.button(Nav3Move)
                driver.waitForMap("other-B", "custom", selected = false)
                driver.button(Nav3Select)
                driver.tapMap("other-B", "custom", selected = true)
                driver.waitForDetails("other-B")
                driver.button(Nav3Main)
                driver.waitForMap("main-B", "default", selected = false)
                driver.button(Nav3Other)
                driver.waitForDetails("other-B")

                lateinit var oldActivity: Nav3TestActivity
                scenario.onActivity { oldActivity = it }
                scenario.recreate()
                scenario.onActivity { assertNotSame(oldActivity, it) }
                driver.waitForDetails("other-B")
                driver.back()
                driver.tapMap("other-B", "custom", selected = true)
                driver.waitForDetails("other-B")
                driver.button(Nav3Main)
                driver.waitForMap("main-B", "default", selected = false)
                driver.back()
                driver.tapMap("main-A", "custom", selected = false)
                driver.waitForDetails("main-A")
                driver.assertTaps("main-A", "main-B", "main-A", "main-B", "other-B", "other-B", "main-A")
            }
        } finally {
            instrumentation.runOnMainSync { activeProbe = null }
        }
    }
}

private class NavDriver(
    private val scenario: ActivityScenario<Nav3TestActivity>,
    private val probe: Nav3Probe,
) {
    fun waitForMap(id: String, viewport: String, selected: Boolean) {
        await("map $id, viewport=$viewport, selected=$selected") { host ->
            val entry = probe.screen
            val target = probe.target
            entry != null && entry.name == "Map $id" && entry.host === host.navigationHost &&
                entry.layout?.isAttached == true && target != null && target.entry === entry &&
                target.viewport == viewport && target.selected == selected
        }
    }

    fun waitForDetails(id: String) {
        await("details $id composed in the current Activity") { host ->
            val entry = probe.screen
            entry != null && entry.name == "Details $id" && entry.host === host.navigationHost &&
                entry.layout?.isAttached == true
        }
    }

    fun tapMap(id: String, viewport: String, selected: Boolean) {
        waitForMap(id, viewport, selected)
        tap(id) {
            probe.target?.takeIf { it.entry === probe.screen }?.let { hit ->
                hit.entry.layout?.let { screenPoint(it, hit.x, hit.y) }
            }
        }
    }

    fun button(label: String) {
        tap(label) { probe.layouts[label]?.let { screenPoint(it, 0.5f, 0.5f) } }
    }

    fun back() {
        InstrumentationRegistry.getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_BACK)
    }

    fun assertTaps(vararg expected: String) {
        scenario.onActivity { assertEquals(expected.toList(), probe.taps.toList()) }
    }

    private fun screenPoint(coordinates: LayoutCoordinates, x: Float, y: Float): Offset? {
        if (!coordinates.isAttached) return null
        val point = coordinates.localToScreen(Offset(coordinates.size.width * x, coordinates.size.height * y))
        return point.takeIf { it.x.isFinite() && it.y.isFinite() }
    }

    private fun await(description: String, condition: (Nav3TestActivity) -> Boolean) {
        val deadline = SystemClock.uptimeMillis() + 10_000L
        var diagnostic = ""
        while (SystemClock.uptimeMillis() < deadline) {
            var satisfied = false
            scenario.onActivity { host ->
                satisfied = host.hasWindowFocus() && condition(host)
                diagnostic = "screen=${probe.screen?.name}; target=${probe.target}; taps=${probe.taps.toList()}"
            }
            if (satisfied) return
            SystemClock.sleep(20L)
        }
        throw AssertionError("Waiting for $description. $diagnostic")
    }

    private fun tap(label: String, coordinate: () -> Offset?) {
        var last: Offset? = null
        await("stable screen position of $label") {
            val point = coordinate()
            val stable = point != null && point == last
            last = point
            stable
        }
        val point = assertNotNull(last)
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
}
