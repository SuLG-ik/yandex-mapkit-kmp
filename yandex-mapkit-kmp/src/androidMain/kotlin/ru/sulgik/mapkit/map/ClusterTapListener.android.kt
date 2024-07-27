package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.ClusterTapListener as NativeClusterTapListener

actual abstract class ClusterTapListener actual constructor() {

    private val nativeListener = NativeClusterTapListener {
        onClusterTap(it.toCommon())
    }

    fun toNative(): NativeClusterTapListener {
        return nativeListener
    }

    actual abstract fun onClusterTap(cluster: Cluster): Boolean

}