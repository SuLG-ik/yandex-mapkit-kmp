package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.Point

/** A location and its role in a routing request. */
public data class RequestPoint(
    public val point: Point,
    public val type: RequestPointType,
    public val pointContext: String? = null,
    public val drivingArrivalPointId: String? = null,
    public val indoorLevelId: String? = null,
)
