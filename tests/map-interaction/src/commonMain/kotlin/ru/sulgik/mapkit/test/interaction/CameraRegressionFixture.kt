package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.CameraPositionState
import ru.sulgik.mapkit.compose.MapConfig
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.compose.toImageProvider
import ru.sulgik.mapkit.compose.user_location.UserLocationConfig
import ru.sulgik.mapkit.compose.user_location.rememberUserLocationState
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.location.DummyLocationQuality
import ru.sulgik.mapkit.location.Location
import ru.sulgik.mapkit.location.asLocationManager
import ru.sulgik.mapkit.map.CameraCallback
import ru.sulgik.mapkit.map.CameraListener
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.CameraUpdateReason
import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TimeMark
import kotlin.time.TimeSource

internal enum class CameraRegressionMode { Gestures, Animation, Location }

internal enum class CameraZoomDirection(val sign: Float, val event: String) {
    In(1f, "zoom moved in"),
    Out(-1f, "zoom moved out"),
}

internal class CameraRegressionProbe {

    val events = mutableStateListOf<String>()
    var mapLayout: LayoutCoordinates? = null
    var advance: (() -> Unit)? = null
}

@Composable
internal fun CameraRegressionFixture(
    mode: CameraRegressionMode,
    probe: CameraRegressionProbe = remember { CameraRegressionProbe() },
    zoomDirection: CameraZoomDirection = CameraZoomDirection.In,
) {
    val kit = rememberAndInitializeMapKit()
    kit.bindToLifecycleOwner()

    Column {
        when (mode) {
            CameraRegressionMode.Gestures -> GestureCamera(probe, zoomDirection)
            CameraRegressionMode.Animation -> AnimatedCamera(probe)
            CameraRegressionMode.Location -> SimulatedLocationCamera(probe, kit)
        }
        BasicText(probe.events.joinToString("\n"), modifier = Modifier.testTag("fixture-trace"))
    }
}

