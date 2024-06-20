package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.Cluster as NativeCluster
import com.yandex.mapkit.map.ClusterTapListener as NativeClusterTapListener

actual class ClusterTapListener actual constructor(private val onClusterTap: (cluster: Cluster) -> Boolean) :
    NativeClusterTapListener {

    override fun onClusterTap(p0: NativeCluster): Boolean {
        return onClusterTap(p0.toCommon())
    }

}