package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.map.BaseMetadata

/** A public transport line. */
public expect class Line : BaseMetadata {

    /** The line identifier. */
    public val id: String

    /** The line name. */
    public val name: String

    /** Vehicle types ordered from most detailed to most general. */
    public val vehicleTypes: List<String>

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
