package ru.sulgik.mapkit.geometry

import ru.sulgik.mapkit.map.ClusterTapListener
import ru.sulgik.mapkit.map.PlacemarkMapObject

expect class Cluster {

    val placemarks: List<PlacemarkMapObject>

    val size: Int

    val appearance: PlacemarkMapObject

    fun addClusterTapListener(listener: ClusterTapListener)

    fun removeClusterTapListener(listener: ClusterTapListener)

}