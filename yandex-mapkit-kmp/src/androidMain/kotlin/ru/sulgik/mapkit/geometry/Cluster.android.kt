package ru.sulgik.mapkit.geometry

import ru.sulgik.mapkit.map.ClusterTapListener
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.toCommon
import com.yandex.mapkit.map.Cluster as NativeCluster

public actual class Cluster internal constructor(private val nativeCluster: NativeCluster) {

    public fun toNative(): NativeCluster {
        return nativeCluster
    }

    public actual val placemarks: List<PlacemarkMapObject>
        get() = nativeCluster.placemarks.map { it.toCommon() }

    public actual val size: Int
        get() = nativeCluster.size

    public actual val appearance: PlacemarkMapObject
        get() = nativeCluster.appearance.toCommon()

    public actual fun addClusterTapListener(listener: ClusterTapListener) {
        nativeCluster.addClusterTapListener(listener.toNative())
    }

    public actual fun removeClusterTapListener(listener: ClusterTapListener) {
        nativeCluster.removeClusterTapListener(listener.toNative())
    }

}


public fun NativeCluster.toCommon(): Cluster {
    return Cluster(this)
}