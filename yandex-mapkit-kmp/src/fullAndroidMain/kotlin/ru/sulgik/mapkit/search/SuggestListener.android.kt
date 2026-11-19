package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.search.SuggestResponse as NativeSuggestResponse
import com.yandex.mapkit.search.SuggestSession.SuggestListener as NativeSuggestListener
import com.yandex.runtime.Error as NativeError

/** Receives a terminal [SuggestSession.suggest] response or error on the UI thread. */
public actual abstract class SuggestListener actual constructor() : NativeConvertible<NativeSuggestListener> {

    private val nativeListener: NativeSuggestListener = object : NativeSuggestListener {
        override fun onResponse(response: NativeSuggestResponse) {
            this@SuggestListener.onResponse(response.toCommon())
        }

        override fun onError(error: NativeError) {
            this@SuggestListener.onError(error.toCommon())
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