@Composable
private fun GestureCamera(probe: CameraRegressionProbe, zoomDirection: CameraZoomDirection) {
    val camera = remember { CameraPositionState(InitialCamera) }
    var nativeMap by remember { mutableStateOf<Map?>(null) }
    var phase by remember { mutableStateOf(GesturePhase.Enabled) }
    var baseline by remember { mutableStateOf<CameraPosition?>(null) }
    var checkBlocked by remember { mutableStateOf(false) }
    var blockedChecked by remember { mutableStateOf(false) }
    var movedWhileBlocked by remember { mutableStateOf(false) }
    var lastCameraReading by remember { mutableStateOf("") }

    val action = when (phase) {
        GesturePhase.Enabled -> "Disable scroll"
        GesturePhase.NoScroll -> if (blockedChecked) "Disable zoom" else "Check blocked pan"
        GesturePhase.NoZoom -> "Check blocked zoom"
    }
    CameraAction(probe, action) {
        when {
            phase == GesturePhase.Enabled -> phase = GesturePhase.NoScroll

            phase == GesturePhase.NoScroll && blockedChecked -> {
                baseline = null
                checkBlocked = false
                blockedChecked = false
                movedWhileBlocked = false
                phase = GesturePhase.NoZoom
            }

            else -> checkBlocked = true
        }
    }
    Box(Modifier.size(260.dp)) {
        YandexMap(
            cameraPositionState = camera,
            modifier = Modifier.matchParentSize()
                .onGloballyPositioned { probe.mapLayout = it }
                .semantics { contentDescription = "camera gesture map" },
            config = MapConfig(
                mapType = MapType.NONE,
                isScrollGesturesEnabled = phase.scroll,
                isZoomGesturesEnabled = phase.zoom,
                isRotateGesturesEnabled = false,
                isTiltGesturesEnabled = false,
            ),
        ) {
            MapEffect(phase) { map ->
                nativeMap = map
                val currentPhase = phase
                val configured = awaitCameraCondition {
                    map.isScrollGesturesEnabled == currentPhase.scroll &&
                        map.isZoomGesturesEnabled == currentPhase.zoom &&
                        probe.mapLayout?.isAttached == true
                }
                if (!configured) {
                    probe.events.add("failure: native gesture configuration was not applied")
                    return@MapEffect
                }

                if (currentPhase != GesturePhase.Enabled) {
                    camera.position = InitialCamera
                    val reset = awaitCameraCondition {
                        map.cameraPosition.near(InitialCamera) && camera.position.near(InitialCamera) && !camera.isMoving
                    }
                    if (!reset) {
                        probe.events.add("failure: could not reset the camera after disabling gestures")
                        return@MapEffect
                    }
                    baseline = map.cameraPosition
                }
                probe.events.add(currentPhase.readyEvent)
            }
        }
        if (zoomDirection == CameraZoomDirection.Out) {
            Box(
                Modifier.align(Alignment.Center)
                    .size(140.dp)
                    .semantics { contentDescription = "camera two-finger target" },
            )
        }
    }
    BasicText(lastCameraReading, modifier = Modifier.testTag("fixture-gesture-position"))

    LaunchedEffect(camera) {
        snapshotFlow {
            GestureReading(camera.position, camera.updateReason, camera.isMoving, phase, baseline, blockedChecked)
        }.collect { reading ->
            if (reading.phase != phase) return@collect
            val start = reading.baseline
            if (start != null && !reading.blockedChecked && !reading.position.near(start)) {
                movedWhileBlocked = true
            }
            if (reading.moving) return@collect
            lastCameraReading = "${reading.phase} ${reading.reason} ${reading.position}"
            if (reading.reason != CameraUpdateReason.GESTURES) return@collect
            val comparedTo = start ?: InitialCamera
            val pannedWest = reading.position.target.longitude.value < comparedTo.target.longitude.value - 0.0001 &&
                abs(reading.position.zoom - comparedTo.zoom) < 0.02f
            val zoomed = (reading.position.zoom - comparedTo.zoom) * zoomDirection.sign > 0.35f
            val event = when (phase) {
                GesturePhase.Enabled -> when {
                    "pan moved west" !in probe.events && pannedWest -> "pan moved west"
                    "pan moved west" in probe.events && zoomed -> zoomDirection.event
                    else -> null
                }

                GesturePhase.NoScroll -> {
                    if (reading.blockedChecked && zoomed) "${zoomDirection.event} with scroll disabled" else null
                }

                GesturePhase.NoZoom -> {
                    if (reading.blockedChecked && pannedWest) "pan moved west with zoom disabled" else null
                }
            }
            if (event != null && event !in probe.events) probe.events.add(event)
        }
    }
    LaunchedEffect(phase, baseline, checkBlocked) {
        val before = baseline ?: return@LaunchedEffect
        if (!checkBlocked || blockedChecked) return@LaunchedEffect
        delay(750)
        val actual = nativeMap?.cameraPosition
        if (!movedWhileBlocked && actual?.near(before) == true && camera.position.near(before) && !camera.isMoving) {
            blockedChecked = true
            val event = if (phase == GesturePhase.NoScroll) "blocked pan held camera" else "blocked zoom held camera"
            probe.events.add(event)
        } else {
            probe.events.add(
                "failure: disabled gestures changed camera from $before to $actual (state ${camera.position})",
            )
        }
    }
}

private enum class GesturePhase(val scroll: Boolean, val zoom: Boolean, val readyEvent: String) {
    Enabled(scroll = true, zoom = true, readyEvent = "gestures enabled"),
    NoScroll(scroll = false, zoom = true, readyEvent = "scroll disabled"),
    NoZoom(scroll = true, zoom = false, readyEvent = "zoom disabled"),
}

