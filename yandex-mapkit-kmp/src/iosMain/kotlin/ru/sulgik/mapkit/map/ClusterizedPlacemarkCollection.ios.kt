package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

actual class ClusterizedPlacemarkCollection(private val nativeClusterizedPlacemarkCollection: NativeClusterizedPlacemarkCollection) :
    BaseMapObjectCollection(nativeClusterizedPlacemarkCollection) {

    override fun toNative(): NativeClusterizedPlacemarkCollection {
        return nativeClusterizedPlacemarkCollection
    }

    actual fun addPlacemark(): PlacemarkMapObject {
        return nativeClusterizedPlacemarkCollection.addPlacemark().toCommon()
    }

    actual fun addPlacemark(placemarkCreatedCallback: PlacemarkCreatedCallback): PlacemarkMapObject {
        return nativeClusterizedPlacemarkCollection
            .addPlacemarkWithPlacemarkCreatedCallback(placemarkCreatedCallback)
            .toCommon()
    }

    @Suppress("UNCHECKED_CAST")
    actual fun addEmptyPlacemarks(points: List<Point>): List<PlacemarkMapObject> {
        return (nativeClusterizedPlacemarkCollection
            .addEmptyPlacemarksWithPoints(points.map { it.toNative() }) as List<NativePlacemarkMapObject>)
            .map { it.toCommon() }
    }

    actual fun addPlacemarks(
        points: List<Point>,
        image: ImageProvider,
        style: IconStyle,
    ): List<PlacemarkMapObject> {
        @Suppress("UNCHECKED_CAST")
        return (nativeClusterizedPlacemarkCollection
            .addPlacemarksWithPoints(
                points.map { it.toNative() },
                image.toNative(),
                style.toNative()
            ) as List<NativePlacemarkMapObject>)
            .map { it.toCommon() }
    }

    actual fun clusterPlacemarks(clusterRadius: Double, minZoom: Int) {
        nativeClusterizedPlacemarkCollection.clusterPlacemarksWithClusterRadius(
            clusterRadius,
            minZoom.toULong(),
        )
    }

}

fun NativeClusterizedPlacemarkCollection.toCommon(): ClusterizedPlacemarkCollection {
    return ClusterizedPlacemarkCollection(this)
}