package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKMapWindow as NativeMapWindow

actual class MapWindow internal constructor(private val nativeMapWindow: NativeMapWindow) {

    fun toNative(): NativeMapWindow {
        return nativeMapWindow
    }

    actual val width: Int
        get() = nativeMapWindow.width().toInt()

    actual val height: Int
        get() = nativeMapWindow.height().toInt()

    actual val map: Map
        get() = nativeMapWindow.map.toCommon()

    actual fun addSizeChangeListener(listener: SizeChangeListener) {
        nativeMapWindow.addSizeChangedListenerWithSizeChangedListener(listener.toNative())
    }

    actual fun removeSizeChangeListener(listener: SizeChangeListener) {
        nativeMapWindow.removeSizeChangedListenerWithSizeChangedListener(listener.toNative())
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
            nativeMapWindow.scaleFactor = value
        }

    actual fun convertWorldToScreen(worldPoint: Point): ScreenPoint? {
        return nativeMapWindow.worldToScreenWithWorldPoint(worldPoint.toNative())?.toCommon()
    }

    actual fun convertScreenToWorld(screenPoint: ScreenPoint): Point? {
        return nativeMapWindow.screenToWorldWithScreenPoint(screenPoint.toNative())?.toCommon()
    }

}

fun NativeMapWindow.toCommon(): MapWindow {
    return MapWindow(this)
}