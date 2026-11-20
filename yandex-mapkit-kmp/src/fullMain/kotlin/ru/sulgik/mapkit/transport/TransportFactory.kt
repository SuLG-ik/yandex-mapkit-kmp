package ru.sulgik.mapkit.transport

/** Factory for the transport entry point in Full MapKit. */
public expect object TransportFactory {

    /** Returns the transport entry point. */
    public fun getInstance(): Transport
}
