package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ZoomRange
import ru.sulgik.mapkit.geometry.geo.Projection
import ru.sulgik.mapkit.layers.TileFormat
import ru.sulgik.mapkit.layers.toNative
import ru.sulgik.mapkit.tiles.TileProvider
import ru.sulgik.mapkit.tiles.UrlProvider
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.TileDataSourceBuilder as NativeTileDataSourceBuilder

/**
 * Configures the tile data source of a custom layer.
 */
public actual class TileDataSourceBuilder internal constructor(
    private val nativeBuilder: NativeTileDataSourceBuilder,
) {

    public fun toNative(): NativeTileDataSourceBuilder {
        return nativeBuilder
    }

    public actual fun setTileUrlProvider(urlProvider: UrlProvider) {
        nativeBuilder.setTileUrlProvider(urlProvider.toNative())
    }

    public actual fun setTileProvider(tileProvider: TileProvider) {
        nativeBuilder.setTileProvider(tileProvider.toNative())
    }

    public actual fun setProjection(projection: Projection) {
        nativeBuilder.setProjection(projection.toNative())
    }

    public actual fun setZoomRanges(zoomRanges: List<ZoomRange>) {
        nativeBuilder.setZoomRanges(zoomRanges.map { it.toNative() })
    }

    public actual fun setTileFormat(format: TileFormat) {
        nativeBuilder.setTileFormat(format.toNative())
    }
}

public fun NativeTileDataSourceBuilder.toCommon(): TileDataSourceBuilder {
    return TileDataSourceBuilder(this)
}
