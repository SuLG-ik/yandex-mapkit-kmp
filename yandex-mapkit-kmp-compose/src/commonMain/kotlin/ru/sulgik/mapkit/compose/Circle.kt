package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import ru.sulgik.mapkit.compose.utils.toMapkitColor
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CircleMapObject

/**
 * Uses [rememberSaveable] to retain [CircleState.geometry] across configuration changes,
 * for simple use cases.
 *
 * Other use cases may be better served syncing [CircleState.geometry] with a data model.
 */
@Composable
public fun rememberCircleState(geometry: Circle, key: String? = null): CircleState {
    return rememberSaveable(
        key = key,
        saver = CircleState.Saver,
    ) { CircleState(geometry) }
}

@Immutable
public class CircleState(geometry: Circle) {

    public var geometry: Circle by mutableStateOf(geometry)

    public companion object {
        public val Saver: Saver<CircleState, Any> = listSaver(
            save = {
                listOf(
                    it.geometry.center.latitude.value,
                    it.geometry.center.longitude.value,
                    it.geometry.radius,
                )
            },
            restore = {
                CircleState(
                    geometry = Circle(
                        center = Point(it[0].toDouble(), it[1].toDouble()),
                        radius = it[2].toFloat(),
                    )
                )
            }
        )
    }

}

@[YandexMapComposable Composable]
public fun Circle(
    state: CircleState,
    color: Color = DefaultFillColor,
    strokeColor: Color = DefaultStrokeColor,
    strokeWidth: Float = DefaultStrokeWidth,
    geodesic: Boolean = DefaultGeodesic,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    onTap: ((Point) -> Boolean)? = null,
) {
    CircleImpl(
        state = state,
        color = color,
        strokeColor = strokeColor,
        strokeWidth = strokeWidth,
        geodesic = geodesic,
        visible = visible,
        zIndex = zIndex,
        onTap = onTap,
    )
}

@[YandexMapComposable Composable]
internal fun CircleImpl(
    state: CircleState,
    color: Color = DefaultFillColor,
    strokeColor: Color = DefaultStrokeColor,
    strokeWidth: Float = DefaultStrokeWidth,
    geodesic: Boolean = DefaultGeodesic,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    onTap: ((Point) -> Boolean)? = null,
) {
    val collection = LocalMapObjectCollection.current
    MapObjectNode(
        visible = visible,
        zIndex = zIndex,
        onTap = onTap,
        factory = {
            val mapObject = collection.addCircle(state.geometry)
            mapObject.strokeColor = strokeColor.toMapkitColor()
            mapObject.strokeWidth = strokeWidth
            mapObject.fillColor = color.toMapkitColor()
            mapObject.isGeodesic = geodesic
            CircleNode(
                mapObject = mapObject,
                tapListener = onTap,
            )
        },
        update = {
            update(state.geometry) { this.mapObject.geometry = it }
            update(strokeColor) { mapObject.strokeColor = strokeColor.toMapkitColor() }
            update(strokeWidth) { mapObject.strokeWidth = strokeWidth }
            update(color) { mapObject.fillColor = color.toMapkitColor() }
            update(geodesic) { mapObject.isGeodesic = geodesic }
        }
    )
}


internal class CircleNode(
    mapObject: CircleMapObject,
    tapListener: ((Point) -> Boolean)?
) : MapObjectNode<CircleMapObject>(mapObject, tapListener)

private val DefaultStrokeColor = Color(0xFF66FF00)
private const val DefaultStrokeWidth = 5f
private val DefaultFillColor = Color(0x9966FF00)
private const val DefaultGeodesic = false