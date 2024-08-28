package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.Updater
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.currentComposer
import ru.sulgik.mapkit.compose.composition.MapApplier
import ru.sulgik.mapkit.compose.composition.MapNode
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.MapObject
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.map.MapObjectTapListener

@[YandexMapComposable Composable]
internal inline fun <reified T : MapObjectNode<R>, R : MapObject> MapObjectNode(
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    noinline onTap: ((Point) -> Boolean)? = null,
    noinline factory: (applier: MapApplier) -> T,
    update: @DisallowComposableCalls Updater<T>.() -> Unit,
) {
    val mapApplier = currentComposer.applier as? MapApplier
        ?: error("Creating ${T::class} from not YandexMapComposable is not supported")
    ComposeNode<T, MapApplier>(
        factory = {
            val node = factory(mapApplier)
            node.mapObject.isVisible = visible
            node.mapObject.zIndex = zIndex
            node
        },
        update = {
            update(onTap) { this.tapListener = it }
            update(zIndex) { this.mapObject.zIndex = it }
            update(visible) { this.mapObject.isVisible = it }
            update()
        }
    )
}

internal abstract class MapObjectNode<T : MapObject>(
    val mapObject: T,
    internal var tapListener: ((point: Point) -> Boolean)?,
) : MapNode {

    private val nativeTapListener =
        MapObjectTapListener { _, point -> tapListener?.invoke(point) ?: false }

    override fun onAttached() {
        mapObject.addTapListener(nativeTapListener)
    }

    override fun onRemoved() {
        mapObject.removeTapListener(nativeTapListener)
        mapObject.parent.remove(mapObject)
    }

    override fun onCleared() {
        tapListener = null
    }

}

internal val LocalMapObjectCollection =
    compositionLocalOf<MapObjectCollection> { error("No MapObjectCollection provided") }