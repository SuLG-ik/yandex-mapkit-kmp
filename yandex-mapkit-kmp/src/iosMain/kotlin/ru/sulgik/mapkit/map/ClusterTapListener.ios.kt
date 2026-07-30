package ru.sulgik.mapkit.map

import YandexMapKit.YMKCluster
import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKClusterTapListenerProtocol as NativeClusterTapListener

public actual abstract class ClusterTapListener actual constructor() : NativeConvertible<NativeClusterTapListener> {

    private val nativeListener = object : NativeClusterTapListener,
        NSObject() {
        override fun onClusterTapWithCluster(cluster: YMKCluster): Boolean {
            return onClusterTap(cluster.toCommon())
        }
    }

    override fun toNative(): NativeClusterTapListener {
        return nativeListener
    }

    public actual abstract fun onClusterTap(cluster: Cluster): Boolean

}