package ru.sulgik.mapkit.transport.masstransit

import kotlin.time.Instant

/** Desired time for a time-dependent route. Set either departure or arrival time. */
public data class TimeOptions(
    /** The desired UTC departure time. */
    public val departureTime: Instant? = null,
    /** The desired UTC arrival time. */
    public val arrivalTime: Instant? = null,
)
