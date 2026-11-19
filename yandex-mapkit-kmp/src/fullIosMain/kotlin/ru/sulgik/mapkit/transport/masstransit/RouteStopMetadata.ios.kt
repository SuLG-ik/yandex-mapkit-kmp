package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.map.BaseMetadata
import YandexMapKit.YMKMasstransitRouteStopMetadata as NativeRouteStopMetadata

/** Stop information, with optional station entrances and exits. */
public actual class RouteStopMetadata internal constructor(private val nativeRouteStopMetadata: NativeRouteStopMetadata) : BaseMetadata {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeRouteStopMetadata {
        return nativeRouteStopMetadata
    }

    /** The stop on the route. */
    public actual val stop: Stop
        get() = nativeRouteStopMetadata.stop.toCommon()

    /** An underground station exit, when present. */
    public actual val stopExit: Stop?
        get() = nativeRouteStopMetadata.stopExit?.toCommon()

    /** The exit coordinates, when present. */
    public actual val exitPoint: Point?
        get() = nativeRouteStopMetadata.exitPoint?.toCommon()

    /** An underground station entrance, when present. */
    public actual val stopEntrance: Stop?
        get() = nativeRouteStopMetadata.stopEntrance?.toCommon()

    /** The entrance coordinates, when present. */
    public actual val entrancePoint: Point?
        get() = nativeRouteStopMetadata.entrancePoint?.toCommon()

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RouteStopMetadata) return false
        return nativeRouteStopMetadata == other.nativeRouteStopMetadata
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeRouteStopMetadata.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeRouteStopMetadata.toCommon(): RouteStopMetadata {
    return RouteStopMetadata(this)
}
