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
import ru.sulgik.mapkit.compose.utils.toComposeColor
import ru.sulgik.mapkit.compose.utils.toMapkitColor
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.map.Arrow
import ru.sulgik.mapkit.map.PolylineMapObject

/**
 * Uses [rememberSaveable] to retain [PolylineState.geometry] across configuration changes,
 * for simple use cases.
 *
 * Other use cases may be better served syncing [PolylineState.geometry] with a data model.
 */
@Composable
public fun rememberPolylineState(geometry: Polyline, key: String? = null): PolylineState {
    return rememberSaveable(key = key, saver = PolylineState.Saver) { PolylineState(geometry) }
}

@Immutable
public class PolylineState(geometry: Polyline) : MapObjectState<PolylineMapObject>() {

    public var geometry: Polyline by mutableStateOf(geometry)

    public fun select(color: Color, subpolyline: Subpolyline) {
        mapObject?.select(color.toMapkitColor(), subpolyline)
    }

    public fun hide(subpolyline: Subpolyline) {
        mapObject?.hide(subpolyline)
    }

    public fun hide(subpolylines: List<Subpolyline>) {
        mapObject?.hide(subpolylines)
    }

    /**
     * Sets indexes of colors in palette for line segments.
     *
     * A polyline is colored through a palette: [setPaletteColor] defines the color stored under an
     * index, and this method assigns one of those indexes to every segment. By default, all segments
     * use palette index 0.
     *
     * [weights] are used for generalization of colors.
     */
    public fun setStrokeColors(paletteIndices: List<Int>, weights: List<Double>) {
        mapObject?.setStrokeColors(paletteIndices, weights)
    }

    /**
     * Sets indexes of colors in palette for line segments.
     *
     * A polyline is colored through a palette: [setPaletteColor] defines the color stored under an
     * index, and this method assigns one of those indexes to every segment. By default, all segments
     * use palette index 0.
     *
     * All the weights are equal to 1.
     */
    public fun setStrokeColors(paletteIndices: List<Int>) {
        mapObject?.setStrokeColors(paletteIndices)
    }

    /**
     * Returns the palette index used by segment with the specified index.
     *
     * The returned value is an index into the palette, not a color; resolve it with
     * [getPaletteColor].
     */
    public fun getStrokeColor(segmentIndex: Int): Int {
        return requireMapObject().getStrokeColor(segmentIndex)
    }

    /**
     * Sets color in RGBA mode for [colorIndex].
     *
     * If the color is not provided for some index, the default value 0x0066FFFF is used.
     */
    public fun setPaletteColor(colorIndex: Int, color: Color) {
        mapObject?.setPaletteColor(colorIndex, color.toMapkitColor())
    }

    /**
     * Returns the palette color for the specified index.
     */
    public fun getPaletteColor(colorIndex: Int): Color {
        return requireMapObject().getPaletteColor(colorIndex).toComposeColor()
    }

    public fun addArrow(
        position: PolylinePosition,
        length: Float,
        fillColor: Color,
    ): Arrow {
        return requireMapObject().addArrow(position, length, fillColor.toMapkitColor())
    }

    public val arrows: List<Arrow>
        get() = requireMapObject().arrows

    public companion object {
        public val Saver: Saver<PolylineState, Any> = listSaver(
            save = {
                val points = mutableListOf<Double>()
                it.geometry.points.forEach { point ->
                    points.add(point.latitude.value)
                    points.add(point.longitude.value)
                }
                points
            },
            restore = {
                val points = mutableListOf<Point>()
                for (i in 0 until it.size / 2) {
                    points.add(Point(it[i * 2], it[i * 2 + 1]))
                }
                PolylineState(
                    geometry = Polyline(
                        points = points,
                    ),
                )
            },
        )
    }
}

