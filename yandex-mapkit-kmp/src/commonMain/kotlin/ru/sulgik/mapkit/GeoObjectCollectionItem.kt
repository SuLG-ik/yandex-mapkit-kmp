package ru.sulgik.mapkit

/**
 * An entry of a [GeoObjectCollection]: either a [GeoObject] or a nested collection.
 */
public expect class GeoObjectCollectionItem {

    public val obj: GeoObject?

    public val collection: GeoObjectCollection?
}
