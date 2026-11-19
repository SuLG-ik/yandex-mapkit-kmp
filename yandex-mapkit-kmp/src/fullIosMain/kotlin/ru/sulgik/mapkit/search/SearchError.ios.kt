package ru.sulgik.mapkit.search

import YandexMapKit.YRTUnderlyingErrorKey
import ru.sulgik.mapkit.runtime.Error
import YandexMapKit.YRTError as NativeRuntimeError
import platform.Foundation.NSError as NativeError
import ru.sulgik.mapkit.runtime.toCommon as toRuntimeError

/** A failure reported by the search service. */
public actual class SearchError internal constructor(private val nativeError: NativeError) {

    public fun toNative(): NativeError {
        return nativeError
    }

    /** The typed MapKit failure, when the native platform supplies one. */
    public actual val error: Error?
        get() = (nativeError.userInfo[YRTUnderlyingErrorKey] as? NativeRuntimeError)?.toRuntimeError()

    /** The platform's message, when available. */
    public actual val description: String?
        get() = nativeError.localizedDescription
}

public fun NativeError.toCommon(): SearchError {
    return SearchError(this)
}
