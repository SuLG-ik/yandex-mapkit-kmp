package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.runtime.Error
import ru.sulgik.mapkit.runtime.toCommon
import com.yandex.runtime.Error as NativeError

/**
 * A failure reported by the offline cache.
 */
public actual class OfflineCacheError internal constructor(private val nativeError: NativeError) {

    public fun toNative(): NativeError {
        return nativeError
    }

    /**
     * A human readable description of the failure, `null` on Android.
     */
    public actual val description: String?
        get() = null

    /**
     * The typed MapKit error, `null` on iOS.
     */
    public actual val error: Error?
        get() = nativeError.toCommon()
}

public fun NativeError.toOfflineCacheError(): OfflineCacheError {
    return OfflineCacheError(this)
}
