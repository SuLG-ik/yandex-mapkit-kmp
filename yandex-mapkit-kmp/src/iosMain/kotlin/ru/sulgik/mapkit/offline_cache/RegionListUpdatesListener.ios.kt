package ru.sulgik.mapkit.offline_cache

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKOfflineMapRegionListUpdatesListenerProtocol as NativeRegionListUpdatesListener

/**
 * Notifies when the list of offline regions is updated.
 */
public actual abstract class RegionListUpdatesListener actual constructor() : NativeConvertible<NativeRegionListUpdatesListener> {

    private val nativeListener = object : NativeRegionListUpdatesListener, NSObject() {
        override fun onListUpdated() {
            this@RegionListUpdatesListener.onListUpdated()
        }
    }

    override fun toNative(): NativeRegionListUpdatesListener {
        return nativeListener
    }

    public actual abstract fun onListUpdated()
}
