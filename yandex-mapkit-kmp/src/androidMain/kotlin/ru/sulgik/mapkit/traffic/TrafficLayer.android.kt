package ru.sulgik.mapkit.traffic

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.traffic.TrafficLayer as NativeTrafficLayer

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
        get() = nativeTrafficLayer.isTrafficVisible
        set(value) {
            nativeTrafficLayer.setTrafficVisible(value)
        }

    /**
     * Applies JSON style transformations to the traffic layer.
     */
    public actual fun setTrafficStyle(style: String): Boolean {
        return nativeTrafficLayer.setTrafficStyle(style)
    }

    /**
     * Applies JSON style transformations to the traffic layer.
     */
    public actual fun setTrafficStyle(id: Int, style: String): Boolean {
        return nativeTrafficLayer.setTrafficStyle(id, style)
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
        nativeTrafficLayer.addTrafficListener(trafficListener.toNative())
    }

    /**
     * Removes a traffic listener.
     */
    public actual fun removeTrafficListener(trafficListener: WeakRef<TrafficListener>) {
        nativeTrafficLayer.removeTrafficListener(trafficListener.toNative())
    }

    /**
     * Tells if this **TrafficLayer** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeTrafficLayer.isValid

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TrafficLayer) return false
        if (this::class != other::class) return false
        return nativeTrafficLayer == other.nativeTrafficLayer
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeTrafficLayer.hashCode()
    }
}

public fun NativeTrafficLayer.toCommon(): TrafficLayer {
    return TrafficLayer(this)
}
