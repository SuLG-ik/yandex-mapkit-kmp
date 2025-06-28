package ru.sulgik.mapkit.compose.user_location

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.Stable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.compose.YandexMapComposable
import ru.sulgik.mapkit.compose.YandexMapsComposeExperimentalApi
import ru.sulgik.mapkit.compose.composition.MapApplier
import ru.sulgik.mapkit.compose.composition.MapNode
import ru.sulgik.mapkit.compose.utils.toMapkitColor
import ru.sulgik.mapkit.location.LocationManager
import ru.sulgik.mapkit.map.CircleMapObject
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.user_location.UserLocationObjectListener

@Stable
@YandexMapsComposeExperimentalApi
internal class UserLocationUpdaterState(
    userLocation: UserLocationConfig,
) {
    var userLocation by mutableStateOf(userLocation)
}


@YandexMapsComposeExperimentalApi
internal class UserLocationNode(
    mapWindow: MapWindow,
    mapKit: MapKit,
    initialState: UserLocationState,
    userLocation: UserLocationConfig,
    source: LocationManager? = null,
) : MapNode {

    init {
        mapKit.resetLocationManagerToDefault()
    }

    internal var state: UserLocationState = initialState

    private val userLocationLayer = mapKit.createUserLocationLayer(mapWindow).apply {
        this.isHeadingModeActive = true
        if (source == null) {
            setDefaultSource()
        }
    }

    init {
        updateUserLocation(userLocation)
    }

    var userLocation = userLocation
        set(value) {
            updateUserLocation(value)
            field = value
        }
    private var pin: PlacemarkMapObject? = null
        set(value) {
            if (value != null) {
                applyIcon(value, userLocation.pin)
            }
            field = value
        }
    private var arrow: PlacemarkMapObject? = null
        set(value) {
            if (value != null) {
                applyIcon(value, userLocation.arrow)
            }
            field = value
        }

    private var accuracyCircle: CircleMapObject? = null
        set(value) {
            if (value != null) {
                applyCircle(value, userLocation.accuracy)
            }
        }

    private val userLocationObjectListener = UserLocationObjectListener(
        onObjectUpdated = { it, _ ->
            pin = it.pin
            arrow = it.arrow
            accuracyCircle = it.accuracyCircle
            updateUserLocationState()
        },
        onObjectRemoved = {
            pin = null
            arrow = null
            accuracyCircle = null
            updateUserLocationState()
        },
        onObjectAdded = {
            pin = it.pin
            arrow = it.arrow
            accuracyCircle = it.accuracyCircle
            updateUserLocationState()
        },
    )

    private fun updateUserLocationState() {
        state.cameraPosition = userLocationLayer.cameraPosition
    }

    private fun applyIcon(
        mapObject: PlacemarkMapObject,
        locationIcon: UserLocationConfig.LocationIcon?,
    ) {
        if (locationIcon == null) return
        mapObject.opacity = locationIcon.opacity
        if (locationIcon.direction != null) {
            mapObject.direction = locationIcon.direction
        }
        mapObject.setIcon(locationIcon.image, locationIcon.style)
    }

    private fun applyCircle(
        mapObject: CircleMapObject,
        locationAccuracy: UserLocationConfig.LocationAccuracy?,
    ) {
        if (locationAccuracy == null) return
        mapObject.fillColor = locationAccuracy.fillColor.toMapkitColor()
        mapObject.strokeColor = locationAccuracy.strokeColor.toMapkitColor()
        mapObject.strokeWidth = locationAccuracy.strokeWidth
        mapObject.isGeodesic = locationAccuracy.isGeodesic
    }

    private fun updateUserLocation(config: UserLocationConfig) {
        if (config.isVisible != null) {
            userLocationLayer.isVisible = config.isVisible
        }
        if (config.isHeadingEnabled != null) {
            userLocationLayer.isHeadingModeActive = config.isHeadingEnabled
        }
        if (config.isAutoZoomEnabled != null) {
            userLocationLayer.isAutoZoomEnabled = config.isAutoZoomEnabled
        }
        if (config.anchor != null) {
            userLocationLayer.setAnchor(config.anchor.normal, config.anchor.course)
        } else {
            userLocationLayer.resetAnchor()
        }
        arrow?.let { applyIcon(it, config.arrow) }
        pin?.let { applyIcon(it, config.pin) }
        accuracyCircle?.let { applyCircle(it, config.accuracy) }
    }

    override fun onAttached() {
        super.onAttached()
        userLocationLayer.setObjectListener(userLocationObjectListener)
    }

    override fun onCleared() {
        super.onCleared()
        pin = null
        arrow = null
        accuracyCircle = null
    }

    override fun onRemoved() {
        super.onRemoved()
        userLocationLayer.setObjectListener(null)
        pin = null
        arrow = null
        accuracyCircle = null
    }

}


@[YandexMapsComposeExperimentalApi YandexMapComposable]
@Composable
internal fun UserLocationUpdater(state: UserLocationState, updater: UserLocationUpdaterState) =
    with(updater) {
        val mapWindow = (currentComposer.applier as MapApplier).mapWindow
        ComposeNode<UserLocationNode, MapApplier>(
            factory = {
                UserLocationNode(
                    mapWindow = mapWindow,
                    mapKit = MapKit.getInstance(),
                    initialState = state,
                    userLocation = userLocation,
                )
            }
        ) {
            update(state) { this.state = state }
            update(userLocation) { this.userLocation = it }
        }
    }