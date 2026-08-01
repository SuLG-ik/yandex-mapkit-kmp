package ru.sulgik.mapkit.offline_cache

/**
 * Notifies about the download state of the offline regions.
 */
public expect abstract class RegionListener() {

    /**
     * Region state was changed.
     */
    public abstract fun onRegionStateChanged(regionId: Int)

    /**
     * Progress of specific region download was updated.
     */
    public abstract fun onRegionProgress(regionId: Int)
}

public inline fun RegionListener(
    crossinline onRegionStateChanged: (regionId: Int) -> Unit,
    crossinline onRegionProgress: (regionId: Int) -> Unit = {},
): RegionListener {
    return object : RegionListener() {
        override fun onRegionStateChanged(regionId: Int) {
            onRegionStateChanged.invoke(regionId)
        }

        override fun onRegionProgress(regionId: Int) {
            onRegionProgress.invoke(regionId)
        }
    }
}
