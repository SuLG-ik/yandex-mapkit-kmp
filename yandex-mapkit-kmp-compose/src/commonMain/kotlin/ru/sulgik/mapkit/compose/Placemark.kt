package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Updater
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.MapObjectDragListener
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.TextStyle

/**
 * Uses [rememberSaveable] to retain [PlacemarkState.geometry] and [PlacemarkState.direction] across configuration changes,
 * for simple use cases.
 *
 * Other use cases may be better served syncing [PlacemarkState.geometry] and [PlacemarkState.direction] with a data model.
 */
@Composable
public fun rememberPlacemarkState(
    geometry: Point,
    direction: Float = 0.0f,
    key: String? = null
): PlacemarkState {
    return rememberSaveable(
        key = key,
        saver = PlacemarkState.Saver,
    ) { PlacemarkState(geometry, direction) }
}

@Immutable
public class PlacemarkState(geometry: Point, direction: Float = 0.0f) : MapObjectState() {

    public var geometry: Point by mutableStateOf(geometry)

    public var direction: Float by mutableStateOf(direction)

    public var isDragging: Boolean by mutableStateOf(false)
        internal set

    public companion object {
        public val Saver: Saver<PlacemarkState, Any> = listSaver(
            save = {
                listOf(
                    it.geometry.latitude.value,
                    it.geometry.longitude.value,
                    it.direction,
                )
            },
            restore = {
                PlacemarkState(
                    geometry = Point(it[0].toDouble(), it[1].toDouble()),
                    direction = it[2].toFloat(),
                )
            }
        )
    }

}

@[YandexMapComposable Composable]
public fun Placemark(
    state: PlacemarkState,
    icon: ImageProvider,
    iconStyle: IconStyle = IconStyle(),
    onTap: ((Point) -> Boolean)? = null,
    visible: Boolean = true,
    draggable: Boolean = false,
    zIndex: Float = 0.0f,
    opacity: Float = 1.0f,
) {
    PlacemarkImpl(
        state = state,
        icon = icon,
        iconStyle = iconStyle,
        visible = visible,
        draggable = draggable,
        zIndex = zIndex,
        opacity = opacity,
        onTap = onTap,
    )
}

@[YandexMapComposable Composable]
public fun TitledPlacemark(
    state: PlacemarkState,
    icon: ImageProvider,
    title: String,
    iconStyle: IconStyle = IconStyle(),
    titleStyle: TextStyle = TextStyle(),
    onTap: ((Point) -> Boolean)? = null,
    visible: Boolean = true,
    draggable: Boolean = false,
    zIndex: Float = 0.0f,
    opacity: Float = 1.0f,
) {
    TitledPlacemarkImpl(
        state = state,
        icon = icon,
        title = title,
        iconStyle = iconStyle,
        titleStyle = titleStyle,
        visible = visible,
        draggable = draggable,
        zIndex = zIndex,
        opacity = opacity,
        onTap = onTap,
    )
}

@[YandexMapComposable Composable]
internal inline fun PlacemarkImpl(
    state: PlacemarkState,
    icon: ImageProvider,
    iconStyle: IconStyle = IconStyle(),
    visible: Boolean = true,
    draggable: Boolean = false,
    zIndex: Float = 0.0f,
    opacity: Float = 1.0f,
    noinline onTap: ((Point) -> Boolean)? = null,
    crossinline init: PlacemarkNode.() -> Unit = {},
    update: @DisallowComposableCalls Updater<PlacemarkNode>.() -> Unit = {},
) {
    val collection = LocalMapObjectCollection.current
    MapObjectNode(
        state = state,
        visible = visible,
        zIndex = zIndex,
        onTap = onTap,
        factory = {
            val mapObject = collection.addPlacemark()
            mapObject.geometry = state.geometry
            mapObject.direction = state.direction
            mapObject.opacity = opacity
            mapObject.setIcon(icon, iconStyle)
            mapObject.isDraggable = draggable
            PlacemarkNode(
                mapObject = mapObject,
                state = state,
                tapListener = onTap,
            ).apply(init)
        },
        update = {
            update(state.geometry) { this.mapObject.geometry = it }
            update(state.direction) { this.mapObject.direction = it }
            update(opacity) { this.mapObject.opacity = it }
            update(draggable) { this.mapObject.isDraggable = it }
            update()
        }
    )
}


@[YandexMapComposable Composable]
internal fun TitledPlacemarkImpl(
    state: PlacemarkState,
    icon: ImageProvider,
    title: String,
    iconStyle: IconStyle = IconStyle(),
    titleStyle: TextStyle = TextStyle(),
    visible: Boolean = true,
    draggable: Boolean = false,
    zIndex: Float = 0.0f,
    opacity: Float = 1.0f,
    onTap: ((Point) -> Boolean)? = null,
) {
    PlacemarkImpl(
        state = state,
        icon = icon,
        iconStyle = iconStyle,
        visible = visible,
        draggable = draggable,
        zIndex = zIndex,
        opacity = opacity,
        onTap = onTap,
        init = {
            mapObject.setText(title, titleStyle)
        },
        update = {
            update(title) { this.mapObject.setText(title, titleStyle) }
            update(titleStyle) { this.mapObject.setTextStyle(titleStyle) }
        }
    )
}

internal class PlacemarkNode(
    mapObject: PlacemarkMapObject,
    state: PlacemarkState,
    tapListener: ((Point) -> Boolean)?
) : MapObjectNode<PlacemarkMapObject>(mapObject, state, tapListener) {


    private var nativeDragListener: MapObjectDragListener? = MapObjectDragListener(
        onMapObjectDrag = { _, point -> state.geometry = point },
        onMapObjectDragStart = { _ -> state.isDragging = true },
        onMapObjectDragEnd = { _ -> state.isDragging = false }
    )

    override fun onAttached() {
        super.onAttached()
        mapObject.setDragListener(nativeDragListener)
    }

    override fun onRemoved() {
        mapObject.setDragListener(null)
        super.onRemoved()
    }

    override fun onCleared() {
        super.onCleared()
        nativeDragListener = null
    }
}