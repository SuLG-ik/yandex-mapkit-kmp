package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitTransport as NativeTransport

/** Transport suitable for a ride section. */
public actual class Transport internal constructor(private val nativeTransport: NativeTransport) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeTransport {
        return nativeTransport
    }

    /** The public transport line. */
    public actual val line: Line
        get() = nativeTransport.line.toCommon()

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Transport) return false
        return nativeTransport == other.nativeTransport
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeTransport.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeTransport.toCommon(): Transport {
    return Transport(this)
}
