package ru.sulgik.mapkit.layers

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKGeoObjectTapEvent as NativeGeoObjectTapEvent
import YandexMapKit.YMKLayersGeoObjectTapListenerProtocol as NativeGeoObjectTapListener

/**
 * Listener that retrieves brief geo object info for the tapped object.
 */
public actual abstract class GeoObjectTapListener actual constructor() : NativeConvertible<NativeGeoObjectTapListener> {

    private val nativeListener = object : NativeGeoObjectTapListener, NSObject() {
        override fun onObjectTapWithEvent(event: NativeGeoObjectTapEvent): Boolean {
            return onObjectTap(event.toCommon())
        }
    }

    override fun toNative(): NativeGeoObjectTapListener {
        return nativeListener
    }

    /**
     * Returns false if the event wasn't handled. The event will be propagated to the map.
     */
    public actual abstract fun onObjectTap(event: GeoObjectTapEvent): Boolean
}
