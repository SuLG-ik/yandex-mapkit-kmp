package ru.sulgik.mapkit.transport

import ru.sulgik.mapkit.transport.masstransit.PedestrianRouter

/** Entry point for walking, cycling and public transport in Full MapKit. */
public expect class Transport {

    /** Tells whether this transport object is valid. */
    public val isValid: Boolean

    /** Creates a manager that builds pedestrian routes. */
    public fun createPedestrianRouter(): PedestrianRouter

    public companion object {

        /** Returns the transport entry point. */
        public fun getInstance(): Transport
    }

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
