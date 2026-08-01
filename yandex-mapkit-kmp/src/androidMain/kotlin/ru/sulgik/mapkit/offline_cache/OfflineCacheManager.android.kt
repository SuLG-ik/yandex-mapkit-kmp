package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toNative
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import com.yandex.mapkit.offline_cache.OfflineCacheManager as NativeOfflineCacheManager
import com.yandex.mapkit.offline_cache.RegionsAtPointListener as NativeRegionsAtPointListener
import com.yandex.runtime.Error as NativeError

/**
 * Downloads and manages the offline maps.
 */
@OptIn(ExperimentalTime::class)
public actual class OfflineCacheManager internal constructor(
    private val nativeOfflineCacheManager: NativeOfflineCacheManager,
) {

    public fun toNative(): NativeOfflineCacheManager {
        return nativeOfflineCacheManager
    }

    /**
     * Copying a list of regions from memory.
     */
    public actual fun regions(): List<Region> {
        return nativeOfflineCacheManager.regions().map { it.toCommon() }
    }

    /**
     * Indicates whether to allow downloading using cellular networks (3G, LTE, and other).
     */
    public actual fun allowUseCellularNetwork(useCellular: Boolean) {
        nativeOfflineCacheManager.allowUseCellularNetwork(useCellular)
    }

    /**
     * Subscribe on update of region list.
     *
     * The class does not retain the object in the 'regionListUpdatesListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addRegionListUpdatesListener(regionListUpdatesListener: WeakRef<RegionListUpdatesListener>) {
        nativeOfflineCacheManager.addRegionListUpdatesListener(regionListUpdatesListener.toNative())
    }

    /**
     * Unsubscribe from region list update.
     */
    public actual fun removeRegionListUpdatesListener(regionListUpdatesListener: WeakRef<RegionListUpdatesListener>) {
        nativeOfflineCacheManager.removeRegionListUpdatesListener(regionListUpdatesListener.toNative())
    }

    /**
     * Subscribe on errors.
     *
     * The class does not retain the object in the 'errorListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addErrorListener(errorListener: WeakRef<ErrorListener>) {
        nativeOfflineCacheManager.addErrorListener(errorListener.toNative())
    }

    /**
     * Unsubscribe from errors.
     */
    public actual fun removeErrorListener(errorListener: WeakRef<ErrorListener>) {
        nativeOfflineCacheManager.removeErrorListener(errorListener.toNative())
    }

    /**
     * Subscribe on status events.
     *
     * The class does not retain the object in the 'regionListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addRegionListener(regionListener: WeakRef<RegionListener>) {
        nativeOfflineCacheManager.addRegionListener(regionListener.toNative())
    }

    /**
     * Unsubscribe from status events.
     */
    public actual fun removeRegionListener(regionListener: WeakRef<RegionListener>) {
        nativeOfflineCacheManager.removeRegionListener(regionListener.toNative())
    }

    /**
     * Returns a list of cities.
     */
    public actual fun getCities(regionId: Int): List<String> {
        return nativeOfflineCacheManager.getCities(regionId)
    }

    /**
     * Current region state.
     */
    public actual fun getState(regionId: Int): RegionState {
        return nativeOfflineCacheManager.getState(regionId).toCommon()
    }

    /**
     * Release time of downloaded region files.
     */
    public actual fun getDownloadedReleaseTime(regionId: Int): Instant? {
        return nativeOfflineCacheManager.getDownloadedReleaseTime(regionId)
            ?.let { Instant.fromEpochMilliseconds(it) }
    }

    /**
     * Current region progress [0, 1].
     */
    public actual fun getProgress(regionId: Int): Float {
        return nativeOfflineCacheManager.getProgress(regionId)
    }

    /**
     * Start to download new offline cache for the region or update if region has been downloaded.
     */
    public actual fun startDownload(regionId: Int) {
        nativeOfflineCacheManager.startDownload(regionId)
    }

    /**
     * Stop downloading of region.
     */
    public actual fun stopDownload(regionId: Int) {
        nativeOfflineCacheManager.stopDownload(regionId)
    }

    /**
     * Pause downloading of region.
     */
    public actual fun pauseDownload(regionId: Int) {
        nativeOfflineCacheManager.pauseDownload(regionId)
    }

    /**
     * Drop region data from the device.
     */
    public actual fun drop(regionId: Int) {
        nativeOfflineCacheManager.drop(regionId)
    }

    /**
     * Returns true if available disk space might not be enough for installation of the region data.
     */
    public actual fun mayBeOutOfAvailableSpace(regionId: Int): Boolean {
        return nativeOfflineCacheManager.mayBeOutOfAvailableSpace(regionId)
    }

    /**
     * Returns true if region has files with legacy localized path.
     */
    public actual fun isLegacyPath(regionId: Int): Boolean {
        return nativeOfflineCacheManager.isLegacyPath(regionId)
    }

    /**
     * Calculates the full cache size in bytes.
     */
    public actual fun computeCacheSize(callback: (size: Long?) -> Unit) {
        nativeOfflineCacheManager.computeCacheSize { size -> callback(size) }
    }

    /**
     * Provides the data path for offline cache files.
     */
    public actual fun requestPath(callback: (path: String) -> Unit) {
        nativeOfflineCacheManager.requestPath { path -> callback(path) }
    }

    /**
     * Moves offline caches to the specified folder.
     */
    public actual fun moveData(newPath: String, dataMoveListener: WeakRef<DataMoveListener>) {
        nativeOfflineCacheManager.moveData(newPath, dataMoveListener.toNative())
    }

    /**
     * Sets a new path for caches.
     */
    public actual fun setCachePath(path: String, callback: (error: OfflineCacheError?) -> Unit) {
        nativeOfflineCacheManager.setCachePath(
            path,
            object : NativeOfflineCacheManager.PathSetterListener {
                override fun onPathSet() {
                    callback(null)
                }

                override fun onPathSetError(error: NativeError) {
                    callback(error.toOfflineCacheError())
                }
            },
        )
    }

    /**
     * Enables autoupdating downloaded caches when they become outdated.
     */
    public actual fun enableAutoUpdate(enable: Boolean) {
        nativeOfflineCacheManager.enableAutoUpdate(enable)
    }

    /**
     * Erases all data for downloads and regions and wipes the cache.
     */
    public actual fun clear(callback: () -> Unit) {
        nativeOfflineCacheManager.clear { callback() }
    }

    /**
     * Provides ids of regions containing specified point.
     */
    public actual fun requestRegionsAtPoint(
        point: Point,
        callback: (regions: List<Int>?, error: OfflineCacheError?) -> Unit,
    ) {
        nativeOfflineCacheManager.requestRegionsAtPoint(
            point.toNative(),
            object : NativeRegionsAtPointListener {
                override fun onRegions(regions: MutableList<Int>) {
                    callback(regions, null)
                }

                override fun onError(error: NativeError) {
                    callback(null, error.toOfflineCacheError())
                }
            },
        )
    }

    /**
     * Tells if this **OfflineCacheManager** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeOfflineCacheManager.isValid

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is OfflineCacheManager) return false
        if (this::class != other::class) return false
        return nativeOfflineCacheManager == other.nativeOfflineCacheManager
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeOfflineCacheManager.hashCode()
    }
}

public fun NativeOfflineCacheManager.toCommon(): OfflineCacheManager {
    return OfflineCacheManager(this)
}
