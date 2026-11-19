package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.RawTile
import ru.sulgik.mapkit.ZoomRange
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.geo.Projections
import ru.sulgik.mapkit.tiles.TileProvider
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotSame
import kotlin.test.assertTrue

public class LiveTileLayerTest {

    private var providerInUse: TileProvider? = null

    @Test
    public fun custom_layer_updates_visibility_and_style_and_invalidates_on_removal() {
        LiveMap.onMap { map ->
            providerInUse = TileProvider { _, version, features, etag ->
                RawTile(version, features, etag, RawTile.UseCache.NO, RawTile.State.ERROR, byteArrayOf())
            }
            try {
                var configurations = 0
                val layer = map.addTileLayer(
                    layerId = "layer-regression-test",
                    layerOptions = LayerOptions(active = false, cacheable = false, animateOnActivation = false),
                ) { builder ->
                    configurations++
                    builder.setTileProvider(checkNotNull(providerInUse))
                    builder.setProjection(Projections.sphericalMercator)
                    builder.setZoomRanges(listOf(ZoomRange(zMin = 0, zMax = 19)))
                    builder.setTileFormat(TileFormat.PNG)
                }
                try {
                    val data = layer.dataSourceLayer()
                    assertEquals(1, configurations)
                    assertTrue(layer.isValid)
                    assertTrue(data.isValid)
                    assertEquals(data, data.toNative().toCommon())
                    assertFalse(data.isActive)

                    val firstSourceListener = DataSourceListener { }
                    val nextSourceListener = DataSourceListener { }
                    val firstLoadedListener = LayerLoadedListener { }
                    val nextLoadedListener = LayerLoadedListener { }
                    data.setDataSourceListener(firstSourceListener.asWeakRef())
                    data.setLayerLoadedListener(firstLoadedListener.asWeakRef())
                    data.setDataSourceListener(nextSourceListener.asWeakRef())
                    data.setLayerLoadedListener(nextLoadedListener.asWeakRef())
                    data.setDataSourceListener(null)
                    data.setLayerLoadedListener(null)
                    assertNotSame(firstSourceListener.toNative(), nextSourceListener.toNative())
                    assertNotSame(firstLoadedListener.toNative(), nextLoadedListener.toNative())

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
            } finally {
                providerInUse = null
            }
        }
    }
}
