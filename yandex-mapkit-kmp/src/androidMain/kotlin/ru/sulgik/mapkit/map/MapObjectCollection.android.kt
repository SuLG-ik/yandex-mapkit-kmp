package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.map.MapObjectCollection as NativeMapObjectCollection

actual class MapObjectCollection internal constructor(private val nativeMapObjectCollection: NativeMapObjectCollection) :
    BaseMapObjectCollection(nativeMapObjectCollection) {

    override fun toNative(): NativeMapObjectCollection {
        return nativeMapObjectCollection
    }

    actual fun addPlacemark(): PlacemarkMapObject {
        return nativeMapObjectCollection.addPlacemark().toCommon()
    }

    actual fun addPlacemark(placemarkCreatedCallback: PlacemarkCreatedCallback): PlacemarkMapObject {
        return nativeMapObjectCollection.addPlacemark(placemarkCreatedCallback).toCommon()
    }

    actual fun addPolyline(polyline: Polyline): PolylineMapObject {
        return nativeMapObjectCollection.addPolyline(polyline.toNative()).toCommon()
    }

    actual fun addPolygon(polygon: Polygon): PolygonMapObject {
        return nativeMapObjectCollection.addPolygon(polygon.toNative()).toCommon()
    }

    actual fun addCircle(circle: Circle): CircleMapObject {
        return nativeMapObjectCollection.addCircle(circle.toNative()).toCommon()
    }

    actual fun addCollection(): MapObjectCollection {
        return nativeMapObjectCollection.addCollection().toCommon()
    }

    actual fun addClusterizedPlacemarkCollection(listener: ClusterListener): ClusterizedPlacemarkCollection {
        return nativeMapObjectCollection.addClusterizedPlacemarkCollection(listener).toCommon()
    }

    actual val placemarksStyler: PlacemarksStyler
        get() = nativeMapObjectCollection.placemarksStyler().toCommon()

}

fun NativeMapObjectCollection.toCommon(): MapObjectCollection {
    return MapObjectCollection(this)
}