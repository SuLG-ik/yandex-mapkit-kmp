package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKSearchSessionResponseHandler as NativeSearchListener

/** Receives the terminal response or error of a [SearchManager.submit] request on the UI thread. */
public actual abstract class SearchListener actual constructor() : NativeConvertible<NativeSearchListener> {

    private val nativeListener: NativeSearchListener = { response, error ->
        when {
            error != null -> onSearchError(error.toCommon())
            response != null -> onSearchResponse(response.toCommon())
            else -> Unit
        }
    }

    override fun toNative(): NativeSearchListener {
        return nativeListener
    }

    /** MapKit completed the request successfully. */
    public actual abstract fun onSearchResponse(response: Response)

    /** MapKit reported a failure. */
    public actual abstract fun onSearchError(error: SearchError)
}
