package ru.sulgik.mapkit.compose.composition

import androidx.compose.runtime.AbstractApplier
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.RootMapObjectCollection

internal interface MapNode {
    fun onAttached() {}
    fun onRemoved() {}
    fun onCleared() {}
}

private object MapNodeRoot : MapNode

internal class MapApplier(
    val mapWindow: MapWindow,
) : AbstractApplier<MapNode>(MapNodeRoot) {

    private val mapObjects = mapWindow.map.mapObjects
    private val decorations = mutableListOf<MapNode>()
    private val objectLayers = mutableMapOf<String, RootMapObjectCollection>()

    /**
     * MapKit links one collection to a layer id and has no way to unlink it, so asking twice for
     * the same id throws. The collection is created once and reused for as long as the map lives.
     */
    fun mapObjectLayer(layerId: String): RootMapObjectCollection {
        return objectLayers.getOrPut(layerId) { mapWindow.map.addMapObjectLayer(layerId) }
    }

    override fun insertBottomUp(index: Int, instance: MapNode) {
        decorations.add(index, instance)
        instance.onAttached()
    }

    override fun insertTopDown(index: Int, instance: MapNode) {
    }

    override fun move(from: Int, to: Int, count: Int) {
        decorations.move(from, to, count)
    }

    override fun onClear() {
        mapObjects.clear()
        decorations.forEach { it.onCleared() }
        decorations.clear()
    }

    override fun remove(index: Int, count: Int) {
        repeat(count) {
            decorations[index + it].onRemoved()
        }
        decorations.remove(index, count)
    }
}
