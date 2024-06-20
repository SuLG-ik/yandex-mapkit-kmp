package ru.sulgik.mapkit.geometry

import ru.sulgik.mapkit.map.ClusterTapListener
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.toCommon
import YandexMapKit.YMKCluster as NativeCluster
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

actual class Cluster(private val nativeCluster: NativeCluster) {

    fun toNative(): NativeCluster {
        return nativeCluster
    }

    actual val placemarks: List<PlacemarkMapObject>
        get() = (nativeCluster.placemarks as List<NativePlacemarkMapObject>).map { it.toCommon() }

    actual val size: Int
        get() = nativeCluster.size.toInt()
    actual val appearance: PlacemarkMapObject
        get() = nativeCluster.appearance.toCommon()

    actual fun addClusterTapListener(listener: ClusterTapListener) {
        nativeCluster.addClusterTapListenerWithClusterTapListener(listener)
    }

    actual fun removeClusterTapListener(listener: ClusterTapListener) {
        nativeCluster.removeClusterTapListenerWithClusterTapListener(listener)
    }

}

fun NativeCluster.toCommon(): Cluster {
    return Cluster(this)
}