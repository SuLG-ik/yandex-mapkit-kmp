package ru.sulgik.mapkit.transport.masstransit

/** Preferences for pedestrian and bicycle routes. */
public data class FitnessOptions(
    /** Prefer routes that avoid steep sections. */
    public val avoidSteep: Boolean = false,
    /** Prefer routes that avoid stairs. */
    public val avoidStairs: Boolean = false,
)
