package ru.sulgik.mapkit.tiles

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.TileId
import ru.sulgik.mapkit.Version
import ru.sulgik.mapkit.toCommon
import YandexMapKit.YMKTileId as NativeTileId
import YandexMapKit.YMKTilesUrlProviderProtocol as NativeUrlProvider
import YandexMapKit.YMKVersion as NativeVersion

/**
 * Builds the URL a tile is downloaded from.
 */
public actual abstract class UrlProvider actual constructor() : NativeConvertible<NativeUrlProvider> {

    private val nativeUrlProvider = object : NativeUrlProvider, NSObject() {
        @Suppress("UNCHECKED_CAST")
        override fun formatUrlWithTileId(
            tileId: NativeTileId,
            version: NativeVersion,
            features: Map<Any?, *>,
        ): String {
            return this@UrlProvider.formatUrl(
                tileId.toCommon(),
                version.toCommon(),
                features as Map<String, String>,
            )
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
