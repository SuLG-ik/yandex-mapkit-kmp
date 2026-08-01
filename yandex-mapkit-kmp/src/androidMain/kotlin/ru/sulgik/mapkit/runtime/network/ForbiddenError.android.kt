package ru.sulgik.mapkit.runtime.network

import com.yandex.runtime.network.ForbiddenError as NativeForbiddenError

/**
 * The server refused to authorize the request.
 */
public actual open class ForbiddenError internal constructor(
    private val nativeForbiddenError: NativeForbiddenError,
) : RemoteError(nativeForbiddenError) {

    override fun toNative(): NativeForbiddenError {
        return nativeForbiddenError
    }
}

public fun NativeForbiddenError.toCommon(): ForbiddenError {
    return ForbiddenError(this)
}
