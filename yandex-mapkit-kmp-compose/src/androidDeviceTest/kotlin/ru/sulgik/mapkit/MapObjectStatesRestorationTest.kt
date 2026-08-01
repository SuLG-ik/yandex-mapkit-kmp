package ru.sulgik.mapkit

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.StateRestorationTester
import androidx.compose.ui.test.runComposeUiTest
import ru.sulgik.mapkit.compose.CameraPositionState
import ru.sulgik.mapkit.compose.CircleState
import ru.sulgik.mapkit.compose.PlacemarkState
import ru.sulgik.mapkit.compose.rememberCameraPositionState
import ru.sulgik.mapkit.compose.rememberCircleState
import ru.sulgik.mapkit.compose.rememberPlacemarkState
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNotSame

@OptIn(ExperimentalTestApi::class)
public class MapObjectStatesRestorationTest {

    @Test
    public fun circleStateRestoresChangedGeometry() {
        assertStateIsRestored(
            create = { rememberCircleState(geometry = InitialCircle) },
            change = { it.geometry = ChangedCircle },
            read = CircleState::geometry,
            expected = ChangedCircle,
        )
    }

    @Test
    public fun placemarkStateRestoresChangedGeometry() {
        assertStateIsRestored(
            create = { rememberPlacemarkState(geometry = InitialPoint) },
            change = { it.geometry = ChangedPoint },
            read = PlacemarkState::geometry,
            expected = ChangedPoint,
        )
    }

    @Test
    public fun placemarkStateRestoresChangedDirection() {
        assertStateIsRestored(
            create = { rememberPlacemarkState(geometry = InitialPoint, direction = InitialDirection) },
            change = { it.direction = ChangedDirection },
            read = PlacemarkState::direction,
            expected = ChangedDirection,
        )
    }

    @Test
    public fun cameraPositionStateRestoresChangedPosition() {
        assertStateIsRestored(
            create = { rememberCameraPositionState { position = InitialCameraPosition } },
            change = { it.position = ChangedCameraPosition },
            read = CameraPositionState::position,
            expected = ChangedCameraPosition,
        )
    }

    private fun <S : Any, R> assertStateIsRestored(
        create: @Composable () -> S,
        change: (S) -> Unit,
        read: (S) -> R,
        expected: R,
    ) {
        runComposeUiTest {
            val restorationTester = StateRestorationTester(this)
            var state: S? = null
            restorationTester.setContent {
                state = create()
            }

            val created = assertNotNull(state, "state was not created")
            change(created)
            restorationTester.emulateSaveAndRestore()

            val restored = assertNotNull(state, "state was not recreated")
            assertNotSame(created, restored, "composition was not recreated")
            assertEquals(expected, read(restored))
        }
    }

    private companion object {

        val InitialCircle = Circle(center = Point(55.751244, 37.618423), radius = 100f)
        val ChangedCircle = Circle(center = Point(59.938784, 30.314997), radius = 250f)

        val InitialPoint = Point(55.751244, 37.618423)
        val ChangedPoint = Point(59.938784, 30.314997)

        const val InitialDirection = 0f
        const val ChangedDirection = 90f

        val InitialCameraPosition = CameraPosition(
            target = InitialPoint,
            zoom = 10f,
            azimuth = 0f,
            tilt = 0f,
        )
        val ChangedCameraPosition = CameraPosition(
            target = ChangedPoint,
            zoom = 16f,
            azimuth = 45f,
            tilt = 30f,
        )
    }
}
