package ru.sulgik.mapkit.transport.masstransit

/** Transport suitable for a ride section. */
public expect class Transport {

    /** The public transport line. */
    public val line: Line

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
