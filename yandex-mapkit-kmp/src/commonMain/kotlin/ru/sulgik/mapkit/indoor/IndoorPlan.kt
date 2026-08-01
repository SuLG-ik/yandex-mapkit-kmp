package ru.sulgik.mapkit.indoor

/**
 * Describes indoor plan of building.
 *
 * Use activeLevelId property to select active level
 */
public expect class IndoorPlan {

    /**
     * List of all levels in indoor plan, from bottom to top.
     */
    public val levels: List<IndoorLevel>

    /**
     * Gets/sets active id
     */
    public var activeLevelId: String

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
