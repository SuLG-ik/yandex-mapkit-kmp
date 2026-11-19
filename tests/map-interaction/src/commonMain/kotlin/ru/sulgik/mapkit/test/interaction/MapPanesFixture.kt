package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import kotlin.math.abs

internal const val PaneA = "A"
internal const val PaneB = "B"
internal const val PaneScenarioArgument = "--map-panes"
internal const val PaneTraceTag = "panes-trace"
internal const val PaneSheetTraceTag = "panes-sheet-trace"
internal const val PaneSheetSlider = "panes-sheet-slider"
internal const val PaneOpenSheet = "Open panel"
internal const val PaneSheetAction = "Panel action"
internal const val PaneDismissSheet = "Close panel"
internal const val PaneShowSecond = "Show B"
internal const val PaneMoveA = "Move A"
internal const val PaneMoveB = "Move B"
internal const val PaneResizeA = "Resize A"
internal const val PaneRemoveB = "Remove B"

private val initialA = Point(59.9400, 30.3100)
private val movedA = Point(59.9420, 30.3120)
private val initialB = Point(55.7510, 37.6200)
private val movedB = Point(55.7540, 37.6260)
private const val pointTolerance = 0.0001
private const val paneZoom = 15f
private const val exposedPaneY = 0.28f

internal class MapPanesTrace {
    val events = mutableStateListOf<String>()
    val layouts = mutableMapOf<String, LayoutCoordinates>()
    val windows = mutableMapOf<String, MapWindow>()
    val targets = mutableStateMapOf<String, PaneTarget>()
}

internal data class PaneTarget(
    val revision: Int,
    val worldPoint: Point,
    val x: Float,
    val y: Float,
    val width: Int,
    val height: Int,
)

@Composable
internal fun MapPanesFixture(trace: MapPanesTrace = remember { MapPanesTrace() }) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    var hasSheet by remember { mutableStateOf(false) }
    var hasSecond by remember { mutableStateOf(false) }
    var resized by remember { mutableStateOf(false) }
    var aRevision by remember { mutableStateOf(1) }
    var bRevision by remember { mutableStateOf(1) }
    var aTarget by remember { mutableStateOf(initialA) }
    var bTarget by remember { mutableStateOf(initialB) }

    Column(
        Modifier.fillMaxSize().padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PaneToolbarControl(PaneOpenSheet, trace) { hasSheet = true }
            PaneToolbarControl(PaneShowSecond, trace) {
                hasSecond = true
                aRevision++
            }
            PaneToolbarControl(PaneRemoveB, trace) {
                hasSecond = false
                aRevision++
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PaneToolbarControl(PaneMoveA, trace) {
                aTarget = movedA
                aRevision++
            }
            PaneToolbarControl(PaneMoveB, trace) {
                bTarget = movedB
                bRevision++
            }
            PaneToolbarControl(PaneResizeA, trace) {
                resized = true
                aRevision++
            }
        }
        PaneMap(
            id = PaneA,
            revision = aRevision,
            worldPoint = aTarget,
            resized = resized,
            trace = trace,
            modifier = Modifier.weight(if (resized && hasSecond) 0.67f else 1f)
                .fillMaxWidth()
                .then(if (resized) Modifier.padding(start = 36.dp, end = 12.dp, top = 12.dp) else Modifier),
        )
        if (hasSecond) {
            PaneMap(PaneB, bRevision, bTarget, false, trace, Modifier.weight(1f).fillMaxWidth())
        }
        PaneTrace(trace, PaneTraceTag)
    }
    if (hasSheet) {
        PaneSheet(trace) { hasSheet = false }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PaneSheet(trace: MapPanesTrace, onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var dragDistance by remember { mutableStateOf(0f) }
    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == SheetValue.Expanded) {
            trace.events.add("sheet-open")
        }
    }
    ModalBottomSheet(
        onDismissRequest = {
            trace.events.add("unexpected sheet dismissal")
            onDismiss()
        },
        sheetState = sheetState,
        dragHandle = null,
        properties = ModalBottomSheetProperties(
            shouldDismissOnBackPress = false,
            shouldDismissOnClickOutside = false,
        ),
    ) {
        Box(
            Modifier.fillMaxWidth().height(56.dp)
                .capturePosition(PaneSheetSlider, trace)
                .testTag(PaneSheetSlider)
                .semantics { contentDescription = PaneSheetSlider }
                .background(Color.LightGray)
                .draggable(
                    state = rememberDraggableState { dragDistance += it },
                    orientation = Orientation.Horizontal,
                    onDragStarted = { dragDistance = 0f },
                    onDragStopped = {
                        trace.events.add(if (dragDistance > 0f) "sheet-drag" else "unexpected sheet drag")
                    },
                ),
        )
        PaneControl(PaneSheetAction, trace) { trace.events.add("sheet-action") }
        PaneControl(PaneDismissSheet, trace) {
            scope.launch {
                sheetState.hide()
                trace.events.add("sheet-dismiss")
                onDismiss()
            }
        }
        PaneTrace(trace, PaneSheetTraceTag)
    }
}

@Composable
private fun PaneTrace(trace: MapPanesTrace, tag: String) {
    Box(Modifier.height(42.dp)) {
        BasicText(
            trace.events.joinToString("|"),
            modifier = Modifier.testTag(tag),
            maxLines = 4,
            style = TextStyle(fontSize = 9.sp),
        )
    }
}

