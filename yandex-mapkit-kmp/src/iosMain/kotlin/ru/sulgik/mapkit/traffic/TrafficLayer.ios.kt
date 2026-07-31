package ru.sulgik.mapkit.traffic

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKTrafficLayer as NativeTrafficLayer

/**
 * The traffic layer of the map.
 */
public actual class TrafficLayer internal constructor(
    private val nativeTrafficLayer: NativeTrafficLayer,
) {

    public fun toNative(): NativeTrafficLayer {
        return nativeTrafficLayer
    }

    /**
     * Manages traffic visibility.
     */
    public actual var isTrafficVisible: Boolean
        get() = nativeTrafficLayer.isTrafficVisible()
        set(value) {
            nativeTrafficLayer.setTrafficVisibleWithOn(value)
        }

    /**
     * Applies JSON style transformations to the traffic layer.
     */
    public actual fun setTrafficStyle(style: String): Boolean {
        return nativeTrafficLayer.setTrafficStyleWithStyle(style)
    }

    /**
     * Applies JSON style transformations to the traffic layer.
     */
    public actual fun setTrafficStyle(id: Int, style: String): Boolean {
        return nativeTrafficLayer.setTrafficStyleWithId(id.toLong(), style)
    }

    /**
     * Resets all JSON style transformations applied to the traffic layer.
     */
    public actual fun resetTrafficStyles() {
        nativeTrafficLayer.resetTrafficStyles()
    }

    /**
     * Adds a traffic listener.
     *
     * The class does not retain the object in the 'trafficListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addTrafficListener(trafficListener: WeakRef<TrafficListener>) {
        nativeTrafficLayer.addTrafficListenerWithTrafficListener(trafficListener.toNative() ?: return)
    }

    /**
     * Removes a traffic listener.
     */
    public actual fun removeTrafficListener(trafficListener: WeakRef<TrafficListener>) {
        nativeTrafficLayer.removeTrafficListenerWithTrafficListener(trafficListener.toNative() ?: return)
    }

    /**
     * Tells if this **TrafficLayer** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeTrafficLayer.isValid()
}

public fun NativeTrafficLayer.toCommon(): TrafficLayer {
    return TrafficLayer(this)
}
