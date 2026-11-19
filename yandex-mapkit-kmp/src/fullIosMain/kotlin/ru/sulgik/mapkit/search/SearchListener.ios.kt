package ru.sulgik.mapkit.search

import platform.Foundation.NSError
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKSearchResponse as NativeResponse

/** Receives the terminal response or error of a [SearchManager.submit] request on the UI thread. */
public actual abstract class SearchListener actual constructor() :
    NativeConvertible<(NativeResponse?, NSError?) -> Unit> {

    private val nativeListener: (NativeResponse?, NSError?) -> Unit = { response, error ->
        when {
            error != null -> onSearchError(error.toCommon())
            response != null -> onSearchResponse(response.toCommon())
            else -> Unit
        }
    }

    override fun toNative(): (NativeResponse?, NSError?) -> Unit {
        return nativeListener
    }

    /** MapKit completed the request successfully. */
    public actual abstract fun onSearchResponse(response: Response)

    /** MapKit reported a failure. */
    public actual abstract fun onSearchError(error: SearchError)
}