private data class GestureReading(
    val position: CameraPosition,
    val reason: CameraUpdateReason?,
    val moving: Boolean,
    val phase: GesturePhase,
    val baseline: CameraPosition?,
    val blockedChecked: Boolean,
)

@Composable
private fun AnimatedCamera(probe: CameraRegressionProbe) {
    val controller = rememberYandexMapController()
    var window by remember { mutableStateOf<MapWindow?>(null) }
    var mounted by remember { mutableStateOf(true) }
    var generation by remember { mutableStateOf(1) }
    var step by remember { mutableStateOf(AnimationStep.Supersede) }
    var requested by remember { mutableStateOf(false) }
    var retiredMap by remember { mutableStateOf<Map?>(null) }
    var retiredMoveDeadline by remember { mutableStateOf<TimeMark?>(null) }

    CameraAction(probe, step.label) {
        if (step == AnimationStep.Reopen) {
            generation++
            step = AnimationStep.MoveNewMap
            mounted = true
        } else {
            requested = true
        }
    }
    if (mounted) {
        YandexMap(controller, modifier = Modifier.size(260.dp))
        MapControllerEffect(
            controller = controller,
            dispose = {
                window = null
                probe.events.add("animation detached $generation")
            },
        ) {
            it.map.mapType = MapType.NONE
            it.map.move(InitialCamera)
            window = it
        }
    }

    LaunchedEffect(window, generation) {
        val current = window ?: return@LaunchedEffect
        val ready = awaitCameraCondition {
            current.width > 0 && current.height > 0 && current.map.cameraPosition.near(InitialCamera)
        }
        when {
            !ready -> probe.events.add("failure: animation map $generation not ready")

            generation == 2 -> {
                if (retiredMap == null || retiredMap == current.map) {
                    probe.events.add("failure: reopening did not create a distinct native map")
                } else {
                    probe.events.add("animation ready 2 on a new native map")
                }
            }

            else -> probe.events.add("animation ready 1")
        }
    }

    LaunchedEffect(window, step, requested) {
        val current = window ?: return@LaunchedEffect
        if (!requested) return@LaunchedEffect
        when (step) {
            AnimationStep.Supersede -> {
                val interrupted = CompletableDeferred<Boolean>()
                val first = CameraCallback { interrupted.complete(it) }
                if (!awaitNativeMoveStart(current.map, LongMove, first, probe)) return@LaunchedEffect
                probe.events.add("first animation moving 1")
                val settled = moveAndAwait(current.map, ReplacementCamera)
                val cancelled = withTimeoutOrNull(CameraWaitMillis) { interrupted.await() }
                if (cancelled == false) probe.events.add("first animation cancelled 1")
                if (settled && current.map.cameraPosition.near(ReplacementCamera)) {
                    probe.events.add("replacement finished 1")
                } else {
                    probe.events.add("failure: replacement move did not win")
                }
                requested = false
                step = AnimationStep.Leave
            }

            AnimationStep.Leave -> {
                val origin = generation
                val leaving = CameraCallback { completed ->
                    if (mounted && generation == origin && window == current) {
                        probe.events.add("failure: outgoing animation reported $completed before map $origin detached")
                    }
                }
                val deadline = TimeSource.Monotonic.markNow() + DepartingMove.duration
                if (!awaitNativeMoveStart(current.map, DepartingMove, leaving, probe)) return@LaunchedEffect
                retiredMap = current.map
                retiredMoveDeadline = deadline
                probe.events.add("leaving while moving $origin")
                requested = false
                mounted = false
                step = AnimationStep.Reopen
            }

            AnimationStep.MoveNewMap -> {
                val settled = moveAndAwait(current.map, RemountedCamera)
                if (!settled || !current.map.cameraPosition.near(RemountedCamera)) {
                    probe.events.add("failure: new map missed its camera destination")
                    return@LaunchedEffect
                }
                probe.events.add("new animation finished $generation")
                val deadline = checkNotNull(retiredMoveDeadline)
                val remaining = -deadline.elapsedNow()
                delay(remaining + 250.milliseconds)
                withFrameNanos { }
                if (deadline.hasPassedNow() && current.map.cameraPosition.near(RemountedCamera)) {
                    probe.events.add("retired move deadline passed 1")
                } else {
                    probe.events.add("failure: retired move changed the new native map")
                }
                requested = false
            }

            AnimationStep.Reopen -> Unit
        }
    }
}

