package ru.sulgik.mapkit

/**
 * The address of a tile in the tile pyramid.
 */
public data class TileId(
    /**
     * The number of the tile horizontally.
     */
    val x: Int,
    /**
     * The number of the tile vertically.
     */
    val y: Int,
    /**
     * The number of columns and rows to split the map into.
     */
    val z: Int,
)
