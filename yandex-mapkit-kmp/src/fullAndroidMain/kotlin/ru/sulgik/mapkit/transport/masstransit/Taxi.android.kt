package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.Taxi as NativeTaxi

/** Native data for a taxi section. */
public actual class Taxi internal constructor(private val nativeTaxi: NativeTaxi) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeTaxi {
        return nativeTaxi
    }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Taxi) return false
        return nativeTaxi == other.nativeTaxi
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeTaxi.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeTaxi.toCommon(): Taxi {
    return Taxi(this)
}
