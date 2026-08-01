package ru.sulgik.mapkit.runtime

import ru.sulgik.mapkit.runtime.network.BadRequestError
import ru.sulgik.mapkit.runtime.network.ForbiddenError
import ru.sulgik.mapkit.runtime.network.NetworkError
import ru.sulgik.mapkit.runtime.network.NotFoundError
import ru.sulgik.mapkit.runtime.network.RemoteError
import ru.sulgik.mapkit.runtime.network.RequestEntityTooLargeError
import ru.sulgik.mapkit.runtime.network.UnauthorizedError
import ru.sulgik.mapkit.runtime.network.toCommon
import YandexMapKit.YRTBadRequestError as NativeBadRequestError
import YandexMapKit.YRTDiskCorruptError as NativeDiskCorruptError
import YandexMapKit.YRTDiskFullError as NativeDiskFullError
import YandexMapKit.YRTDiskWriteAccessError as NativeDiskWriteAccessError
import YandexMapKit.YRTError as NativeError
import YandexMapKit.YRTForbiddenError as NativeForbiddenError
import YandexMapKit.YRTLocalError as NativeLocalError
import YandexMapKit.YRTNetworkError as NativeNetworkError
import YandexMapKit.YRTNotFoundError as NativeNotFoundError
import YandexMapKit.YRTRemoteError as NativeRemoteError
import YandexMapKit.YRTRequestEntityTooLargeError as NativeRequestEntityTooLargeError
import YandexMapKit.YRTUnauthorizedError as NativeUnauthorizedError

/**
 * The base type of every error MapKit reports.
 */
public actual open class Error internal constructor(private val nativeError: NativeError) {

    public open fun toNative(): NativeError {
        return nativeError
    }

    /**
     * Tells if this **Error** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeError.isValid()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Error) return false
        if (this::class != other::class) return false
        return nativeError == other.nativeError
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeError.hashCode()
    }
}

public fun NativeError.toCommon(): Error {
    return when (this) {
        is NativeDiskWriteAccessError -> toCommon()
        is NativeDiskCorruptError -> toCommon()
        is NativeDiskFullError -> toCommon()
        is NativeLocalError -> toCommon()
        is NativeNetworkError -> toCommon()
        is NativeBadRequestError -> toCommon()
        is NativeForbiddenError -> toCommon()
        is NativeNotFoundError -> toCommon()
        is NativeRequestEntityTooLargeError -> toCommon()
        is NativeUnauthorizedError -> toCommon()
        is NativeRemoteError -> toCommon()
        else -> Error(this)
    }
}
