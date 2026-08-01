package ru.sulgik.mapkit.runtime

import YandexMapKit.YRTDiskCorruptError as NativeDiskCorruptError
import YandexMapKit.YRTDiskWriteAccessError as NativeDiskWriteAccessError

/**
 * Local storage is corrupted.
 */
public actual open class DiskCorruptError internal constructor(
    private val nativeDiskCorruptError: NativeDiskCorruptError,
) : LocalError(nativeDiskCorruptError) {

    override fun toNative(): NativeDiskCorruptError {
        return nativeDiskCorruptError
    }
}

public fun NativeDiskCorruptError.toCommon(): DiskCorruptError {
    return when (this) {
        is NativeDiskWriteAccessError -> toCommon()
        else -> DiskCorruptError(this)
    }
}
