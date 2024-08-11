package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.ClusterTapListener as NativeClusterTapListener

public actual abstract class ClusterTapListener actual constructor() {

    private val nativeListener = NativeClusterTapListener {
        onClusterTap(it.toCommon())
    }

    public fun toNative(): NativeClusterTapListener {
        return nativeListener
    }

    public actual abstract fun onClusterTap(cluster: Cluster): Boolean

}