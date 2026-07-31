package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.BoundingBox

/**
 * A tree of geo objects.
 */
public expect class GeoObjectCollection {

    /**
     * The bounds around the collection of objects.
     */
    public val boundingBox: BoundingBox?

    /**
     * The objects and the nested collections.
     */
    public val children: List<GeoObjectCollectionItem>
}
