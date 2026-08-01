package ru.sulgik.mapkit.runtime.network

import com.yandex.runtime.network.BadRequestError as NativeBadRequestError

/**
 * The server rejected the request as malformed.
 */
public actual open class BadRequestError internal constructor(
    private val nativeBadRequestError: NativeBadRequestError,
) : RemoteError(nativeBadRequestError) {

    override fun toNative(): NativeBadRequestError {
        return nativeBadRequestError
    }
}

public fun NativeBadRequestError.toCommon(): BadRequestError {
    return BadRequestError(this)
}
