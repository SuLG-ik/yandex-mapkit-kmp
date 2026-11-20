package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.LocalizedValue

/** Numeric characteristics of a route or section. */
public data class Weight(
    /** Travel time. */
    public val time: LocalizedValue,
    /** Distance of the walking part. */
    public val walkingDistance: LocalizedValue,
    /** The number of transfers. */
    public val transfersCount: Int,
)
