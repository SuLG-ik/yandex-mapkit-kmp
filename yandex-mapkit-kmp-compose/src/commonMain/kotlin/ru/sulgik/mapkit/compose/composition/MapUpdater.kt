package ru.sulgik.mapkit.compose.composition

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.Stable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import ru.sulgik.mapkit.compose.CameraPositionState
import ru.sulgik.mapkit.map.CameraListener
import ru.sulgik.mapkit.map.MapWindow

@Stable
internal class MapUpdaterState(
    cameraPositionState: CameraPositionState,
) {
    var cameraPositionState by mutableStateOf(cameraPositionState)
}

internal class MapPropertiesNode(
    private val mapWindow: MapWindow,
    cameraPositionState: CameraPositionState,
    var density: Density,
) : MapNode {

    init {
        cameraPositionState.mapWindowOwner.setMapWindow(mapWindow)
    }

    var cameraPositionState = cameraPositionState
        set(value) {
            if (value == field) return
            field.mapWindowOwner.setMapWindow(null)
            field = value
            value.mapWindowOwner.setMapWindow(mapWindow)
        }

    private val cameraListener = CameraListener { _, cameraPosition, cameraUpdateReason, finished ->
        cameraPositionState.rawPosition = cameraPosition
        cameraPositionState.isMoving = !finished
        cameraPositionState.updateReason = cameraUpdateReason
    }

    override fun onAttached() {
        mapWindow.map.addCameraListener(cameraListener)
    }

    override fun onCleared() {
        mapWindow.map.removeCameraListener(cameraListener)
        cameraPositionState.mapWindowOwner.setMapWindow(null)
    }

    override fun onRemoved() {
        mapWindow.map.removeCameraListener(cameraListener)
        cameraPositionState.mapWindowOwner.setMapWindow(null)
    }

}

@Composable
internal fun MapUpdater(mapUpdaterState: MapUpdaterState) = with(mapUpdaterState) {
    val mapWindow = (currentComposer.applier as MapApplier).mapWindow
    val density = LocalDensity.current
    ComposeNode<MapPropertiesNode, MapApplier>(
        factory = {
            MapPropertiesNode(
                mapWindow = mapWindow,
                cameraPositionState = cameraPositionState,
                density = density
            )
        }
    ) {
        update(density) { this.density = it }
        update(cameraPositionState) { this.cameraPositionState = it }
    }
}