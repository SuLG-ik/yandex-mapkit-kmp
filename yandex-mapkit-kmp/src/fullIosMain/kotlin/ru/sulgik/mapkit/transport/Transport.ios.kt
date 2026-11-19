package ru.sulgik.mapkit.transport

import ru.sulgik.mapkit.transport.masstransit.BicycleRouterV2
import ru.sulgik.mapkit.transport.masstransit.MasstransitRouter
import ru.sulgik.mapkit.transport.masstransit.PedestrianRouter
import ru.sulgik.mapkit.transport.masstransit.toCommon
import YandexMapKit.YMKTransport as NativeTransport
import YandexMapKit.YMKTransportFactory as NativeTransportFactory

/** Entry point for walking, cycling and public transport in Full MapKit. */
public actual class Transport internal constructor(
    private val nativeTransport: NativeTransport,
) {
    /** Returns the wrapped native handle. */
    public fun toNative(): NativeTransport = nativeTransport

    /** Tells whether this transport object is valid. */
    public actual val isValid: Boolean
        get() = nativeTransport.isValid()

    /** Creates a manager that builds pedestrian routes. */
    public actual fun createPedestrianRouter(): PedestrianRouter = nativeTransport.createPedestrianRouter().toCommon()

    /** Creates a manager that builds bicycle routes. */
    public actual fun createBicycleRouterV2(): BicycleRouterV2 = nativeTransport.createBicycleRouterV2().toCommon()

    /** Creates a manager that builds public transport routes. */
    public actual fun createMasstransitRouter(): MasstransitRouter = nativeTransport.createMasstransitRouter().toCommon()

    public actual companion object {
        /** Returns the transport entry point. */
        public actual fun getInstance(): Transport = NativeTransportFactory.instance().toCommon()
    }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Transport) return false
        return nativeTransport == other.nativeTransport
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int = nativeTransport.hashCode()
}

/** Wraps this native handle. */
public fun NativeTransport.toCommon(): Transport = Transport(this)