@Composable
private fun RowScope.PaneToolbarControl(label: String, trace: MapPanesTrace, onClick: () -> Unit) {
    PaneControl(label, trace, Modifier.weight(1f), onClick)
}

@Composable
private fun PaneControl(
    label: String,
    trace: MapPanesTrace,
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: () -> Unit,
) {
    Box(
        modifier.height(48.dp)
            .capturePosition(label, trace)
            .clickable(role = Role.Button, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        BasicText(label)
    }
}

@Composable
private fun PaneMap(
    id: String,
    revision: Int,
    worldPoint: Point,
    resized: Boolean,
    trace: MapPanesTrace,
    modifier: Modifier,
) {
    val controller = rememberYandexMapController()
    var window by remember { mutableStateOf<MapWindow?>(null) }
    var size by remember { mutableStateOf(IntSize.Zero) }
    val listener = remember(trace, id) {
        InputListener(
            onMapTap = { map, point ->
                val target = trace.targets[id]
                val expectedMap = window?.takeIf { it.isValid }?.map
                val event = when {
                    expectedMap != map || !map.isValid -> "unexpected native map for $id"
                    target == null || !point.isNear(target.worldPoint) -> "unexpected tap $id $point"
                    !map.cameraPosition.isAt(target.worldPoint) -> "unexpected camera $id ${map.cameraPosition}"
                    else -> "tap $id ${target.revision}"
                }
                trace.events.add(event)
            },
            onMapLongTap = { _, _ -> trace.events.add("unexpected long tap $id") },
        )
    }
    val projection = trace.targets[id]
    YandexMap(
        controller,
        modifier = modifier
            .onSizeChanged { size = it }
            .capturePosition(id, trace)
            .testTag("pane-map-$id")
            .semantics {
                contentDescription = if (projection == null) {
                    "pane-waiting $id"
                } else {
                    "pane-target $id ${projection.revision} ${projection.x} ${projection.y} " +
                        "${projection.width} ${projection.height}"
                }
            },
    )
    MapControllerEffect(
        controller,
        dispose = { old ->
            if (old.isValid && old.map.isValid) {
                old.map.removeInputListener(listener.asWeakRef())
            }
            trace.targets.remove(id)
            window = null
            trace.events.add("detach $id")
        },
    ) { attached ->
        attached.map.mapType = MapType.NONE
        attached.map.isFastTapEnabled = true
        attached.map.addInputListener(listener.asWeakRef())
        if (trace.windows.any { (otherId, otherWindow) -> otherId != id && otherWindow == attached }) {
            trace.events.add("shared native window $id")
        }
        trace.windows[id] = attached
        window = attached
        trace.events.add("attach $id")
    }
    val attached = window
    LaunchedEffect(attached, revision, size) {
        if (attached != null && size.width > 0 && size.height > 0) {
            val target = withTimeoutOrNull(5_000L) {
                do {
                    withFrameNanos { }
                } while (!attached.hasSize(size))
                attached.focusPoint = if (id == PaneA && !resized) {
                    ScreenPoint(attached.width * 0.5f, attached.height * exposedPaneY)
                } else {
                    null
                }
                attached.focusRect = if (resized) {
                    ScreenRect(
                        ScreenPoint(attached.width * 0.12f, attached.height * 0.40f),
                        ScreenPoint(attached.width * 0.52f, attached.height * 0.88f),
                    )
                } else {
                    null
                }
                attached.map.move(CameraPosition(worldPoint, paneZoom, 0f, 0f))
                val expectedX = if (resized) 0.32f else 0.5f
                val expectedY = when {
                    resized -> 0.64f
                    id == PaneA -> exposedPaneY
                    else -> 0.5f
                }
                var projected: PaneTarget?
                do {
                    withFrameNanos { }
                    projected = attached.project(revision, worldPoint, expectedX, expectedY)
                } while (projected == null)
                projected
            }
            if (target != null) {
                trace.targets[id] = target
            } else {
                trace.events.add("projection timeout $id $revision for ${size.width}x${size.height}")
            }
        }
    }
}

private fun Modifier.capturePosition(label: String, trace: MapPanesTrace): Modifier {
    return onGloballyPositioned { trace.layouts[label] = it }
}

private fun MapWindow.hasSize(size: IntSize): Boolean {
    return isValid && width > 0 && height > 0 && abs(width - size.width) <= 2 && abs(height - size.height) <= 2
}

private fun MapWindow.project(revision: Int, worldPoint: Point, expectedX: Float, expectedY: Float): PaneTarget? {
    if (!isValid || width <= 0 || height <= 0) return null
    if (!map.cameraPosition.isAt(worldPoint)) return null
    val projected = worldToScreen(worldPoint) ?: return null
    val x = projected.x / width
    val y = projected.y / height
    if (abs(x - expectedX) > 0.04f || abs(y - expectedY) > 0.04f) return null
    return PaneTarget(revision, worldPoint, x, y, width, height)
}

private fun Point.isNear(other: Point): Boolean {
    return abs(latitude.value - other.latitude.value) < pointTolerance &&
        abs(longitude.value - other.longitude.value) < pointTolerance
}

private fun CameraPosition.isAt(point: Point): Boolean {
    return target.isNear(point) && abs(zoom - paneZoom) <= 0.01f &&
        abs(azimuth) <= 0.01f && abs(tilt) <= 0.01f
}
