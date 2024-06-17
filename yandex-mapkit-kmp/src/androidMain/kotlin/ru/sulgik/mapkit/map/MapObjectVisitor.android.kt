package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapObjectVisitor as NativeMapObjectVisitor

actual abstract class MapObjectVisitor : NativeMapObjectVisitor {
    actual abstract fun onPlacemarkVisited(placemark: PlacemarkMapObject)
    actual abstract fun onPolylineVisited(polyline: PolylineMapObject)
    actual abstract fun onPolygonVisited(polygon: PolygonMapObject)
    actual abstract fun onCircleVisited(circle: CircleMapObject)
    actual abstract fun onCollectionVisitStart(collection: MapObjectCollection): Boolean
    actual abstract fun onCollectionVisitEnd(collection: MapObjectCollection): Boolean
    actual abstract fun onClusterizedCollectionVisitStart(collection: ClusterizedPlacemarkCollection): Boolean
    actual abstract fun onClusterizedCollectionVisitEnd(collection: ClusterizedPlacemarkCollection)

    override fun onPlacemarkVisited(p0: com.yandex.mapkit.map.PlacemarkMapObject) {
        onPlacemarkVisited(p0.toCommon())
    }

    override fun onPolylineVisited(p0: com.yandex.mapkit.map.PolylineMapObject) {
        onPolylineVisited(p0.toCommon())
    }

    override fun onPolygonVisited(p0: com.yandex.mapkit.map.PolygonMapObject) {
        onPolygonVisited(p0.toCommon())
    }

    override fun onCircleVisited(p0: com.yandex.mapkit.map.CircleMapObject) {
        onCircleVisited(p0.toCommon())
    }

    override fun onCollectionVisitStart(p0: com.yandex.mapkit.map.MapObjectCollection): Boolean {
        return onCollectionVisitStart(p0.toCommon())
    }

    override fun onCollectionVisitEnd(p0: com.yandex.mapkit.map.MapObjectCollection) {
        onCollectionVisitEnd(p0.toCommon())
    }

    override fun onClusterizedCollectionVisitStart(p0: com.yandex.mapkit.map.ClusterizedPlacemarkCollection): Boolean {
        return onClusterizedCollectionVisitStart(p0.toCommon())
    }

    override fun onClusterizedCollectionVisitEnd(p0: com.yandex.mapkit.map.ClusterizedPlacemarkCollection) {
        onClusterizedCollectionVisitEnd(p0.toCommon())
    }
}