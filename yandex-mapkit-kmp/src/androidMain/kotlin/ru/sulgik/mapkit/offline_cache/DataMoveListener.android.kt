package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.offline_cache.DataMoveListener as NativeDataMoveListener
import com.yandex.runtime.Error as NativeError

/**
 * Notifies about the progress of moving the offline cache to another folder.
 */
public actual abstract class DataMoveListener actual constructor() : NativeConvertible<NativeDataMoveListener> {

    private val nativeListener = object : NativeDataMoveListener {
        override fun onDataMoveProgress(percent: Int) {
            this@DataMoveListener.onDataMoveProgress(percent)
        }

        override fun onDataMoveCompleted() {
            this@DataMoveListener.onDataMoveCompleted()
        }

        override fun onDataMoveError(error: NativeError) {
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
