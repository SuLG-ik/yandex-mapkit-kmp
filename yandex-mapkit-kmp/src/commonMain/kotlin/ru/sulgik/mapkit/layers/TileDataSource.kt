package ru.sulgik.mapkit.layers

/**
 * A data source that is fed tile by tile.
 */
public expect class TileDataSource : BaseDataSource {

    /**
     * Invalidates data source and reloads all tiles.
     */
    public fun invalidate(version: String)
}
