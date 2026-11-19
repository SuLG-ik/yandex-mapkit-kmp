package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitTransfer as NativeTransfer

/** Native data for a transfer section. */
public actual class Transfer internal constructor(
    private val nativeTransfer: NativeTransfer,
) {
    /** Returns the wrapped native handle. */
    public fun toNative(): NativeTransfer = nativeTransfer

    /** The stop used by the transfer. */
    public actual val transferStop: TransferStop
        get() = nativeTransfer.transferStop.toCommon()

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Transfer) return false
        return nativeTransfer == other.nativeTransfer
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int = nativeTransfer.hashCode()
}

/** Wraps this native handle. */
public fun NativeTransfer.toCommon(): Transfer = Transfer(this)
