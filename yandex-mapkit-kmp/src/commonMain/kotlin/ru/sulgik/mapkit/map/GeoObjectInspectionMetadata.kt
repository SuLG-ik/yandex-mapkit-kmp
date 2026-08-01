package ru.sulgik.mapkit.map

/**
 * Describes the geometry kind of a basemap object.
 */
public data class GeoObjectInspectionMetadata(
    val layerId: String,
    val objectType: ObjectType,
) : BaseMetadata {

    public enum class ObjectType {
        POINT,
        POLYLINE,
        POLYGON,
        CIRCLE,
    }
}
