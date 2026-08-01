package ru.sulgik.mapkit.runtime.network

import ru.sulgik.mapkit.runtime.Error
import com.yandex.runtime.network.NetworkError as NativeNetworkError

/**
 * The request could not reach the server.
 */
public actual open class NetworkError internal constructor(
    private val nativeNetworkError: NativeNetworkError,
) : Error(nativeNetworkError) {

    override fun toNative(): NativeNetworkError {
        return nativeNetworkError
    }
}

public fun NativeNetworkError.toCommon(): NetworkError {
    return NetworkError(this)
}
