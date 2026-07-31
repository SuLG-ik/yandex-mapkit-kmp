package ru.sulgik.mapkit.tiles

import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.RawTile
import ru.sulgik.mapkit.TileId
import ru.sulgik.mapkit.Version
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.RawTile as NativeRawTile
import com.yandex.mapkit.TileId as NativeTileId
import com.yandex.mapkit.Version as NativeVersion
import com.yandex.mapkit.tiles.TileProvider as NativeTileProvider

/**
 * Generates the tiles of a custom tile layer.
 */
public actual abstract class TileProvider actual constructor() : NativeConvertible<NativeTileProvider> {

    private val nativeTileProvider = object : NativeTileProvider {
        override fun load(
            tileId: NativeTileId,
            version: NativeVersion,
            features: MutableMap<String, String>,
            etag: String,
        ): NativeRawTile {
            return this@TileProvider.load(
                tileId.toCommon(),
                version.toCommon(),
                features,
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
