package ru.sulgik.mapkit.tiles

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.RawTile
import ru.sulgik.mapkit.TileId
import ru.sulgik.mapkit.Version
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKRawTile as NativeRawTile
import YandexMapKit.YMKTileId as NativeTileId
import YandexMapKit.YMKTileProviderProtocol as NativeTileProvider
import YandexMapKit.YMKVersion as NativeVersion

/**
 * Generates the tiles of a custom tile layer.
 */
public actual abstract class TileProvider actual constructor() : NativeConvertible<NativeTileProvider> {

    private val nativeTileProvider = object : NativeTileProvider, NSObject() {
        @Suppress("UNCHECKED_CAST")
        override fun loadWithTileId(
            tileId: NativeTileId,
            version: NativeVersion,
            features: Map<Any?, *>,
            etag: String,
        ): NativeRawTile {
            return this@TileProvider.load(
                tileId.toCommon(),
                version.toCommon(),
                features as Map<String, String>,
                etag,
            ).toNative()
        }
    }

    override fun toNative(): NativeTileProvider {
        return nativeTileProvider
    }

    /**
     * Generates tile.
     */
    public actual abstract fun load(
        tileId: TileId,
        version: Version,
        features: Map<String, String>,
        etag: String,
    ): RawTile
}
