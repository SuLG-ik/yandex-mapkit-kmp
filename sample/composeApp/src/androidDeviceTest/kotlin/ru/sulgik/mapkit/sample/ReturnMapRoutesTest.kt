package ru.sulgik.mapkit.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.StateRestorationTester
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import ru.sulgik.mapkit.compose.CameraPositionState
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNotSame

@OptIn(ExperimentalTestApi::class)
public class ReturnMapRoutesTest {

    @Test
    public fun restoresEachTabThroughDetailsAndRecreationAndDropsStateWhenExited() {
        runComposeUiTest {
            val fixture = setUpRoutes()
            click("Change viewport")
            click("Select A-1")
            click("Open details")
            click("Back to map")
            assertViewport(fixture, ChangedCameraA, "A-1")

            click("Tab B")
            assertViewport(fixture, ReturnMapTab.B.initialCamera, selectedId = null)
            click("Change viewport")
            click("Select B-1")
            assertViewport(fixture, ChangedCameraB, "B-1")

            click("Tab A")
            assertViewport(fixture, ChangedCameraA, "A-1")
            val oldState = runOnIdle { fixture.map?.camera }
            fixture.restoration.emulateSaveAndRestore()
            assertViewport(fixture, ChangedCameraA, "A-1")
            runOnIdle { assertNotSame(assertNotNull(oldState), assertNotNull(fixture.map).camera) }
            click("Tab B")
            assertViewport(fixture, ChangedCameraB, "B-1")

            click("Exit example")
            click("Reopen example")
            assertViewport(fixture, ReturnMapTab.A.initialCamera, selectedId = null)
            click("Tab B")
            assertViewport(fixture, ReturnMapTab.B.initialCamera, selectedId = null)
        }
    }

    @Test
    public fun movedMarkerKeepsItsSelectionAndRemovedMarkerDoesNotReturn() {
        runComposeUiTest {
            val fixture = setUpRoutes()
            click("Select A-1")
            click("Open details")
            click("Move marker")
            click("Back to map")
            runOnIdle {
                val map = assertNotNull(fixture.map)
                assertEquals("A-1", map.selectedId)
                assertEquals(
                    listOf(ReturnMapTab.A.editableMarker.copy(point = ReturnMapTab.A.movedPoint), ReturnMapTab.A.referenceMarker),
                    map.markers,
                )
            }

            click("Open details")
            click("Remove marker")
            fixture.restoration.emulateSaveAndRestore()
            onNodeWithText("Marker no longer in catalog").assertExists()
            click("Back to map")
            runOnIdle {
                val map = assertNotNull(fixture.map)
                assertEquals(null, map.selectedId)
                assertEquals(listOf(ReturnMapTab.A.referenceMarker), map.markers)
            }
        }
    }

    private fun ComposeUiTest.setUpRoutes(): Fixture {
        val restoration = StateRestorationTester(this)
        val fixture = Fixture(restoration)
        val isOpen = mutableStateOf(true)
        restoration.setContent {
            if (isOpen.value) {
                ReturnMapRoutes(onExit = { isOpen.value = false }) { camera, markers, selectedId, onSelect, modifier ->
                    SideEffect { fixture.map = VisibleMap(camera, markers, selectedId) }
                    Column(modifier) {
                        Button(onClick = {
                            camera.position = if (markers.any { it.id == "A-2" }) ChangedCameraA else ChangedCameraB
                        }) {
                            Text("Change viewport")
                        }
                        for (marker in markers) {
                            Button(onClick = { onSelect(marker.id) }) {
                                Text("Select ${marker.id}")
                            }
                        }
                    }
                }
            } else {
                SideEffect { fixture.map = null }
                Button(onClick = { isOpen.value = true }) {
                    Text("Reopen example")
                }
            }
        }
        return fixture
    }

    private fun ComposeUiTest.click(text: String) {
        onNodeWithText(text).performClick()
    }

    private fun ComposeUiTest.assertViewport(fixture: Fixture, position: CameraPosition, selectedId: String?) {
        runOnIdle {
            val map = assertNotNull(fixture.map)
            assertEquals(position, map.camera.position)
            assertEquals(selectedId, map.selectedId)
        }
    }

    private class Fixture(val restoration: StateRestorationTester) {
        var map: VisibleMap? = null
    }

    private class VisibleMap(
        val camera: CameraPositionState,
        val markers: List<ReturnMapMarker>,
        val selectedId: String?,
    )

    private companion object {
        val ChangedCameraA = CameraPosition(Point(55.7559, 37.6210), zoom = 16f, azimuth = 20f, tilt = 15f)
        val ChangedCameraB = CameraPosition(Point(59.9395, 30.3160), zoom = 17f, azimuth = 30f, tilt = 25f)
    }
}
