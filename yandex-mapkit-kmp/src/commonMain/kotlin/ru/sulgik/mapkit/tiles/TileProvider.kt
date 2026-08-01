package ru.sulgik.mapkit.tiles

import ru.sulgik.mapkit.RawTile
import ru.sulgik.mapkit.TileId
import ru.sulgik.mapkit.Version

/**
 * Generates the tiles of a custom tile layer.
 */
public expect abstract class TileProvider() {

    /**
     * Generates tile.
     */
    public abstract fun load(
        tileId: TileId,
        version: Version,
        features: Map<String, String>,
        etag: String,
    ): RawTile
}

public inline fun TileProvider(
    crossinline load: (
        tileId: TileId,
        version: Version,
        features: Map<String, String>,
        etag: String,
    ) -> RawTile,
): TileProvider {
    return object : TileProvider() {
        override fun load(
            tileId: TileId,
            version: Version,
            features: Map<String, String>,
            etag: String,
        ): RawTile {
            return load.invoke(tileId, version, features, etag)
        }
    }
}
