package ru.sulgik.mapkit.map

import platform.Foundation.NSNumber
import platform.Foundation.numberWithInt
import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.logo.Logo
import ru.sulgik.mapkit.logo.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKMap as NativeMap

actual class Map internal constructor(private val nativeMap: NativeMap) {

    fun toNative(): NativeMap {
        return nativeMap
    }

    /**
     * Current camera position. Target position must be within latitude [-90, 90] and longitude [-180, 180].
     */
    actual val cameraPosition: CameraPosition
        get() = nativeMap.cameraPosition.toCommon()

    /**
     * The map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    actual val visibleRegion: VisibleRegion
        get() = nativeMap.visibleRegion.toCommon()

    actual val cameraBounds: CameraBounds
        get() = nativeMap.cameraBounds.toCommon()

    actual val mapObjects: MapObjectCollection
        get() = nativeMap.mapObjects.toCommon()

    /**
     * If enabled, night mode will reduce map brightness and improve contrast.
     */
    actual var isNightModeEnabled: Boolean
        get() = nativeMap.isNightModeEnabled()
        set(value) {
            nativeMap.setNightModeEnabled(value)
        }

    /**
     * Limits the number of visible basemap POIs.
     *
     * Optional property, can be null.
     */
    actual var poiLimit: Int?
        get() = nativeMap.poiLimit()?.intValue()
        set(value) {
            nativeMap.setPoiLimit(value?.let(NSNumber.Companion::numberWithInt))
        }

    /**
     * Removes the 300 ms delay in emitting a tap gesture.
     *
     * However, a double-tap will emit a tap gesture along with a double-tap.
     */
    actual var isFastTapEnabled: Boolean
        get() = nativeMap.isFastTapEnabled()
        set(value) {
            nativeMap.setFastTapEnabled(value)
        }

    /**
     * Enable/disable rotation gestures, such as rotation with two fingers.
     */
    actual var isRotateGesturesEnabled: Boolean
        get() = nativeMap.isRotateGesturesEnabled()
        set(value) {
            nativeMap.setRotateGesturesEnabled(value)
        }

    /**
     * Enable/disable tilt gestures, such as parallel pan with two fingers.
     */
    actual var isTiltGesturesEnabled: Boolean
        get() = nativeMap.isTiltGesturesEnabled()
        set(value) {
            nativeMap.setTiltGesturesEnabled(value)
        }

    /**
     * Enable/disable scroll gestures.
     */
    actual var isScrollGesturesEnabled: Boolean
        get() = nativeMap.isScrollGesturesEnabled()
        set(value) {
            nativeMap.setScrollGesturesEnabled(value)
        }

    /**
     * Enable/disable zoom gestures.
     */
    actual var isZoomGesturesEnabled: Boolean
        get() = nativeMap.isZoomGesturesEnabled()
        set(value) {
            nativeMap.setZoomGesturesEnabled(value)
        }

    /**
     * Forces the map to be flat.
     *
     * true - All loaded tiles start showing the "flatten out" animation; all new tiles do not start 3D animation. false - All tiles start showing the "rise up" animation.
     */
    actual fun set2DMode(enable: Boolean) {
        nativeMap.set2DModeWithEnable(enable)
    }

    /**
     * Erases tiles, caches, etc.
     *
     * Does not trigger the next frame generation.
     */
    actual fun wipe() {
        nativeMap.wipe()
    }

    /**
     * Calculates the camera position that projects the specified geometry into the current focusRect, or the full view if the focusRect is not set.
     */
    actual fun calculateCameraPosition(geometry: Geometry): CameraPosition {
        return nativeMap.cameraPositionWithGeometry(geometry.toNative()).toCommon()
    }

    /**
     * Calculates the camera position that projects the specified geometry into the custom focusRect.
     */
    actual fun calculateCameraPosition(
        geometry: Geometry,
        screenRect: ScreenRect,
    ): CameraPosition {
        return nativeMap.cameraPositionWithGeometry(geometry.toNative(), screenRect.toNative())
            .toCommon()
    }

    /**
     * Camera position that projects the specified geometry into the custom focusRect, with custom azimuth and tilt camera parameters. If focus rect is not provided, current focus rect is used.
     */
    actual fun calculateCameraPosition(
        geometry: Geometry,
        azimuth: Float,
        tilt: Float,
        screenRect: ScreenRect,
    ): CameraPosition {
        return nativeMap.cameraPositionWithGeometry(
            geometry.toNative(),
            azimuth,
            tilt,
            screenRect.toNative()
        ).toCommon()
    }

    /**
     * Calculates the map region that is visible from the given camera position. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If the longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.
     */
    actual fun calculateVisibleRegion(cameraPosition: CameraPosition): VisibleRegion {
        return nativeMap.visibleRegionWithCameraPosition(cameraPosition.toNative()).toCommon()
    }

    /**
     * Immediately changes the camera position.
     *
     * Can cancel a previous unfinished movement.
     */
    actual fun move(cameraPosition: CameraPosition) {
        nativeMap.moveWithCameraPosition(cameraPosition.toNative())
    }

    /**
     * Changes camera position.
     *
     * Can cancel a previous unfinished movement.
     * @param animation Required. Defines animation parameters. @see mapkit.Animation for more details.
     * @param cameraCallback A function that takes the bool argument marking the camera action complete. Invoked when:
     * * A camera action is cancelled (for example, as a result of a subsequent request for camera movement), passing false as an argument.
     * * A camera action finished successfully, passing true as an argument.
     */
    actual fun move(
        cameraPosition: CameraPosition,
        animation: Animation,
        cameraCallback: CameraCallback?,
    ) {
        nativeMap.moveWithCameraPosition(
            cameraPosition.toNative(),
            animation.toNative(),
            cameraCallback?.toNative()
        )
    }

    /**
     * Adds camera listeners.
     */
    actual fun addCameraListener(cameraListener: CameraListener) {
        nativeMap.addCameraListenerWithCameraListener(cameraListener.toNative())
    }

    /**
     * Removes camera listeners.
     */
    actual fun removeCameraListener(cameraListener: CameraListener) {
        nativeMap.removeCameraListenerWithCameraListener(cameraListener.toNative())
    }

    /**
     * Yandex logo object.
     */
    actual fun getLogo(): Logo {
        return nativeMap.logo.toCommon()
    }

    /**
     * The base map type.
     */
    actual var mapType: MapType
        get() = nativeMap.mapType.toCommon()
        set(value) {
            nativeMap.mapType = value.toNative()
        }

    /**
     * Adds input listeners.
     */
    actual fun addInputListener(inputListener: InputListener) {
        nativeMap.addInputListenerWithInputListener(inputListener.toNative())
    }

    /**
     * Removes input listeners.
     */
    actual fun removeInputListener(inputListener: InputListener) {
        nativeMap.removeInputListenerWithInputListener(inputListener.toNative())
    }

}

fun NativeMap.toCommon(): Map {
    return Map(this)
}