package ru.sulgik.mapkit.geometry

import ru.sulgik.mapkit.geometry.geo.XYPoint
import ru.sulgik.mapkit.geometry.geo.toCommon
import ru.sulgik.mapkit.geometry.geo.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import YandexMapKit.YMKBoundingBox as NativeBoundingBox
import YandexMapKit.YMKCircle as NativeCircle
import YandexMapKit.YMKDirection as NativeDirection
import YandexMapKit.YMKPoint as NativePoint
import YandexMapKit.YMKPolylinePosition as NativePolylinePosition
import YandexMapKit.YMKSegment as NativeSegment
import YandexMapKit.YMKSpan as NativeSpan
import YandexMapKit.YMKSubpolyline as NativeSubpolyline
import YandexMapKit.YMKXYPoint as NativeXYPoint

public class GeometryConverterTest {

    @Test
    public fun `point keeps latitude and longitude in their own native fields`() {
        val native = Point(latitude = 55.75, longitude = 37.61).toNative()

        assertEquals(55.75, native.latitude)
        assertEquals(37.61, native.longitude)
    }

    @Test
    public fun `point reads latitude and longitude back from their own native fields`() {
        val common = NativePoint.pointWithLatitude(55.75, 37.61).toCommon()

        assertEquals(Latitude(55.75), common.latitude)
        assertEquals(Longitude(37.61), common.longitude)
    }

    @Test
    public fun `direction keeps azimuth and tilt apart`() {
        val native = Direction(azimuth = 12.5, tilt = 40.25).toNative()

        assertEquals(12.5, native.azimuth)
        assertEquals(40.25, native.tilt)

        val common = NativeDirection.directionWithAzimuth(12.5, 40.25).toCommon()

        assertEquals(12.5, common.azimuth)
        assertEquals(40.25, common.tilt)
    }

    @Test
    public fun `span keeps horizontal and vertical angles apart`() {
        val native = Span(horizontalAngle = 1.5, verticalAngle = 2.5).toNative()

        assertEquals(1.5, native.horizontalAngle)
        assertEquals(2.5, native.verticalAngle)

        val common = NativeSpan.spanWithHorizontalAngle(1.5, 2.5).toCommon()

        assertEquals(1.5, common.horizontalAngle)
        assertEquals(2.5, common.verticalAngle)
    }

    @Test
    public fun `xy point keeps x and y apart`() {
        val native = XYPoint(x = 3.5, y = -7.25).toNative()

        assertEquals(3.5, native.x)
        assertEquals(-7.25, native.y)

        val common = NativeXYPoint.xYPointWithX(3.5, -7.25).toCommon()

        assertEquals(3.5, common.x)
        assertEquals(-7.25, common.y)
    }

    @Test
    public fun `bounding box keeps south west and north east apart`() {
        val native = BoundingBox(
            southWest = Point(55.0, 37.0),
            northEast = Point(56.0, 38.0),
        ).toNative()

        assertEquals(55.0, native.southWest.latitude)
        assertEquals(37.0, native.southWest.longitude)
        assertEquals(56.0, native.northEast.latitude)
        assertEquals(38.0, native.northEast.longitude)

        val common = NativeBoundingBox.boundingBoxWithSouthWest(
            NativePoint.pointWithLatitude(55.0, 37.0),
            NativePoint.pointWithLatitude(56.0, 38.0),
        ).toCommon()

        assertEquals(Point(55.0, 37.0), common.southWest)
        assertEquals(Point(56.0, 38.0), common.northEast)
    }

    @Test
    public fun `circle keeps the center and the radius apart`() {
        val native = Circle(center = Point(55.75, 37.61), radius = 250f).toNative()

        assertEquals(55.75, native.center.latitude)
        assertEquals(37.61, native.center.longitude)
        assertEquals(250f, native.radius)

        val common = NativeCircle.circleWithCenter(
            NativePoint.pointWithLatitude(55.75, 37.61),
            250f,
        ).toCommon()

        assertEquals(Point(55.75, 37.61), common.center)
        assertEquals(250f, common.radius)
    }

    @Test
    public fun `segment keeps the start and the end apart`() {
        val native = Segment(
            startPoint = Point(55.0, 37.0),
            endPoint = Point(56.0, 38.0),
        ).toNative()

        assertEquals(55.0, native.startPoint.latitude)
        assertEquals(56.0, native.endPoint.latitude)

        val common = NativeSegment.segmentWithStartPoint(
            NativePoint.pointWithLatitude(55.0, 37.0),
            NativePoint.pointWithLatitude(56.0, 38.0),
        ).toCommon()

        assertEquals(Point(55.0, 37.0), common.startPoint)
        assertEquals(Point(56.0, 38.0), common.endPoint)
    }

