package ru.sulgik.mapkit.map

import YandexMapKit.YMKCluster
import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKClusterTapListenerProtocol as NativeClusterTapListener

actual class ClusterTapListener actual constructor(val onClusterTap: (cluster: Cluster) -> Boolean) :
    NativeClusterTapListener,
    NSObject() {

    override fun onClusterTapWithCluster(cluster: YMKCluster): Boolean {
        return onClusterTap(cluster.toCommon())
    }

}