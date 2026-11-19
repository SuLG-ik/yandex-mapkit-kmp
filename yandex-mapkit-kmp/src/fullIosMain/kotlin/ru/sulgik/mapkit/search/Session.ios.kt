package ru.sulgik.mapkit.search

import YandexMapKit.YMKSearchSession as NativeSession

/**
 * A text search request in progress. Retain this session until the search completes or is canceled.
 */
public actual class Session internal constructor(
    private val nativeSession: NativeSession,
    private val request: SearchRequest? = null,
) {

    public fun toNative(): NativeSession {
        return nativeSession
    }

    /** Cancels the current request. The listener receives no further events from this request. */
    public actual fun cancel() {
        request?.dispose()
        nativeSession.cancel()
    }

    /** Two handles are equal when they wrap the same native session. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Session) return false
        return nativeSession == other.nativeSession
    }

    /** The hash code of the native session. */
    actual override fun hashCode(): Int {
        return nativeSession.hashCode()
    }
}

public fun NativeSession.toCommon(): Session {
    return Session(this)
}
