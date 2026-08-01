package ru.sulgik.mapkit.offline_cache

/**
 * Notifies about the progress of moving the offline cache to another folder.
 */
public expect abstract class DataMoveListener() {

    /**
     * Called when the operation makes progress.
     */
    public abstract fun onDataMoveProgress(percent: Int)

    /**
     * Called when the request is completed.
     */
    public abstract fun onDataMoveCompleted()

    /**
     * Called when an error occurs.
     */
    public abstract fun onDataMoveError(error: OfflineCacheError)
}

public inline fun DataMoveListener(
    crossinline onDataMoveCompleted: () -> Unit,
    crossinline onDataMoveError: (error: OfflineCacheError) -> Unit,
    crossinline onDataMoveProgress: (percent: Int) -> Unit = {},
): DataMoveListener {
    return object : DataMoveListener() {
        override fun onDataMoveProgress(percent: Int) {
            onDataMoveProgress.invoke(percent)
        }

        override fun onDataMoveCompleted() {
            onDataMoveCompleted.invoke()
        }

        override fun onDataMoveError(error: OfflineCacheError) {
            onDataMoveError.invoke(error)
        }
    }
}
