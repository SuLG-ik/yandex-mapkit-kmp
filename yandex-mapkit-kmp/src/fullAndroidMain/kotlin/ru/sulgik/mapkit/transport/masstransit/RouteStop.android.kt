package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.transport.masstransit.RouteStop as NativeRouteStop

/** A public transport stop on a route. */
public actual class RouteStop internal constructor(private val nativeRouteStop: NativeRouteStop) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeRouteStop {
        return nativeRouteStop
    }

    /** The stop information and optional entrances or exits. */
    public actual val metadata: RouteStopMetadata
        get() = nativeRouteStop.metadata.toCommon()

    /** The stop coordinates. */
    public actual val position: Point
        get() = nativeRouteStop.position.toCommon()

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RouteStop) return false
        return nativeRouteStop == other.nativeRouteStop
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeRouteStop.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeRouteStop.toCommon(): RouteStop {
    return RouteStop(this)
}
