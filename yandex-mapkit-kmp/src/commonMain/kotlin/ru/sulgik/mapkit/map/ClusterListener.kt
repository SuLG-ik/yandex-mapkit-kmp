package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster

expect abstract class ClusterListener() {

    abstract fun onClusterAdded(cluster: Cluster)

}

inline fun ClusterListener(crossinline onClusterAdded: (cluster: Cluster) -> Unit): ClusterListener {
    return object : ClusterListener() {
        override fun onClusterAdded(cluster: Cluster) {
            onClusterAdded.invoke(cluster)
        }
    }
}