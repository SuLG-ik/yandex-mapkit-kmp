package ru.sulgik.mapkit.search

import com.yandex.mapkit.search.Search as NativeSearch
import com.yandex.mapkit.search.SearchFactory as NativeSearchFactory

/**
 * Entry point for search in the Full MapKit SDK.
 */
public actual class Search internal constructor(private val nativeSearch: NativeSearch) {

    public fun toNative(): NativeSearch {
        return nativeSearch
    }

    /** Creates a manager that searches for geographical objects. */
    public actual fun createSearchManager(searchManagerType: SearchManagerType): SearchManager {
        return nativeSearch.createSearchManager(searchManagerType.toNative()).toCommon()
    }

    /** Tells if this search object is valid. */
    public actual val isValid: Boolean
        get() = nativeSearch.isValid

    public actual companion object {

        /** Returns the search entry point. */
        public actual fun getInstance(): Search {
            return NativeSearchFactory.getInstance().toCommon()
        }
    }

    /** Two handles are equal when they wrap the same native search object. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Search) return false
        return nativeSearch == other.nativeSearch
    }

    /** Returns the hash code of the native search object. */
    actual override fun hashCode(): Int {
        return nativeSearch.hashCode()
    }
}

public fun NativeSearch.toCommon(): Search {
    return Search(this)
}
