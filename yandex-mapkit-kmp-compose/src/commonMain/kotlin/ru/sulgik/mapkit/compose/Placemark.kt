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
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CompositeIcon
import ru.sulgik.mapkit.map.Icon
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.MapObjectDragListener
import ru.sulgik.mapkit.map.Model
import ru.sulgik.mapkit.map.PlacemarkAnimation
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.PlacemarkText
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
    key: String? = null,
): PlacemarkState {
    return rememberSaveable(
        key = key,
        saver = PlacemarkState.Saver,
    ) { PlacemarkState(geometry, direction) }
}

@Immutable
public class PlacemarkState(
    geometry: Point,
    direction: Float = 0.0f,
) : MapObjectState<PlacemarkMapObject>() {

    public var geometry: Point by mutableStateOf(geometry)

    public var direction: Float by mutableStateOf(direction)

    public var isDragging: Boolean by mutableStateOf(false)
        internal set

    /**
     * Sets piecewise linear scale of the placemark, depending on the zoom.
     */
    public fun setScaleFunction(points: List<PointF>) {
        mapObject?.setScaleFunction(points)
    }

    /**
     * Returns [Icon] object that can be used to set image and its style for the placemark.
     */
    public fun useIcon(): Icon {
        return requireMapObject().useIcon()
    }

    /**
     * Returns [CompositeIcon] object that can be used to set icons and their styles for the
     * placemark.
     */
    public fun useCompositeIcon(): CompositeIcon {
        return requireMapObject().useCompositeIcon()
    }

    /**
     * Returns [Model] object that can be used to set model and its style for the placemark.
     */
    public fun useModel(): Model {
        return requireMapObject().useModel()
    }

    /**
     * Returns [PlacemarkAnimation] object that can be used to control animation of the placemark.
     */
    public fun useAnimation(): PlacemarkAnimation {
        return requireMapObject().useAnimation()
    }

    /**
     * [PlacemarkText] that can be used to set text and its style for the placemark.
     */
    public val text: PlacemarkText
        get() = requireMapObject().text

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
            },
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
    userData: Any? = null,
) {
    PlacemarkImpl(
        state = state,
        icon = icon,
        iconStyle = iconStyle,
        visible = visible,
        draggable = draggable,
        zIndex = zIndex,
        opacity = opacity,
        userData = userData,
        onTap = onTap,
    )
}

/**
 * Placemark with icon rendered from composable [content].
 *
 * Placemark is not added to the map until [content] is rendered for the first time.
 *
 * @see imageProvider
 */
@YandexMapsComposeExperimentalApi
@[YandexMapComposable Composable]
public fun Placemark(
    state: PlacemarkState,
    iconStyle: IconStyle = IconStyle(),
    visible: Boolean = true,
    draggable: Boolean = false,
    zIndex: Float = 0.0f,
    opacity: Float = 1.0f,
    userData: Any? = null,
    onTap: ((Point) -> Boolean)? = null,
    content: @Composable () -> Unit,
) {
    val icon = imageProvider(content) ?: return
    Placemark(
        state = state,
        icon = icon,
        iconStyle = iconStyle,
        visible = visible,
        draggable = draggable,
        zIndex = zIndex,
        opacity = opacity,
        userData = userData,
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
    userData: Any? = null,
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
        userData = userData,
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
    userData: Any? = null,
    noinline onTap: ((Point) -> Boolean)? = null,
    crossinline init: PlacemarkNode.() -> Unit = {},
    update: @DisallowComposableCalls Updater<PlacemarkNode>.() -> Unit = {},
) {
    val collection = LocalMapObjectCollection.current
    MapObjectNode(
        state = state,
        visible = visible,
        zIndex = zIndex,
        userData = userData,
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
                tapListener = onTap,
            ).apply(init)
        },
        update = {
            update(state.geometry) { this.mapObject.geometry = it }
            update(state.direction) { this.mapObject.direction = it }
            update(opacity) { this.mapObject.opacity = it }
            update(draggable) { this.mapObject.isDraggable = it }
            update(icon) { this.mapObject.setIcon(icon, iconStyle) }
            update(iconStyle) { this.mapObject.setIcon(icon, iconStyle) }
            update()
        },
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
    userData: Any? = null,
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
        userData = userData,
        onTap = onTap,
        init = {
            mapObject.setText(title, titleStyle)
        },
        update = {
            update(title) { this.mapObject.setText(title, titleStyle) }
            update(titleStyle) { this.mapObject.setTextStyle(titleStyle) }
        },
    )
}

internal class PlacemarkNode(
    mapObject: PlacemarkMapObject,
    tapListener: ((Point) -> Boolean)?,
) : MapObjectNode<PlacemarkMapObject, PlacemarkState>(mapObject, tapListener) {

    private var nativeDragListener: MapObjectDragListener? = MapObjectDragListener(
        onMapObjectDrag = { _, point -> state?.geometry = point },
        onMapObjectDragStart = { _ -> state?.isDragging = true },
        onMapObjectDragEnd = { _ -> state?.isDragging = false },
    )

    override fun onAttached() {
        super.onAttached()
        mapObject.setDragListener(nativeDragListener?.asWeakRef())
    }

    override fun onRemoved() {
        if (mapObject.isValid) {
            mapObject.setDragListener(null)
        }
        super.onRemoved()
    }

    override fun onCleared() {
        super.onCleared()
        nativeDragListener = null
    }
}
