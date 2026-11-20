package ru.sulgik.mapkit.transport.masstransit

/** Features of a public transport stop. */
public data class StopFeatureMask(
    /** Whether the stop is cooled in hot weather. */
    public val cooled: Boolean = false,
    /** Whether the stop is heated in cold weather. */
    public val heated: Boolean = false,
)
