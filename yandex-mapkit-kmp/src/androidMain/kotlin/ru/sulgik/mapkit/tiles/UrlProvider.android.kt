package ru.sulgik.mapkit.tiles

import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.TileId
import ru.sulgik.mapkit.Version
import ru.sulgik.mapkit.toCommon
import com.yandex.mapkit.TileId as NativeTileId
import com.yandex.mapkit.Version as NativeVersion
import com.yandex.mapkit.tiles.UrlProvider as NativeUrlProvider

/**
 * Builds the URL a tile is downloaded from.
 */
public actual abstract class UrlProvider actual constructor() : NativeConvertible<NativeUrlProvider> {

    private val nativeUrlProvider = object : NativeUrlProvider {
        override fun formatUrl(
            tileId: NativeTileId,
            version: NativeVersion,
            features: MutableMap<String, String>,
        ): String {
            return this@UrlProvider.formatUrl(tileId.toCommon(), version.toCommon(), features)
        }
    }

    override fun toNative(): NativeUrlProvider {
        return nativeUrlProvider
    }

    /**
     * Creates a URL based on the tile ID, version, and features.
     */
    public actual abstract fun formatUrl(
        tileId: TileId,
        version: Version,
        features: Map<String, String>,
    ): String
}
