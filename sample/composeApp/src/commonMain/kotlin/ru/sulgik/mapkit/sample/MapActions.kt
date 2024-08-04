package ru.sulgik.mapkit.sample

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MapActionsState(
    isPlacemarksEnabled: Boolean = true,
    isPlacemarksClsuteringEnabled: Boolean = false,
    isCirclesEnabled: Boolean = true,
    isPolygonsEnabled: Boolean = true,
    isPolylinesEnabled: Boolean = true,
    isDragEnabled: Boolean = false,
) {
    var isPlacemarksEnabled by mutableStateOf(isPlacemarksEnabled)
    var isPlacemarksClsuteringEnabled by mutableStateOf(isPlacemarksClsuteringEnabled)
    var isCirclesEnabled by mutableStateOf(isCirclesEnabled)
    var isPolygonsEnabled by mutableStateOf(isPolygonsEnabled)
    var isPolylinesEnabled by mutableStateOf(isPolylinesEnabled)
    var isDragEnabled by mutableStateOf(isDragEnabled)

    companion object {
        val Saver: Saver<MapActionsState, Any> = listSaver(
            save = {
                listOf(
                    it.isPlacemarksEnabled,
                    it.isPlacemarksClsuteringEnabled,
                    it.isCirclesEnabled,
                    it.isPolygonsEnabled,
                    it.isPolylinesEnabled,
                    it.isDragEnabled,
                )
            },
            restore = {
                MapActionsState(
                    isPlacemarksEnabled = it[0],
                    isPlacemarksClsuteringEnabled = it[1],
                    isCirclesEnabled = it[2],
                    isPolygonsEnabled = it[3],
                    isPolylinesEnabled = it[3],
                    isDragEnabled = it[5]
                )
            }
        )
    }
}

@Composable
fun rememberMapActionsState(
    isPlacemarksEnabled: Boolean = true,
    isCirclesEnabled: Boolean = true,
    isPolygonsEnabled: Boolean = true,
    isPolylinesEnabled: Boolean = true,
    isDragEnabled: Boolean = false
): MapActionsState {
    return rememberSaveable(saver = MapActionsState.Saver) {
        MapActionsState(
            isPlacemarksEnabled = isPlacemarksEnabled,
            isCirclesEnabled = isCirclesEnabled,
            isPolygonsEnabled = isPolygonsEnabled,
            isPolylinesEnabled = isPolylinesEnabled,
            isDragEnabled = isDragEnabled,
        )
    }
}

@Composable
fun MapActions(
    onStartPosition: () -> Unit,
    modifier: Modifier = Modifier,
    state: MapActionsState = rememberMapActionsState(),
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState())
            .padding(horizontal = 10.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedButton(
            onClick = onStartPosition,
        ) {
            Text("To start position")
        }
        OutlinedButton(
            onClick = { state.isPlacemarksEnabled = !state.isPlacemarksEnabled },
        ) {
            Text("Placemarks: ${if (state.isPlacemarksEnabled) "on" else "off"}")
        }
        OutlinedButton(
            onClick = { state.isPlacemarksClsuteringEnabled = !state.isPlacemarksClsuteringEnabled },
        ) {
            Text("Placemarks clustering: ${if (state.isPlacemarksClsuteringEnabled) "on" else "off"}")
        }
        OutlinedButton(
            onClick = { state.isCirclesEnabled = !state.isCirclesEnabled },
        ) {
            Text("Circles: ${if (state.isCirclesEnabled) "on" else "off"}")
        }
        OutlinedButton(
            onClick = { state.isPolygonsEnabled = !state.isPolygonsEnabled },
        ) {
            Text("Polygons: ${if (state.isPolygonsEnabled) "on" else "off"}")
        }
        OutlinedButton(
            onClick = { state.isPolylinesEnabled = !state.isPolylinesEnabled },
        ) {
            Text("Polylines: ${if (state.isPolylinesEnabled) "on" else "off"}")
        }
        OutlinedButton(
            onClick = { state.isDragEnabled = !state.isDragEnabled }
        ) {
            Text("Drag: ${if (state.isDragEnabled) "on" else "off"}")
        }
    }
}