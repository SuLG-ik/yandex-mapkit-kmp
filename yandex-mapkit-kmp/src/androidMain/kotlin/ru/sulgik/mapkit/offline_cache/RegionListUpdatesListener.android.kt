package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.offline_cache.RegionListUpdatesListener as NativeRegionListUpdatesListener

/**
 * Notifies when the list of offline regions is updated.
 */
public actual abstract class RegionListUpdatesListener actual constructor() : NativeConvertible<NativeRegionListUpdatesListener> {

    private val nativeListener = NativeRegionListUpdatesListener { onListUpdated() }

    override fun toNative(): NativeRegionListUpdatesListener {
        return nativeListener
    }

    public actual abstract fun onListUpdated()
}
