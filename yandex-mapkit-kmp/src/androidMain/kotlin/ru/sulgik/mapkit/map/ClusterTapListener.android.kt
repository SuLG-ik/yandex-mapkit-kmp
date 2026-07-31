package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.ClusterTapListener as NativeClusterTapListener

public actual abstract class ClusterTapListener actual constructor() : NativeConvertible<NativeClusterTapListener> {

    private val nativeListener = NativeClusterTapListener {
        onClusterTap(it.toCommon())
    }

    override fun toNative(): NativeClusterTapListener {
        return nativeListener
    }

    public actual abstract fun onClusterTap(cluster: Cluster): Boolean

}