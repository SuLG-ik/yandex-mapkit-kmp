package ru.sulgik.mapkit

/**
 * Determines how feature participates in conflict resolution.
 */
public enum class ConflictResolutionMode {

    /**
     * Feature can be hidden (if supported) due to conflict with higher feature but will not
     * conflict with lower features.
     */
    MINOR,

    /**
     * Feature can be hidden (if supported) due to conflict with higher feature and can displace
     * lower features.
     */
    EQUAL,

    /**
     * Feature can NOT be hidden but can displace lower features.
     */
    MAJOR,

    /**
     * Feature doesn't participate in conflict resolution.
     */
    IGNORE,
}
