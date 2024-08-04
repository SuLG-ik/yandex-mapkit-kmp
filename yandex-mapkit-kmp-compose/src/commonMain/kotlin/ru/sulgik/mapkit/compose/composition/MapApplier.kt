package ru.sulgik.mapkit.compose.composition

import androidx.compose.runtime.AbstractApplier
import ru.sulgik.mapkit.map.MapWindow


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