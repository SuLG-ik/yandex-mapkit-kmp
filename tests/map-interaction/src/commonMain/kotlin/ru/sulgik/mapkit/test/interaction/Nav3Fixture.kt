package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigationevent.NavigationEventTransitionState
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberCameraPositionState
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraListener
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.CircleMapObject
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import kotlin.math.abs

@Serializable
private data class MapRoute(val name: String) : NavKey

@Serializable
private data class DetailsRoute(val map: String) : NavKey

private val mapA = MapRoute("A")
private val mapB = MapRoute("B")

private val nav3Configuration = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(MapRoute::class, MapRoute.serializer())
            subclass(DetailsRoute::class, DetailsRoute.serializer())
        }
    }
}

internal const val Nav3Main = "Nav main tab"
internal const val Nav3Other = "Nav other tab"
internal const val Nav3PushB = "Nav push B"
internal const val Nav3Move = "Nav move camera"
internal const val Nav3Select = "Nav select marker"

internal class Nav3Entry(val name: String, val host: Any) {
    var layout: LayoutCoordinates? = null
}

internal data class Nav3Target(
    val entry: Nav3Entry,
    val window: MapWindow,
    val point: Point,
    val viewport: String,
    val selected: Boolean,
    val x: Float,
    val y: Float,
)

internal class Nav3Probe {
    var screen by mutableStateOf<Nav3Entry?>(null)
    var target by mutableStateOf<Nav3Target?>(null)
    var gestureStarts by mutableStateOf(0)
    var gestureInProgress by mutableStateOf(false)
    var gestureProgressed by mutableStateOf(false)
    var tapMismatch: String? = null
    val taps = mutableStateListOf<String>()
    val layouts = mutableMapOf<String, LayoutCoordinates>()
}

@Composable
internal fun Nav3Fixture(probe: Nav3Probe, host: Any = remember { Any() }) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val mainStack = rememberNavBackStack(nav3Configuration, mapA)
    val otherStack = rememberNavBackStack(nav3Configuration, mapB)
    var activeTab by rememberSaveable { mutableStateOf("main") }
    val tab = activeTab
    val backStack = if (tab == "main") mainStack else otherStack
    val dispatcher = LocalNavigationEventDispatcherOwner.current?.navigationEventDispatcher
    val stateHolder = rememberSaveableStateHolder()

    LaunchedEffect(dispatcher) {
        dispatcher?.transitionState?.collect { transition ->
            if (transition is NavigationEventTransitionState.InProgress) {
                if (!probe.gestureInProgress) {
                    probe.gestureStarts++
                    probe.gestureProgressed = false
                }
                if (transition.latestEvent.progress > 0.05f) probe.gestureProgressed = true
                probe.gestureInProgress = true
            } else {
                probe.gestureInProgress = false
            }
        }
    }
    Column {
        Row(Modifier.width(navMapWidth)) {
            NavButton(Nav3Main, probe, Modifier.weight(1f)) { activeTab = "main" }
            NavButton(Nav3Other, probe, Modifier.weight(1f)) { activeTab = "other" }
        }
        BasicText("Nav visible ${probe.screen?.name ?: "transitioning"}")
        val ready = probe.target?.takeIf { it.entry === probe.screen }?.let {
            "${it.entry.name.removePrefix("Map ")} ${it.viewport} selected=${it.selected}"
        } ?: "pending"
        BasicText("Nav ready $ready", maxLines = 1)
        BasicText("Nav taps ${probe.taps.joinToString(" ")}")
        val gesture = if (probe.gestureInProgress) "dragging" else "idle"
        BasicText("Nav gesture ${probe.gestureStarts} $gesture progressed=${probe.gestureProgressed}", maxLines = 1)
        stateHolder.SaveableStateProvider(tab) {
            NavDisplay(
                backStack = backStack,
                onBack = { if (backStack.size > 1) backStack.removeAt(backStack.lastIndex) },
                entryDecorators = listOf(rememberSaveableStateHolderNavEntryDecorator()),
                entryProvider = entryProvider {
                    entry<MapRoute> { route ->
                        NavMapEntry(
                            route = route,
                            id = "$tab-${route.name}",
                            host = host,
                            top = activeTab == tab && route == backStack.lastOrNull(),
                            probe = probe,
                            pushB = if (route == mapA) {
                                { if (backStack.lastOrNull() == route) backStack.add(mapB) }
                            } else {
                                null
                            },
                            openDetails = {
                                if (activeTab == tab && backStack.lastOrNull() == route) {
                                    backStack.add(DetailsRoute(route.name))
                                }
                            },
                        )
                    }
                    entry<DetailsRoute> { route ->
                        val name = "Details $tab-${route.map}"
                        val entry = remember(name, host) { Nav3Entry(name, host) }
                        observeEntry(entry, activeTab == tab && route == backStack.lastOrNull(), probe)
                        BasicText(
                            text = entry.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { entry.layout = it }
                                .padding(12.dp),
                        )
                    }
                },
            )
        }
    }
}

