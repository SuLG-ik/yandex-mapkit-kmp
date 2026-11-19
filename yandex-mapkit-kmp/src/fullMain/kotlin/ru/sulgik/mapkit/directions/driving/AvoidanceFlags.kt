package ru.sulgik.mapkit.directions.driving

/** Features a driving router tries to avoid when possible. */
public data class AvoidanceFlags(
    public val avoidTolls: Boolean = false,
    public val avoidUnpaved: Boolean = false,
    public val avoidPoorCondition: Boolean = false,
    public val avoidRailwayCrossing: Boolean = false,
    public val avoidBoatFerry: Boolean = false,
    public val avoidFordCrossing: Boolean = false,
    public val avoidTunnel: Boolean = false,
    public val avoidHighway: Boolean = false,
)
