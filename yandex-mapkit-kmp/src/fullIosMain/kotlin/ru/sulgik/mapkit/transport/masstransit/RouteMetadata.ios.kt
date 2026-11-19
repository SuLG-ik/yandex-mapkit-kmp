package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.map.BaseMetadata
import YandexMapKit.YMKMasstransitRouteMetadata as NativeRouteMetadata
import YandexMapKit.YMKMasstransitWayPoint as NativeWayPoint

/** Information about a walking, cycling or transit route. */
public actual class RouteMetadata internal constructor(private val nativeRouteMetadata: NativeRouteMetadata) : BaseMetadata {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeRouteMetadata {
        return nativeRouteMetadata
    }

    /** Travel time, walking distance and transfer count. */
    public actual val weight: Weight
        get() = nativeRouteMetadata.weight.toCommon()

    /** The router's settings, when reported. */
    public actual val settings: RouteSettings?
        get() = nativeRouteMetadata.settings?.toCommon()

    /** Estimated times, when the route is time-dependent. */
    public actual val estimation: TravelEstimation?
        get() = nativeRouteMetadata.estimation?.toCommon()

    /** Waypoints in route order. */
    public actual val wayPoints: List<WayPoint>
        get() = nativeRouteMetadata.wayPoints.map { (it as NativeWayPoint).toCommon() }

    /** The SDK route identifier, when reported. */
    public actual val routeId: String?
        get() = nativeRouteMetadata.routeId

    /** Route flags, when reported. */
    public actual val flags: Flags?
        get() = nativeRouteMetadata.flags?.toCommon()

    /** Stair and ramp counts. */
    public actual val stairsSummary: StairsSummary
        get() = nativeRouteMetadata.stairsSummary.toCommon()

    /** The SDK explanation of this route, when reported. */
    public actual val routeExplanation: String?
        get() = nativeRouteMetadata.routeExplanation

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RouteMetadata) return false
        return nativeRouteMetadata == other.nativeRouteMetadata
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeRouteMetadata.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeRouteMetadata.toCommon(): RouteMetadata {
    return RouteMetadata(this)
}
