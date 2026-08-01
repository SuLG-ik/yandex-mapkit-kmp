package ru.sulgik.mapkit.offline_cache

/**
 * Notifies about the failures of the offline cache.
 */
public expect abstract class ErrorListener() {

    public abstract fun onError(error: OfflineCacheError)

    public abstract fun onRegionError(error: OfflineCacheError, regionId: Int)
}

public inline fun ErrorListener(
    crossinline onError: (error: OfflineCacheError) -> Unit,
    crossinline onRegionError: (error: OfflineCacheError, regionId: Int) -> Unit = { _, _ -> },
): ErrorListener {
    return object : ErrorListener() {
        override fun onError(error: OfflineCacheError) {
            onError.invoke(error)
        }

        override fun onRegionError(error: OfflineCacheError, regionId: Int) {
            onRegionError.invoke(error, regionId)
        }
    }
}
