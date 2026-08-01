package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.layers.GeoObjectTapListener as NativeGeoObjectTapListener

/**
 * Listener that retrieves brief geo object info for the tapped object.
 */
public actual abstract class GeoObjectTapListener actual constructor() : NativeConvertible<NativeGeoObjectTapListener> {

    private val nativeListener = NativeGeoObjectTapListener { event ->
        onObjectTap(event.toCommon())
    }

    override fun toNative(): NativeGeoObjectTapListener {
        return nativeListener
    }

    /**
     * Returns false if the event wasn't handled. The event will be propagated to the map.
     */
    public actual abstract fun onObjectTap(event: GeoObjectTapEvent): Boolean
}
