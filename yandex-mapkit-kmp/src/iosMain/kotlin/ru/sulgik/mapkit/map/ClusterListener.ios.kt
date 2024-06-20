package ru.sulgik.mapkit.map

import YandexMapKit.YMKCluster
import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKClusterListenerProtocol as NativeClusterListener

actual class ClusterListener actual constructor(private val onClusterAdded: (cluster: Cluster) -> Unit) :
    NativeClusterListener, NSObject() {

    override fun onClusterAddedWithCluster(cluster: YMKCluster) {
        onClusterAdded(cluster.toCommon())
    }
}