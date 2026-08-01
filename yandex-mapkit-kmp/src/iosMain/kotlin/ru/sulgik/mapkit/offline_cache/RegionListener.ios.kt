package ru.sulgik.mapkit.offline_cache

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKOfflineCacheRegionListenerProtocol as NativeRegionListener

/**
 * Notifies about the download state of the offline regions.
 */
public actual abstract class RegionListener actual constructor() : NativeConvertible<NativeRegionListener> {

    private val nativeListener = object : NativeRegionListener, NSObject() {
        override fun onRegionStateChangedWithRegionId(regionId: ULong) {
            this@RegionListener.onRegionStateChanged(regionId.toInt())
        }

        override fun onRegionProgressWithRegionId(regionId: ULong) {
            this@RegionListener.onRegionProgress(regionId.toInt())
        }
    }

    override fun toNative(): NativeRegionListener {
        return nativeListener
    }

    /**
     * Region state was changed.
     */
    public actual abstract fun onRegionStateChanged(regionId: Int)

    /**
     * Progress of specific region download was updated.
     */
    public actual abstract fun onRegionProgress(regionId: Int)
}
