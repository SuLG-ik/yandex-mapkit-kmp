package ru.sulgik.mapkit.layers

/**
 * Listener that retrieves brief geo object info for the tapped object.
 */
public expect abstract class GeoObjectTapListener() {

    /**
     * Returns false if the event wasn't handled. The event will be propagated to the map.
     */
    public abstract fun onObjectTap(event: GeoObjectTapEvent): Boolean
}

public inline fun GeoObjectTapListener(
    crossinline onObjectTap: (event: GeoObjectTapEvent) -> Boolean,
): GeoObjectTapListener {
    return object : GeoObjectTapListener() {
        override fun onObjectTap(event: GeoObjectTapEvent): Boolean {
            return onObjectTap.invoke(event)
        }
    }
}
