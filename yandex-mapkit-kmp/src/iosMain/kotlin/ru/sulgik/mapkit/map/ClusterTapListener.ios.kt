package ru.sulgik.mapkit.map

import YandexMapKit.YMKCluster
import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKClusterTapListenerProtocol as NativeClusterTapListener

actual abstract class ClusterTapListener actual constructor() {

    private val nativeListener = object : NativeClusterTapListener,
        NSObject() {
        override fun onClusterTapWithCluster(cluster: YMKCluster): Boolean {
            return onClusterTap(cluster.toCommon())
        }
    }

    fun toNative(): NativeClusterTapListener {
        return nativeListener
    }

    actual abstract fun onClusterTap(cluster: Cluster): Boolean

}