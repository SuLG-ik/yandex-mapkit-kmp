package ru.sulgik.mapkit.storage

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.runtime.Error

/**
 * Manages the space MapKit occupies on the device.
 */
public expect class StorageManager {

    /**
     * Subscribes to storage events.
     *
     * The class does not retain the object in the 'errorListener' parameter.
     * It is your responsibility to maintain a strong reference to the target object while it is attached to a class.
     */
    public fun addStorageErrorListener(errorListener: WeakRef<StorageErrorListener>)

    /**
     * Unsubscribes from storage events.
     */
    public fun removeStorageErrorListener(errorListener: WeakRef<StorageErrorListener>)

    /**
     * Computes storage size in bytes.
     */
    public fun computeSize(callback: (bytes: Long?, error: Error?) -> Unit)

    /**
     * Removes all data.
     */
    public fun clear(callback: () -> Unit)

    /**
     * Sets the maximum tile cache size to [limit] bytes.
     */
    public fun setMaxTileStorageSize(limit: Long, callback: (bytes: Long?, error: Error?) -> Unit)

    /**
     * Resets the tile cache size limit.
     */
    public fun resetMaxTileStorageSize(callback: (bytes: Long?, error: Error?) -> Unit)

    /**
     * Obtains the current storage size limit in bytes.
     */
    public fun maxTileStorageSize(callback: (bytes: Long?, error: Error?) -> Unit)

    /**
     * Tells if this **StorageManager** is valid or not.
     */
    public val isValid: Boolean

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
