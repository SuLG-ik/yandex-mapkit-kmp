package ru.sulgik.mapkit.transport.masstransit

/** Counts of stairs and ramps along the route. */
public data class StairsSummary(
    /** Number of stairs along the route. */
    public val numberOfStairs: Int,
    /** Number of stairs with ramps. */
    public val numberOfStairsWithRamp: Int,
)