private enum class AnimationStep(val label: String) {
    Supersede("Supersede animated move"),
    Leave("Leave during a move"),
    Reopen("Reopen animation map"),
    MoveNewMap("Move the new map"),
}

private suspend fun awaitNativeMoveStart(
    map: Map,
    animation: Animation,
    callback: CameraCallback,
    probe: CameraRegressionProbe,
): Boolean {
    val startedOnMountedMap = CompletableDeferred<Boolean>()
    val listener = CameraListener { reportedMap, _, reason, finished ->
        if (reason == CameraUpdateReason.APPLICATION && !finished) {
            startedOnMountedMap.complete(reportedMap == map)
        }
    }
    map.addCameraListener(listener.asWeakRef())
    try {
        map.move(InterruptedCamera, animation, callback)
        val started = withTimeoutOrNull(CameraWaitMillis) { startedOnMountedMap.await() } == true
        if (!started) probe.events.add("failure: native animation did not start on the mounted map")
        return started
    } finally {
        if (map.isValid) map.removeCameraListener(listener.asWeakRef())
    }
}

private suspend fun moveAndAwait(map: Map, position: CameraPosition): Boolean {
    val callbackFinished = CompletableDeferred<Boolean>()
    val nativeFinished = CompletableDeferred<Boolean>()
    val callback = CameraCallback { callbackFinished.complete(it) }
    val listener = CameraListener { reportedMap, camera, reason, finished ->
        if (reason == CameraUpdateReason.APPLICATION && finished && camera.near(position)) {
            nativeFinished.complete(reportedMap == map)
        }
    }
    map.addCameraListener(listener.asWeakRef())
    try {
        map.move(position, Animation(Animation.Type.LINEAR, 350.milliseconds), callback)
        return withTimeoutOrNull(CameraWaitMillis) { callbackFinished.await() && nativeFinished.await() } == true
    } finally {
        if (map.isValid) map.removeCameraListener(listener.asWeakRef())
    }
}

@Composable
private fun SimulatedLocationCamera(probe: CameraRegressionProbe, kit: MapKit) {
    val owner = remember { LocationTestOwner() }
    var generation by remember { mutableStateOf(1) }
    var visible by remember { mutableStateOf(true) }
    CameraAction(probe, if (visible) "Hide simulated location" else "Remount location map") {
        if (visible) {
            visible = false
        } else {
            generation++
            visible = true
        }
    }
    key(generation) {
        SimulatedLocationMap(probe, kit, owner, generation, visible)
    }
}

private class LocationTestOwner {
    val clockStart = TimeSource.Monotonic.markNow()
    var generation: Int? = null
}

