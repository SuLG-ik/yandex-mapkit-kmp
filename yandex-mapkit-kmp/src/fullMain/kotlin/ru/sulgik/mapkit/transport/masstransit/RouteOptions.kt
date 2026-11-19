package ru.sulgik.mapkit.transport.masstransit

/** Route-building preferences. */
public data class RouteOptions(
    /** Preferences for steep sections and stairs. */
    public val fitnessOptions: FitnessOptions = FitnessOptions(),
)