@Composable
private fun NavMapEntry(
    route: MapRoute,
    id: String,
    host: Any,
    top: Boolean,
    probe: Nav3Probe,
    pushB: (() -> Unit)?,
    openDetails: () -> Unit,
) {
    var selected by rememberSaveable { mutableStateOf(false) }
    val camera = rememberCameraPositionState { position = initialViewport(route) }
    val entry = remember(id, host) { Nav3Entry("Map $id", host) }
    val active = observeEntry(entry, top, probe)
    val controller = rememberYandexMapController()
    var attachment by remember { mutableStateOf<NativeAttachment?>(null) }
    val currentOpenDetails by rememberUpdatedState(openDetails)
    val cameraListener = remember(camera) {
        CameraListener { _, position, _, finished ->
            if (finished) camera.position = position
        }
    }

    Column {
        if (pushB != null) NavButton(Nav3PushB, probe, onClick = pushB)
        Row(Modifier.width(navMapWidth)) {
            NavButton(Nav3Move, probe, Modifier.weight(1f)) {
                attachment?.window?.map?.move(movedViewport(route))
            }
            NavButton(Nav3Select, probe, Modifier.weight(1f)) {
                attachment?.marker?.let { marker ->
                    marker.isVisible = !marker.isVisible
                    selected = marker.isVisible
                }
            }
        }
        YandexMap(
            controller = controller,
            modifier = Modifier
                .size(width = navMapWidth, height = 160.dp)
                .onGloballyPositioned { entry.layout = it }
                .semantics {
                    contentDescription = probe.target?.takeIf { it.entry === entry }?.let {
                        "nav-target $id ${it.viewport} selected=${it.selected} ${it.x} ${it.y}"
                    } ?: "nav-target-waiting $id"
                },
        )
    }
    MapControllerEffect(
        controller,
        dispose = { window ->
            if (window.isValid) window.map.removeCameraListener(cameraListener.asWeakRef())
            attachment = null
        },
    ) { window ->
        val map = window.map
        map.mapType = MapType.NONE
        map.isFastTapEnabled = true
        val savedPosition = camera.position
        map.addCameraListener(cameraListener.asWeakRef())
        map.move(savedPosition)
        val marker = map.mapObjects.addCircle(selectionCircle(savedPosition.target))
        marker.fillColor = Color.fromArgb(0xffda4638.toInt())
        marker.isVisible = selected
        attachment = NativeAttachment(window, marker)
    }
    val currentAttachment = attachment ?: return
    val listener = remember(currentAttachment) {
        InputListener(
            onMapTap = { _, point ->
                val target = probe.target
                val activeWindow = target != null && probe.screen === entry && target.entry === entry &&
                    target.window == currentAttachment.window
                if (target != null && activeWindow && near(point, target.point, 0.00012)) {
                    probe.taps.add(id)
                    currentOpenDetails()
                } else {
                    probe.tapMismatch = "map=$id actual=$point projected=${target?.point} resumed=${probe.screen?.name} activeWindow=$activeWindow"
                    probe.taps.add("unexpected-$id")
                }
            },
            onMapLongTap = { _, _ -> probe.taps.add("long-$id") },
        )
    }
    DisposableEffect(currentAttachment, listener) {
        val map = currentAttachment.window.map
        map.addInputListener(listener.asWeakRef())
        onDispose { if (map.isValid) map.removeInputListener(listener.asWeakRef()) }
    }
    LaunchedEffect(currentAttachment, camera.position, selected, active) {
        if (probe.target?.entry === entry) probe.target = null
        if (!active) return@LaunchedEffect
        val window = currentAttachment.window
        val marker = currentAttachment.marker
        val target = withTimeoutOrNull(5_000L) {
            var hit = project(window, route, entry, marker)
            while (hit == null) {
                withFrameNanos { }
                hit = project(window, route, entry, marker)
            }
            hit
        }
        if (target != null && probe.screen === entry) {
            marker.geometry = selectionCircle(window.map.cameraPosition.target)
            probe.target = target
        }
    }
}

