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
}
