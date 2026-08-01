package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.Point
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Downloads and manages the offline maps.
 */
@OptIn(ExperimentalTime::class)
public expect class OfflineCacheManager {

    /**
     * Copying a list of regions from memory.
     */
    public fun regions(): List<Region>

    /**
     * Indicates whether to allow downloading using cellular networks (3G, LTE, and other).
     */
    public fun allowUseCellularNetwork(useCellular: Boolean)

    /**
     * Subscribe on update of region list.
     *
     * The class does not retain the object in the 'regionListUpdatesListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun addRegionListUpdatesListener(regionListUpdatesListener: WeakRef<RegionListUpdatesListener>)

    /**
     * Unsubscribe from region list update.
     */
    public fun removeRegionListUpdatesListener(regionListUpdatesListener: WeakRef<RegionListUpdatesListener>)

    /**
     * Subscribe on errors.
     *
     * The class does not retain the object in the 'errorListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun addErrorListener(errorListener: WeakRef<ErrorListener>)

    /**
     * Unsubscribe from errors.
     */
    public fun removeErrorListener(errorListener: WeakRef<ErrorListener>)

    /**
     * Subscribe on status events.
     *
     * The class does not retain the object in the 'regionListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun addRegionListener(regionListener: WeakRef<RegionListener>)

    /**
     * Unsubscribe from status events.
     */
    public fun removeRegionListener(regionListener: WeakRef<RegionListener>)

    /**
     * Returns a list of cities.
     */
    public fun getCities(regionId: Int): List<String>

    /**
     * Current region state.
     */
    public fun getState(regionId: Int): RegionState

    /**
     * Release time of downloaded region files.
     */
    public fun getDownloadedReleaseTime(regionId: Int): Instant?

    /**
     * Current region progress [0, 1].
     */
    public fun getProgress(regionId: Int): Float

    /**
     * Start to download new offline cache for the region or update if region has been downloaded.
     */
    public fun startDownload(regionId: Int)

    /**
     * Stop downloading of region.
     */
    public fun stopDownload(regionId: Int)

    /**
     * Pause downloading of region.
     */
    public fun pauseDownload(regionId: Int)

    /**
     * Drop region data from the device.
     */
    public fun drop(regionId: Int)

    /**
     * Returns true if available disk space might not be enough for installation of the region data.
     */
    public fun mayBeOutOfAvailableSpace(regionId: Int): Boolean

    /**
     * Returns true if region has files with legacy localized path.
     */
    public fun isLegacyPath(regionId: Int): Boolean

    /**
     * Calculates the full cache size in bytes.
     */
    public fun computeCacheSize(callback: (size: Long?) -> Unit)

    /**
     * Provides the data path for offline cache files.
     */
    public fun requestPath(callback: (path: String) -> Unit)

    /**
     * Moves offline caches to the specified folder.
     */
    public fun moveData(newPath: String, dataMoveListener: WeakRef<DataMoveListener>)

    /**
     * Sets a new path for caches.
     */
    public fun setCachePath(path: String, callback: (error: OfflineCacheError?) -> Unit)

    /**
     * Enables autoupdating downloaded caches when they become outdated.
     */
    public fun enableAutoUpdate(enable: Boolean)

    /**
     * Erases all data for downloads and regions and wipes the cache.
     */
    public fun clear(callback: () -> Unit)

    /**
     * Provides ids of regions containing specified point.
     */
    public fun requestRegionsAtPoint(
        point: Point,
        callback: (regions: List<Int>?, error: OfflineCacheError?) -> Unit,
    )

    /**
     * Tells if this **OfflineCacheManager** is valid or not.
     */
    public val isValid: Boolean

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
