package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.ClusterListener as NativeClusterListener

actual abstract class ClusterListener actual constructor() {

    private val nativeListener = NativeClusterListener { onClusterAdded(it.toCommon()) }

    fun toNative(): NativeClusterListener {
        return nativeListener
    }

    actual abstract fun onClusterAdded(cluster: Cluster)

}