package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.Geometry

/**
 * Manager for searching for geographical objects.
 */
public expect class SearchManager {

    /**
     * Searches near a point, bounding box, polyline or rectangular polygon.
     *
     * Call on the UI thread and retain the returned session. The session holds the listener until
     * delivery or cancellation. Call [Session.cancel] when leaving the owning screen or replacing
     * the request. The listener runs on the UI thread.
     */
    public fun submit(
        text: String,
        geometry: Geometry,
        searchOptions: SearchOptions,
        searchListener: SearchListener,
    ): Session

    /** Creates a session for suggest requests. Retain it for the lifetime of the query editor. */
    public fun createSuggestSession(): SuggestSession

    /** Two handles are equal when they wrap the same native search manager. */
    override fun equals(other: Any?): Boolean

    /** Returns the hash code of the native search manager. */
    override fun hashCode(): Int
}
