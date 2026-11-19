package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKMasstransitRouteStop as NativeRouteStop
import YandexMapKit.YMKMasstransitSection as NativeSection
import YandexMapKit.YMKSubpolyline as NativeSubpolyline

/** A section of a walking, cycling or transit route. */
public actual class Section internal constructor(
    private val nativeSection: NativeSection,
) {
    /** Returns the wrapped native handle. */
    public fun toNative(): NativeSection = nativeSection

    /** General information about this section. */
    public actual val metadata: SectionMetadata
        get() = nativeSection.metadata.toCommon()

    /** The fragment of the route polyline that describes this section. */
    public actual val geometry: Subpolyline
        get() = nativeSection.geometry.toCommon()

    /** Stops from boarding to exiting transport, in route order. */
    public actual val stops: List<RouteStop>
        get() = nativeSection.stops.map { (it as NativeRouteStop).toCommon() }

    /** The geometry connecting consecutive stops on a transit ride. */
    public actual val rideLegs: List<Subpolyline>
        get() = nativeSection.rideLegs.map { (it as NativeSubpolyline).toCommon() }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Section) return false
        return nativeSection == other.nativeSection
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int = nativeSection.hashCode()
}

/** Wraps this native handle. */
public fun NativeSection.toCommon(): Section = Section(this)
