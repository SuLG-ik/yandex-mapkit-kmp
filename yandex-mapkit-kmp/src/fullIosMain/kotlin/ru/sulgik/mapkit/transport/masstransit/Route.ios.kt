package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.uri.UriObjectMetadata
import ru.sulgik.mapkit.uri.toCommon
import YandexMapKit.YMKMasstransitRoute as NativeRoute
import YandexMapKit.YMKMasstransitSection as NativeSection
import YandexMapKit.YMKMasstransitWayPoint as NativeWayPoint

/** A walking, cycling or transit route returned by MapKit. */
public actual class Route internal constructor(private val nativeRoute: NativeRoute) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeRoute {
        return nativeRoute
    }

    /** General information about this route. */
    public actual val metadata: RouteMetadata
        get() = nativeRoute.metadata.toCommon()

    /** Waypoints in route order. */
    public actual val wayPoints: List<WayPoint>
        get() = nativeRoute.wayPoints.map { (it as NativeWayPoint).toCommon() }

    /** Sections in route order. */
    public actual val sections: List<Section>
        get() = nativeRoute.sections.map { (it as NativeSection).toCommon() }

    /** Geometry of the whole route. */
    public actual val geometry: Polyline
        get() = nativeRoute.geometry.toCommon()

    /** URI metadata that can identify the route. */
    public actual val uriMetadata: UriObjectMetadata
        get() = nativeRoute.uriMetadata.toCommon()

    /** Returns the path distance between two positions on this route. */
    public actual fun distanceBetweenPolylinePositions(from: PolylinePosition, to: PolylinePosition): Double {
        return nativeRoute.distanceBetweenPolylinePositionsWithFrom(from = from.toNative(), to = to.toNative())
    }

    /** Returns the travel time between two positions on this route. */
    public actual fun timeBetweenPolylinePositions(from: PolylinePosition, to: PolylinePosition): Double {
        return nativeRoute.timeBetweenPolylinePositionsWithFrom(from = from.toNative(), to = to.toNative())
    }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Route) return false
        return nativeRoute == other.nativeRoute
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeRoute.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeRoute.toCommon(): Route {
    return Route(this)
}
