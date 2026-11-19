package ru.sulgik.liteconsumer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.Map

private val start = Point(55.75, 37.62)
private val destination = Point(55.76, 37.63)
private val firstRoute = listOf(start, Point(55.753, 37.621), destination)
private val alternativeRoute = listOf(start, Point(55.756, 37.628), destination)

internal fun verifyRoutingOverlay(map: Map) {
    verifyDrivingWaypoints()
    verifyNoRouteReplies()
    val drawing = RoutingOverlay(map.mapObjects)
    try {
        val first = checkNotNull(drawing.show(Polyline(firstRoute)))
        check(first.isValid && first.geometry.points == firstRoute)
        val replacement = checkNotNull(drawing.show(Polyline(alternativeRoute)))
        check(!first.isValid && replacement.isValid && replacement.geometry.points == alternativeRoute)
        drawing.clear()
        check(!replacement.isValid)
    } finally {
        drawing.dispose()
    }
}

@Composable
internal fun RoutingPreview(map: Map, modifier: Modifier) {
    var drawing by remember(map) { mutableStateOf<RoutingOverlay?>(null) }
    DisposableEffect(map) {
        val overlay = RoutingOverlay(map.mapObjects)
        drawing = overlay
        onDispose {
            overlay.dispose()
        }
    }

    Row(modifier = modifier.background(Color.White)) {
        PreviewAction("Draw route") {
            map.move(CameraPosition(Point(55.755, 37.625), 12f, 0f, 0f))
            drawing?.show(Polyline(firstRoute))
        }
        PreviewAction("Replace route") {
            map.move(CameraPosition(Point(55.755, 37.625), 12f, 0f, 0f))
            drawing?.show(Polyline(alternativeRoute))
        }
        PreviewAction("Clear route") {
            drawing?.clear()
        }
    }
}

@Composable
private fun PreviewAction(label: String, action: () -> Unit) {
    BasicText(
        text = label,
        modifier = Modifier.clickable(role = Role.Button, onClick = action).padding(12.dp),
    )
}
