package ru.sulgik.mapkit.search

/**
 * Manager for searching for geographical objects.
 */
public expect class SearchManager {

    /** Two handles are equal when they wrap the same native search manager. */
    override fun equals(other: Any?): Boolean

    /** Returns the hash code of the native search manager. */
    override fun hashCode(): Int
}
