package ru.sulgik.mapkit.map

import YandexMapKit.YMKCircleMapObject
import YandexMapKit.YMKClusterizedPlacemarkCollection
import YandexMapKit.YMKMapObjectCollection
import YandexMapKit.YMKMapObjectVisitorProtocol
import YandexMapKit.YMKPlacemarkMapObject
import YandexMapKit.YMKPolygonMapObject
import YandexMapKit.YMKPolylineMapObject
import platform.darwin.NSObject

public actual class MapObjectVisitor actual constructor(
    private val onPlacemarkVisited: (placemark: PlacemarkMapObject) -> Unit,
    private val onPolylineVisited: (polyline: PolylineMapObject) -> Unit,
    private val onPolygonVisited: (polygon: PolygonMapObject) -> Unit,
    private val onCircleVisited: (circle: CircleMapObject) -> Unit,
    private val onCollectionVisitStart: (collection: MapObjectCollection) -> Boolean,
    private val onCollectionVisitEnd: (collection: MapObjectCollection) -> Boolean,
    private val onClusterizedCollectionVisitStart: (collection: ClusterizedPlacemarkCollection) -> Boolean,
    private val onClusterizedCollectionVisitEnd: (collection: ClusterizedPlacemarkCollection) -> Unit,
) : YMKMapObjectVisitorProtocol, NSObject() {

    override fun onCircleVisitedWithCircle(circle: YMKCircleMapObject) {
        onCircleVisited(circle.toCommon())
    }

    override fun onClusterizedCollectionVisitEndWithCollection(collection: YMKClusterizedPlacemarkCollection) {
        onClusterizedCollectionVisitEnd(collection.toCommon())
    }

    override fun onClusterizedCollectionVisitStartWithCollection(collection: YMKClusterizedPlacemarkCollection): Boolean {
        return onClusterizedCollectionVisitStart(collection.toCommon())
    }

    override fun onCollectionVisitEndWithCollection(collection: YMKMapObjectCollection) {
        onCollectionVisitEnd(collection.toCommon())
    }

    override fun onCollectionVisitStartWithCollection(collection: YMKMapObjectCollection): Boolean {
        return onCollectionVisitStart(collection.toCommon())
    }

    override fun onPlacemarkVisitedWithPlacemark(placemark: YMKPlacemarkMapObject) {
        onPlacemarkVisited(placemark.toCommon())
    }

    override fun onPolygonVisitedWithPolygon(polygon: YMKPolygonMapObject) {
        onPolygonVisited(polygon.toCommon())
    }

    override fun onPolylineVisitedWithPolyline(polyline: YMKPolylineMapObject) {
        onPolylineVisited(polyline.toCommon())
    }
}