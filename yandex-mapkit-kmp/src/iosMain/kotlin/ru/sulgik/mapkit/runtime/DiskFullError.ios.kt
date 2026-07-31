package ru.sulgik.mapkit.runtime

import YandexMapKit.YRTDiskFullError as NativeDiskFullError

/**
 * There is not enough free space on the device.
 */
public actual open class DiskFullError internal constructor(
    private val nativeDiskFullError: NativeDiskFullError,
) : LocalError(nativeDiskFullError) {

    override fun toNative(): NativeDiskFullError {
        return nativeDiskFullError
    }
}

public fun NativeDiskFullError.toCommon(): DiskFullError {
    return DiskFullError(this)
}
