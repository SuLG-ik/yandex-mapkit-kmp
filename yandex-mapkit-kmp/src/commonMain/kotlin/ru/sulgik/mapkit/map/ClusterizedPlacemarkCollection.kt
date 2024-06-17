package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect class ClusterizedPlacemarkCollection : BaseMapObjectCollection {

    fun addPlacemark(): PlacemarkMapObject

    fun addPlacemark(placemarkCreatedCallback: PlacemarkCreatedCallback): PlacemarkMapObject

    fun addEmptyPlacemarks(points: List<Point>): List<PlacemarkMapObject>

    fun addPlacemarks(
        points: List<Point>,
        image: ImageProvider,
        style: IconStyle,
    ): List<PlacemarkMapObject>

    fun clusterPlacemarks(clusterRadius: Double, minZoom: Int)

}