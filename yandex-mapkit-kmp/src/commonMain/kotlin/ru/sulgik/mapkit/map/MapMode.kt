package ru.sulgik.mapkit.map

/**
 * Supported map style modes
 */
public enum class MapMode {
    /**
     * Basic map
     */
    MAP,

    /**
     * Public transport map
     */
    TRANSIT,

    /**
     * Automobile navigation map
     */
    DRIVING,

    /**
     * Administrative map
     */
    ADMIN,

    /**
     * Legacy basic map design, can be used to preserve compatibility with app design/legacy map customizaitons
     */
    LEGACY_MAP,

    /**
     * Upcoming basic map design
     */
    FUTURE_MAP
}