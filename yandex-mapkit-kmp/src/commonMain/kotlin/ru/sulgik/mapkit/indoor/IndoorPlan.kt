package ru.sulgik.mapkit.indoor

/**
 * Describes indoor plan of building.
 *
 * Use activeLevelId property to select active level
 */
public interface IndoorPlan {
    /**
     * List of all levels in indoor plan, from bottom to top.
     */
    public val levels: List<IndoorLevel>

    /**
     * Gets/sets active id
     */
    public var activeLevelId: String
}