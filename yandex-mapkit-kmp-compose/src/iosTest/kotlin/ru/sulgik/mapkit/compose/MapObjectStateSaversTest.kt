package ru.sulgik.mapkit.compose

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.LinearRing
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.map.CameraPosition
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

public class MapObjectStateSaversTest {

    @Test
    public fun circleStateSaverKeepsGeometry() {
        val restored = saveAndRestore(CircleState.Saver, CircleState(CircleGeometry))
        assertEquals(CircleGeometry, restored.geometry)
    }

    @Test
    public fun placemarkStateSaverKeepsGeometryAndDirection() {
        val restored = saveAndRestore(
            PlacemarkState.Saver,
            PlacemarkState(geometry = PlacemarkPoint, direction = PlacemarkDirection),
        )
        assertEquals(PlacemarkPoint, restored.geometry)
        assertEquals(PlacemarkDirection, restored.direction)
    }

    @Test
    public fun cameraPositionStateSaverKeepsPosition() {
        val restored = saveAndRestore(CameraPositionState.Saver, CameraPositionState(CameraPositionValue))
        assertEquals(CameraPositionValue, restored.position)
    }

    @Test
    public fun polylineStateSaverKeepsPoints() {
        val geometry = Polyline(PolylinePoints)
        val restored = saveAndRestore(PolylineState.Saver, PolylineState(geometry))
        assertEquals(geometry.points, restored.geometry.points)
    }

    @Test
    public fun polygonStateSaverKeepsOuterRing() {
        val geometry = polygonOf(OuterRing, emptyList())
        val restored = saveAndRestore(PolygonState.Saver, PolygonState(geometry))
        assertEquals(geometry.rings(), restored.geometry.rings())
    }

    @Test
    public fun polygonStateSaverKeepsInnerRings() {
        val geometry = polygonOf(OuterRing, InnerRings)
        val restored = saveAndRestore(PolygonState.Saver, PolygonState(geometry))
        assertEquals(geometry.rings(), restored.geometry.rings())
    }

    private fun <T : Any> saveAndRestore(saver: Saver<T, Any>, value: T): T {
        val saved = with(saver) { SaverScope { true }.save(value) }
        return assertNotNull(
            saver.restore(assertNotNull(saved, "saver produced nothing")),
            "saver restored nothing",
        )
    }

    private fun polygonOf(outerRing: List<Point>, innerRings: List<List<Point>>): Polygon {
        return Polygon(
            outerRing = LinearRing(outerRing),
            innerRings = innerRings.map { LinearRing(it) },
        )
    }

    private fun Polygon.rings(): List<List<Point>> {
        return listOf(outerRing.points) + innerRings.map { it.points }
    }

    private companion object {

        val CircleGeometry = Circle(center = Point(55.751244, 37.618423), radius = 250f)

        val PlacemarkPoint = Point(59.938784, 30.314997)
        const val PlacemarkDirection = 90f

        val CameraPositionValue = CameraPosition(
            target = Point(55.751244, 37.618423),
            zoom = 16f,
            azimuth = 45f,
            tilt = 30f,
        )

        val PolylinePoints = listOf(
            Point(59.0, 30.0),
            Point(59.1, 30.1),
            Point(59.2, 30.2),
        )

        val OuterRing = listOf(
            Point(55.0, 37.0),
            Point(55.0, 38.0),
            Point(56.0, 38.0),
            Point(56.0, 37.0),
        )
        val InnerRings = listOf(
            listOf(
                Point(55.2, 37.2),
                Point(55.2, 37.4),
                Point(55.4, 37.4),
            ),
            listOf(
                Point(55.6, 37.6),
                Point(55.6, 37.8),
                Point(55.8, 37.8),
                Point(55.8, 37.6),
            ),
        )
    }
}
