package ru.sulgik.mapkit.map

expect abstract class MapObjectVisitor {

    abstract fun onPlacemarkVisited(placemark: PlacemarkMapObject)

    abstract fun onPolylineVisited(polyline: PolylineMapObject)

    abstract fun onPolygonVisited(polygon: PolygonMapObject)

    abstract fun onCircleVisited(circle: CircleMapObject)

    abstract fun onCollectionVisitStart(collection: MapObjectCollection): Boolean

    abstract fun onCollectionVisitEnd(collection: MapObjectCollection): Boolean

    abstract fun onClusterizedCollectionVisitStart(collection: ClusterizedPlacemarkCollection): Boolean

    abstract fun onClusterizedCollectionVisitEnd(collection: ClusterizedPlacemarkCollection)

}