    @Test
    public fun `polyline position keeps the segment index and the segment position apart`() {
        val native = PolylinePosition(segmentIndex = 7, segmentPosition = 0.25).toNative()

        assertEquals(7UL, native.segmentIndex)
        assertEquals(0.25, native.segmentPosition)

        val common = NativePolylinePosition.polylinePositionWithSegmentIndex(7UL, 0.25).toCommon()

        assertEquals(7, common.segmentIndex)
        assertEquals(0.25, common.segmentPosition)
    }

    @Test
    public fun `subpolyline keeps the begin and the end apart`() {
        val native = Subpolyline(
            begin = PolylinePosition(1, 0.25),
            end = PolylinePosition(4, 0.75),
        ).toNative()

        assertEquals(1UL, native.begin.segmentIndex)
        assertEquals(0.25, native.begin.segmentPosition)
        assertEquals(4UL, native.end.segmentIndex)
        assertEquals(0.75, native.end.segmentPosition)

        val common = NativeSubpolyline.subpolylineWithBegin(
            NativePolylinePosition.polylinePositionWithSegmentIndex(1UL, 0.25),
            NativePolylinePosition.polylinePositionWithSegmentIndex(4UL, 0.75),
        ).toCommon()

        assertEquals(PolylinePosition(1, 0.25), common.begin)
        assertEquals(PolylinePosition(4, 0.75), common.end)
    }

    @Test
    public fun `polyline keeps the point order and coordinates`() {
        val native = Polyline(listOf(Point(55.75, 37.61), Point(59.93, 30.31))).toNative()

        @Suppress("UNCHECKED_CAST")
        val points = native.points as List<NativePoint>

        assertEquals(2, points.size)
        assertEquals(55.75, points[0].latitude)
        assertEquals(37.61, points[0].longitude)
        assertEquals(59.93, points[1].latitude)
        assertEquals(30.31, points[1].longitude)

        assertEquals(listOf(Point(55.75, 37.61), Point(59.93, 30.31)), native.toCommon().points)
    }

    @Test
    public fun `linear ring keeps the point order and coordinates`() {
        val ring = LinearRing(listOf(Point(1.0, 2.0), Point(3.0, 4.0), Point(5.0, 6.0)))

        @Suppress("UNCHECKED_CAST")
        val points = ring.toNative().points as List<NativePoint>

        assertEquals(3, points.size)
        assertEquals(1.0, points[0].latitude)
        assertEquals(2.0, points[0].longitude)
        assertEquals(5.0, points[2].latitude)
        assertEquals(6.0, points[2].longitude)

        assertEquals(
            listOf(Point(1.0, 2.0), Point(3.0, 4.0), Point(5.0, 6.0)),
            ring.toNative().toCommon().points,
        )
    }

    @Test
    public fun `polygon keeps the outer ring apart from the inner rings`() {
        val outer = LinearRing(listOf(Point(0.0, 0.0), Point(0.0, 10.0), Point(10.0, 10.0)))
        val inner = LinearRing(listOf(Point(1.0, 1.0), Point(1.0, 2.0), Point(2.0, 2.0)))

        val native = Polygon(outer, listOf(inner)).toNative()

        @Suppress("UNCHECKED_CAST")
        val outerPoints = native.outerRing.points as List<NativePoint>

        assertEquals(0.0, outerPoints[0].latitude)
        assertEquals(10.0, outerPoints[1].longitude)
        assertEquals(1, native.innerRings.size)

        val common = native.toCommon()

        assertEquals(outer.points, common.outerRing.points)
        assertEquals(listOf(inner.points), common.innerRings.map { it.points })
    }

    @Test
    public fun `multi polygon keeps the polygon order`() {
        val first = Polygon(
            LinearRing(listOf(Point(0.0, 0.0), Point(0.0, 1.0), Point(1.0, 1.0))),
            emptyList(),
        )
        val second = Polygon(
            LinearRing(listOf(Point(5.0, 5.0), Point(5.0, 6.0), Point(6.0, 6.0))),
            emptyList(),
        )

        val common = MultiPolygon(listOf(first, second)).toNative().toCommon()

        assertEquals(2, common.polygons.size)
        assertEquals(Point(0.0, 0.0), common.polygons[0].outerRing.points[0])
        assertEquals(Point(5.0, 5.0), common.polygons[1].outerRing.points[0])
    }
}
