package ru.sulgik.mapkit.compose.composition

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.Stable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ru.sulgik.mapkit.compose.CameraPositionState
import ru.sulgik.mapkit.compose.MapConfig
import ru.sulgik.mapkit.compose.MapLogoConfig
import ru.sulgik.mapkit.map.CameraListener
import ru.sulgik.mapkit.map.MapWindow

@Stable
internal class MapUpdaterState(
    cameraPositionState: CameraPositionState,
    config: MapConfig,
) {
    var cameraPositionState by mutableStateOf(cameraPositionState)
    var config by mutableStateOf(config)
}

internal class MapPropertiesNode(
    private val mapWindow: MapWindow,
    cameraPositionState: CameraPositionState,
    mapConfig: MapConfig,
) : MapNode {

    init {
        cameraPositionState.mapWindowOwner.setMapWindow(mapWindow)
        updateMap(mapConfig)
    }

    var cameraPositionState = cameraPositionState
        set(value) {
            if (value == field) return
            field.mapWindowOwner.setMapWindow(null)
            field = value
            value.mapWindowOwner.setMapWindow(mapWindow)
        }

    private fun updateLogo(value: MapLogoConfig) {
        val logo = mapWindow.map.getLogo()
        if (value.alignment != null) {
            logo.setAlignment(value.alignment)
        }
        if (value.padding != null) {
            logo.setPadding(value.padding)
        }
    }

    fun updateMap(value: MapConfig) {
        val map = mapWindow.map
        if (value.isNightModeEnabled != null) {
            map.isNightModeEnabled = value.isNightModeEnabled
        }
        if (value.poiLimit != null) {
            map.poiLimit = value.poiLimit
        }
        if (value.isFastTapEnabled != null) {
            map.isFastTapEnabled = value.isFastTapEnabled
        }
        if (value.isRotateGesturesEnabled != null) {
            map.isRotateGesturesEnabled = value.isRotateGesturesEnabled
        }
        if (value.isTiltGesturesEnabled != null) {
            map.isTiltGesturesEnabled = value.isTiltGesturesEnabled
        }
        if (value.isScrollGesturesEnabled != null) {
            map.isScrollGesturesEnabled = value.isScrollGesturesEnabled
        }
        if (value.isZoomGesturesEnabled != null) {
            map.isZoomGesturesEnabled = value.isZoomGesturesEnabled
        }
        if (value.mapType != null) {
            map.mapType = value.mapType
        }
        if (value.use2dMode != null) {
            map.set2DMode(value.use2dMode)
        }
        updateLogo(value.logo)
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
    ComposeNode<MapPropertiesNode, MapApplier>(
        factory = {
            MapPropertiesNode(
                mapWindow = mapWindow,
                cameraPositionState = cameraPositionState,
                mapConfig = mapUpdaterState.config
            )
        }
    ) {
        update(cameraPositionState) { this.cameraPositionState = it }
        update(mapUpdaterState.config) { this.updateMap(it) }
    }
}