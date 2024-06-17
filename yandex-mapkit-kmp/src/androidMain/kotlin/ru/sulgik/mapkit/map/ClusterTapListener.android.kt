package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.Cluster as NativeCluster
import com.yandex.mapkit.map.ClusterTapListener as NativeClusterTapListener

actual abstract class ClusterTapListener actual constructor() : NativeClusterTapListener {
    actual abstract fun onClusterTap(cluster: Cluster): Boolean

    override fun onClusterTap(p0: NativeCluster): Boolean {
        return onClusterTap(p0.toCommon())
    }

}