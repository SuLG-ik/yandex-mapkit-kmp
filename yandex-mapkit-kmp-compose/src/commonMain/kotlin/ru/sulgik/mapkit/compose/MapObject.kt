package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.Updater
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ru.sulgik.mapkit.compose.composition.MapApplier
import ru.sulgik.mapkit.compose.composition.MapNode
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.MapObject
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.map.MapObjectDragListener
import ru.sulgik.mapkit.map.MapObjectTapListener

public abstract class MapObjectState {


}

@[YandexMapComposable Composable]
internal inline fun <reified T : MapObjectNode<R>, R : MapObject> MapObjectNode(
    state: MapObjectState,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    noinline onTap: ((Point) -> Boolean)? = null,
    noinline factory: (applier: MapApplier) -> T,
    update: @DisallowComposableCalls Updater<T>.() -> Unit
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
            update(state) { this.state = it }
            update(onTap) { this.tapListener = it }
            update(zIndex) { this.mapObject.zIndex = it }
            update(visible) { this.mapObject.isVisible = it }
            update()
        }
    )
}

internal abstract class MapObjectNode<T : MapObject>(
    val mapObject: T,
    state: MapObjectState,
    tapListener: ((point: Point) -> Boolean)?,
) : MapNode {

    internal var tapListener: ((point: Point) -> Boolean)? = tapListener
        set(value) {
            if (value == field) return
            if (value == null) {
                mapObject.removeTapListener(nativeTapListener)
            } else if (field == null) {
                mapObject.addTapListener(nativeTapListener)
            }
            field = value
        }

    internal var state: MapObjectState = state
        set(value) {
            if (value == field) return
            field = value
        }

    private val nativeTapListener =
        MapObjectTapListener { _, point -> tapListener?.invoke(point) ?: false }

    override fun onAttached() {
        if (tapListener != null) {
            mapObject.addTapListener(nativeTapListener)
        }
    }

    override fun onRemoved() {
        mapObject.removeTapListener(nativeTapListener)
        mapObject.parent.remove(mapObject)
    }

    override fun onCleared() {
        tapListener = null
        onRemoved()
    }

}

internal val LocalMapObjectCollection =
    compositionLocalOf<MapObjectCollection> { error("No MapObjectCollection provided") }