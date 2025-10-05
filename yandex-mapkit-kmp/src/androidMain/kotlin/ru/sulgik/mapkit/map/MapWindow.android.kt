package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapWindow
import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative

public actual class MapWindow internal constructor(private val nativeMapWindow: MapWindow) {

    public fun toNative(): MapWindow {
        return nativeMapWindow
    }

    public actual val width: Int
        get() = nativeMapWindow.width()
    public actual val height: Int
        get() = nativeMapWindow.height()

    public actual val map: Map = nativeMapWindow.map.toCommon()

    public actual fun addSizeChangeListener(listener: SizeChangedListener) {
        nativeMapWindow.addSizeChangedListener(listener.toNative())
    }

    public actual fun removeSizeChangeListener(listener: SizeChangedListener) {
        nativeMapWindow.removeSizeChangedListener(listener.toNative())
    }


    public actual var focusRect: ScreenRect?
        get() = nativeMapWindow.focusRect?.toCommon()
        set(value) {
            nativeMapWindow.focusRect = value?.toNative()
        }
    public actual var focusPoint: ScreenPoint?
        get() = nativeMapWindow.focusPoint?.toCommon()
        set(value) {
            nativeMapWindow.focusPoint = value?.toNative()
        }

    public actual var gestureFocusPoint: ScreenPoint?
        get() = nativeMapWindow.gestureFocusPoint?.toCommon()
        set(value) {
            nativeMapWindow.gestureFocusPoint = value?.toNative()
        }

    public actual var gestureFocusPointMode: GestureFocusPointMode
        get() = nativeMapWindow.gestureFocusPointMode.toCommon()
        set(value) {
            nativeMapWindow.gestureFocusPointMode = value.toNative()
        }

    public actual var pointOfView: PointOfView
        get() = nativeMapWindow.pointOfView.toCommon()
        set(value) {
            nativeMapWindow.pointOfView = value.toNative()
        }

    public actual var scaleFactor: Float
        get() = nativeMapWindow.scaleFactor
        set(value) {
            nativeMapWindow.scaleFactor = scaleFactor
        }

    public actual fun convertWorldToScreen(worldPoint: Point): ScreenPoint? {
        return nativeMapWindow.worldToScreen(worldPoint.toNative())?.toCommon()
    }

    public actual fun convertScreenToWorld(screenPoint: ScreenPoint): Point? {
        return nativeMapWindow.screenToWorld(screenPoint.toNative())?.toCommon()
    }

    /**
     * Gets the focused region.
     */
    public actual val focusRegion: VisibleRegion
        get() = nativeMapWindow.focusRegion.toCommon()

    /**
     * Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable.
     *
     * Valid range: (0, 60]. Default: 60.
     */
    public actual fun setMapFps(fps: Float) {
        nativeMapWindow.setMaxFps(fps)
    }

    public actual val isValid: Boolean
        get() = nativeMapWindow.isValid
}

public fun MapWindow.toCommon(): ru.sulgik.mapkit.map.MapWindow {
    return MapWindow(this)
}