package ru.sulgik.mapkit.geometry

import ru.sulgik.mapkit.geometry.geo.XYPoint
import ru.sulgik.mapkit.geometry.geo.toCommon
import ru.sulgik.mapkit.geometry.geo.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import com.yandex.mapkit.geometry.BoundingBox as NativeBoundingBox
import com.yandex.mapkit.geometry.Circle as NativeCircle
import com.yandex.mapkit.geometry.Direction as NativeDirection
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.geometry.PolylinePosition as NativePolylinePosition
import com.yandex.mapkit.geometry.Segment as NativeSegment
import com.yandex.mapkit.geometry.Span as NativeSpan
import com.yandex.mapkit.geometry.Subpolyline as NativeSubpolyline
import com.yandex.mapkit.geometry.geo.XYPoint as NativeXYPoint

public class GeometryConverterTest {

    @Test
    public fun `point keeps latitude and longitude in their own native fields`() {
        val native = Point(latitude = 55.75, longitude = 37.61).toNative()

        assertEquals(55.75, native.latitude, 0.0)
        assertEquals(37.61, native.longitude, 0.0)
    }

    @Test
    public fun `point reads latitude and longitude back from their own native fields`() {
        val common = NativePoint(55.75, 37.61).toCommon()

        assertEquals(Latitude(55.75), common.latitude)
        assertEquals(Longitude(37.61), common.longitude)
    }

    @Test
    public fun `direction keeps azimuth and tilt apart`() {
        val native = Direction(azimuth = 12.5, tilt = 40.25).toNative()

        assertEquals(12.5, native.azimuth, 0.0)
        assertEquals(40.25, native.tilt, 0.0)

        val common = NativeDirection(12.5, 40.25).toCommon()

        assertEquals(12.5, common.azimuth, 0.0)
        assertEquals(40.25, common.tilt, 0.0)
    }

    @Test
    public fun `span keeps horizontal and vertical angles apart`() {
        val native = Span(horizontalAngle = 1.5, verticalAngle = 2.5).toNative()

        assertEquals(1.5, native.horizontalAngle, 0.0)
        assertEquals(2.5, native.verticalAngle, 0.0)

        val common = NativeSpan(1.5, 2.5).toCommon()

        assertEquals(1.5, common.horizontalAngle, 0.0)
        assertEquals(2.5, common.verticalAngle, 0.0)
    }

    @Test
    public fun `xy point keeps x and y apart`() {
        val native = XYPoint(x = 3.5, y = -7.25).toNative()

        assertEquals(3.5, native.x, 0.0)
        assertEquals(-7.25, native.y, 0.0)

        val common = NativeXYPoint(3.5, -7.25).toCommon()

        assertEquals(3.5, common.x, 0.0)
        assertEquals(-7.25, common.y, 0.0)
    }

    @Test
    public fun `bounding box keeps south west and north east apart`() {
        val native = BoundingBox(
            southWest = Point(55.0, 37.0),
            northEast = Point(56.0, 38.0),
        ).toNative()

        assertEquals(55.0, native.southWest.latitude, 0.0)
        assertEquals(37.0, native.southWest.longitude, 0.0)
        assertEquals(56.0, native.northEast.latitude, 0.0)
        assertEquals(38.0, native.northEast.longitude, 0.0)

        val common = NativeBoundingBox(NativePoint(55.0, 37.0), NativePoint(56.0, 38.0)).toCommon()

        assertEquals(Point(55.0, 37.0), common.southWest)
        assertEquals(Point(56.0, 38.0), common.northEast)
    }

    @Test
    public fun `circle keeps the center and the radius apart`() {
        val native = Circle(center = Point(55.75, 37.61), radius = 250f).toNative()

        assertEquals(55.75, native.center.latitude, 0.0)
        assertEquals(37.61, native.center.longitude, 0.0)
        assertEquals(250f, native.radius, 0f)

        val common = NativeCircle(NativePoint(55.75, 37.61), 250f).toCommon()

        assertEquals(Point(55.75, 37.61), common.center)
        assertEquals(250f, common.radius, 0f)
    }

    @Test
    public fun `segment keeps the start and the end apart`() {
        val native = Segment(
            startPoint = Point(55.0, 37.0),
            endPoint = Point(56.0, 38.0),
        ).toNative()

        assertEquals(55.0, native.startPoint.latitude, 0.0)
        assertEquals(56.0, native.endPoint.latitude, 0.0)

        val common = NativeSegment(NativePoint(55.0, 37.0), NativePoint(56.0, 38.0)).toCommon()

        assertEquals(Point(55.0, 37.0), common.startPoint)
        assertEquals(Point(56.0, 38.0), common.endPoint)
    }

    @Test
    public fun `polyline position keeps the segment index and the segment position apart`() {
        val native = PolylinePosition(segmentIndex = 7, segmentPosition = 0.25).toNative()

        assertEquals(7, native.segmentIndex)
        assertEquals(0.25, native.segmentPosition, 0.0)

        val common = NativePolylinePosition(7, 0.25).toCommon()

        assertEquals(7, common.segmentIndex)
        assertEquals(0.25, common.segmentPosition, 0.0)
    }

    @Test
    public fun `subpolyline keeps the begin and the end apart`() {
        val native = Subpolyline(
            begin = PolylinePosition(1, 0.25),
            end = PolylinePosition(4, 0.75),
        ).toNative()

        assertEquals(1, native.begin.segmentIndex)
        assertEquals(0.25, native.begin.segmentPosition, 0.0)
        assertEquals(4, native.end.segmentIndex)
        assertEquals(0.75, native.end.segmentPosition, 0.0)

        val common = NativeSubpolyline(
            NativePolylinePosition(1, 0.25),
            NativePolylinePosition(4, 0.75),
        ).toCommon()

        assertEquals(PolylinePosition(1, 0.25), common.begin)
        assertEquals(PolylinePosition(4, 0.75), common.end)
    }
}
