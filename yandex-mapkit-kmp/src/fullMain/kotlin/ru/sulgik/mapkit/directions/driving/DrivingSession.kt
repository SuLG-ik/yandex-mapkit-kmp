package ru.sulgik.mapkit.directions.driving

/** A driving route request session. */
public expect class DrivingSession {

    /** Cancels the current request and releases its listener through any alias. Call on the UI thread. */
    public fun cancel()

    /** Retries the request using [routeListener]. Call on the UI thread. */
    public fun retry(routeListener: DrivingRouteListener)

    /** Two wrappers are equal when they hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
