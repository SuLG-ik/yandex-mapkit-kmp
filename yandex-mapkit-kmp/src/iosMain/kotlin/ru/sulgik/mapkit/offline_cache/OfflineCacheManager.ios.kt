package ru.sulgik.mapkit.offline_cache

import platform.Foundation.NSDate
import platform.Foundation.NSError
import platform.Foundation.NSNumber
import platform.Foundation.timeIntervalSince1970
import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toNative
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import YandexMapKit.YMKOfflineCacheManager as NativeOfflineCacheManager
import YandexMapKit.YMKOfflineCacheRegion as NativeRegion

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
    @Suppress("UNCHECKED_CAST")
    public actual fun regions(): List<Region> {
        return (nativeOfflineCacheManager.regions() as List<NativeRegion>).map { it.toCommon() }
    }

    /**
     * Indicates whether to allow downloading using cellular networks (3G, LTE, and other).
     */
    public actual fun allowUseCellularNetwork(useCellular: Boolean) {
        nativeOfflineCacheManager.allowUseCellularNetworkWithUseCellular(useCellular)
    }

    /**
     * Subscribe on update of region list.
     *
     * The class does not retain the object in the 'regionListUpdatesListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addRegionListUpdatesListener(regionListUpdatesListener: WeakRef<RegionListUpdatesListener>) {
        nativeOfflineCacheManager.addRegionListUpdatesListenerWithRegionListUpdatesListener(
            regionListUpdatesListener.toNative() ?: return,
        )
    }

    /**
     * Unsubscribe from region list update.
     */
    public actual fun removeRegionListUpdatesListener(regionListUpdatesListener: WeakRef<RegionListUpdatesListener>) {
        nativeOfflineCacheManager.removeRegionListUpdatesListenerWithRegionListUpdatesListener(
            regionListUpdatesListener.toNative() ?: return,
        )
    }

    /**
     * Subscribe on errors.
     *
     * The class does not retain the object in the 'errorListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addErrorListener(errorListener: WeakRef<ErrorListener>) {
        nativeOfflineCacheManager.addErrorListenerWithErrorListener(errorListener.toNative() ?: return)
    }

    /**
     * Unsubscribe from errors.
     */
    public actual fun removeErrorListener(errorListener: WeakRef<ErrorListener>) {
        nativeOfflineCacheManager.removeErrorListenerWithErrorListener(errorListener.toNative() ?: return)
    }

    /**
     * Subscribe on status events.
     *
     * The class does not retain the object in the 'regionListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addRegionListener(regionListener: WeakRef<RegionListener>) {
        nativeOfflineCacheManager.addRegionListenerWithRegionListener(regionListener.toNative() ?: return)
    }

    /**
     * Unsubscribe from status events.
     */
    public actual fun removeRegionListener(regionListener: WeakRef<RegionListener>) {
        nativeOfflineCacheManager.removeRegionListenerWithRegionListener(regionListener.toNative() ?: return)
    }

    /**
     * Returns a list of cities.
     */
    @Suppress("UNCHECKED_CAST")
    public actual fun getCities(regionId: Int): List<String> {
        return nativeOfflineCacheManager.getCitiesWithRegionId(regionId.toULong()) as List<String>
    }

    /**
     * Current region state.
     */
    public actual fun getState(regionId: Int): RegionState {
        return nativeOfflineCacheManager.getStateWithRegionId(regionId.toULong()).toCommon()
    }

    /**
     * Release time of downloaded region files.
     */
    public actual fun getDownloadedReleaseTime(regionId: Int): Instant? {
        return nativeOfflineCacheManager.getDownloadedReleaseTimeWithRegionId(regionId.toULong())
            ?.toInstant()
    }

    /**
     * Current region progress [0, 1].
     */
    public actual fun getProgress(regionId: Int): Float {
        return nativeOfflineCacheManager.getProgressWithRegionId(regionId.toULong())
    }

    /**
     * Start to download new offline cache for the region or update if region has been downloaded.
     */
    public actual fun startDownload(regionId: Int) {
        nativeOfflineCacheManager.startDownloadWithRegionId(regionId.toULong())
    }

    /**
     * Stop downloading of region.
     */
    public actual fun stopDownload(regionId: Int) {
        nativeOfflineCacheManager.stopDownloadWithRegionId(regionId.toULong())
    }

    /**
     * Pause downloading of region.
     */
    public actual fun pauseDownload(regionId: Int) {
        nativeOfflineCacheManager.pauseDownloadWithRegionId(regionId.toULong())
    }

    /**
     * Drop region data from the device.
     */
    public actual fun drop(regionId: Int) {
        nativeOfflineCacheManager.dropWithRegionId(regionId.toULong())
    }

    /**
     * Returns true if available disk space might not be enough for installation of the region data.
     */
    public actual fun mayBeOutOfAvailableSpace(regionId: Int): Boolean {
        return nativeOfflineCacheManager.mayBeOutOfAvailableSpaceWithRegionId(regionId.toULong())
    }

    /**
     * Returns true if region has files with legacy localized path.
     */
    public actual fun isLegacyPath(regionId: Int): Boolean {
        return nativeOfflineCacheManager.isLegacyPathWithRegionId(regionId.toULong())
    }

    /**
     * Calculates the full cache size in bytes.
     */
    public actual fun computeCacheSize(callback: (size: Long?) -> Unit) {
        nativeOfflineCacheManager.computeCacheSizeWithSizeCallback { size ->
            callback(size?.longLongValue)
        }
    }

    /**
     * Provides the data path for offline cache files.
     */
    public actual fun requestPath(callback: (path: String) -> Unit) {
        nativeOfflineCacheManager.requestPathWithPathGetterListener { path -> callback(path.orEmpty()) }
    }

    /**
     * Moves offline caches to the specified folder.
     */
    public actual fun moveData(newPath: String, dataMoveListener: WeakRef<DataMoveListener>) {
        nativeOfflineCacheManager.moveDataWithNewPath(newPath, dataMoveListener.toNative() ?: return)
    }

    /**
     * Sets a new path for caches.
     */
    public actual fun setCachePath(path: String, callback: (error: OfflineCacheError?) -> Unit) {
        nativeOfflineCacheManager.setCachePathWithPath(path) { error: NSError? ->
            callback(error?.toOfflineCacheError())
        }
    }

    /**
     * Enables autoupdating downloaded caches when they become outdated.
     */
    public actual fun enableAutoUpdate(enable: Boolean) {
        nativeOfflineCacheManager.enableAutoUpdateWithEnable(enable)
    }

    /**
     * Erases all data for downloads and regions and wipes the cache.
     */
    public actual fun clear(callback: () -> Unit) {
        nativeOfflineCacheManager.clearWithClearCallback { callback() }
    }

    /**
     * Provides ids of regions containing specified point.
     */
    @Suppress("UNCHECKED_CAST")
    public actual fun requestRegionsAtPoint(
        point: Point,
        callback: (regions: List<Int>?, error: OfflineCacheError?) -> Unit,
    ) {
        nativeOfflineCacheManager.requestRegionsAtPointWithPoint(point.toNative()) { regions, error ->
            callback(
                (regions as? List<NSNumber>)?.map { it.intValue },
                error?.toOfflineCacheError(),
            )
        }
    }

    /**
     * Tells if this **OfflineCacheManager** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeOfflineCacheManager.isValid()

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

@OptIn(ExperimentalTime::class)
private fun NSDate.toInstant(): Instant {
    return Instant.fromEpochMilliseconds((timeIntervalSince1970 * 1000).toLong())
}

public fun NativeOfflineCacheManager.toCommon(): OfflineCacheManager {
    return OfflineCacheManager(this)
}
