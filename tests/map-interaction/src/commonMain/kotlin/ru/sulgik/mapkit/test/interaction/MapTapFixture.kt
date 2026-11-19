package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.compose.MapConfig
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.MapListeners
import ru.sulgik.mapkit.compose.MapObjectCollection
import ru.sulgik.mapkit.compose.Placemark
import ru.sulgik.mapkit.compose.Polygon
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberCameraPositionState
import ru.sulgik.mapkit.compose.rememberPlacemarkState
import ru.sulgik.mapkit.compose.rememberPolygonState
import ru.sulgik.mapkit.geometry.LinearRing
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.MapType
import kotlin.math.abs
import ru.sulgik.mapkit.geometry.Polygon as PolygonGeometry

internal const val TapMapLabel = "fixture-tap-map"
internal const val TapNextCase = "Next tap case"

private const val tapTolerance = 0.0001
private const val tapZoom = 16f
private val emptyPoint = Point(55.751225, 37.629540)
private val objectPoint = Point(55.752225, 37.638540)
private val polygonGeometry = PolygonGeometry(
    outerRing = LinearRing(
        listOf(
            Point(55.751225, 37.637540),
            Point(55.753225, 37.637540),
            Point(55.753225, 37.639540),
            Point(55.751225, 37.639540),
            Point(55.751225, 37.637540),
        ),
    ),
    innerRings = emptyList(),
)

private enum class TapCase(
    val target: Point = objectPoint,
    val hasPlacemark: Boolean = true,
    val isPlacemarkVisible: Boolean = true,
    val placemarkConsumes: Boolean = true,
    val polygonConsumes: Boolean = false,
    val collectionConsumes: Boolean = false,
    val mapHandler: String? = "map",
    val longTapEnabled: Boolean = false,
) {
    Disabled(target = emptyPoint, hasPlacemark = false, mapHandler = null),
    Empty(target = emptyPoint, hasPlacemark = false, longTapEnabled = true),
    PolygonOnly(hasPlacemark = false),
    PlacemarkConsumes,
    PlacemarkPropagates(placemarkConsumes = false, collectionConsumes = true),
    PlacemarkHidden(isPlacemarkVisible = false, polygonConsumes = true),
    PlacemarkRestored,
    PlacemarkRemoved(hasPlacemark = false, mapHandler = "replacement"),
    HandlerRemoved(hasPlacemark = false, mapHandler = null),
    HandlerRestored(hasPlacemark = false, mapHandler = "restored"),
}

internal class MapTapTrace {
    val events = mutableStateListOf<String>()
    var nextCaseCenter: Offset? = null
    var target: Point? = null

    fun record(name: String, actual: Point, expected: Point) {
        val event = if (actual.isNear(expected)) name else "wrong $name coordinate: $actual, expected $expected"
        events.add(event)
    }
}

@Composable
internal fun MapTapFixture(trace: MapTapTrace = remember { MapTapTrace() }) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()

    var step by remember { mutableStateOf(TapCase.Disabled) }
    val activeCase = step
    val camera = rememberCameraPositionState { position = tapCamera(activeCase.target) }
    val marker = rememberPlacemarkState(objectPoint)
    val polygon = rememberPolygonState(polygonGeometry)
    val icon = remember { fixtureMarkerIcon() }

    Column {
        BasicText(
            text = TapNextCase,
            modifier = Modifier
                .onGloballyPositioned { trace.nextCaseCenter = it.boundsInWindow().center }
                .clickable(enabled = activeCase != TapCase.HandlerRestored, role = Role.Button) {
                    step = TapCase.entries[step.ordinal + 1]
                },
        )
        YandexMap(
            cameraPositionState = camera,
            modifier = Modifier.size(260.dp)
                .testTag(TapMapLabel)
                .semantics { contentDescription = TapMapLabel },
            config = MapConfig(
                mapType = MapType.NONE,
                isFastTapEnabled = true,
                isScrollGesturesEnabled = false,
                isZoomGesturesEnabled = false,
            ),
        ) {
            MapListeners(
                onMapTap = activeCase.mapHandler?.let { handler ->
                    { point -> trace.record(handler, point, activeCase.target) }
                },
                onMapLongTap = if (activeCase.longTapEnabled) {
                    { point -> trace.record("long", point, activeCase.target) }
                } else {
                    null
                },
            )
            MapObjectCollection(onTap = { point ->
                trace.record("collection", point, activeCase.target)
                activeCase.collectionConsumes
            }) {
                Polygon(
                    state = polygon,
                    onTap = { point ->
                        trace.record("polygon", point, activeCase.target)
                        activeCase.polygonConsumes
                    },
                )
                if (activeCase.hasPlacemark) {
                    Placemark(
                        state = marker,
                        icon = icon,
                        iconStyle = IconStyle(anchor = PointF(0.5f, 0.5f)),
                        visible = activeCase.isPlacemarkVisible,
                        zIndex = 1f,
                        onTap = { point ->
                            trace.record("placemark", point, activeCase.target)
                            activeCase.placemarkConsumes
                        },
                    )
                }
            }
            MapEffect(activeCase) { map ->
                map.move(tapCamera(activeCase.target))
                val ready = withTimeoutOrNull(5_000L) {
                    do {
                        withFrameNanos { }
                    } while (!map.cameraPosition.target.isNear(activeCase.target) ||
                        abs(map.cameraPosition.zoom - tapZoom) > 0.01f ||
                        !polygon.isValid ||
                        marker.isValid != activeCase.hasPlacemark
                    )
                    withFrameNanos { }
                    true
                }
                trace.target = activeCase.target.takeIf { ready == true }
                trace.events.add(if (ready == true) "ready ${activeCase.name}" else "timeout ${activeCase.name}")
            }
        }
        BasicText(
            text = trace.events.joinToString("\n"),
            modifier = Modifier.testTag("fixture-trace"),
        )
    }
}

private fun tapCamera(target: Point): CameraPosition {
    return CameraPosition(target, zoom = tapZoom, azimuth = 0f, tilt = 0f)
}

private fun Point.isNear(other: Point): Boolean {
    return abs(latitude.value - other.latitude.value) < tapTolerance &&
        abs(longitude.value - other.longitude.value) < tapTolerance
}
