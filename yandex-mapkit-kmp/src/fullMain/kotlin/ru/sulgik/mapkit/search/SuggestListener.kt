package ru.sulgik.mapkit.search

/** Receives a terminal [SuggestSession.suggest] response or error on the UI thread. */
public expect abstract class SuggestListener() {

    /** MapKit returned suggestions. */
    public abstract fun onResponse(response: SuggestResponse)

    /** MapKit reported a failure. */
    public abstract fun onError(error: SearchError)
}

/** Creates a listener from its response and error callbacks. */
public inline fun SuggestListener(
    crossinline onResponse: (SuggestResponse) -> Unit,
    crossinline onError: (SearchError) -> Unit,
): SuggestListener {
    return object : SuggestListener() {
        override fun onResponse(response: SuggestResponse) {
            onResponse.invoke(response)
        }

        override fun onError(error: SearchError) {
            onError.invoke(error)
        }
    }
}

internal class SuggestRequests {

    private var pending: SuggestRequest? = null

    fun submit(listener: SuggestListener, submit: (SuggestListener) -> Unit) {
        pending?.dispose()
        val request = SuggestRequest(listener) { completed ->
            if (pending === completed) pending = null
        }
        pending = request
        try {
            submit(request)
        } catch (error: Throwable) {
            request.dispose()
            if (pending === request) pending = null
            throw error
        }
    }

    fun dispose() {
        val previous = pending
        pending = null
        previous?.dispose()
    }
}

private class SuggestRequest(
    listener: SuggestListener,
    onFinished: (SuggestRequest) -> Unit,
) : SuggestListener() {

    private var pendingListener: SuggestListener? = listener
    private var onFinished: ((SuggestRequest) -> Unit)? = onFinished

    override fun onResponse(response: SuggestResponse) {
        val listener = takeListener() ?: return
        listener.onResponse(response)
    }

    override fun onError(error: SearchError) {
        val listener = takeListener() ?: return
        listener.onError(error)
    }

    fun dispose() {
        pendingListener = null
        onFinished = null
    }

    private fun takeListener(): SuggestListener? {
        val listener = pendingListener ?: return null
        val completed = onFinished
        dispose()
        completed?.invoke(this)
        return listener
    }
}
