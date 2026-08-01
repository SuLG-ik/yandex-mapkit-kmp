package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.map.MapLoadedListener as NativeMapLoadedListener

/**
 * Notifies about the map rendering progress.
 */
public actual abstract class MapLoadedListener actual constructor() : NativeConvertible<NativeMapLoadedListener> {

    private val nativeListener = NativeMapLoadedListener { statistics ->
        onMapLoaded(statistics.toCommon())
    }

    override fun toNative(): NativeMapLoadedListener {
        return nativeListener
    }

    /**
     * Called after the map has finished loading all visible tiles.
     */
    public actual abstract fun onMapLoaded(statistics: MapLoadStatistics)
}
