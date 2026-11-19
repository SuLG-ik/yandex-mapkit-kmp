package ru.sulgik.mapkit.test.interaction

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.stack.animation.isEnter
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.create
import com.arkivanov.essenty.lifecycle.destroy
import com.arkivanov.essenty.lifecycle.pause
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.start
import com.arkivanov.essenty.lifecycle.stop
import com.arkivanov.essenty.lifecycle.subscribe
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.compose.toImageProvider
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.PlacemarkMapObject
import kotlin.math.abs
import androidx.lifecycle.Lifecycle as HostLifecycle

internal const val DecomposeSaveCamera = "Save A viewport"
internal const val DecomposePushB = "Push B"
internal const val DecomposeFrontA = "Front A"
internal const val DecomposeFrontB = "Front B"
internal const val DecomposeReplace = "Replace with C"
internal const val DecomposeFinish = "Finish fade"
internal const val DecomposeBack = "Pop details"
internal const val DecomposeTraceTag = "decompose-trace"

private val MapViewportSize = 200.dp
private const val MaxMapFps = 30

internal class DecomposeTrace {
    val events = mutableStateListOf<String>()
    val layouts = mutableMapOf<String, LayoutCoordinates>()
    val targets = mutableMapOf<String, Offset>()
    private val displayed = mutableSetOf<String>()
    private val counts = mutableMapOf<StackRoute, Int>()
    private val stopped = mutableSetOf<String>()
    private val windows = mutableMapOf<String, NativeWindow>()

    var heldOutgoing by mutableStateOf<String?>(null)
        private set

    fun nextId(route: StackRoute): String {
        val count = (counts[route] ?: 0) + 1
        counts[route] = count
        return "${route.name}$count"
    }

    fun enter(id: String) {
        displayed += id
        events.add("show $id")
        if (displayed.size > 1) events.add("overlap ${displayed.sorted().joinToString(" ")}")
    }

    fun leave(id: String) {
        displayed -= id
        events.add("hide $id")
    }

    fun started(id: String) {
        stopped -= id
        events.add("start $id")
    }

    fun stopped(id: String) {
        stopped += id
        events.add("stop $id")
    }

    fun attached(id: String, child: String, window: MapWindow) {
        windows[id] = NativeWindow(child, window)
        events.add("attach $id")
    }

    fun listening(id: String, listening: Boolean) {
        windows.getValue(id).listening = listening
        events.add("${if (listening) "subscribe" else "unsubscribe"} $id")
    }

    fun released(id: String) {
        windows.remove(id)
        events.add("release $id")
    }

    fun mapWindow(id: String): MapWindow? {
        return windows[id]?.window
    }

    fun holdFade(outgoingId: String) {
        check(heldOutgoing == null)
        heldOutgoing = outgoingId
    }

    fun finishFade() {
        heldOutgoing = null
    }

    fun overlapWith(incomingId: String): String? {
        val outgoingId = heldOutgoing ?: return null
        if (outgoingId == incomingId) return null
        val outgoing = windows[outgoingId] ?: return null
        val incoming = windows[incomingId] ?: return null
        if (layouts[outgoing.child]?.isAttached != true || layouts[incoming.child]?.isAttached != true) return null
        if (!outgoing.window.isValid || !incoming.window.isValid || outgoing.window == incoming.window) return null
        if (outgoing.child !in stopped || outgoing.listening || !incoming.listening) return null
        return "$outgoingId $incomingId"
    }

    private class NativeWindow(val child: String, val window: MapWindow, var listening: Boolean = false)
}

internal enum class StackRoute {
    A,
    B,
    C,
    D,
}

private class TestStack(
    context: ComponentContext,
    private val trace: DecomposeTrace,
) : ComponentContext by context {
    val navigation = StackNavigation<StackRoute>()
    val stack: Value<ChildStack<StackRoute, TestChild>> = childStack(
        source = navigation,
        serializer = null,
        initialConfiguration = StackRoute.A,
        childFactory = ::createChild,
    )

    private fun createChild(route: StackRoute, context: ComponentContext): TestChild {
        val id = trace.nextId(route)
        if (route == StackRoute.D) return TestChild(context, trace, id)
        return MapChild(context, trace, id, route) { navigation.push(StackRoute.D) }
    }
}

private open class TestChild(
    context: ComponentContext,
    protected val trace: DecomposeTrace,
    val id: String,
) : ComponentContext by context {
    init {
        lifecycle.subscribe(
            onStart = { trace.started(id) },
            onStop = { trace.stopped(id) },
            onDestroy = { trace.events.add("destroy $id") },
        )
    }
}

