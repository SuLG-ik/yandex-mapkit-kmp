package ru.sulgik.mapkit.runtime.network

import com.yandex.runtime.network.NotFoundError as NativeNotFoundError

/**
 * The server has nothing at the requested address.
 */
public actual open class NotFoundError internal constructor(
    private val nativeNotFoundError: NativeNotFoundError,
) : RemoteError(nativeNotFoundError) {

    override fun toNative(): NativeNotFoundError {
        return nativeNotFoundError
    }
}

public fun NativeNotFoundError.toCommon(): NotFoundError {
    return NotFoundError(this)
}
