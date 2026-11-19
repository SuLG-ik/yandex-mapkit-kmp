package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKSearchSuggestSession as NativeSuggestSession

private val requestBindings = SearchRequestBindings<NativeSuggestSession, SuggestRequests>()

internal fun NativeSuggestSession.requestState(): SuggestRequests {
    return requestBindings.requestFor(this) ?: SuggestRequests().also { requestBindings.bind(this, it) }
}

/** Retain one suggest session for the lifetime of a query editor. Use it on the UI thread. */
public actual class SuggestSession internal constructor(private val nativeSuggestSession: NativeSuggestSession) {

    private val requests = nativeSuggestSession.requestState()

    public fun toNative(): NativeSuggestSession {
        return nativeSuggestSession
    }

    /**
     * Begins a suggest request in the map [window]. A new request replaces any pending request
     * in this session. Retain the session until the response, reset, or editor disposal.
     */
    public actual fun suggest(
        text: String,
        window: BoundingBox,
        suggestOptions: SuggestOptions,
        suggestListener: SuggestListener,
    ) {
        val nativeWindow = window.toNative()
        val nativeOptions = suggestOptions.toNative()
        requests.submit(suggestListener) { request ->
            nativeSuggestSession.suggestWithText(
                text = text,
                window = nativeWindow,
                suggestOptions = nativeOptions,
                responseHandler = request.toNative(),
            )
        }
    }

    /**
     * Cancels the pending request and resets native state. The service treats the next request
     * as the start of a new session.
     */
    public actual fun reset() {
        requests.dispose()
        nativeSuggestSession.reset()
    }

    /** Two handles are equal when they wrap the same native session. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SuggestSession) return false
        return nativeSuggestSession == other.nativeSuggestSession
    }

    /** Returns the hash code of the native session. */
    actual override fun hashCode(): Int {
        return nativeSuggestSession.hashCode()
    }
}

public fun NativeSuggestSession.toCommon(): SuggestSession {
    return SuggestSession(this)
}
