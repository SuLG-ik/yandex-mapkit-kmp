package ru.sulgik.mapkit.map

/**
 * Notifies about the map rendering progress.
 */
public expect abstract class MapLoadedListener() {

    /**
     * Called after the map has finished loading all visible tiles.
     */
    public abstract fun onMapLoaded(statistics: MapLoadStatistics)
}

public inline fun MapLoadedListener(
    crossinline onMapLoaded: (statistics: MapLoadStatistics) -> Unit,
): MapLoadedListener {
    return object : MapLoadedListener() {
        override fun onMapLoaded(statistics: MapLoadStatistics) {
            onMapLoaded.invoke(statistics)
        }
    }
}
