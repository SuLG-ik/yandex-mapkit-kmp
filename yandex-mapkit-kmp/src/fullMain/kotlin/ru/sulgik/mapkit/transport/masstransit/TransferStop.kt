package ru.sulgik.mapkit.transport.masstransit

/** A stop visited while transferring between rides. */
public expect class TransferStop {

    /** The stop used by the transfer. */
    public val routeStop: RouteStop

    /** Transport alternatives at the stop. */
    public val transports: List<Transport>

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
