package ru.sulgik.mapkit.tiles

import ru.sulgik.mapkit.TileId
import ru.sulgik.mapkit.Version

/**
 * Builds the URL a tile is downloaded from.
 */
public expect abstract class UrlProvider() {

    /**
     * Creates a URL based on the tile ID, version, and features.
     */
    public abstract fun formatUrl(
        tileId: TileId,
        version: Version,
        features: Map<String, String>,
    ): String
}

public inline fun UrlProvider(
    crossinline formatUrl: (
        tileId: TileId,
        version: Version,
        features: Map<String, String>,
    ) -> String,
): UrlProvider {
    return object : UrlProvider() {
        override fun formatUrl(
            tileId: TileId,
            version: Version,
            features: Map<String, String>,
        ): String {
            return formatUrl.invoke(tileId, version, features)
        }
    }
}
