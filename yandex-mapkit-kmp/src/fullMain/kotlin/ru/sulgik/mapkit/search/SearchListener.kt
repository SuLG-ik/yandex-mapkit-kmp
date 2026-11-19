package ru.sulgik.mapkit.search

/** Receives the terminal response or error of a [SearchManager.submit] request on the UI thread. */
public expect abstract class SearchListener() {

    /** MapKit completed the request successfully. */
    public abstract fun onSearchResponse(response: Response)

    /** MapKit reported a failure. */
    public abstract fun onSearchError(error: SearchError)
}

/** Creates a listener from its response and error callbacks. */
public inline fun SearchListener(
    crossinline onSearchResponse: (Response) -> Unit,
    crossinline onSearchError: (SearchError) -> Unit,
): SearchListener {
    return object : SearchListener() {
        override fun onSearchResponse(response: Response) {
            onSearchResponse.invoke(response)
        }

        override fun onSearchError(error: SearchError) {
            onSearchError.invoke(error)
        }
    }
}

internal class SearchRequest(listener: SearchListener) : SearchListener() {

    private var pendingListener: SearchListener? = listener

    override fun onSearchResponse(response: Response) {
        val listener = pendingListener ?: return
        pendingListener = null
        listener.onSearchResponse(response)
    }

    override fun onSearchError(error: SearchError) {
        val listener = pendingListener ?: return
        pendingListener = null
        listener.onSearchError(error)
    }

    fun dispose() {
        pendingListener = null
    }
}
