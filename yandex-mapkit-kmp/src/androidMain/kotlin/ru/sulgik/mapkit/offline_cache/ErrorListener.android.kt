package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.offline_cache.OfflineCacheManager as NativeOfflineCacheManager
import com.yandex.runtime.Error as NativeError

/**
 * Notifies about the failures of the offline cache.
 */
public actual abstract class ErrorListener actual constructor() : NativeConvertible<NativeOfflineCacheManager.ErrorListener> {

    private val nativeListener = object : NativeOfflineCacheManager.ErrorListener {
        override fun onError(error: NativeError) {
            this@ErrorListener.onError(error.toOfflineCacheError())
        }

        override fun onRegionError(error: NativeError, regionId: Int) {
            this@ErrorListener.onRegionError(error.toOfflineCacheError(), regionId)
        }
    }

    override fun toNative(): NativeOfflineCacheManager.ErrorListener {
        return nativeListener
    }

    public actual abstract fun onError(error: OfflineCacheError)

    public actual abstract fun onRegionError(error: OfflineCacheError, regionId: Int)
}
