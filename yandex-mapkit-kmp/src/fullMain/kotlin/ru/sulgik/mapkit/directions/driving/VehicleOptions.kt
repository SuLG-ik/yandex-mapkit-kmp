package ru.sulgik.mapkit.directions.driving

/** The vehicle and any vehicle restrictions used when building a driving route. */
public data class VehicleOptions(
    public val vehicleType: VehicleType = VehicleType.DEFAULT,
    public val weight: Float? = null,
    public val axleWeight: Float? = null,
    public val maxWeight: Float? = null,
    public val height: Float? = null,
    public val width: Float? = null,
    public val length: Float? = null,
    public val payload: Float? = null,
    public val ecoClass: Int? = null,
    public val hasTrailer: Boolean? = null,
    public val buswayPermitted: Boolean? = null,
)
