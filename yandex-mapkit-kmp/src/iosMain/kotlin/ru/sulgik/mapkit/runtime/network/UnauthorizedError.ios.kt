package ru.sulgik.mapkit.runtime.network

import YandexMapKit.YRTUnauthorizedError as NativeUnauthorizedError

/**
 * The request was not authorized by the server.
 */
public actual open class UnauthorizedError internal constructor(
    private val nativeUnauthorizedError: NativeUnauthorizedError,
) : RemoteError(nativeUnauthorizedError) {

    override fun toNative(): NativeUnauthorizedError {
        return nativeUnauthorizedError
    }
}

public fun NativeUnauthorizedError.toCommon(): UnauthorizedError {
    return UnauthorizedError(this)
}
