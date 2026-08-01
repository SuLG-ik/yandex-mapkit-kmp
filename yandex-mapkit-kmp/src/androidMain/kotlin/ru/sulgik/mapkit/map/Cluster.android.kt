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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Cluster) return false
        if (this::class != other::class) return false
        return nativeCluster == other.nativeCluster
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeCluster.hashCode()
    }
}

public fun NativeCluster.toCommon(): Cluster {
    return Cluster(this)
}