private class MapChild(
    context: ComponentContext,
    trace: DecomposeTrace,
    id: String,
    route: StackRoute,
    private val showDetails: () -> Unit,
) : TestChild(context, trace, id) {
    private val center = when (route) {
        StackRoute.A -> Point(55.751225, 37.629540)
        StackRoute.B -> Point(59.939800, 30.314600)
        StackRoute.C -> Point(56.838900, 60.605700)
        StackRoute.D -> error("Details has no map")
    }
    private var nextAttachment = 0
    private var active = false
    private var selected = false

    var camera by mutableStateOf(CameraPosition(center, zoom = 16f, azimuth = 0f, tilt = 0f))
        private set

    var attachment by mutableStateOf<WindowLease?>(null)
        private set

    init {
        lifecycle.subscribe(
            onResume = {
                active = true
                attachment?.listen()
            },
            onPause = {
                active = false
                attachment?.unlisten()
            },
        )
    }

    fun saveCamera() {
        camera = CameraPosition(Point(55.751525, 37.629840), zoom = 17f, azimuth = 0f, tilt = 0f)
    }

    fun attach(window: MapWindow) {
        check(attachment == null)
        window.setMaxFps(MaxMapFps)
        val map = window.map
        map.mapType = MapType.NONE
        map.isFastTapEnabled = true
        val restoredMarker = if (selected) {
            map.mapObjects.addPlacemark().apply {
                geometry = Point(center.latitude.value + 0.0004, center.longitude.value)
                val bitmap = ImageBitmap(24, 24)
                Canvas(bitmap).drawCircle(Offset(12f, 12f), 9f, Paint().apply { color = Color.Red })
                setIcon(bitmap.toImageProvider())
            }
        } else {
            null
        }
        val lease = WindowLease(window, "$id.${++nextAttachment}", restoredMarker)
        attachment = lease
        trace.attached(lease.id, id, window)
        if (active) lease.listen()
    }

    fun release(window: MapWindow) {
        val lease = attachment ?: return
        check(lease.window === window)
        lease.unlisten()
        trace.targets.remove(lease.id)
        trace.layouts.remove(id)
        attachment = null
        trace.released(lease.id)
    }

    inner class WindowLease(val window: MapWindow, val id: String, val marker: PlacemarkMapObject?) {
        private var listening = false
        private val listener = InputListener(
            onMapTap = { map, point ->
                if (active && listening && attachment === this && point.isNear(camera.target)) {
                    if (trace.heldOutgoing == null) {
                        selected = true
                        camera = map.cameraPosition
                        trace.events.add("tap $id")
                        showDetails()
                    } else {
                        val overlap = trace.overlapWith(id)
                        trace.events.add(if (overlap == null) "unexpected overlap tap $id" else "overlap tap $overlap")
                    }
                } else {
                    trace.events.add("unexpected tap $id")
                }
            },
            onMapLongTap = { _, _ -> trace.events.add("unexpected long tap $id") },
        )

        fun listen() {
            if (!listening && window.isValid) {
                window.map.addInputListener(listener.asWeakRef())
                listening = true
                trace.listening(id, listening = true)
            }
        }

        fun unlisten() {
            if (!listening) return
            if (window.isValid) window.map.removeInputListener(listener.asWeakRef())
            listening = false
            trace.listening(id, listening = false)
        }
    }
}

@Composable
internal fun DecomposeStackFixture(trace: DecomposeTrace = remember { DecomposeTrace() }) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val parent = remember { LifecycleRegistry() }
    val stack = remember(parent, trace) {
        parent.subscribe(
            onStart = { trace.events.add("parent start") },
            onStop = { trace.events.add("parent stop") },
        )
        TestStack(DefaultComponentContext(lifecycle = parent), trace)
    }
    val host = LocalLifecycleOwner.current.lifecycle
    val animation = remember(trace) {
        stackAnimation<StackRoute, TestChild>(animator = HoldableFade(trace), disableInputDuringAnimation = false)
    }
    DisposableEffect(host, parent) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                HostLifecycle.Event.ON_CREATE -> parent.create()
                HostLifecycle.Event.ON_START -> parent.start()
                HostLifecycle.Event.ON_RESUME -> parent.resume()
                HostLifecycle.Event.ON_PAUSE -> parent.pause()
                HostLifecycle.Event.ON_STOP -> parent.stop()
                HostLifecycle.Event.ON_DESTROY -> parent.destroy()
                HostLifecycle.Event.ON_ANY -> Unit
            }
        }
        host.addObserver(observer)
        onDispose {
            host.removeObserver(observer)
            parent.destroy()
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(Modifier.fillMaxWidth()) {
            StackButton(trace, DecomposeSaveCamera, Modifier.weight(1f)) {
                (stack.stack.value.active.instance as? MapChild)?.saveCamera()
            }
            StackButton(trace, DecomposePushB, Modifier.weight(1f)) { stack.navigation.push(StackRoute.B) }
        }
        Row(Modifier.fillMaxWidth()) {
            StackButton(trace, DecomposeFrontA, Modifier.weight(1f)) { stack.navigation.pushToFront(StackRoute.A) }
            StackButton(trace, DecomposeFrontB, Modifier.weight(1f)) { stack.navigation.pushToFront(StackRoute.B) }
        }
        Row(Modifier.fillMaxWidth()) {
            StackButton(trace, DecomposeReplace, Modifier.weight(1f)) {
                val child = stack.stack.value.active.instance as MapChild
                trace.holdFade(checkNotNull(child.attachment).id)
                stack.navigation.replaceCurrent(StackRoute.C)
            }
            StackButton(trace, DecomposeFinish, Modifier.weight(1f), trace::finishFade)
        }
        Children(
            stack = stack.stack,
            modifier = Modifier.size(MapViewportSize),
            animation = animation,
        ) { created ->
            val child = created.instance
            DisposableEffect(child) {
                trace.enter(child.id)
                onDispose { trace.leave(child.id) }
            }
            when (child) {
                is MapChild -> StackMap(child, trace)

                else -> Box(Modifier.size(MapViewportSize), contentAlignment = Alignment.Center) {
                    StackButton(trace, DecomposeBack) { stack.navigation.pop() }
                }
            }
        }
        BasicText(text = trace.events.joinToString("\n"), modifier = Modifier.testTag(DecomposeTraceTag), maxLines = 1)
    }
}

