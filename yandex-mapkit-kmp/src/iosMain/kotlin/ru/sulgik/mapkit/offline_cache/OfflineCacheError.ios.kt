package ru.sulgik.mapkit.offline_cache

import platform.Foundation.NSError
import ru.sulgik.mapkit.runtime.Error

/**
 * A failure reported by the offline cache.
 */
public actual class OfflineCacheError internal constructor(private val nsError: NSError) {

    public fun toNative(): NSError {
        return nsError
    }

    /**
     * A human readable description of the failure, `null` on Android.
     */
    public actual val description: String?
        get() = nsError.localizedDescription

    /**
     * The typed MapKit error, `null` on iOS.
     */
    public actual val error: Error?
        get() = null

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is OfflineCacheError) return false
        if (this::class != other::class) return false
        return nsError == other.nsError
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nsError.hashCode()
    }
}

public fun NSError.toOfflineCacheError(): OfflineCacheError {
    return OfflineCacheError(this)
}
