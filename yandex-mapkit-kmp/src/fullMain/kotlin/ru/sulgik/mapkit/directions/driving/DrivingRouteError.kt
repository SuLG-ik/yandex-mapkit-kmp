package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.runtime.Error

/** A failure reported by the driving router. */
public expect class DrivingRouteError {

    /** The typed MapKit failure, when the platform supplies one. */
    public val error: Error?

    /** The native message, when the platform supplies one. */
    public val description: String?
}
