package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.GeoObjectCollection

/** The result of a successful search request. */
public expect class Response {

    /** Organizations and toponyms returned by MapKit. An empty collection is a successful result. */
    public val collection: GeoObjectCollection

    /** Whether MapKit obtained this response from offline data. */
    public val isOffline: Boolean

    /** Two handles are equal when they wrap the same native response. */
    override fun equals(other: Any?): Boolean

    /** The hash code of the native response. */
    override fun hashCode(): Int
}
