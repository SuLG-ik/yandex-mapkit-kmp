package ru.sulgik.mapkit.geometry

import ru.sulgik.mapkit.map.ClusterTapListener
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.toCommon
import com.yandex.mapkit.map.Cluster as NativeCluster

actual class Cluster internal constructor(private val nativeCluster: NativeCluster) {

    fun toNative(): NativeCluster {
        return nativeCluster
    }

    actual val placemarks: List<PlacemarkMapObject>
        get() = nativeCluster.placemarks.map { it.toCommon() }

    actual val size: Int
        get() = nativeCluster.size

    actual val appearance: PlacemarkMapObject
        get() = nativeCluster.appearance.toCommon()

    actual fun addClusterTapListener(listener: ClusterTapListener) {
        nativeCluster.addClusterTapListener(listener)
    }

    actual fun removeClusterTapListener(listener: ClusterTapListener) {
        nativeCluster.removeClusterTapListener(listener)
    }

}


fun NativeCluster.toCommon(): Cluster {
    return Cluster(this)
}