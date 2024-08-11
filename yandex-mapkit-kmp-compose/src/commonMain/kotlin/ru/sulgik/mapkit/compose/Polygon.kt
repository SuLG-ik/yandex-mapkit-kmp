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
import ru.sulgik.mapkit.geometry.LinearRing
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.PolygonMapObject

@Composable
public fun rememberPolygonState(geometry: Polygon, key: String? = null): PolygonState {
    return rememberSaveable(key = key, saver = PolygonState.Saver) { PolygonState(geometry) }
}

@Immutable
public class PolygonState(geometry: Polygon) {

    public var geometry: Polygon by mutableStateOf(geometry)

    public companion object {
        public val Saver: Saver<PolygonState, Any> = listSaver(
            save = {
                mutableListOf<Any>().saveOuterRing(it.geometry.outerRing)
                    .saveInnerRing(it.geometry.innerRing)
            },
            restore = {
                val (outerRing, innerRingStart) = it.restoreLinearRing(0)
                PolygonState(
                    geometry = Polygon(
                        outerRing = outerRing,
                        innerRing = it.restoreInnerRing(innerRingStart),
                    )
                )
            }
        )

        private fun MutableList<Any>.saveInnerRing(rings: List<LinearRing>): MutableList<Any> {
            add(rings.size)
            rings.map {
                saveLinearRing(it)
            }
            return this
        }

        private fun MutableList<Any>.saveOuterRing(ring: LinearRing): MutableList<Any> {
            saveLinearRing(ring)
            return this
        }

        private fun MutableList<Any>.saveLinearRing(ring: LinearRing): MutableList<Any> {
            add(ring.points.size)
            ring.points.forEach {
                add(it.latitude.value)
                add(it.longitude.value)
            }
            return this
        }

        private fun List<Any>.restoreLinearRing(start: Int): Pair<LinearRing, Int> {
            val size = get(start) as Int
            val points = mutableListOf<Point>()
            for (i in 0 until size) {
                points.add(
                    Point(
                        latitude = get(start + 1 + i * 2) as Double,
                        longitude = get(start + 1 + i * 2 + 1) as Double
                    )
                )
            }
            return LinearRing(
                points = points
            ) to (start * 2 + size + 1)
        }

        private fun List<Any>.restoreInnerRing(start: Int): List<LinearRing> {
            val size = get(start) as Int
            var offset = start + 1
            var rings = mutableListOf<LinearRing>()
            for (i in 0 until size) {
                val (ring, nextStart) = restoreLinearRing(offset)
                offset = nextStart
                rings.add(ring)
            }
            return rings
        }
    }

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