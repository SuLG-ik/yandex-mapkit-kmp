package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKCluster as NativeCluster
import YandexMapKit.YMKClusterListenerProtocol as NativeClusterListener

public actual abstract class ClusterListener actual constructor() {

    private val nativeListener =
        object : NativeClusterListener, NSObject() {
            override fun onClusterAddedWithCluster(cluster: NativeCluster) {
                onClusterAdded(cluster.toCommon())
            }
        }

    public fun toNative(): NativeClusterListener {
        return nativeListener
    }

    public actual abstract fun onClusterAdded(cluster: Cluster)

}