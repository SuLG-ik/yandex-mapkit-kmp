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
 *
 * The builder is handed to [Map.addTileLayer] and is only valid for the duration of that call.
 */
public actual class TileDataSourceBuilder internal constructor(
    private val nativeBuilder: NativeTileDataSourceBuilder,
) {

    public fun toNative(): NativeTileDataSourceBuilder {
        return nativeBuilder
    }

    /**
     * The class does not retain the object in the 'urlProvider' parameter.
     */
    public actual fun setTileUrlProvider(urlProvider: UrlProvider) {
        nativeBuilder.setTileUrlProvider(urlProvider.toNative())
    }

    /**
     * The class does not retain the object in the 'tileProvider' parameter.
     */
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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TileDataSourceBuilder) return false
        if (this::class != other::class) return false
        return nativeBuilder == other.nativeBuilder
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeBuilder.hashCode()
    }
}

public fun NativeTileDataSourceBuilder.toCommon(): TileDataSourceBuilder {
    return TileDataSourceBuilder(this)
}
