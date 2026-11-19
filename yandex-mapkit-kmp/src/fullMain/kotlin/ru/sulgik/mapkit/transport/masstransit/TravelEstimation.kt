package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.Time

/** Estimated times for a time-dependent route or section. */
public data class TravelEstimation(
    /** Estimated departure time. */
    public val departureTime: Time,
    /** Estimated arrival time. */
    public val arrivalTime: Time,
)
