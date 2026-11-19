package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.BoundingBox

/** Retain one suggest session for the lifetime of a query editor. Use it on the UI thread. */
public expect class SuggestSession {

    /**
     * Begins a suggest request in the map [window]. A new request replaces any pending request
     * in this session. Retain the session until the response, reset, or editor disposal.
     */
    public fun suggest(
        text: String,
        window: BoundingBox,
        suggestOptions: SuggestOptions,
        suggestListener: SuggestListener,
    )

    /**
     * Cancels the pending request and resets native state. The service treats the next request
     * as the start of a new session.
     */
    public fun reset()

    /** Two handles are equal when they wrap the same native session. */
    override fun equals(other: Any?): Boolean

    /** Returns the hash code of the native session. */
    override fun hashCode(): Int
}
