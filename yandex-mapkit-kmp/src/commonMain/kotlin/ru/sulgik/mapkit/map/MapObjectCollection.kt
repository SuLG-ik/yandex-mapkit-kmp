package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.Polyline

expect class MapObjectCollection : BaseMapObjectCollection {

    fun addPlacemark(): PlacemarkMapObject

    fun addPlacemark(placemarkCreatedCallback: PlacemarkCreatedCallback): PlacemarkMapObject

    fun addPolyline(polyline: Polyline): PolylineMapObject

    fun addPolygon(polygon: Polygon): PolygonMapObject

    fun addCircle(circle: Circle): CircleMapObject

    fun addCollection(): MapObjectCollection

    fun addClusterizedPlacemarkCollection(listener: ClusterListener): ClusterizedPlacemarkCollection
    // TODO:
    //  var placemarkStyled: PlacemarksStyler


}