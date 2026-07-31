package ru.sulgik.mapkit.layers

import YandexMapKit.YMKTileDataSource as NativeTileDataSource

/**
 * A data source that is fed tile by tile.
 */
public actual class TileDataSource internal constructor(
    private val nativeTileDataSource: NativeTileDataSource,
) : BaseDataSource(nativeTileDataSource) {

    override fun toNative(): NativeTileDataSource {
        return nativeTileDataSource
    }

    /**
     * Invalidates data source and reloads all tiles.
     */
    public actual fun invalidate(version: String) {
        nativeTileDataSource.invalidateWithVersion(version)
    }
}

public fun NativeTileDataSource.toCommon(): TileDataSource {
    return TileDataSource(this)
}