@OptIn(kotlin.time.ExperimentalTime::class)
@Composable
private fun SimulatedLocationMap(
    probe: CameraRegressionProbe,
    kit: MapKit,
    owner: LocationTestOwner,
    generation: Int,
    visible: Boolean,
) {
    val locationState = rememberUserLocationState()
    val camera = remember { CameraPositionState(InitialCamera) }
    var dummyInstalled by remember { mutableStateOf(false) }
    val input = if (generation == 1) FirstLocation else SecondLocation
    val testIcon = remember {
        val image = ImageBitmap(32, 32)
        Canvas(image).drawCircle(Offset(16f, 16f), 13f, Paint().apply { color = Color(0xFFE516B7) })
        UserLocationConfig.LocationIcon(image.toImageProvider())
    }

    YandexMap(
        locationState = locationState,
        cameraPositionState = camera,
        locationConfig = UserLocationConfig(
            isVisible = dummyInstalled && visible,
            isHeadingEnabled = false,
            isAutoZoomEnabled = false,
            pin = testIcon,
            arrow = testIcon,
        ),
        config = MapConfig(mapType = MapType.NONE),
        modifier = Modifier.size(260.dp)
            .onGloballyPositioned { probe.mapLayout = it }
            .semantics { contentDescription = "camera location map" },
    ) {
        MapEffect(generation) { map ->
            val dummy = kit.createDummyLocationManager()
            val manager = dummy.asLocationManager()
            owner.generation = generation
            try {
                kit.setLocationManager(manager)
                manager.resume()
                dummyInstalled = true
                val destination = withTimeoutOrNull(CameraWaitMillis) {
                    var position: CameraPosition? = null
                    while (position == null) {
                        val now = Clock.System.now()
                        dummy.setLocation(
                            Location(
                                position = input,
                                accuracy = 5.0,
                                altitude = null,
                                altitudeAccuracy = null,
                                heading = 0.0,
                                speed = 0.0,
                                indoorLevelId = null,
                                absoluteTimestamp = now,
                                relativeTimestamp = owner.clockStart.elapsedNow(),
                            ),
                            DummyLocationQuality.HIGH,
                        )
                        delay(100)
                        position = locationState.cameraPosition?.takeIf { it.target.near(input) }
                    }
                    position
                }
                if (destination == null) {
                    probe.events.add("failure: UserLocationState on map $generation did not receive $input")
                    return@MapEffect
                }
                if (!moveAndAwait(map, destination) ||
                    !awaitCameraCondition { camera.position.target.near(input) && !camera.isMoving }
                ) {
                    probe.events.add("failure: map $generation did not finish at $input")
                    return@MapEffect
                }
                probe.events.add("location applied $generation")
                awaitCancellation()
            } finally {
                if (owner.generation == generation) {
                    owner.generation = null
                    kit.resetLocationManagerToDefault()
                }
            }
        }
        MapEffect(visible, dummyInstalled) { map ->
            if (dummyInstalled && !visible) {
                if (map.cameraPosition.target.near(input)) {
                    probe.events.add("location hide requested $generation")
                } else {
                    probe.events.add("failure: hiding the layer changed its requested camera target")
                }
            }
        }
    }
}

@Composable
private fun CameraAction(probe: CameraRegressionProbe, label: String, onClick: () -> Unit) {
    SideEffect { probe.advance = onClick }
    BasicText(label, modifier = Modifier.clickable(role = Role.Button, onClick = onClick))
}

private suspend fun awaitCameraCondition(matches: () -> Boolean): Boolean {
    return withTimeoutOrNull(CameraWaitMillis) {
        while (!matches()) {
            withFrameNanos { }
        }
        true
    } == true
}

private fun CameraPosition.near(other: CameraPosition): Boolean {
    return target.near(other.target) && abs(zoom - other.zoom) < 0.02f
}

private fun Point.near(other: Point): Boolean {
    return abs(latitude.value - other.latitude.value) < 0.0001 &&
        abs(longitude.value - other.longitude.value) < 0.0001
}

private const val CameraWaitMillis = 10_000L
private val InitialCamera = CameraPosition(Point(55.751225, 37.629540), 16f, 0f, 0f)
private val LongMove = Animation(Animation.Type.LINEAR, 8.seconds)
private val DepartingMove = Animation(Animation.Type.LINEAR, 3.seconds)
private val InterruptedCamera = InitialCamera.copy(target = Point(55.7600, 37.6110))
private val ReplacementCamera = InitialCamera.copy(target = Point(55.7550, 37.6350))
private val RemountedCamera = InitialCamera.copy(target = Point(55.7470, 37.6200))
private val FirstLocation = Point(55.7528, 37.6311)
private val SecondLocation = Point(55.7501, 37.6271)
