package ru.sulgik.mapkit.search

/**
 * A text search request in progress. Retain this session until the search completes or is canceled.
 */
public expect class Session {

    /** Cancels the current request. The listener receives no further events from this request. */
    public fun cancel()

    /** Two handles are equal when they wrap the same native session. */
    override fun equals(other: Any?): Boolean

    /** The hash code of the native session. */
    override fun hashCode(): Int
}
