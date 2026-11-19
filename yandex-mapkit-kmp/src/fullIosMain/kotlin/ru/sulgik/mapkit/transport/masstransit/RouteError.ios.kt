package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YRTUnderlyingErrorKey
import ru.sulgik.mapkit.runtime.Error
import YandexMapKit.YRTError as NativeRuntimeError
import platform.Foundation.NSError as NativeError
import ru.sulgik.mapkit.runtime.toCommon as toRuntimeError

/** A failure reported by a walking, cycling or transit router. */
public actual class RouteError internal constructor(private val nativeError: NativeError) {

    /** Returns the native failure. */
    public fun toNative(): NativeError {
        return nativeError
    }

    /** The typed MapKit failure, when the platform supplies one. */
    public actual val error: Error?
        get() = (nativeError.userInfo[YRTUnderlyingErrorKey] as? NativeRuntimeError)?.toRuntimeError()

    /** The native error message, when available. */
    public actual val description: String?
        get() = nativeError.localizedDescription
}

/** Wraps a native transport failure. */
public fun NativeError.toCommon(): RouteError {
    return RouteError(this)
}
