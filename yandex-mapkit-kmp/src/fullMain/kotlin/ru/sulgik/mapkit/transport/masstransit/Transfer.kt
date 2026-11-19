package ru.sulgik.mapkit.transport.masstransit

/** Native data for a transfer section. */
public expect class Transfer {

    /** The stop used by the transfer. */
    public val transferStop: TransferStop

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
