package ru.sulgik.mapkit.storage

import ru.sulgik.mapkit.runtime.LocalError

/**
 * Notifies about local storage errors.
 */
public expect abstract class StorageErrorListener() {

    /**
     * Possible error types: [ru.sulgik.mapkit.runtime.DiskCorruptError] if local storage is
     * corrupted, [ru.sulgik.mapkit.runtime.DiskFullError] if there is no space left.
     */
    public abstract fun onStorageError(error: LocalError)
}

public inline fun StorageErrorListener(
    crossinline onStorageError: (error: LocalError) -> Unit,
): StorageErrorListener {
    return object : StorageErrorListener() {
        override fun onStorageError(error: LocalError) {
            onStorageError.invoke(error)
        }
    }
}
