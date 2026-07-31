package ru.sulgik.mapkit.offline_cache

import platform.Foundation.NSError
import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKOfflineCacheManagerErrorListenerProtocol as NativeErrorListener

/**
 * Notifies about the failures of the offline cache.
 */
public actual abstract class ErrorListener actual constructor() : NativeConvertible<NativeErrorListener> {

    private val nativeListener = object : NativeErrorListener, NSObject() {
        override fun onErrorWithError(error: NSError) {
            this@ErrorListener.onError(error.toOfflineCacheError())
        }

        override fun onRegionErrorWithError(error: NSError, regionId: ULong) {
            this@ErrorListener.onRegionError(error.toOfflineCacheError(), regionId.toInt())
        }
    }

    override fun toNative(): NativeErrorListener {
        return nativeListener
    }

    public actual abstract fun onError(error: OfflineCacheError)

    public actual abstract fun onRegionError(error: OfflineCacheError, regionId: Int)
}
