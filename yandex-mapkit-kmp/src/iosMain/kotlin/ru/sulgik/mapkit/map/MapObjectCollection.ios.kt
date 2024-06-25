package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKMapObjectCollection as NativeMapObjectCollection

actual class MapObjectCollection internal constructor(private val nativeMapObjectCollection: NativeMapObjectCollection) :
    BaseMapObjectCollection(nativeMapObjectCollection) {

    // TODO:
    //  var placemarkStyled: PlacemarksStyler

    override fun toNative(): NativeMapObjectCollection {
        return nativeMapObjectCollection
    }

    actual fun addPlacemark(): PlacemarkMapObject {
        return nativeMapObjectCollection.addPlacemark().toCommon()
    }

    actual fun addPlacemark(placemarkCreatedCallback: PlacemarkCreatedCallback): PlacemarkMapObject {
        return nativeMapObjectCollection.addPlacemarkWithPlacemarkCreatedCallback(
            placemarkCreatedCallback
        ).toCommon()
    }

    actual fun addPolyline(polyline: Polyline): PolylineMapObject {
        return nativeMapObjectCollection.addPolylineWithPolyline(polyline.toNative()).toCommon()
    }

    actual fun addPolygon(polygon: Polygon): PolygonMapObject {
        return nativeMapObjectCollection.addPolygonWithPolygon(polygon.toNative()).toCommon()
    }

    actual fun addCircle(circle: Circle): CircleMapObject {
        return nativeMapObjectCollection.addCircleWithCircle(circle.toNative()).toCommon()
    }

    actual fun addCollection(): MapObjectCollection {
        return nativeMapObjectCollection.addCollection().toCommon()
    }

    actual fun addClusterizedPlacemarkCollection(listener: ClusterListener): ClusterizedPlacemarkCollection {
        return nativeMapObjectCollection.addClusterizedPlacemarkCollectionWithClusterListener(
            listener
        ).toCommon()
    }


}

fun NativeMapObjectCollection.toCommon(): MapObjectCollection {
    return MapObjectCollection(this)
}