package ru.sulgik.mapkit.runtime.network

import ru.sulgik.mapkit.runtime.Error
import YandexMapKit.YRTBadRequestError as NativeBadRequestError
import YandexMapKit.YRTForbiddenError as NativeForbiddenError
import YandexMapKit.YRTNotFoundError as NativeNotFoundError
import YandexMapKit.YRTRemoteError as NativeRemoteError
import YandexMapKit.YRTRequestEntityTooLargeError as NativeRequestEntityTooLargeError
import YandexMapKit.YRTUnauthorizedError as NativeUnauthorizedError

/**
 * The server answered with an error.
 */
public actual open class RemoteError internal constructor(
    private val nativeRemoteError: NativeRemoteError,
) : Error(nativeRemoteError) {

    override fun toNative(): NativeRemoteError {
        return nativeRemoteError
    }
}

public fun NativeRemoteError.toCommon(): RemoteError {
    return when (this) {
        is NativeBadRequestError -> toCommon()
        is NativeForbiddenError -> toCommon()
        is NativeNotFoundError -> toCommon()
        is NativeRequestEntityTooLargeError -> toCommon()
        is NativeUnauthorizedError -> toCommon()
        else -> RemoteError(this)
    }
}