@Composable
private fun observeEntry(entry: Nav3Entry, top: Boolean, probe: Nav3Probe): Boolean {
    val lifecycleState by LocalLifecycleOwner.current.lifecycle.currentStateFlow.collectAsState()
    val resumed = top && lifecycleState == Lifecycle.State.RESUMED
    DisposableEffect(entry, resumed) {
        if (resumed) probe.screen = entry
        onDispose {
            if (probe.target?.entry === entry) probe.target = null
            if (probe.screen === entry) probe.screen = null
        }
    }
    return resumed
}

@Composable
private fun NavButton(label: String, probe: Nav3Probe, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .sizeIn(minWidth = 48.dp, minHeight = 48.dp)
            .onGloballyPositioned { probe.layouts[label] = it }
            .clickable(role = Role.Button, onClick = onClick)
            .padding(8.dp),
        contentAlignment = Alignment.Center,
    ) {
        BasicText(label)
    }
}

private val navMapWidth = 240.dp

private class NativeAttachment(val window: MapWindow, val marker: CircleMapObject)

private fun initialViewport(route: MapRoute): CameraPosition {
    val base = if (route == mapA) Point(55.751225, 37.629540) else Point(59.934280, 30.335099)
    return CameraPosition(base, zoom = 15f, azimuth = 0f, tilt = 0f)
}

private fun movedViewport(route: MapRoute): CameraPosition {
    val base = initialViewport(route).target
    val target = Point(base.latitude.value + 0.002, base.longitude.value + 0.001)
    return CameraPosition(target, zoom = 16f, azimuth = 0f, tilt = 0f)
}

private fun selectionCircle(point: Point): Circle {
    val center = Point(point.latitude.value + 0.0004, point.longitude.value)
    return Circle(center, 18f)
}

private fun near(actual: Point, expected: Point, tolerance: Double): Boolean {
    return abs(actual.latitude.value - expected.latitude.value) < tolerance &&
        abs(actual.longitude.value - expected.longitude.value) < tolerance
}

private fun project(window: MapWindow, route: MapRoute, entry: Nav3Entry, marker: CircleMapObject): Nav3Target? {
    if (!window.isValid || !marker.isValid || window.width == 0 || window.height == 0) return null
    val actual = window.map.cameraPosition
    val viewport = when {
        matches(actual, initialViewport(route)) -> "default"
        matches(actual, movedViewport(route)) -> "custom"
        else -> "unexpected"
    }
    val projected = window.worldToScreen(actual.target) ?: return null
    val x = projected.x / window.width
    val y = projected.y / window.height
    if (x !in 0.05f..0.95f || y !in 0.05f..0.95f) return null
    return Nav3Target(entry, window, actual.target, viewport, marker.isVisible, x, y)
}

private fun matches(actual: CameraPosition, expected: CameraPosition): Boolean {
    return near(actual.target, expected.target, 0.00001) && abs(actual.zoom - expected.zoom) < 0.01f &&
        abs(actual.azimuth - expected.azimuth) < 0.01f && abs(actual.tilt - expected.tilt) < 0.01f
}
