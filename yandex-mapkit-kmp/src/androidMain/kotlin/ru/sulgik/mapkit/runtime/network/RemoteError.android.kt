package ru.sulgik.mapkit.runtime.network

import ru.sulgik.mapkit.runtime.Error
import com.yandex.runtime.network.BadRequestError as NativeBadRequestError
import com.yandex.runtime.network.ForbiddenError as NativeForbiddenError
import com.yandex.runtime.network.NotFoundError as NativeNotFoundError
import com.yandex.runtime.network.RemoteError as NativeRemoteError
import com.yandex.runtime.network.RequestEntityTooLargeError as NativeRequestEntityTooLargeError
import com.yandex.runtime.network.UnauthorizedError as NativeUnauthorizedError

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
