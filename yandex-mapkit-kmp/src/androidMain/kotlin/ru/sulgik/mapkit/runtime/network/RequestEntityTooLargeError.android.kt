package ru.sulgik.mapkit.runtime.network

import com.yandex.runtime.network.RequestEntityTooLargeError as NativeRequestEntityTooLargeError

/**
 * The request was too large for the server.
 */
public actual open class RequestEntityTooLargeError internal constructor(
    private val nativeRequestEntityTooLargeError: NativeRequestEntityTooLargeError,
) : RemoteError(nativeRequestEntityTooLargeError) {

    override fun toNative(): NativeRequestEntityTooLargeError {
        return nativeRequestEntityTooLargeError
    }
}

public fun NativeRequestEntityTooLargeError.toCommon(): RequestEntityTooLargeError {
    return RequestEntityTooLargeError(this)
}
