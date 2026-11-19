package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.search.Response as NativeResponse
import com.yandex.mapkit.search.Session.SearchListener as NativeSearchListener
import com.yandex.runtime.Error as NativeError

/** Receives the terminal response or error of a [SearchManager.submit] request on the UI thread. */
public actual abstract class SearchListener actual constructor() : NativeConvertible<NativeSearchListener> {

    private val nativeListener: NativeSearchListener = object : NativeSearchListener {
        override fun onSearchResponse(response: NativeResponse) {
            this@SearchListener.onSearchResponse(response.toCommon())
        }

        override fun onSearchError(error: NativeError) {
            this@SearchListener.onSearchError(error.toCommon())
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
