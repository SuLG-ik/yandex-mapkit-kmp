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

/**
 * Create and [rememberSaveable] a [CameraPositionState] using [CameraPositionState.Saver].
 * [init] will be called when the [CameraPositionState] is first created to configure its
 * initial state.
 */
@Composable
public inline fun rememberCameraPositionState(
    key: String? = null,
    crossinline init: CameraPositionState.() -> Unit = {},
): CameraPositionState = rememberSaveable(key = key, saver = CameraPositionState.Saver) {
    CameraPositionState().apply(init)
}

/**
 * A state object that can be hoisted to control and observe the map's camera state.
 * A [CameraPositionState] may only be used by a single [YandexMap] composable at a time
 * as it reflects instance state for a single view of a map.
 *
 * @param position the initial camera position
 */
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

    /**
     * Current position of the camera on the map.
     */
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

    /**
     * Whether the camera is currently moving or not. This includes any kind of movement:
     * panning, zooming, or rotation.
     */
    public var isMoving: Boolean by mutableStateOf(false)
        internal set

    /**
     * The reason for the start of the most recent camera moment
     */
    public var updateReason: CameraUpdateReason? by mutableStateOf(null)
        internal set

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

/** Provides the [CameraPositionState] used by the map. */
internal val LocalCameraPositionState = staticCompositionLocalOf { CameraPositionState() }

/** The current [CameraPositionState] used by the map. */
public val currentCameraPositionState: CameraPositionState
    @[YandexMapComposable ReadOnlyComposable Composable]
    get() = LocalCameraPositionState.current