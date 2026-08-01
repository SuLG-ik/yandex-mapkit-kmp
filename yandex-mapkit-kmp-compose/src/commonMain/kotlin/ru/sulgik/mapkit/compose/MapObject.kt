package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Updater
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.mutableStateOf
import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.composition.MapApplier
import ru.sulgik.mapkit.compose.composition.MapNode
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.Callback
import ru.sulgik.mapkit.map.MapObject
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.map.MapObjectTapListener

/**
 * The part of a map object that a composable parameter cannot express.
 *
 * A state is bound to its map object while the matching composable is in the composition. Methods
 * that have nothing to return do nothing before that happens; the ones that do throw
 * [IllegalStateException].
 */
public abstract class MapObjectState<T : MapObject> internal constructor() {

    private val mapObjectState: MutableState<T?> = mutableStateOf(null)

    internal var mapObject: T?
        get() = mapObjectState.value
        set(value) {
            val current = mapObjectState.value
            if (current === value) return
            if (current != null && value != null) {
                error("${this::class.simpleName} may only be associated with one map object at a time.")
            }
            mapObjectState.value = value
        }

    internal fun requireMapObject(): T {
        return mapObject
            ?: throw IllegalStateException("${this::class.simpleName} is not attached to a map object")
    }

    /**
     * Manages visibility of the object with a transition between the visible and not visible
     * states.
     *
     * Use the `visible` parameter of the composable for a plain, non-animated change.
     */
    public fun setVisible(visible: Boolean, animation: Animation, onFinished: Callback? = null) {
        mapObject?.setVisible(visible, animation, onFinished)
    }

    /**
     * Tells if the bound map object is valid or not.
     */
    public val isValid: Boolean
        get() = mapObject?.isValid == true
}

@[YandexMapComposable Composable]
internal inline fun <reified N : MapObjectNode<T, S>, T : MapObject, S : MapObjectState<T>> MapObjectNode(
    state: S?,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    userData: Any? = null,
    noinline onTap: ((Point) -> Boolean)? = null,
    noinline factory: (applier: MapApplier) -> N,
    update: @DisallowComposableCalls Updater<N>.() -> Unit,
) {
    val mapApplier = currentComposer.applier as? MapApplier
        ?: error("Creating ${N::class} from not YandexMapComposable is not supported")
    ComposeNode<N, MapApplier>(
        factory = {
            val node = factory(mapApplier)
            node.mapObject.isVisible = visible
            node.mapObject.zIndex = zIndex
            node.mapObject.userData = userData
            node
        },
        update = {
            update(state) { this.state = it }
            update(onTap) { this.tapListener = it }
            update(zIndex) { this.mapObject.zIndex = it }
            update(visible) { this.mapObject.isVisible = it }
            update(userData) { this.mapObject.userData = it }
            update()
        },
    )
}

internal abstract class MapObjectNode<T : MapObject, S : MapObjectState<T>>(
    val mapObject: T,
    internal var tapListener: ((point: Point) -> Boolean)?,
    state: S?,
) : MapNode {

    internal var state: S? = state.also { it?.mapObject = mapObject }
        set(value) {
            if (field === value) return
            field?.mapObject = null
            field = value
            value?.mapObject = mapObject
        }

    private val nativeTapListener =
        MapObjectTapListener { _, point -> tapListener?.invoke(point) ?: false }

    override fun onAttached() {
        state?.mapObject = mapObject
        mapObject.addTapListener(nativeTapListener.asWeakRef())
    }

    override fun onRemoved() {
        state?.mapObject = null
        if (!mapObject.isValid) return
        mapObject.removeTapListener(nativeTapListener.asWeakRef())
        mapObject.parent.remove(mapObject)
    }

    override fun onCleared() {
        state?.mapObject = null
        tapListener = null
    }
}

internal val LocalMapObjectCollection =
    compositionLocalOf<MapObjectCollection> { error("No MapObjectCollection provided") }
