package ru.sulgik.mapkit.location

public expect class LocationViewSource {

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}

public expect fun LocationManager.toLocationViewSource(): LocationViewSource
