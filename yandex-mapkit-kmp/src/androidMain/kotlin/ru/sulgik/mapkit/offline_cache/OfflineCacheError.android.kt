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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is OfflineCacheError) return false
        if (this::class != other::class) return false
        return nativeError == other.nativeError
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeError.hashCode()
    }
}

public fun NativeError.toOfflineCacheError(): OfflineCacheError {
    return OfflineCacheError(this)
}
