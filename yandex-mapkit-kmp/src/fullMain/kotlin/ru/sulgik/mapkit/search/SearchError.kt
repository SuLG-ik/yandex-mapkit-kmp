package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.runtime.Error

/** A failure reported by the search service. */
public expect class SearchError {

    /** The typed MapKit failure, when the native platform supplies one. */
    public val error: Error?

    /** The platform's message, when available. */
    public val description: String?
}
