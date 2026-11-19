package ru.sulgik.mapkit.search

import YandexMapKit.YMKSearchManager as NativeSearchManager

/**
 * Manager for searching for geographical objects.
 */
public actual class SearchManager internal constructor(private val nativeSearchManager: NativeSearchManager) {

    public fun toNative(): NativeSearchManager {
        return nativeSearchManager
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
