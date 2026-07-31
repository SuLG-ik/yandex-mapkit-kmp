package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKCluster as NativeCluster
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

public actual class Cluster internal constructor(private val nativeCluster: NativeCluster) {

    public fun toNative(): NativeCluster {
        return nativeCluster
    }

    public actual val placemarks: List<PlacemarkMapObject>
        @Suppress("UNCHECKED_CAST")
        get() = (nativeCluster.placemarks as List<NativePlacemarkMapObject>).map { it.toCommon() }

    public actual val size: Int
        get() = nativeCluster.size.toInt()

    public actual val appearance: PlacemarkMapObject
        get() = nativeCluster.appearance.toCommon()

    public actual fun addClusterTapListener(listener: WeakRef<ClusterTapListener>) {
        nativeCluster.addClusterTapListenerWithClusterTapListener(listener.toNative() ?: return)
    }

    public actual fun removeClusterTapListener(listener: WeakRef<ClusterTapListener>) {
        nativeCluster.removeClusterTapListenerWithClusterTapListener(listener.toNative() ?: return)
    }

    /**
     * Tells if this **Cluster** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeCluster.isValid()
}

public fun NativeCluster.toCommon(): Cluster {
    return Cluster(this)
}
