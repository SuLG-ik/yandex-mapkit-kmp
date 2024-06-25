package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapWindow
import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative

actual class MapWindow internal constructor(private val nativeMapWindow: MapWindow) {

    fun toNative(): MapWindow {
        return nativeMapWindow
    }

    actual val width: Int
        get() = nativeMapWindow.width()
    actual val height: Int
        get() = nativeMapWindow.height()

    actual val map: Map = nativeMapWindow.map.toCommon()

    actual fun addSizeChangeListener(listener: SizeChangeListener) {
        nativeMapWindow.addSizeChangedListener(listener)
    }

    actual fun removeSizeChangeListener(listener: SizeChangeListener) {
        nativeMapWindow.removeSizeChangedListener(listener)
    }


    actual var focusRect: ScreenRect?
        get() = nativeMapWindow.focusRect?.toCommon()
        set(value) {
            nativeMapWindow.focusRect = value?.toNative()
        }
    actual var focusPoint: ScreenPoint?
        get() = nativeMapWindow.focusPoint?.toCommon()
        set(value) {
            nativeMapWindow.focusPoint = value?.toNative()
        }

    actual var gestureFocusPoint: ScreenPoint?
        get() = nativeMapWindow.gestureFocusPoint?.toCommon()
        set(value) {
            nativeMapWindow.gestureFocusPoint = value?.toNative()
        }

    actual var gestureFocusPointMode: GestureFocusPointMode
        get() = nativeMapWindow.gestureFocusPointMode.toCommon()
        set(value) {
            nativeMapWindow.gestureFocusPointMode = value.toNative()
        }

    actual var pointOfView: PointOfView
        get() = nativeMapWindow.pointOfView.toCommon()
        set(value) {
            nativeMapWindow.pointOfView = value.toNative()
        }

    actual var scaleFactor: Float
        get() = nativeMapWindow.scaleFactor
        set(value) {
            nativeMapWindow.scaleFactor = scaleFactor
        }

    actual fun convertWorldToScreen(worldPoint: Point): ScreenPoint? {
        return nativeMapWindow.worldToScreen(worldPoint.toNative())?.toCommon()
    }

    actual fun convertScreenToWorld(screenPoint: ScreenPoint): Point? {
        return nativeMapWindow.screenToWorld(screenPoint.toNative())?.toCommon()
    }

}

fun MapWindow.toCommon(): ru.sulgik.mapkit.map.MapWindow {
    return MapWindow(this)
}