package ru.sulgik.mapkit.offline_cache

import platform.Foundation.NSError
import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKOfflineCacheDataMoveListenerProtocol as NativeDataMoveListener

/**
 * Notifies about the progress of moving the offline cache to another folder.
 */
public actual abstract class DataMoveListener actual constructor() : NativeConvertible<NativeDataMoveListener> {

    private val nativeListener = object : NativeDataMoveListener, NSObject() {
        override fun onDataMoveProgressWithPercent(percent: Long) {
            this@DataMoveListener.onDataMoveProgress(percent.toInt())
        }

        override fun onDataMoveCompleted() {
            this@DataMoveListener.onDataMoveCompleted()
        }

        override fun onDataMoveErrorWithError(error: NSError) {
            this@DataMoveListener.onDataMoveError(error.toOfflineCacheError())
        }
    }

    override fun toNative(): NativeDataMoveListener {
        return nativeListener
    }

    /**
     * Called when the operation makes progress.
     */
    public actual abstract fun onDataMoveProgress(percent: Int)

    /**
     * Called when the request is completed.
     */
    public actual abstract fun onDataMoveCompleted()

    /**
     * Called when an error occurs.
     */
    public actual abstract fun onDataMoveError(error: OfflineCacheError)
}
