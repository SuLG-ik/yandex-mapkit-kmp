package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
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
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.location.DummyLocationQuality
import ru.sulgik.mapkit.location.Location
import ru.sulgik.mapkit.location.asLocationManager
import ru.sulgik.mapkit.location.toLocationViewSource
import ru.sulgik.mapkit.map.CameraCallback
import ru.sulgik.mapkit.map.CameraListener
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.CameraUpdateReason
import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.user_location.UserLocationLayer
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

internal enum class CameraRegressionMode { Gestures, Animation, Location }

internal class CameraRegressionProbe {

    val events = mutableStateListOf<String>()
    var mapLayout: LayoutCoordinates? = null
    var advance: (() -> Unit)? = null
}

@Composable
internal fun CameraRegressionFixture(
    mode: CameraRegressionMode,
    probe: CameraRegressionProbe = remember { CameraRegressionProbe() },
) {
    val kit = rememberAndInitializeMapKit()
    kit.bindToLifecycleOwner()

    Column {
        when (mode) {
            CameraRegressionMode.Gestures -> GestureCamera(probe)
            CameraRegressionMode.Animation -> AnimatedCamera(probe)
            CameraRegressionMode.Location -> SimulatedLocationCamera(probe, kit)
        }
        BasicText(probe.events.joinToString("\n"), modifier = Modifier.testTag("fixture-trace"))
    }
}

@Composable
private fun GestureCamera(probe: CameraRegressionProbe) {
    val camera = remember { CameraPositionState(InitialCamera) }
    var nativeMap by remember { mutableStateOf<Map?>(null) }
    var gesturesEnabled by remember { mutableStateOf(true) }
    var disabledPosition by remember { mutableStateOf<CameraPosition?>(null) }
    var checkDisabled by remember { mutableStateOf(false) }

    CameraAction(probe, if (gesturesEnabled) "Disable gestures" else "Check disabled gestures") {
        if (gesturesEnabled) {
            gesturesEnabled = false
        } else {
            checkDisabled = true
        }
    }
    YandexMap(
        cameraPositionState = camera,
        modifier = Modifier.size(260.dp)
            .onGloballyPositioned { probe.mapLayout = it }
            .semantics { contentDescription = "camera gesture map" },
        config = MapConfig(
            mapType = MapType.NONE,
            isScrollGesturesEnabled = gesturesEnabled,
            isZoomGesturesEnabled = gesturesEnabled,
            isRotateGesturesEnabled = false,
            isTiltGesturesEnabled = false,
        ),
    ) {
        MapEffect(gesturesEnabled) { map ->
            nativeMap = map
            val enabled = gesturesEnabled
            val configured = awaitCameraCondition {
                map.isScrollGesturesEnabled == enabled && map.isZoomGesturesEnabled == enabled &&
                    probe.mapLayout?.isAttached == true
            }
            if (!configured) {
                probe.events.add("failure: native gesture configuration was not applied")
                return@MapEffect
            }

            if (!enabled) {
                camera.position = InitialCamera
                if (!awaitCameraCondition { map.cameraPosition.near(InitialCamera) && !camera.isMoving }) {
                    probe.events.add("failure: could not reset the camera after disabling gestures")
                    return@MapEffect
                }
                disabledPosition = map.cameraPosition
            }
            probe.events.add(if (enabled) "gestures enabled" else "gestures disabled")
        }
    }

    LaunchedEffect(camera) {
        snapshotFlow { GestureReading(camera.position, camera.updateReason, camera.isMoving) }.collect { reading ->
            if (!gesturesEnabled || reading.moving || reading.reason != CameraUpdateReason.GESTURES) {
                return@collect
            }
            if ("pan finished" !in probe.events && !reading.position.target.near(InitialCamera.target) &&
                abs(reading.position.zoom - InitialCamera.zoom) < 0.02f
            ) {
                probe.events.add("pan finished")
            }
            if ("pan finished" in probe.events && "zoom finished" !in probe.events &&
                abs(reading.position.zoom - InitialCamera.zoom) > 0.35f
            ) {
                probe.events.add("zoom finished")
            }
        }
    }
    LaunchedEffect(disabledPosition, checkDisabled) {
        val before = disabledPosition ?: return@LaunchedEffect
        if (!checkDisabled) return@LaunchedEffect
        delay(750)
        val actual = nativeMap?.cameraPosition
        if (actual?.near(before) == true && camera.position.near(before) && !camera.isMoving) {
            probe.events.add("disabled gestures held camera")
        } else {
            probe.events.add(
                "failure: disabled gestures changed camera from $before to $actual (state ${camera.position})",
            )
        }
    }
}

private data class GestureReading(
    val position: CameraPosition,
    val reason: CameraUpdateReason?,
    val moving: Boolean,
)

