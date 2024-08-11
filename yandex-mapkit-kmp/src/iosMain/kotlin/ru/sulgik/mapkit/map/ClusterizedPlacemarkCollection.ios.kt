package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

public actual class ClusterizedPlacemarkCollection internal constructor(
    private val nativeClusterizedPlacemarkCollection: NativeClusterizedPlacemarkCollection,
) :
    BaseMapObjectCollection(nativeClusterizedPlacemarkCollection) {

    override fun toNative(): NativeClusterizedPlacemarkCollection {
        return nativeClusterizedPlacemarkCollection
    }

    public actual fun addPlacemark(): PlacemarkMapObject {
        return nativeClusterizedPlacemarkCollection.addPlacemark().toCommon()
    }

    public actual fun addPlacemark(placemarkCreatedCallback: PlacemarkCreatedCallback): PlacemarkMapObject {
        return nativeClusterizedPlacemarkCollection
            .addPlacemarkWithPlacemarkCreatedCallback(placemarkCreatedCallback.toNative())
            .toCommon()
    }

    @Suppress("UNCHECKED_CAST")
    public actual fun addEmptyPlacemarks(points: List<Point>): List<PlacemarkMapObject> {
        return (nativeClusterizedPlacemarkCollection
            .addEmptyPlacemarksWithPoints(points.map { it.toNative() }) as List<NativePlacemarkMapObject>)
            .map { it.toCommon() }
    }

    public actual fun addPlacemarks(
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

    public actual fun clusterPlacemarks(clusterRadius: Double, minZoom: Int) {
        nativeClusterizedPlacemarkCollection.clusterPlacemarksWithClusterRadius(
            clusterRadius,
            minZoom.toULong(),
        )
    }

}

public fun NativeClusterizedPlacemarkCollection.toCommon(): ClusterizedPlacemarkCollection {
    return ClusterizedPlacemarkCollection(this)
}