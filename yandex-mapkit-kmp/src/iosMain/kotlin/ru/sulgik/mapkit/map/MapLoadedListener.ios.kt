package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKMapLoadStatistics as NativeMapLoadStatistics
import YandexMapKit.YMKMapLoadedListenerProtocol as NativeMapLoadedListener

/**
 * Notifies about the map rendering progress.
 */
public actual abstract class MapLoadedListener actual constructor() : NativeConvertible<NativeMapLoadedListener> {

    private val nativeListener = object : NativeMapLoadedListener, NSObject() {
        override fun onMapLoadedWithStatistics(statistics: NativeMapLoadStatistics) {
            onMapLoaded(statistics.toCommon())
        }
    }

    override fun toNative(): NativeMapLoadedListener {
        return nativeListener
    }

    /**
     * Called after the map has finished loading all visible tiles.
     */
    public actual abstract fun onMapLoaded(statistics: MapLoadStatistics)
}
