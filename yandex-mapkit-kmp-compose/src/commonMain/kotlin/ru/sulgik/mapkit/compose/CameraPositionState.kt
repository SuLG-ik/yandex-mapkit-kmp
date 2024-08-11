package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.StateFactoryMarker
import androidx.compose.runtime.staticCompositionLocalOf
import ru.sulgik.mapkit.geometry.Latitude
import ru.sulgik.mapkit.geometry.Longitude
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.CameraUpdateReason


@Composable
public inline fun rememberCameraPositionState(
    key: String? = null,
    crossinline init: CameraPositionState.() -> Unit = {},
): CameraPositionState = rememberSaveable(key = key, saver = CameraPositionState.Saver) {
    CameraPositionState().apply(init)
}


@Stable
public class CameraPositionState private constructor(
    position: CameraPosition = DefaultCameraPosition,
) {
    internal val mapWindowOwner = MapWindowOwner {
        if (it == null) {
            isMoving = false
        } else {
            it.map.move(this.position)
        }
    }
    internal var rawPosition by mutableStateOf(position)

    public var position: CameraPosition
        get() = rawPosition
        set(value) {
            mapWindowOwner.withLock {
                if (it == null) {
                    rawPosition = value
                } else {
                    it.map.move(value)
                }
            }
        }

    public var isMoving: Boolean by mutableStateOf(false)
        internal set


    public var updateReason: CameraUpdateReason? by mutableStateOf(null)
        internal set

    private fun cameraPositionListener() {
    }

    public companion object {
        private val DefaultCameraPosition = CameraPosition(
            target = Point(Latitude(0.0), Longitude(0.0)),
            zoom = 0.0f,
            azimuth = 0.0f,
            tilt = 0.0f,
        )

        /**
         * Creates a new [CameraPositionState] object
         *
         * @param position the initial camera position
         */
        @StateFactoryMarker
        public operator fun invoke(
            position: CameraPosition = DefaultCameraPosition,
        ): CameraPositionState = CameraPositionState(position)

        /**
         * The default saver implementation for [CameraPositionState]
         */
        public val Saver: Saver<CameraPositionState, Any> = listSaver(
            save = { it.saveToList() },
            restore = { restoreFromList(it) }
        )

        private fun CameraPositionState.saveToList(): List<Double> {
            val position = position
            return listOf(
                position.target.latitude.value,
                position.target.longitude.value,
                position.tilt.toDouble(),
                position.zoom.toDouble(),
                position.azimuth.toDouble(),
            )
        }

        private fun restoreFromList(list: List<Double>): CameraPositionState {
            return CameraPositionState(
                CameraPosition(
                    target = Point(list[0], list[1]),
                    tilt = list[2].toFloat(),
                    zoom = list[3].toFloat(),
                    azimuth = list[4].toFloat()
                )
            )
        }
    }
}


internal val LocalCameraPositionState = staticCompositionLocalOf { CameraPositionState() }

public val currentCameraPositionState: CameraPositionState
    @[YandexMapComposable ReadOnlyComposable Composable]
    get() = LocalCameraPositionState.current