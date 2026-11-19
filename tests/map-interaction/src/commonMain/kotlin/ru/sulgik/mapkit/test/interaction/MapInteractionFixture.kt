package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
import androidx.compose.ui.unit.dp
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
import kotlin.math.abs

internal const val FixtureMapTag = "fixture-map"
internal const val FixtureOpen = "Open map"
internal const val FixtureClose = "Close map"
internal const val FixtureKey = "00000000-0000-0000-0000-000000000000"

private val cameraTarget = Point(55.751225, 37.629540)
private val markerPosition = Point(55.752225, 37.630540)
private val initialCamera = CameraPosition(cameraTarget, zoom = 16f, azimuth = 0f, tilt = 0f)
private const val readinessTimeoutMillis = 5_000L
private const val coordinateTolerance = 0.0001

internal class MapInteractionTrace {

    val events = mutableStateListOf<String>()
    private var nextMapId = 0

    fun mounted(screen: Int): String {
        val identity = "screen=$screen map=${++nextMapId}"
        events.add("mount $identity")
        return identity
    }

    fun tapped(identity: String, point: Point) {
        val hit = abs(point.latitude.value - cameraTarget.latitude.value) < coordinateTolerance &&
            abs(point.longitude.value - cameraTarget.longitude.value) < coordinateTolerance
        events.add("${if (hit) "tap" else "unexpected tap"} $identity")
    }
}

@Composable
internal fun MapInteractionFixture(trace: MapInteractionTrace = remember { MapInteractionTrace() }) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    var screen by remember { mutableStateOf(1) }
    var isOpen by remember { mutableStateOf(true) }

    Column {
        BasicText(
            text = if (isOpen) FixtureClose else FixtureOpen,
            modifier = Modifier.clickable(role = Role.Button) {
                if (!isOpen) screen++
                isOpen = !isOpen
            },
        )
        if (isOpen) {
            FixtureMap(screen, trace)
        }
        BasicText(
            text = trace.events.joinToString("\n"),
            modifier = Modifier.testTag("fixture-trace"),
        )
    }
}

@Composable
private fun FixtureMap(screen: Int, trace: MapInteractionTrace) {
    val controller = rememberYandexMapController()
    var attachment by remember { mutableStateOf<Attachment?>(null) }
    var target by remember { mutableStateOf<HitTarget?>(null) }

    YandexMap(
        controller = controller,
        modifier = Modifier.size(260.dp)
            .testTag(FixtureMapTag)
            .semantics {
                contentDescription = target?.let { "fixture-target ${it.identity} ${it.x} ${it.y}" }
                    ?: "fixture-map-waiting"
            },
    )
    MapControllerEffect(controller, dispose = { attachment = null }) { window ->
        window.map.mapType = MapType.NONE
        window.map.isFastTapEnabled = true
        window.map.move(initialCamera)
        val marker = window.map.mapObjects.addPlacemark()
        marker.geometry = markerPosition
        val icon = ImageBitmap(24, 24)
        Canvas(icon).drawCircle(Offset(12f, 12f), 10f, Paint().apply { color = Color.Red })
        marker.setIcon(icon.toImageProvider())
        attachment = Attachment(window, trace.mounted(screen))
    }

    attachment?.let { current ->
        val listener = remember(current) {
            InputListener(
                onMapTap = { _, point -> trace.tapped(current.identity, point) },
                onMapLongTap = { _, _ -> trace.events.add("long tap ${current.identity}") },
            )
        }
        DisposableEffect(current, listener) {
            val map = current.window.map
            map.addInputListener(listener.asWeakRef())
            onDispose {
                if (map.isValid) map.removeInputListener(listener.asWeakRef())
                trace.events.add("unmount ${current.identity}")
            }
        }
        LaunchedEffect(current) {
            val projected = withTimeoutOrNull(readinessTimeoutMillis) {
                var result = targetAt(current)
                while (result == null) {
                    withFrameNanos { }
                    result = targetAt(current)
                }
                result
            }
            if (projected == null) {
                trace.events.add("readiness timeout ${current.identity}")
            } else {
                trace.events.add("ready ${current.identity}")
                target = projected
            }
        }
    }
}

private class Attachment(val window: MapWindow, val identity: String)

private class HitTarget(val identity: String, val x: Float, val y: Float)

private fun targetAt(attachment: Attachment): HitTarget? {
    val window = attachment.window
    if (!window.isValid || window.width == 0 || window.height == 0) return null
    if (abs(window.map.cameraPosition.zoom - initialCamera.zoom) > 0.01f) return null
    val projected = window.worldToScreen(cameraTarget) ?: return null
    val x = projected.x / window.width
    val y = projected.y / window.height
    return if (x in 0.05f..0.95f && y in 0.05f..0.95f) HitTarget(attachment.identity, x, y) else null
}