@Composable
private fun AnimatedCamera(probe: CameraRegressionProbe) {
    val controller = rememberYandexMapController()
    var window by remember { mutableStateOf<MapWindow?>(null) }
    var mounted by remember { mutableStateOf(true) }
    var generation by remember { mutableStateOf(1) }
    var step by remember { mutableStateOf(AnimationStep.Supersede) }
    var requested by remember { mutableStateOf(false) }

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
        if (ready) {
            probe.events.add("animation ready $generation")
        } else {
            probe.events.add("failure: animation map $generation not ready")
        }
    }

    LaunchedEffect(window, step, requested) {
        val current = window ?: return@LaunchedEffect
        if (!requested) return@LaunchedEffect
        when (step) {
            AnimationStep.Supersede -> {
                val interrupted = CompletableDeferred<Boolean>()
                val first = CameraCallback { interrupted.complete(it) }
                if (!awaitNativeMoveStart(current, first, probe)) return@LaunchedEffect
                probe.events.add("first animation moving 1")
                val settled = moveAndAwait(current, ReplacementCamera)
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
                    if (completed) probe.events.add("failure: animation finished after leaving map $origin")
                }
                if (!awaitNativeMoveStart(current, leaving, probe)) return@LaunchedEffect
                probe.events.add("leaving while moving $origin")
                requested = false
                mounted = false
                step = AnimationStep.Reopen
            }
            AnimationStep.MoveNewMap -> {
                val settled = moveAndAwait(current, RemountedCamera)
                if (settled && current.map.cameraPosition.near(RemountedCamera)) {
                    probe.events.add("new animation finished $generation")
                } else {
                    probe.events.add("failure: new map missed its camera destination")
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
    window: MapWindow,
    callback: CameraCallback,
    probe: CameraRegressionProbe,
): Boolean {
    val map = window.map
    val startedOnMountedMap = CompletableDeferred<Boolean>()
    val listener = CameraListener { reportedMap, _, reason, finished ->
        if (reason == CameraUpdateReason.APPLICATION && !finished) {
            startedOnMountedMap.complete(reportedMap == map)
        }
    }
    map.addCameraListener(listener.asWeakRef())
    try {
        map.move(InterruptedCamera, Animation(Animation.Type.LINEAR, 8.seconds), callback)
        val started = withTimeoutOrNull(CameraWaitMillis) { startedOnMountedMap.await() } == true
        if (!started) probe.events.add("failure: native animation did not start on the mounted map")
        return started
    } finally {
        if (map.isValid) map.removeCameraListener(listener.asWeakRef())
    }
}

private suspend fun moveAndAwait(window: MapWindow, position: CameraPosition): Boolean {
    val finished = CompletableDeferred<Boolean>()
    val callback = CameraCallback { finished.complete(it) }
    window.map.move(position, Animation(Animation.Type.LINEAR, 350.milliseconds), callback)
    return withTimeoutOrNull(CameraWaitMillis) { finished.await() } == true
}

@Composable
private fun SimulatedLocationCamera(probe: CameraRegressionProbe, kit: MapKit) {
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
        SimulatedLocationMap(probe, kit, generation, visible)
    }
}

@OptIn(kotlin.time.ExperimentalTime::class)
@Composable
private fun SimulatedLocationMap(probe: CameraRegressionProbe, kit: MapKit, generation: Int, visible: Boolean) {
    val controller = rememberYandexMapController()
    var window by remember { mutableStateOf<MapWindow?>(null) }
    var layer by remember { mutableStateOf<UserLocationLayer?>(null) }
    val input = if (generation == 1) FirstLocation else SecondLocation

    YandexMap(controller, modifier = Modifier.size(260.dp))
    MapControllerEffect(controller, dispose = { window = null }) {
        it.map.mapType = MapType.NONE
        it.map.move(InitialCamera)
        window = it
    }

    LaunchedEffect(window) {
        val current = window ?: return@LaunchedEffect
        if (!awaitCameraCondition { current.width > 0 && current.height > 0 }) {
            probe.events.add("failure: location map $generation missing its window")
            return@LaunchedEffect
        }
        val dummy = kit.createDummyLocationManager()
        val locationManager = dummy.asLocationManager()
        val source = locationManager.toLocationViewSource()
        val activeLayer = kit.createUserLocationLayer(current)
        layer = activeLayer
        activeLayer.setSource(source)
        locationManager.resume()
        activeLayer.isVisible = true
        val startedAt = Clock.System.now()
        try {
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
                            relativeTimestamp = now - startedAt,
                        ),
                        DummyLocationQuality.HIGH,
                    )
                    delay(100)
                    position = activeLayer.cameraPosition?.takeIf { it.target.near(input) }
                }
                position
            }
            if (destination != null && activeLayer.isVisible) {
                current.map.move(destination)
                if (awaitCameraCondition { current.map.cameraPosition.target.near(input) }) {
                    probe.events.add("location applied $generation")
                } else {
                    probe.events.add("failure: map $generation did not move to $input")
                }
            } else {
                probe.events.add("failure: map $generation did not receive simulated location $input")
            }
            awaitCancellation()
        } finally {
            if (activeLayer.isValid) {
                activeLayer.isVisible = false
                activeLayer.setSource(null)
            }
        }
    }
    LaunchedEffect(visible, layer) {
        val currentLayer = layer ?: return@LaunchedEffect
        if (visible) return@LaunchedEffect
        currentLayer.isVisible = false
        if (!currentLayer.isVisible && window?.map?.cameraPosition?.target?.near(input) == true) {
            probe.events.add("location hidden $generation")
        } else {
            probe.events.add("failure: hiding the layer changed its requested camera target")
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
private val InterruptedCamera = InitialCamera.copy(target = Point(55.7600, 37.6110))
private val ReplacementCamera = InitialCamera.copy(target = Point(55.7550, 37.6350))
private val RemountedCamera = InitialCamera.copy(target = Point(55.7470, 37.6200))
private val FirstLocation = Point(55.7528, 37.6311)
private val SecondLocation = Point(55.7501, 37.6271)
