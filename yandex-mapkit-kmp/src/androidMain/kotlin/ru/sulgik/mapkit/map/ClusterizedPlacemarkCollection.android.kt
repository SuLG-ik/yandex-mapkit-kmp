package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.map.ClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection

actual class ClusterizedPlacemarkCollection internal constructor(
    private val nativeClusterizedPlacemarkCollection: NativeClusterizedPlacemarkCollection,
) : BaseMapObjectCollection(nativeClusterizedPlacemarkCollection) {

    override fun toNative(): NativeClusterizedPlacemarkCollection {
        return nativeClusterizedPlacemarkCollection
    }

    actual fun addPlacemark(): PlacemarkMapObject {
        return nativeClusterizedPlacemarkCollection.addPlacemark().toCommon()
    }

    actual fun addPlacemark(placemarkCreatedCallback: PlacemarkCreatedCallback): PlacemarkMapObject {
        return nativeClusterizedPlacemarkCollection.addPlacemark(placemarkCreatedCallback.toNative())
            .toCommon()
    }

    actual fun addEmptyPlacemarks(points: List<Point>): List<PlacemarkMapObject> {
        return nativeClusterizedPlacemarkCollection.addEmptyPlacemarks(points.map(Point::toNative))
            .map { it.toCommon() }
    }

    actual fun addPlacemarks(
        points: List<Point>,
        image: ImageProvider,
        style: IconStyle,
    ): List<PlacemarkMapObject> {
        return nativeClusterizedPlacemarkCollection.addPlacemarks(
            points.map(Point::toNative),
            image.toNative(),
            style.toNative()
        ).map { it.toCommon() }
    }

    actual fun clusterPlacemarks(clusterRadius: Double, minZoom: Int) {
        nativeClusterizedPlacemarkCollection.clusterPlacemarks(clusterRadius, minZoom)
    }

}


fun NativeClusterizedPlacemarkCollection.toCommon(): ClusterizedPlacemarkCollection {
    return ClusterizedPlacemarkCollection(this)
}