package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKMapObjectCollection as NativeMapObjectCollection

public actual class MapObjectCollection internal constructor(private val nativeMapObjectCollection: NativeMapObjectCollection) :
    BaseMapObjectCollection(nativeMapObjectCollection) {

    override fun toNative(): NativeMapObjectCollection {
        return nativeMapObjectCollection
    }

    public actual fun addPlacemark(): PlacemarkMapObject {
        return nativeMapObjectCollection.addPlacemark().toCommon()
    }

    public actual fun addPlacemark(placemarkCreatedCallback: PlacemarkCreatedCallback): PlacemarkMapObject {
        return nativeMapObjectCollection.addPlacemarkWithPlacemarkCreatedCallback(
            placemarkCreatedCallback.toNative()
        ).toCommon()
    }

    public actual fun addPolyline(polyline: Polyline): PolylineMapObject {
        return nativeMapObjectCollection.addPolylineWithPolyline(polyline.toNative()).toCommon()
    }

    public actual fun addPolygon(polygon: Polygon): PolygonMapObject {
        return nativeMapObjectCollection.addPolygonWithPolygon(polygon.toNative()).toCommon()
    }

    public actual fun addCircle(circle: Circle): CircleMapObject {
        return nativeMapObjectCollection.addCircleWithCircle(circle.toNative()).toCommon()
    }

    public actual fun addCollection(): MapObjectCollection {
        return nativeMapObjectCollection.addCollection().toCommon()
    }

    public actual fun addClusterizedPlacemarkCollection(listener: ClusterListener): ClusterizedPlacemarkCollection {
        return nativeMapObjectCollection.addClusterizedPlacemarkCollectionWithClusterListener(
            listener.toNative()
        ).toCommon()
    }

    public actual val placemarksStyler: PlacemarksStyler
        get() = nativeMapObjectCollection.placemarksStyler().toCommon()


}

public fun NativeMapObjectCollection.toCommon(): MapObjectCollection {
    return MapObjectCollection(this)
}