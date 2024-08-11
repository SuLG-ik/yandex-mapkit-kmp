package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapObjectVisitor as NativeMapObjectVisitor

public actual class MapObjectVisitor actual constructor(
    private val onPlacemarkVisited: (placemark: PlacemarkMapObject) -> Unit,
    private val onPolylineVisited: (polyline: PolylineMapObject) -> Unit,
    private val onPolygonVisited: (polygon: PolygonMapObject) -> Unit,
    private val onCircleVisited: (circle: CircleMapObject) -> Unit,
    private val onCollectionVisitStart: (collection: MapObjectCollection) -> Boolean,
    private val onCollectionVisitEnd: (collection: MapObjectCollection) -> Boolean,
    private val onClusterizedCollectionVisitStart: (collection: ClusterizedPlacemarkCollection) -> Boolean,
    private val onClusterizedCollectionVisitEnd: (collection: ClusterizedPlacemarkCollection) -> Unit,
) : NativeMapObjectVisitor {

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