package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.map.BaseMetadata
import YandexMapKit.YMKMasstransitLine as NativeLine

/** A public transport line. */
public actual class Line internal constructor(
    private val nativeLine: NativeLine,
) : BaseMetadata {
    /** Returns the wrapped native handle. */
    public fun toNative(): NativeLine = nativeLine

    /** The line identifier. */
    public actual val id: String
        get() = nativeLine.id

    /** The line name. */
    public actual val name: String
        get() = nativeLine.name

    /** Vehicle types ordered from most detailed to most general. */
    public actual val vehicleTypes: List<String>
        get() = nativeLine.vehicleTypes.map { it as String }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Line) return false
        return nativeLine == other.nativeLine
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int = nativeLine.hashCode()
}

/** Wraps this native handle. */
public fun NativeLine.toCommon(): Line = Line(this)
