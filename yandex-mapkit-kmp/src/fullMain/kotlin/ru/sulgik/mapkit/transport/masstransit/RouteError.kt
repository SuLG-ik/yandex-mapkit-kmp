package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.runtime.Error

/** A failure reported by a walking, cycling or transit router. */
public expect class RouteError {
    /** The typed MapKit failure, when the platform supplies one. */
    public val error: Error?

    /** The native error message, when available. */
    public val description: String?
}
