package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.map.BaseMetadata

/** A public transport stop. */
public expect class Stop : BaseMetadata {

    /** The stop identifier. */
    public val id: String

    /** The stop name. */
    public val name: String

    /** An additional stop name or index, when present. */
    public val additionalName: String?

    /** Features of the stop, when present. */
    public val features: StopFeatureMask?

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
