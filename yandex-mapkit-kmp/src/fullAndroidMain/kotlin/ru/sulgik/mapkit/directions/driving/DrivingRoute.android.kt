package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.RequestPoint
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.toCommon
import com.yandex.mapkit.directions.driving.DrivingRoute as NativeDrivingRoute

/** A driving route returned by MapKit. */
public actual class DrivingRoute internal constructor(private val nativeDrivingRoute: NativeDrivingRoute) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeDrivingRoute {
        return nativeDrivingRoute
    }

    /** The SDK route identifier. */
    public actual val routeId: String
        get() = nativeDrivingRoute.routeId

    /** Route geometry. */
    public actual val geometry: Polyline
        get() = nativeDrivingRoute.geometry.toCommon()

    /** The points from the originating request, when supplied by the SDK. */
    public actual val requestPoints: List<RequestPoint>?
        get() = nativeDrivingRoute.requestPoints?.map { it.toCommon() }

    /** Positions of the waypoints on [geometry], including the first and last points. */
    public actual val wayPoints: List<PolylinePosition>
        get() = nativeDrivingRoute.wayPoints.map { it.toCommon() }

    /** Two wrappers are equal when they hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DrivingRoute) return false
        return nativeDrivingRoute == other.nativeDrivingRoute
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeDrivingRoute.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeDrivingRoute.toCommon(): DrivingRoute {
    return DrivingRoute(this)
}
