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

    public actual fun regions(): List<Region> {
        return nativeOfflineCacheManager.regions().map { it.toCommon() }
    }

    public actual fun allowUseCellularNetwork(useCellular: Boolean) {
        nativeOfflineCacheManager.allowUseCellularNetwork(useCellular)
    }

    public actual fun addRegionListUpdatesListener(regionListUpdatesListener: WeakRef<RegionListUpdatesListener>) {
        nativeOfflineCacheManager.addRegionListUpdatesListener(regionListUpdatesListener.toNative())
    }

    public actual fun removeRegionListUpdatesListener(regionListUpdatesListener: WeakRef<RegionListUpdatesListener>) {
        nativeOfflineCacheManager.removeRegionListUpdatesListener(regionListUpdatesListener.toNative())
    }

    public actual fun addErrorListener(errorListener: WeakRef<ErrorListener>) {
        nativeOfflineCacheManager.addErrorListener(errorListener.toNative())
    }

    public actual fun removeErrorListener(errorListener: WeakRef<ErrorListener>) {
        nativeOfflineCacheManager.removeErrorListener(errorListener.toNative())
    }

    public actual fun addRegionListener(regionListener: WeakRef<RegionListener>) {
        nativeOfflineCacheManager.addRegionListener(regionListener.toNative())
    }

    public actual fun removeRegionListener(regionListener: WeakRef<RegionListener>) {
        nativeOfflineCacheManager.removeRegionListener(regionListener.toNative())
    }

    public actual fun getCities(regionId: Int): List<String> {
        return nativeOfflineCacheManager.getCities(regionId)
    }

    public actual fun getState(regionId: Int): RegionState {
        return nativeOfflineCacheManager.getState(regionId).toCommon()
    }

    public actual fun getDownloadedReleaseTime(regionId: Int): Instant? {
        return nativeOfflineCacheManager.getDownloadedReleaseTime(regionId)
            ?.let { Instant.fromEpochMilliseconds(it) }
    }

    public actual fun getProgress(regionId: Int): Float {
        return nativeOfflineCacheManager.getProgress(regionId)
    }

    public actual fun startDownload(regionId: Int) {
        nativeOfflineCacheManager.startDownload(regionId)
    }

    public actual fun stopDownload(regionId: Int) {
        nativeOfflineCacheManager.stopDownload(regionId)
    }

    public actual fun pauseDownload(regionId: Int) {
        nativeOfflineCacheManager.pauseDownload(regionId)
    }

    public actual fun drop(regionId: Int) {
        nativeOfflineCacheManager.drop(regionId)
    }

    public actual fun mayBeOutOfAvailableSpace(regionId: Int): Boolean {
        return nativeOfflineCacheManager.mayBeOutOfAvailableSpace(regionId)
    }

    public actual fun isLegacyPath(regionId: Int): Boolean {
        return nativeOfflineCacheManager.isLegacyPath(regionId)
    }

    public actual fun computeCacheSize(callback: (size: Long?) -> Unit) {
        nativeOfflineCacheManager.computeCacheSize { size -> callback(size) }
    }

    public actual fun requestPath(callback: (path: String) -> Unit) {
        nativeOfflineCacheManager.requestPath { path -> callback(path) }
    }

    public actual fun moveData(newPath: String, dataMoveListener: WeakRef<DataMoveListener>) {
        nativeOfflineCacheManager.moveData(newPath, dataMoveListener.toNative())
    }

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

    public actual fun enableAutoUpdate(enable: Boolean) {
        nativeOfflineCacheManager.enableAutoUpdate(enable)
    }

    public actual fun clear(callback: () -> Unit) {
        nativeOfflineCacheManager.clear { callback() }
    }

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
}

public fun NativeOfflineCacheManager.toCommon(): OfflineCacheManager {
    return OfflineCacheManager(this)
}
