package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import ru.sulgik.mapkit.compose.utils.toMapkitColor
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.PolygonMapObject

@Composable
public fun rememberPolygonState(geometry: Polygon): PolygonState {
    return remember { PolygonState(geometry) }
}

@Immutable
public class PolygonState(geometry: Polygon) {

    public var geometry: Polygon by mutableStateOf(geometry)

}

@[YandexMapComposable Composable]
public fun Polygon(
    state: PolygonState,
    color: Color = DefaultFillColor,
    strokeColor: Color = DefaultStrokeColor,
    strokeWidth: Float = DefaultStrokeWidth,
    geodesic: Boolean = DefaultGeodesic,
    pattern: ImageProvider? = null,
    patternScale: Float = 1f,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    onTap: ((Point) -> Boolean)? = null,
) {
    PolygonImpl(
        state = state,
        color = color,
        strokeColor = strokeColor,
        strokeWidth = strokeWidth,
        geodesic = geodesic,
        pattern = pattern,
        patternScale = patternScale,
        visible = visible,
        zIndex = zIndex,
        onTap = onTap,
    )
}

@[YandexMapComposable Composable]
internal fun PolygonImpl(
    state: PolygonState,
    color: Color = DefaultFillColor,
    strokeColor: Color = DefaultStrokeColor,
    strokeWidth: Float = DefaultStrokeWidth,
    geodesic: Boolean = DefaultGeodesic,
    pattern: ImageProvider? = null,
    patternScale: Float = 1f,
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
            val mapObject = collection.addPolygon(state.geometry)
            mapObject.strokeColor = strokeColor.toMapkitColor()
            mapObject.strokeWidth = strokeWidth
            mapObject.fillColor = color.toMapkitColor()
            mapObject.isGeodesic = geodesic
            if (pattern != null) {
                mapObject.setPattern(pattern, patternScale)
            }
            PolygonNode(
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
            update(patternScale) {
                if (pattern != null) {
                    mapObject.setPattern(pattern, patternScale)
                }
            }
            update(pattern) {
                if (pattern != null) {
                    mapObject.setPattern(pattern, patternScale)
                } else {
                    mapObject.resetPattern()
                }
            }
        }
    )
}


internal class PolygonNode(
    mapObject: PolygonMapObject,
    tapListener: ((Point) -> Boolean)?
) : MapObjectNode<PolygonMapObject>(mapObject, tapListener)

private val DefaultStrokeColor = Color(0xFF66FF00)
private const val DefaultStrokeWidth = 5f
private val DefaultFillColor = Color(0x9966FF00)
private const val DefaultGeodesic = false