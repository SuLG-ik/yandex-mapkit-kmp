package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.ClusterListener as NativeClusterListener

actual abstract class ClusterListener actual constructor(): NativeClusterListener {
    actual abstract fun onClusterAdded(cluster: Cluster)

    override fun onClusterAdded(p0: com.yandex.mapkit.map.Cluster) {
        onClusterAdded(p0.toCommon())
    }
}