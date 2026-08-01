package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import ru.sulgik.mapkit.ui.Overlay
import ru.sulgik.mapkit.ui.toCommon
import YandexMapKit.YMKMapWindow as NativeMapWindow

public actual class MapWindow internal constructor(private val nativeMapWindow: NativeMapWindow) {

    /**
     * Adds raster screen overlay.
     */
    public actual fun addRasterScreenOverlay(): Overlay {
        return nativeMapWindow.addRasterScreenOverlay().toCommon()
    }

    public fun toNative(): NativeMapWindow {
        return nativeMapWindow
    }

    public actual val width: Int
        get() = nativeMapWindow.width().toInt()

    public actual val height: Int
        get() = nativeMapWindow.height().toInt()

    public actual val map: Map
        get() = nativeMapWindow.map.toCommon()

    public actual fun addSizeChangedListener(listener: WeakRef<SizeChangedListener>) {
        nativeMapWindow.addSizeChangedListenerWithSizeChangedListener(listener.toNative() ?: return)
    }

    public actual fun removeSizeChangedListener(listener: WeakRef<SizeChangedListener>) {
        nativeMapWindow.removeSizeChangedListenerWithSizeChangedListener(listener.toNative() ?: return)
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
            nativeMapWindow.scaleFactor = value
        }

    public actual fun worldToScreen(worldPoint: Point): ScreenPoint? {
        return nativeMapWindow.worldToScreenWithWorldPoint(worldPoint.toNative())?.toCommon()
    }

    public actual fun screenToWorld(screenPoint: ScreenPoint): Point? {
        return nativeMapWindow.screenToWorldWithScreenPoint(screenPoint.toNative())?.toCommon()
    }

    /**
     * Gets the focused region.
     */
    public actual val focusRegion: VisibleRegion
        get() = nativeMapWindow.focusRegion.toCommon()

    /**
     * Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable.
     *
     * Valid range: [0, max display refresh rate]. Default max fps depends on max display refresh
     * rate. If [fps] is 0, max fps value is set to max display refresh rate.
     */
    public actual fun setMaxFps(fps: Int) {
        nativeMapWindow.setMaxFpsWithFps(fps.toULong())
    }

    public actual val isValid: Boolean
        get() = nativeMapWindow.isValid()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MapWindow) return false
        if (this::class != other::class) return false
        return nativeMapWindow == other.nativeMapWindow
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeMapWindow.hashCode()
    }
}

public fun NativeMapWindow.toCommon(): MapWindow {
    return MapWindow(this)
}
