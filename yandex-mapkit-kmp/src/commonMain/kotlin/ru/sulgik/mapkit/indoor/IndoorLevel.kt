package ru.sulgik.mapkit.indoor

/**
 * Describes level of indoor plan.
 */
public data class IndoorLevel(
    /**
     * Universal identifier of the level.
     */
    val id: String,
    /**
     * Localized display name of the level.
     */
    val name: String,
    /**
     * true if level is under ground
     */
    val isUnderground: Boolean,
)
