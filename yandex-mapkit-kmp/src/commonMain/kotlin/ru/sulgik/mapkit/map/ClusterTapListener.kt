package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster

expect abstract class ClusterTapListener() {

    abstract fun onClusterTap(cluster: Cluster): Boolean

}


private class LambdaClusterTapListener(val onClusterTap: (cluster: Cluster) -> Boolean) :
    ClusterTapListener() {

    override fun onClusterTap(cluster: Cluster): Boolean {
        return onClusterTap.invoke(cluster)
    }


}

fun ClusterTapListener(onClusterTap: (cluster: Cluster) -> Boolean): ClusterTapListener {
    return LambdaClusterTapListener(onClusterTap)
}