@[YandexMapComposable Composable]
public fun Polyline(
    state: PolylineState,
    strokeColor: Color = DefaultStrokeColor,
    strokeWidth: Float = DefaultStrokeWidth,
    gradientLength: Float = DefaultGradientLength,
    outlineWidth: Float = DefaulOutlineWidth,
    outlineColor: Color = DefaultOutlineColor,
    innerOutlineEnabled: Boolean = false,
    turnRadius: Float = DefaultTurnRadius,
    dashLength: Float = DefaultDashLength,
    gapLength: Float = DefaultGapLength,
    dashOffset: Float = DefaultDashOffset,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    userData: Any? = null,
    onTap: ((Point) -> Boolean)? = null,
) {
    PolylineImpl(
        state = state,
        strokeColor = strokeColor,
        strokeWidth = strokeWidth,
        gradientLength = gradientLength,
        outlineWidth = outlineWidth,
        outlineColor = outlineColor,
        innerOutlineEnabled = innerOutlineEnabled,
        turnRadius = turnRadius,
        dashLength = dashLength,
        gapLength = gapLength,
        dashOffset = dashOffset,
        visible = visible,
        zIndex = zIndex,
        userData = userData,
        onTap = onTap,
    )
}

@[YandexMapComposable Composable]
internal fun PolylineImpl(
    state: PolylineState,
    strokeColor: Color = DefaultStrokeColor,
    strokeWidth: Float = DefaultStrokeWidth,
    gradientLength: Float = DefaultGradientLength,
    outlineWidth: Float = DefaulOutlineWidth,
    outlineColor: Color = DefaultOutlineColor,
    innerOutlineEnabled: Boolean = false,
    turnRadius: Float = DefaultTurnRadius,
    dashLength: Float = DefaultDashLength,
    gapLength: Float = DefaultGapLength,
    dashOffset: Float = DefaultDashOffset,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    userData: Any? = null,
    onTap: ((Point) -> Boolean)? = null,
) {
    val collection = LocalMapObjectCollection.current
    MapObjectNode(
        state = state,
        visible = visible,
        zIndex = zIndex,
        userData = userData,
        onTap = onTap,
        factory = {
            val mapObject = collection.addPolyline(state.geometry)
            mapObject.style.strokeWidth = strokeWidth
            mapObject.style.gradientLength = gradientLength
            mapObject.style.outlineWidth = outlineWidth
            mapObject.style.outlineColor = outlineColor.toMapkitColor()
            mapObject.style.innerOutlineEnabled = innerOutlineEnabled
            mapObject.style.turnRadius = turnRadius
            mapObject.style.dashLength = dashLength
            mapObject.style.gapLength = gapLength
            mapObject.style.dashOffset = dashOffset
            mapObject.setStrokeColor(strokeColor.toMapkitColor())
            PolylineNode(
                mapObject = mapObject,
                tapListener = onTap,
                state = state,
            )
        },
        update = {
            update(state.geometry) { this.mapObject.geometry = it }
            update(strokeWidth) { mapObject.style.strokeWidth = strokeWidth }
            update(gradientLength) { mapObject.style.gradientLength = gradientLength }
            update(outlineWidth) { mapObject.style.outlineWidth = outlineWidth }
            update(outlineColor) { mapObject.style.outlineColor = outlineColor.toMapkitColor() }
            update(innerOutlineEnabled) { mapObject.style.innerOutlineEnabled = innerOutlineEnabled }
            update(turnRadius) { mapObject.style.turnRadius = turnRadius }
            update(dashLength) { mapObject.style.dashLength = dashLength }
            update(gapLength) { mapObject.style.gapLength = gapLength }
            update(dashOffset) { mapObject.style.dashOffset = dashOffset }
            update(strokeColor) { mapObject.setStrokeColor(strokeColor.toMapkitColor()) }
        },
    )
}

internal class PolylineNode(
    mapObject: PolylineMapObject,
    tapListener: ((Point) -> Boolean)?,
    state: PolylineState?,
) : MapObjectNode<PolylineMapObject, PolylineState>(mapObject, tapListener, state)

private val DefaultStrokeColor = Color(0x0066FFFF)
private const val DefaultGradientLength = 0f
private const val DefaultStrokeWidth = 1f
private const val DefaulOutlineWidth = 0f
private const val DefaultTurnRadius = 10f
private val DefaultOutlineColor = Color(0x00000000)
private const val DefaultDashLength = 0f
private const val DefaultDashOffset = 0f
private const val DefaultGapLength = 0f
