package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ZoomRange
import ru.sulgik.mapkit.geometry.geo.Projection
import ru.sulgik.mapkit.layers.TileFormat
import ru.sulgik.mapkit.tiles.TileProvider
import ru.sulgik.mapkit.tiles.UrlProvider

/**
 * Configures the tile data source of a custom layer.
 *
 * The builder is handed to [Map.addTileLayer] and is only valid for the duration of that call.
 */
public expect class TileDataSourceBuilder {

    /**
     * The class does not retain the object in the 'urlProvider' parameter.
     */
    public fun setTileUrlProvider(urlProvider: UrlProvider)

    /**
     * The class does not retain the object in the 'tileProvider' parameter.
     */
    public fun setTileProvider(tileProvider: TileProvider)

    public fun setProjection(projection: Projection)

    public fun setZoomRanges(zoomRanges: List<ZoomRange>)

    public fun setTileFormat(format: TileFormat)
}
