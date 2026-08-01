package ru.sulgik.mapkit.runtime

import com.yandex.runtime.DiskCorruptError as NativeDiskCorruptError
import com.yandex.runtime.DiskFullError as NativeDiskFullError
import com.yandex.runtime.DiskWriteAccessError as NativeDiskWriteAccessError
import com.yandex.runtime.LocalError as NativeLocalError

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
