package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.WeakRef

public expect class Cluster {

    public val placemarks: List<PlacemarkMapObject>

    public val size: Int

    public val appearance: PlacemarkMapObject

    public fun addClusterTapListener(listener: WeakRef<ClusterTapListener>)

    public fun removeClusterTapListener(listener: WeakRef<ClusterTapListener>)

    /**
     * Tells if this **Cluster** is valid or not.
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
