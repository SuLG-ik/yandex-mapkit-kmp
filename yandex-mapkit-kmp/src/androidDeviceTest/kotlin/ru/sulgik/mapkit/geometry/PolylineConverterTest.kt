package ru.sulgik.mapkit.geometry

import ru.sulgik.mapkit.MapKitRuntime
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import com.yandex.mapkit.geometry.LinearRing as NativeLinearRing
import com.yandex.mapkit.geometry.MultiPolygon as NativeMultiPolygon
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.geometry.Polygon as NativePolygon
import com.yandex.mapkit.geometry.Polyline as NativePolyline

public class PolylineConverterTest {

    @BeforeTest
    public fun setUp() {
        MapKitRuntime.ensureLoaded()
    }

    @Test
    public fun polyline_keeps_the_point_order_and_coordinates() {
        val native = Polyline(listOf(Point(55.75, 37.61), Point(59.93, 30.31))).toNative()

        assertEquals(2, native.points.size)
        assertEquals(55.75, native.points[0].latitude, 0.0)
        assertEquals(37.61, native.points[0].longitude, 0.0)
        assertEquals(59.93, native.points[1].latitude, 0.0)
        assertEquals(30.31, native.points[1].longitude, 0.0)
    }

    @Test
    public fun polyline_reads_the_points_back_in_order() {
        val common = NativePolyline(listOf(NativePoint(55.75, 37.61), NativePoint(59.93, 30.31))).toCommon()

        assertEquals(listOf(Point(55.75, 37.61), Point(59.93, 30.31)), common.points)
    }

    @Test
    public fun linear_ring_keeps_the_point_order_and_coordinates() {
        val native = LinearRing(
            listOf(Point(1.0, 2.0), Point(3.0, 4.0), Point(5.0, 6.0)),
        ).toNative()

        assertEquals(3, native.points.size)
        assertEquals(1.0, native.points[0].latitude, 0.0)
        assertEquals(2.0, native.points[0].longitude, 0.0)
        assertEquals(5.0, native.points[2].latitude, 0.0)
        assertEquals(6.0, native.points[2].longitude, 0.0)

        assertEquals(
            listOf(Point(1.0, 2.0), Point(3.0, 4.0), Point(5.0, 6.0)),
            native.toCommon().points,
        )
    }

    @Test
    public fun polygon_keeps_the_outer_ring_apart_from_the_inner_rings() {
        val outer = LinearRing(listOf(Point(0.0, 0.0), Point(0.0, 10.0), Point(10.0, 10.0)))
        val inner = LinearRing(listOf(Point(1.0, 1.0), Point(1.0, 2.0), Point(2.0, 2.0)))

        val native = Polygon(outer, listOf(inner)).toNative()

        assertEquals(0.0, native.outerRing.points[0].latitude, 0.0)
        assertEquals(10.0, native.outerRing.points[1].longitude, 0.0)
        assertEquals(1, native.innerRings.size)
        assertEquals(1.0, native.innerRings[0].points[0].latitude, 0.0)

        val common = native.toCommon()

        assertEquals(outer.points, common.outerRing.points)
        assertEquals(listOf(inner.points), common.innerRings.map { it.points })
    }

    @Test
    public fun polygon_reads_an_empty_inner_ring_list_back_as_empty() {
        val nativeOuter = NativeLinearRing(
            listOf(NativePoint(0.0, 0.0), NativePoint(0.0, 1.0), NativePoint(1.0, 1.0)),
        )
        val common = NativePolygon(nativeOuter, emptyList()).toCommon()

        assertEquals(emptyList(), common.innerRings)
    }

    @Test
    public fun multi_polygon_keeps_the_polygon_order() {
        val first = Polygon(
            LinearRing(listOf(Point(0.0, 0.0), Point(0.0, 1.0), Point(1.0, 1.0))),
            emptyList(),
        )
        val second = Polygon(
            LinearRing(listOf(Point(5.0, 5.0), Point(5.0, 6.0), Point(6.0, 6.0))),
            emptyList(),
        )

        val native = MultiPolygon(listOf(first, second)).toNative()

        assertEquals(2, native.polygons.size)
        assertEquals(0.0, native.polygons[0].outerRing.points[0].latitude, 0.0)
        assertEquals(5.0, native.polygons[1].outerRing.points[0].latitude, 0.0)

        val common = NativeMultiPolygon(listOf(first.toNative(), second.toNative())).toCommon()

        assertEquals(2, common.polygons.size)
        assertEquals(Point(0.0, 0.0), common.polygons[0].outerRing.points[0])
        assertEquals(Point(5.0, 5.0), common.polygons[1].outerRing.points[0])
    }
}
