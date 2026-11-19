package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitTransferStop as NativeTransferStop
import YandexMapKit.YMKMasstransitTransport as NativeTransport

/** A stop visited while transferring between rides. */
public actual class TransferStop internal constructor(private val nativeTransferStop: NativeTransferStop) {

    /** Returns the wrapped native handle. */
    public fun toNative(): NativeTransferStop {
        return nativeTransferStop
    }

    /** The stop used by the transfer. */
    public actual val routeStop: RouteStop
        get() = nativeTransferStop.routeStop.toCommon()

    /** Transport alternatives at the stop. */
    public actual val transports: List<Transport>
        get() = nativeTransferStop.transports.map { (it as NativeTransport).toCommon() }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TransferStop) return false
        return nativeTransferStop == other.nativeTransferStop
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int {
        return nativeTransferStop.hashCode()
    }
}

/** Wraps this native handle. */
public fun NativeTransferStop.toCommon(): TransferStop {
    return TransferStop(this)
}
