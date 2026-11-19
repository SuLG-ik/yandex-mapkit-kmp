package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.runtime.Error
import com.yandex.runtime.Error as NativeError
import ru.sulgik.mapkit.runtime.toCommon as toRuntimeError

/** A failure reported by the search service. */
public actual class SearchError internal constructor(private val nativeError: NativeError) {

    public fun toNative(): NativeError {
        return nativeError
    }

    /** The typed MapKit failure, when the native platform supplies one. */
    public actual val error: Error?
        get() = nativeError.toRuntimeError()

    /** The platform's message, when available. */
    public actual val description: String?
        get() = null
}

public fun NativeError.toCommon(): SearchError {
    return SearchError(this)
}
