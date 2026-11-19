package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.GeoObjectCollection
import ru.sulgik.mapkit.toCommon
import com.yandex.mapkit.search.Response as NativeResponse

/** The result of a successful search request. */
public actual class Response internal constructor(private val nativeResponse: NativeResponse) {

    public fun toNative(): NativeResponse {
        return nativeResponse
    }

    /** Organizations and toponyms returned by MapKit. An empty collection is a successful result. */
    public actual val collection: GeoObjectCollection
        get() = nativeResponse.collection.toCommon()

    /** Whether MapKit obtained this response from offline data. */
    public actual val isOffline: Boolean
        get() = nativeResponse.getIsOffline()

    /** Two handles are equal when they wrap the same native response. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Response) return false
        return nativeResponse == other.nativeResponse
    }

    /** The hash code of the native response. */
    actual override fun hashCode(): Int {
        return nativeResponse.hashCode()
    }
}

public fun NativeResponse.toCommon(): Response {
    return Response(this)
}
