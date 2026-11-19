package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.RawTile
import ru.sulgik.mapkit.ZoomRange
import ru.sulgik.mapkit.geometry.geo.Projections
import ru.sulgik.mapkit.tiles.TileProvider
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

public class LiveTileLayerTest {

    @Test
    public fun custom_layer_updates_visibility_and_style_and_invalidates_on_removal() {
        LiveMap.onMap { map ->
            val provider = TileProvider { _, version, features, etag ->
                RawTile(version, features, etag, RawTile.UseCache.NO, RawTile.State.ERROR, byteArrayOf())
            }
            var configurations = 0
            val layer = map.addTileLayer(
                layerId = "layer-regression-test",
                layerOptions = LayerOptions(active = false, cacheable = false, animateOnActivation = false),
            ) { builder ->
                configurations++
                builder.setTileProvider(provider)
                builder.setProjection(Projections.sphericalMercator)
                builder.setZoomRanges(listOf(ZoomRange(zMin = 0, zMax = 19)))
                builder.setTileFormat(TileFormat.PNG)
            }
            val data = layer.dataSourceLayer()
            try {
                assertEquals(1, configurations)
                assertTrue(layer.isValid)
                assertTrue(data.isValid)
                assertEquals(data, data.toNative().toCommon())
                assertFalse(data.isActive)
                data.isActive = true
                assertTrue(data.isActive)
                data.isActive = false
                assertFalse(data.isActive)

                assertTrue(data.setStyle(id = 7, style = "[]"))
                assertTrue(data.setStyle(id = 7, style = ""))
                assertFalse(data.setStyle(id = 7, style = "{"))
                data.resetStyles()
                data.clear()
                data.remove()
                assertFalse(data.isValid)
            } finally {
                if (layer.isValid) {
                    layer.remove()
                }
            }
            assertFalse(layer.isValid)
        }
    }
}
