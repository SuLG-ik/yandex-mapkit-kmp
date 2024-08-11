package ru.sulgik.mapkit.map

public enum class MapType {
    /**
     * Do not use any of the predefined maps.
     */
    NONE,

    /**
     * Raster map.
     */
    MAP,

    /**
     * Allowed only for Yandex apps Default satellite map.
     */
    SATELLITE,

    /**
     * Allowed only for Yandex apps Satellite map with roads, placemarks and labels.
     */
    HYBRID,

    /**
     * Vector map.
     */
    VECTOR_MAP,
}