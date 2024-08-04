package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.ClusterListener as NativeClusterListener

public actual abstract class ClusterListener actual constructor() {

    private val nativeListener = NativeClusterListener { onClusterAdded(it.toCommon()) }

    public fun toNative(): NativeClusterListener {
        return nativeListener
    }

    public actual abstract fun onClusterAdded(cluster: Cluster)

}