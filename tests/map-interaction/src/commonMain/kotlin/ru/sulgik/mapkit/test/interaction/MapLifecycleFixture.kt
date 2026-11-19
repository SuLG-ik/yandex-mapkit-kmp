package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.compose.toImageProvider
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraListener
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.PlacemarkMapObject
import kotlin.math.abs
import kotlin.time.Duration.Companion.seconds

internal const val LifecycleMapTag = "lifecycle-map"
internal const val LifecycleTraceTag = "lifecycle-trace"
internal const val CoverMap = "Cover map"
internal const val UncoverMap = "Uncover map"
internal const val OpenLifecycleMap = "Open lifecycle map"
internal const val SaveViewport = "Save viewport"
internal const val AnimateAndClose = "Animate and close"

private val defaultCamera = CameraPosition(Point(55.751225, 37.629540), 16f, 0f, 0f)
private val savedCamera = CameraPosition(Point(55.753225, 37.632540), 17f, 0f, 0f)
private val animationTarget = CameraPosition(Point(55.763225, 37.647540), 15f, 0f, 0f)
private val pinPosition = Point(55.754000, 37.633000)

public class MapLifecycleScenario {

    internal val events = mutableStateListOf<String>()
    internal var customCamera: Boolean by mutableStateOf(false)
    internal var selected: Boolean by mutableStateOf(false)
    private var nextAttachment = 0

    internal fun attach(): Int {
        val id = ++nextAttachment
        events.add("attach $id")
        return id
    }
}

@Composable
internal fun MapLifecycleFixture(
    scenario: MapLifecycleScenario,
    onWindowAttached: (Int, MapWindow) -> Unit = { _, _ -> },
) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val controller = rememberYandexMapController()
    var open by remember { mutableStateOf(true) }
    var covered by remember { mutableStateOf(false) }
    var attachment by remember { mutableStateOf<LifecycleAttachment?>(null) }

    Column {
        if (open) {
            Row {
                FixtureButton(if (covered) UncoverMap else CoverMap) { covered = !covered }
                FixtureButton(SaveViewport) {
                    scenario.customCamera = true
                    scenario.selected = true
                }
                FixtureButton(AnimateAndClose) {
                    attachment?.animate()
                    covered = false
                    open = false
                }
            }

            MapControllerEffect(
                controller = controller,
                dispose = {
                    attachment?.close()
                    attachment = null
                },
            ) { window ->
                val current = LifecycleAttachment(scenario, window)
                attachment = current
                onWindowAttached(current.id, window)
            }

            var target by remember { mutableStateOf<String?>(null) }
            Box(Modifier.size(260.dp)) {
                YandexMap(
                    controller = controller,
                    modifier = Modifier.matchParentSize()
                        .testTag(LifecycleMapTag)
                        .semantics { contentDescription = target ?: "lifecycle-map-waiting" },
                )
                if (covered) {
                    Box(
                        Modifier.matchParentSize()
                            .background(Color.LightGray)
                            .clickable(role = Role.Button) {
                                attachment?.let { scenario.events.add("overlay ${it.id}") }
                            }
                            .semantics { contentDescription = "Map overlay" },
                    )
                }
            }
            LaunchedEffect(attachment, scenario.customCamera, scenario.selected) {
                val current = attachment ?: return@LaunchedEffect
                target = null
                val customCamera = scenario.customCamera
                val selected = scenario.selected
                val camera = if (customCamera) savedCamera else defaultCamera
                current.show(camera, selected)
                val projected = withTimeoutOrNull(5_000L) {
                    var candidate = current.projectCenter(camera, selected)
                    while (candidate == null) {
                        withFrameNanos { }
                        candidate = current.projectCenter(camera, selected)
                    }
                    candidate
                }
                if (projected != null) {
                    target = projected
                    scenario.events.add("ready ${current.id} camera=$customCamera selected=$selected")
                } else {
                    scenario.events.add("readiness timeout ${current.id}")
                }
            }
        } else {
            FixtureButton(OpenLifecycleMap) { open = true }
        }
        BasicText(
            text = scenario.events.joinToString("\n"),
            style = TextStyle(fontSize = 9.sp),
            modifier = Modifier.testTag(LifecycleTraceTag),
        )
    }
}

@Composable
private fun FixtureButton(text: String, onClick: () -> Unit) {
    BasicText(text, Modifier.clickable(role = Role.Button, onClick = onClick).padding(6.dp))
}

private class LifecycleAttachment(
    private val scenario: MapLifecycleScenario,
    private val window: MapWindow,
) {
    val id: Int = scenario.attach()
    private val map = window.map
    private val marker: PlacemarkMapObject
    private var closed = false
    private val inputListener = InputListener(
        onMapTap = { _, point ->
            val tap = when {
                closed -> "stale tap"
                near(point, map.cameraPosition.target) -> "tap"
                else -> "unexpected tap"
            }
            scenario.events.add("$tap $id")
        },
        onMapLongTap = { _, _ -> scenario.events.add("unexpected long tap $id") },
    )
    private val cameraListener = CameraListener { _, _, _, _ ->
        if (closed) scenario.events.add("stale camera $id")
    }

    init {
        map.mapType = MapType.NONE
        map.isFastTapEnabled = true
        marker = map.mapObjects.addPlacemark()
        marker.geometry = pinPosition
        map.addInputListener(inputListener.asWeakRef())
        map.addCameraListener(cameraListener.asWeakRef())
    }

    fun show(camera: CameraPosition, selected: Boolean) {
        map.move(camera)
        marker.userData = if (selected) "selected" else "unselected"
        val icon = ImageBitmap(24, 24)
        val color = if (selected) Color.Blue else Color.Red
        Canvas(icon).drawCircle(Offset(12f, 12f), 10f, Paint().apply { this.color = color })
        marker.setIcon(icon.toImageProvider())
    }

    fun animate() {
        map.move(animationTarget, Animation(Animation.Type.SMOOTH, 10.seconds))
        scenario.events.add("animate $id")
    }

    fun close() {
        closed = true
        if (map.isValid) {
            map.removeInputListener(inputListener.asWeakRef())
            map.removeCameraListener(cameraListener.asWeakRef())
        }
        scenario.events.add("detach $id")
    }

    fun projectCenter(camera: CameraPosition, selected: Boolean): String? {
        if (!window.isValid || window.width == 0 || window.height == 0 || !marker.isValid) return null
        val actual = map.cameraPosition
        if (!near(actual.target, camera.target) || abs(actual.zoom - camera.zoom) > 0.01f) return null
        val markerSelection = if (selected) "selected" else "unselected"
        if (marker.userData != markerSelection) return null
        val point = window.worldToScreen(camera.target) ?: return null
        val x = point.x / window.width
        val y = point.y / window.height
        return if (x in 0.05f..0.95f && y in 0.05f..0.95f) "lifecycle-target $id $x $y" else null
    }
}

private fun near(first: Point, second: Point): Boolean {
    return abs(first.latitude.value - second.latitude.value) < 0.0001 &&
        abs(first.longitude.value - second.longitude.value) < 0.0001
}
