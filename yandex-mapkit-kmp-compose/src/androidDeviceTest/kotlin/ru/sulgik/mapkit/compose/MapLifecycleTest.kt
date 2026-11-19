package ru.sulgik.mapkit.compose

import android.os.Bundle
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
import androidx.compose.ui.test.v2.runEmptyComposeUiTest
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.test.interaction.AnimateAndClose
import ru.sulgik.mapkit.test.interaction.CoverMap
import ru.sulgik.mapkit.test.interaction.LifecycleMapTag
import ru.sulgik.mapkit.test.interaction.MapLifecycleFixture
import ru.sulgik.mapkit.test.interaction.MapLifecycleScenario
import ru.sulgik.mapkit.test.interaction.OpenLifecycleMap
import ru.sulgik.mapkit.test.interaction.SaveViewport
import ru.sulgik.mapkit.test.interaction.UncoverMap
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

private class LifecycleRun {
    val fixture = MapLifecycleScenario()
    val windows = mutableMapOf<Int, MapWindow>()
}

private var activeRun: LifecycleRun? = null

public class MapLifecycleTestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDeviceTestMapKitApiKey()
        val run = checkNotNull(activeRun)
        run.fixture.customCamera = savedInstanceState?.getBoolean("customCamera") ?: false
        run.fixture.selected = savedInstanceState?.getBoolean("selected") ?: false
        setContent {
            MapLifecycleFixture(run.fixture) { id, window -> run.windows[id] = window }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val fixture = checkNotNull(activeRun).fixture
        outState.putBoolean("customCamera", fixture.customCamera)
        outState.putBoolean("selected", fixture.selected)
    }
}

@OptIn(ExperimentalTestApi::class)
public class MapLifecycleTest {

    @Test
    public fun coveredAndRecreatedMapKeepsSavedViewportAndReleasesOldWindows() {
        runEmptyComposeUiTest {
            val run = LifecycleRun()
            runOnUiThread { activeRun = run }
            try {
                ActivityScenario.launch(MapLifecycleTestActivity::class.java).use { host ->
                    val initialTarget = target(run, 1, saved = false)
                    tap(initialTarget)
                    waitForEvents(run, "attach 1", "ready 1 camera=false selected=false", "tap 1")

                    onNodeWithText(CoverMap).performClick()
                    waitForIdle()
                    tap(initialTarget)
                    waitForEvents(run, "overlay 1")
                    onNodeWithText(UncoverMap).performClick()
                    waitForIdle()
                    tap(initialTarget)
                    waitForEvents(run, "tap 1", occurrences = 2)
                    runOnIdle { assertTrue(run.windows.getValue(1).isValid) }

                    onNodeWithText(SaveViewport).performClick()
                    target(run, 1, saved = true)
                    host.moveToState(Lifecycle.State.CREATED)
                    host.moveToState(Lifecycle.State.RESUMED)
                    tap(target(run, 1, saved = true))
                    waitForEvents(run, "tap 1", occurrences = 3)
                    runOnIdle { assertTrue(run.windows.getValue(1).isValid) }

                    for (id in 1..2) {
                        onNodeWithText(AnimateAndClose).performClick()
                        waitForEvents(run, "detach $id")
                        runOnIdle { assertFalse(run.windows.getValue(id).isValid, "Native window $id survived removal") }
                        onNodeWithText(OpenLifecycleMap).performClick()
                        tap(target(run, id + 1, saved = true))
                        waitForEvents(run, "tap ${id + 1}")
                    }

                    host.recreate()
                    waitForEvents(run, "detach 3")
                    tap(target(run, 4, saved = true))
                    waitForEvents(run, "tap 4")
                    runOnIdle {
                        assertFalse(run.windows.getValue(3).isValid, "Old host's native window survived recreation")
                        assertTrue(run.windows.getValue(4).isValid)
                        assertEquals(
                            listOf(
                                "attach 1", "ready 1 camera=false selected=false", "tap 1", "overlay 1", "tap 1",
                                "ready 1 camera=true selected=true", "tap 1", "animate 1", "detach 1",
                                "attach 2", "ready 2 camera=true selected=true", "tap 2", "animate 2", "detach 2",
                                "attach 3", "ready 3 camera=true selected=true", "tap 3", "detach 3",
                                "attach 4", "ready 4 camera=true selected=true", "tap 4",
                            ),
                            run.fixture.events.toList(),
                        )
                    }
                }
            } finally {
                runOnUiThread { activeRun = null }
            }
        }
    }

    private fun ComposeUiTest.target(run: LifecycleRun, id: Int, saved: Boolean): Offset {
        waitForEvents(run, "ready $id camera=$saved selected=$saved")
        val node = onNodeWithTag(LifecycleMapTag).fetchSemanticsNode()
        val fields = node.config[SemanticsProperties.ContentDescription].single().split(' ')
        assertEquals(listOf("lifecycle-target", id.toString()), fields.take(2), run.fixture.events.toString())
        val bounds = node.boundsInWindow
        return Offset(
            x = bounds.left + bounds.width * fields[2].toFloat(),
            y = bounds.top + bounds.height * fields[3].toFloat(),
        )
    }

    private fun ComposeUiTest.waitForEvents(
        run: LifecycleRun,
        vararg expected: String,
        occurrences: Int = 1,
    ) {
        try {
            waitUntil(timeoutMillis = 10_000L) {
                expected.all { event -> run.fixture.events.count { it == event } >= occurrences }
            }
        } catch (failure: Throwable) {
            throw AssertionError("Waiting for ${expected.toList()} ($occurrences). Events: ${run.fixture.events}", failure)
        }
    }

    private fun tap(point: Offset) {
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
