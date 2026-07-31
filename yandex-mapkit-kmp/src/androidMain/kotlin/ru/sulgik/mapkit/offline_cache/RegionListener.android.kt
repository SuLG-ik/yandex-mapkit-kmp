package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.offline_cache.RegionListener as NativeRegionListener

/**
 * Notifies about the download state of the offline regions.
 */
public actual abstract class RegionListener actual constructor() : NativeConvertible<NativeRegionListener> {

    private val nativeListener = object : NativeRegionListener {
        override fun onRegionStateChanged(regionId: Int) {
            this@RegionListener.onRegionStateChanged(regionId)
        }

        override fun onRegionProgress(regionId: Int) {
            this@RegionListener.onRegionProgress(regionId)
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
