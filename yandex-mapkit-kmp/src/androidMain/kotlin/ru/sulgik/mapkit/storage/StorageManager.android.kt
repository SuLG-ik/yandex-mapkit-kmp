package ru.sulgik.mapkit.storage

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.runtime.Error
import ru.sulgik.mapkit.runtime.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.storage.StorageManager as NativeStorageManager
import com.yandex.runtime.Error as NativeError

/**
 * Manages the space MapKit occupies on the device.
 */
public actual class StorageManager internal constructor(
    private val nativeStorageManager: NativeStorageManager,
) {

    public fun toNative(): NativeStorageManager {
        return nativeStorageManager
    }

    /**
     * Subscribes to storage events.
     *
     * The class does not retain the object in the 'errorListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public actual fun addStorageErrorListener(errorListener: WeakRef<StorageErrorListener>) {
        nativeStorageManager.addStorageErrorListener(errorListener.toNative())
    }

    /**
     * Unsubscribes from storage events.
     */
    public actual fun removeStorageErrorListener(errorListener: WeakRef<StorageErrorListener>) {
        nativeStorageManager.removeStorageErrorListener(errorListener.toNative())
    }

    /**
     * Computes storage size in bytes.
     */
    public actual fun computeSize(callback: (bytes: Long?, error: Error?) -> Unit) {
        nativeStorageManager.computeSize(callback.toNativeSizeListener())
    }

    /**
     * Removes all data.
     */
    public actual fun clear(callback: () -> Unit) {
        nativeStorageManager.clear { callback() }
    }

    /**
     * Sets the maximum tile cache size to [limit] bytes.
     */
    public actual fun setMaxTileStorageSize(limit: Long, callback: (bytes: Long?, error: Error?) -> Unit) {
        nativeStorageManager.setMaxTileStorageSize(limit, callback.toNativeSizeListener())
    }

    /**
     * Resets the tile cache size limit.
     */
    public actual fun resetMaxTileStorageSize(callback: (bytes: Long?, error: Error?) -> Unit) {
        nativeStorageManager.resetMaxTileStorageSize(callback.toNativeSizeListener())
    }

    /**
     * Obtains the current storage size limit in bytes.
     */
    public actual fun maxTileStorageSize(callback: (bytes: Long?, error: Error?) -> Unit) {
        nativeStorageManager.maxTileStorageSize(callback.toNativeSizeListener())
    }

    /**
     * Tells if this **StorageManager** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeStorageManager.isValid

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StorageManager) return false
        if (this::class != other::class) return false
        return nativeStorageManager == other.nativeStorageManager
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeStorageManager.hashCode()
    }
}

private fun ((bytes: Long?, error: Error?) -> Unit).toNativeSizeListener(): NativeStorageManager.SizeListener {
    return object : NativeStorageManager.SizeListener {
        override fun onSuccess(bytes: Long?) {
            this@toNativeSizeListener(bytes, null)
        }

        override fun onError(error: NativeError) {
            this@toNativeSizeListener(null, error.toCommon())
        }
    }
}

public fun NativeStorageManager.toCommon(): StorageManager {
    return StorageManager(this)
}
