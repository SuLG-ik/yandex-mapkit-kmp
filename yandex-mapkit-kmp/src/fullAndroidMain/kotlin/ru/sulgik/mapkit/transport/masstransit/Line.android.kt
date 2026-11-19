package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.Line as NativeLine

/** A public transport line. */
public actual class Line internal constructor(private val nativeLine: NativeLine) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeLine {
        return nativeLine
    }

    /** The line identifier. */
    public actual val id: String
        get() = nativeLine.id

    /** The line name. */
    public actual val name: String
        get() = nativeLine.name

    /** Vehicle types ordered from most detailed to most general. */
    public actual val vehicleTypes: List<String>
        get() = nativeLine.vehicleTypes

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Line) return false
        return nativeLine == other.nativeLine
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeLine.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeLine.toCommon(): Line {
    return Line(this)
}
