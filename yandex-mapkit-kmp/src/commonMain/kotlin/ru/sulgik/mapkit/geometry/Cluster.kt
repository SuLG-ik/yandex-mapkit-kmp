package ru.sulgik.mapkit.geometry

import ru.sulgik.mapkit.map.ClusterTapListener
import ru.sulgik.mapkit.map.PlacemarkMapObject

public expect class Cluster {

    public val placemarks: List<PlacemarkMapObject>

    public val size: Int

    public val appearance: PlacemarkMapObject

    public fun addClusterTapListener(listener: ClusterTapListener)

    public fun removeClusterTapListener(listener: ClusterTapListener)

}