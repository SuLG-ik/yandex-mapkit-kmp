package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.map.BaseMetadata
import YandexMapKit.YMKMasstransitStop as NativeStop

/** A public transport stop. */
public actual class Stop internal constructor(
    private val nativeStop: NativeStop,
) : BaseMetadata {
    /** Returns the wrapped native handle. */
    public fun toNative(): NativeStop = nativeStop

    /** The stop identifier. */
    public actual val id: String
        get() = nativeStop.id

    /** The stop name. */
    public actual val name: String
        get() = nativeStop.name

    /** An additional stop name or index, when present. */
    public actual val additionalName: String?
        get() = nativeStop.additionalName

    /** Features of the stop, when present. */
    public actual val features: StopFeatureMask?
        get() = nativeStop.features?.toCommon()

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Stop) return false
        return nativeStop == other.nativeStop
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int = nativeStop.hashCode()
}

/** Wraps this native handle. */
public fun NativeStop.toCommon(): Stop = Stop(this)
