package ru.sulgik.mapkit.search

import platform.Foundation.NSError
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKSuggestResponse as NativeSuggestResponse

/** Receives a terminal [SuggestSession.suggest] response or error on the UI thread. */
public actual abstract class SuggestListener actual constructor() : NativeConvertible<(NativeSuggestResponse?, NSError?) -> Unit> {

    private val nativeListener: (NativeSuggestResponse?, NSError?) -> Unit = { response, error ->
        when {
            error != null -> onError(error.toCommon())
            response != null -> onResponse(response.toCommon())
            else -> Unit
        }
    }

    override fun toNative(): (NativeSuggestResponse?, NSError?) -> Unit {
        return nativeListener
    }

    /** MapKit returned suggestions. */
    public actual abstract fun onResponse(response: SuggestResponse)

    /** MapKit reported a failure. */
    public actual abstract fun onError(error: SearchError)
}
