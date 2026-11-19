package ru.sulgik.mapkit.transport.masstransit

/** A session for a walking, cycling or transit route request. */
public expect class Session {

    /** Cancels the current request and releases its listener through any alias. Call on the UI thread. */
    public fun cancel()

    /** Retries using [routeListener]. Call on the UI thread. */
    public fun retry(routeListener: RouteListener)

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
