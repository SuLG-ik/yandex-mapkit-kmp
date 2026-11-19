package ru.sulgik.mapkit.transport.masstransit

/** Native data for a taxi section. */
public expect class Taxi {

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
