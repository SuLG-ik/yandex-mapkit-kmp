package ru.sulgik.mapkit.storage

import YandexMapKit.YRTUnderlyingErrorKey
import platform.Foundation.NSError
import platform.Foundation.NSNumber
import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.runtime.Error
import ru.sulgik.mapkit.runtime.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKStorageManager as NativeStorageManager
import YandexMapKit.YRTError as NativeError

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
        nativeStorageManager.addStorageErrorListenerWithErrorListener(errorListener.toNative() ?: return)
    }

    /**
     * Unsubscribes from storage events.
     */
    public actual fun removeStorageErrorListener(errorListener: WeakRef<StorageErrorListener>) {
        nativeStorageManager.removeStorageErrorListenerWithErrorListener(errorListener.toNative() ?: return)
    }

    /**
     * Computes storage size in bytes.
     */
    public actual fun computeSize(callback: (bytes: Long?, error: Error?) -> Unit) {
        nativeStorageManager.computeSizeWithSizeCallback { bytes, error ->
            callback(bytes?.toLong(), error?.toCommonError())
        }
    }

    /**
     * Removes all data.
     */
    public actual fun clear(callback: () -> Unit) {
        nativeStorageManager.clearWithClearCallback { callback() }
    }

    /**
     * Sets the maximum tile cache size to [limit] bytes.
     */
    public actual fun setMaxTileStorageSize(limit: Long, callback: (bytes: Long?, error: Error?) -> Unit) {
        nativeStorageManager.setMaxTileStorageSizeWithLimit(limit) { bytes, error ->
            callback(bytes?.toLong(), error?.toCommonError())
        }
    }

    /**
     * Resets the tile cache size limit.
     */
    public actual fun resetMaxTileStorageSize(callback: (bytes: Long?, error: Error?) -> Unit) {
        nativeStorageManager.resetMaxTileStorageSizeWithSizeCallback { bytes, error ->
            callback(bytes?.toLong(), error?.toCommonError())
        }
    }

    /**
     * Obtains the current storage size limit in bytes.
     */
    public actual fun maxTileStorageSize(callback: (bytes: Long?, error: Error?) -> Unit) {
        nativeStorageManager.maxTileStorageSizeWithSizeCallback { bytes, error ->
            callback(bytes?.toLong(), error?.toCommonError())
        }
    }

    /**
     * Tells if this **StorageManager** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeStorageManager.isValid()
}

private fun NSNumber.toLong(): Long {
    return longLongValue
}

private fun NSError.toCommonError(): Error? {
    return (userInfo[YRTUnderlyingErrorKey] as? NativeError)?.toCommon()
}

public fun NativeStorageManager.toCommon(): StorageManager {
    return StorageManager(this)
}
