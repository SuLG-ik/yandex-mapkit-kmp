package ru.sulgik.mapkit.runtime

import YandexMapKit.YRTDiskWriteAccessError as NativeDiskWriteAccessError

/**
 * Local storage is not writable.
 */
public actual open class DiskWriteAccessError internal constructor(
    private val nativeDiskWriteAccessError: NativeDiskWriteAccessError,
) : DiskCorruptError(nativeDiskWriteAccessError) {

    override fun toNative(): NativeDiskWriteAccessError {
        return nativeDiskWriteAccessError
    }
}

public fun NativeDiskWriteAccessError.toCommon(): DiskWriteAccessError {
    return DiskWriteAccessError(this)
}
