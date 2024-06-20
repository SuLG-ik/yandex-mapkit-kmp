package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.ClusterListener as NativeClusterListener

actual class ClusterListener actual constructor(private val onClusterAdded: (cluster: Cluster) -> Unit) :
    NativeClusterListener {

    override fun onClusterAdded(p0: com.yandex.mapkit.map.Cluster) {
        onClusterAdded(p0.toCommon())
    }

}