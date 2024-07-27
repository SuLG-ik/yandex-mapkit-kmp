package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster

expect abstract class ClusterTapListener() {

    abstract fun onClusterTap(cluster: Cluster): Boolean

}

inline fun ClusterTapListener(crossinline onClusterTap: (cluster: Cluster) -> Boolean): ClusterTapListener {
    return object : ClusterTapListener() {
        override fun onClusterTap(cluster: Cluster): Boolean {
            return onClusterTap.invoke(cluster)
        }
    }
}