package ru.sulgik.mapkit.runtime

import YandexMapKit.YRTDiskCorruptError as NativeDiskCorruptError
import YandexMapKit.YRTDiskFullError as NativeDiskFullError
import YandexMapKit.YRTDiskWriteAccessError as NativeDiskWriteAccessError
import YandexMapKit.YRTLocalError as NativeLocalError

/**
 * An error caused by the state of the device.
 */
public actual open class LocalError internal constructor(
    private val nativeLocalError: NativeLocalError,
) : Error(nativeLocalError) {

    override fun toNative(): NativeLocalError {
        return nativeLocalError
    }
}

public fun NativeLocalError.toCommon(): LocalError {
    return when (this) {
        is NativeDiskWriteAccessError -> toCommon()
        is NativeDiskCorruptError -> toCommon()
        is NativeDiskFullError -> toCommon()
        else -> LocalError(this)
    }
}
