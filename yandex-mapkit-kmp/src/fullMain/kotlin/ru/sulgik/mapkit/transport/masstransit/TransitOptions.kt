package ru.sulgik.mapkit.transport.masstransit

/** Time and vehicle-type preferences for a public transit request. */
public data class TransitOptions(
    /** A bitwise OR of vehicle types to avoid. */
    public val avoid: Int = FilterVehicleTypes.NONE.value,
    /** Desired departure or arrival time. */
    public val timeOptions: TimeOptions = TimeOptions(),
)
