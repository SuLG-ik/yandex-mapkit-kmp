package ru.sulgik.mapkit.search

/**
 * Entry point for search in the Full MapKit SDK.
 */
public expect class Search {

    /** Creates a manager that searches for geographical objects. */
    public fun createSearchManager(searchManagerType: SearchManagerType): SearchManager

    /** Tells if this search object is valid. */
    public val isValid: Boolean

    public companion object {

        /** Returns the search entry point. */
        public fun getInstance(): Search
    }

    /** Two handles are equal when they wrap the same native search object. */
    override fun equals(other: Any?): Boolean

    /** Returns the hash code of the native search object. */
    override fun hashCode(): Int
}
