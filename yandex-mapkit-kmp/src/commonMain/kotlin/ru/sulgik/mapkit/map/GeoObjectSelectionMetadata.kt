package ru.sulgik.mapkit.map

/**
 * Identifies a basemap object so that it can be selected with [Map.selectGeoObject].
 */
public data class GeoObjectSelectionMetadata(
    /**
     * Object ID.
     */
    val objectId: String,
    /**
     * Data source name.
     */
    val dataSourceName: String,
    /**
     * Layer ID.
     */
    val layerId: String,
    /**
     * Group ID.
     */
    val groupId: Long?,
) : BaseMetadata
