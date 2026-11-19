package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKSearchSuggestSessionResponseHandler as NativeSuggestListener

/** Receives a terminal [SuggestSession.suggest] response or error on the UI thread. */
public actual abstract class SuggestListener actual constructor() : NativeConvertible<NativeSuggestListener> {

    private val nativeListener: NativeSuggestListener = { response, error ->
        when {
            error != null -> onError(error.toCommon())
            response != null -> onResponse(response.toCommon())
            else -> Unit
        }
    }

    override fun toNative(): NativeSuggestListener {
        return nativeListener
    }

    /** MapKit returned suggestions. */
    public actual abstract fun onResponse(response: SuggestResponse)

    /** MapKit reported a failure. */
    public actual abstract fun onError(error: SearchError)
}
