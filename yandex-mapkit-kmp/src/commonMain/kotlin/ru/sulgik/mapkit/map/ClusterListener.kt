package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster

expect abstract class ClusterListener() {

    abstract fun onClusterAdded(cluster: Cluster)

}


private class LambdaClusterListener(val onClusterAdded: (cluster: Cluster) -> Unit) :
    ClusterListener() {

    override fun onClusterAdded(cluster: Cluster) {
        onClusterAdded.invoke(cluster)
    }

}

fun ClusterListener(onClusterAdded: (cluster: Cluster) -> Unit): ClusterListener {
    return LambdaClusterListener(onClusterAdded)
}