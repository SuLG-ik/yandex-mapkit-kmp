package ru.sulgik.mapkit.transport.masstransit

/** Optional properties of a suggested route. */
public data class Flags(
    /** The route requires an access pass. */
    public val requiresAccessPass: Boolean = false,
    /** The route includes automotive roads. */
    public val hasAutoRoad: Boolean = false,
)
