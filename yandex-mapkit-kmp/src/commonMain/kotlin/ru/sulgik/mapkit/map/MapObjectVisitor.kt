package ru.sulgik.mapkit.map

public expect class MapObjectVisitor(
    onPlacemarkVisited: (placemark: PlacemarkMapObject) -> Unit,
    onPolylineVisited: (polyline: PolylineMapObject) -> Unit,
    onPolygonVisited: (polygon: PolygonMapObject) -> Unit,
    onCircleVisited: (circle: CircleMapObject) -> Unit,
    onCollectionVisitStart: (collection: MapObjectCollection) -> Boolean,
    onCollectionVisitEnd: (collection: MapObjectCollection) -> Boolean,
    onClusterizedCollectionVisitStart: (collection: ClusterizedPlacemarkCollection) -> Boolean,
    onClusterizedCollectionVisitEnd: (collection: ClusterizedPlacemarkCollection) -> Unit,
)