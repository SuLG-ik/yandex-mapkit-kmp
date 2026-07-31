package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
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

    public actual fun addClusterTapListener(listener: WeakRef<ClusterTapListener>) {
        nativeCluster.addClusterTapListener(listener.toNative())
    }

    public actual fun removeClusterTapListener(listener: WeakRef<ClusterTapListener>) {
        nativeCluster.removeClusterTapListener(listener.toNative())
    }

    /**
     * Tells if this **Cluster** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeCluster.isValid
}

public fun NativeCluster.toCommon(): Cluster {
    return Cluster(this)
}
