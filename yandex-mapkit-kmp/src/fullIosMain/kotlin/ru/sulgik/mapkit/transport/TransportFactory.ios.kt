package ru.sulgik.mapkit.transport

import YandexMapKit.YMKTransportFactory as NativeTransportFactory

/** Factory for the transport entry point in Full MapKit. */
public actual object TransportFactory {

    /** Returns the transport entry point. */
    public actual fun getInstance(): Transport {
        return NativeTransportFactory.instance().toCommon()
    }
}
