package ru.sulgik.mapkit.traffic

import ru.sulgik.mapkit.WeakRef

/**
 * The traffic layer of the map.
 */
public expect class TrafficLayer {

    /**
     * Manages traffic visibility.
     */
    public var isTrafficVisible: Boolean

    /**
     * Applies JSON style transformations to the traffic layer.
     */
    public fun setTrafficStyle(style: String): Boolean

    /**
     * Applies JSON style transformations to the traffic layer.
     */
    public fun setTrafficStyle(id: Int, style: String): Boolean

    /**
     * Resets all JSON style transformations applied to the traffic layer.
     */
    public fun resetTrafficStyles()

    /**
     * Adds a traffic listener.
     *
     * The class does not retain the object in the 'trafficListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun addTrafficListener(trafficListener: WeakRef<TrafficListener>)

    /**
     * Removes a traffic listener.
     */
    public fun removeTrafficListener(trafficListener: WeakRef<TrafficListener>)

    /**
     * Tells if this **TrafficLayer** is valid or not.
     */
    public val isValid: Boolean

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
