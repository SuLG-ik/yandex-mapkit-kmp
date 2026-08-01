package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.composition.MapApplier
import ru.sulgik.mapkit.compose.composition.MapNode
import ru.sulgik.mapkit.layers.BaseDataSource
import ru.sulgik.mapkit.layers.DataSourceLayer
import ru.sulgik.mapkit.layers.DataSourceListener
import ru.sulgik.mapkit.layers.Layer
import ru.sulgik.mapkit.layers.LayerLoadedListener
import ru.sulgik.mapkit.layers.LayerOptions
import ru.sulgik.mapkit.map.RootMapObjectCollection
import ru.sulgik.mapkit.map.TileDataSourceBuilder

/**
 * Adds a custom tile layer for as long as this composable stays in the composition.
 *
 * [layerId] identifies the layer among the layers of the map and picks its place in the render
 * order; changing it replaces the layer. [createTileDataSource] is called once per layer, so the
 * data source it configures does not follow later recompositions.
 *
 * @param style JSON style transformation applied to the layer, keyed by [styleId].
 */
@[YandexMapComposable Composable]
public fun TileLayer(
    layerId: String,
    options: LayerOptions = LayerOptions(),
    active: Boolean = true,
    styleId: Int = 0,
    style: String? = null,
    onLayerLoaded: (() -> Unit)? = null,
    onDataSourceUpdated: ((BaseDataSource) -> Unit)? = null,
    createTileDataSource: (builder: TileDataSourceBuilder) -> Unit,
) {
    val mapApplier = currentComposer.applier as? MapApplier
        ?: error("TileLayer is not supported outside of YandexMapComposable")
    key(layerId) {
        ComposeNode<TileLayerNode, MapApplier>(
            factory = {
                val layer = mapApplier.mapWindow.map.addTileLayer(
                    layerId = layerId,
                    layerOptions = options,
                    createTileDataSource = createTileDataSource,
                )
                TileLayerNode(
                    layer = layer,
                    onLayerLoaded = onLayerLoaded,
                    onDataSourceUpdated = onDataSourceUpdated,
                ).apply {
                    dataSourceLayer.isActive = active
                    setStyle(styleId, style)
                }
            },
            update = {
                update(active) { this.dataSourceLayer.isActive = it }
                update(styleId) { this.setStyle(it, style) }
                update(style) { this.setStyle(styleId, it) }
                update(onLayerLoaded) { this.onLayerLoaded = it }
                update(onDataSourceUpdated) { this.onDataSourceUpdated = it }
            },
        )
    }
}

internal class TileLayerNode(
    private val layer: Layer,
    internal var onLayerLoaded: (() -> Unit)?,
    internal var onDataSourceUpdated: ((BaseDataSource) -> Unit)?,
) : MapNode {

    internal val dataSourceLayer: DataSourceLayer = layer.dataSourceLayer()

    private var layerLoadedListener: LayerLoadedListener? =
        LayerLoadedListener { onLayerLoaded?.invoke() }

    private var dataSourceListener: DataSourceListener? =
        DataSourceListener { dataSource -> onDataSourceUpdated?.invoke(dataSource) }

    fun setStyle(id: Int, style: String?) {
        if (style == null) {
            dataSourceLayer.resetStyles()
        } else {
            dataSourceLayer.setStyle(id, style)
        }
    }

    override fun onAttached() {
        dataSourceLayer.setLayerLoadedListener(layerLoadedListener?.asWeakRef())
        dataSourceLayer.setDataSourceListener(dataSourceListener?.asWeakRef())
    }

    override fun onRemoved() {
        if (!layer.isValid) return
        dataSourceLayer.setLayerLoadedListener(null)
        dataSourceLayer.setDataSourceListener(null)
        layer.remove()
    }

    override fun onCleared() {
        layerLoadedListener = null
        dataSourceListener = null
        onLayerLoaded = null
        onDataSourceUpdated = null
    }
}

/**
 * Puts the map objects of [content] into an independent collection linked to [layerId], instead of
 * the default collection of the map.
 *
 * The layer picks the place of the objects in the render order; changing [layerId] moves them to
 * another layer. MapKit links one collection to a layer id for the lifetime of the map and cannot
 * unlink it, so the collection is created once per id and reused: leaving the composition empties
 * it and entering it again fills the same collection.
 */
@[YandexMapComposable Composable]
public fun MapObjectLayer(
    layerId: String,
    content: @[Composable YandexMapComposable] () -> Unit,
) {
    val mapApplier = currentComposer.applier as? MapApplier
        ?: error("MapObjectLayer is not supported outside of YandexMapComposable")
    key(layerId) {
        val collection = remember(layerId) { mapApplier.mapObjectLayer(layerId) }
        ComposeNode<MapObjectLayerNode, MapApplier>(
            factory = { MapObjectLayerNode(collection) },
            update = { },
        )
        CompositionLocalProvider(LocalMapObjectCollection provides collection) {
            content()
        }
    }
}

internal class MapObjectLayerNode(
    private val collection: RootMapObjectCollection,
) : MapNode {

    override fun onRemoved() {
        if (collection.isValid) {
            collection.clear()
        }
    }
}