private class HoldableFade(private val trace: DecomposeTrace) : StackAnimator {
    @Composable
    override fun invoke(
        direction: Direction,
        isInitial: Boolean,
        onFinished: () -> Unit,
        content: @Composable (Modifier) -> Unit,
    ) {
        val alpha = remember(direction) { Animatable(if (isInitial || !direction.isEnter) 1f else 0f) }
        val finish by rememberUpdatedState(onFinished)
        val holding = trace.heldOutgoing != null
        LaunchedEffect(alpha, isInitial, holding) {
            if (isInitial) {
                finish()
            } else if (holding) {
                alpha.animateTo(if (direction.isEnter) 1f else 0.5f)
                if (direction.isEnter) trace.events.add("fade held")
            } else {
                alpha.animateTo(if (direction.isEnter) 1f else 0f)
                finish()
            }
        }
        content(Modifier.alpha(alpha.value))
    }
}

@Composable
private fun StackButton(trace: DecomposeTrace, label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier.widthIn(min = 48.dp).height(48.dp)
            .onGloballyPositioned { trace.layouts[label] = it }
            .clickable(role = Role.Button, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        BasicText(label, maxLines = 1)
    }
}

@Composable
private fun StackMap(child: MapChild, trace: DecomposeTrace) {
    val controller = rememberYandexMapController()
    val lease = child.attachment
    val camera = child.camera
    var projected by remember(lease, camera) { mutableStateOf<Offset?>(null) }
    YandexMap(
        controller = controller,
        modifier = Modifier.size(MapViewportSize)
            .onGloballyPositioned { trace.layouts[child.id] = it }
            .semantics {
                contentDescription = projected?.let { "decompose-target ${lease?.id} ${it.x} ${it.y}" }
                    ?: "decompose-map-waiting"
            },
    )
    MapControllerEffect(controller, dispose = child::release) { window -> child.attach(window) }
    LaunchedEffect(lease, camera) {
        if (lease == null) return@LaunchedEffect
        lease.window.map.move(camera)
        val normalized = withTimeoutOrNull(5_000L) {
            var point = lease.project(camera)
            while (point == null || (trace.heldOutgoing != null && trace.overlapWith(lease.id) == null)) {
                withFrameNanos { }
                point = lease.project(camera)
            }
            point
        }
        if (normalized == null) {
            trace.events.add("readiness timeout ${lease.id}")
        } else {
            projected = normalized
            trace.targets[lease.id] = normalized
            val nativeCamera = lease.window.map.cameraPosition
            val marker = lease.marker?.takeIf { it.isValid }?.geometry
            val markerCoordinates = marker?.let { "${it.latitude.value} ${it.longitude.value}" } ?: "none"
            trace.events.add(
                "scene ${lease.id} ${nativeCamera.target.latitude.value} ${nativeCamera.target.longitude.value} " +
                    "${nativeCamera.zoom} $markerCoordinates",
            )
            trace.overlapWith(lease.id)?.let { trace.events.add("overlap windows $it") }
        }
    }
}

private fun MapChild.WindowLease.project(camera: CameraPosition): Offset? {
    if (!window.isValid || window.width == 0 || window.height == 0) return null
    val actual = window.map.cameraPosition
    if (!actual.target.isNear(camera.target) || abs(actual.zoom - camera.zoom) > 0.01f) return null
    val screen = window.worldToScreen(camera.target) ?: return null
    val x = screen.x / window.width
    val y = screen.y / window.height
    return if (x in 0.05f..0.95f && y in 0.05f..0.95f) Offset(x, y) else null
}

private fun Point.isNear(other: Point): Boolean {
    return abs(latitude.value - other.latitude.value) < 0.0001 &&
        abs(longitude.value - other.longitude.value) < 0.0001
}
