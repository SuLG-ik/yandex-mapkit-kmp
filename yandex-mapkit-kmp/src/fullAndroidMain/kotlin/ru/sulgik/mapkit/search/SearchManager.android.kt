package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.search.SearchManager as NativeSearchManager

/**
 * Manager for searching for geographical objects.
 */
public actual class SearchManager internal constructor(private val nativeSearchManager: NativeSearchManager) {

    public fun toNative(): NativeSearchManager {
        return nativeSearchManager
    }

    /**
     * Searches near a point, bounding box, polyline or rectangular polygon.
     *
     * Call on the UI thread and retain the returned session. The session holds the listener until
     * delivery or cancellation. Call [Session.cancel] when leaving the owning screen or replacing
     * the request. The listener runs on the UI thread.
     */
    public actual fun submit(
        text: String,
        geometry: Geometry,
        searchOptions: SearchOptions,
        searchListener: SearchListener,
    ): Session {
        val request = SearchRequest(searchListener)
        val session = nativeSearchManager.submit(text, geometry.toNative(), searchOptions.toNative(), request.toNative())
        return Session(session, request)
    }

    /** Two handles are equal when they wrap the same native search manager. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SearchManager) return false
        return nativeSearchManager == other.nativeSearchManager
    }

    /** Returns the hash code of the native search manager. */
    actual override fun hashCode(): Int {
        return nativeSearchManager.hashCode()
    }
}

public fun NativeSearchManager.toCommon(): SearchManager {
    return SearchManager(this)
}
