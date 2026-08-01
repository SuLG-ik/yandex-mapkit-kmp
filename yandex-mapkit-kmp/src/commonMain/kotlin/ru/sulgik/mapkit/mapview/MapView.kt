package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.MapWindow

public expect class MapView {

    public val mapWindow: MapWindow

    /**
     * Should be called from from corresponding method of activity or fragment containing this view
     */
    public fun onStart()

    /**
     * Should be called from from corresponding method of activity or fragment containing this view
     */
    public fun onStop()

    public fun setNoninteractive(value: Boolean)

    /**
     * Explicitly destroys MapView, releasing its native resources.
     */
    public fun destroy()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
