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
import com.yandex.mapkit.map.MapWindow as NativeMapWindow

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

    /**
     * Window width in physical pixels
     */
    public actual val width: Int
        get() = nativeMapWindow.width()

    /**
     * Window height in physical pixels
     */
    public actual val height: Int
        get() = nativeMapWindow.height()

    /**
     * Gets the map interface.
     */
    public actual val map: Map
        get() = nativeMapWindow.map.toCommon()

    /**
     * Adds a SizeChangedListener.
     *
     * The class does not retain the object in the 'sizeChangedListener' parameter. It is your
     * responsibility to maintain a strong reference to the target object while it is
     * attached to a class.
     */
    public actual fun addSizeChangedListener(listener: WeakRef<SizeChangedListener>) {
        nativeMapWindow.addSizeChangedListener(listener.toNative())
    }

    /**
     * Removes a SizeChangedListener.
     */
    public actual fun removeSizeChangedListener(listener: WeakRef<SizeChangedListener>) {
        nativeMapWindow.removeSizeChangedListener(listener.toNative())
    }

    /**
     * When using controls that overlay the map view, calculating the proper camera position can be
     * tricky.
     *
     * This property simplifies the task by defining the area of interest (the focus rectangle)
     * inside the view. Map methods that calculate the camera position based on a world bounding box
     * ensure that this bounding box will fit into the focusRect.
     *
     * For example, when using a semi-transparent control that overlays the top half of the
     * map view, define the focus rectangle as the lower half of the view to ensure that object of
     * interest appear in the lower half of map view. In addition, if focusPoint is null all camera
     * movements will have the center of the lower half as their target.
     *
     * If focusRect is null, the whole map view is used instead.
     *
     * On iOS, if you change the focus rectangle in the viewDidLayoutSubviews callback, it's
     * recommended to call MapView.layoutIfNeeded just before that action.
     *
     * Optional property, can be null.
     */
    public actual var focusRect: ScreenRect?
        get() = nativeMapWindow.focusRect?.toCommon()
        set(value) {
            nativeMapWindow.focusRect = value?.toNative()
        }

    /**
     * The point on the screen that corresponds to camera position.
     *
     * Changing camera position or focusPoint makes the new camera target appear exactly at the
     * focusPoint on screen.
     *
     * If focusPoint is null, the center of focusRect is used instead.
     *
     * Optional property, can be null.
     */
    public actual var focusPoint: ScreenPoint?
        get() = nativeMapWindow.focusPoint?.toCommon()
        set(value) {
            nativeMapWindow.focusPoint = value?.toNative()
        }

    /**
     * Defines the focus point of gestures.
     *
     * Actual behaviour depends on gestureFocusPointMode. If the point is not set, the source point
     * of the gesture will be used as the focus point. Default: none.
     *
     * Optional property, can be null.
     */
    public actual var gestureFocusPoint: ScreenPoint?
        get() = nativeMapWindow.gestureFocusPoint?.toCommon()
        set(value) {
            nativeMapWindow.gestureFocusPoint = value?.toNative()
        }

    /**
     * Specifies the way provided gesture focus point affects gestures.
     *
     * Default: TapGestures.
     */
    public actual var gestureFocusPointMode: GestureFocusPointMode
        get() = nativeMapWindow.gestureFocusPointMode.toCommon()
        set(value) {
            nativeMapWindow.gestureFocusPointMode = value.toNative()
        }

    /**
     * Defines the position of the point of view.
     *
     * Cameras use perspective projection, which causes perspective deformations. Perspective
     * projection has an axis, and points on this axis are not affected by perspective deformations.
     * This axis is a line parallel to the view's direction, so its projection to the screen is
     * a point - the "point of view". By default, this point is at the center of the screen,
     * but some applications might want to set it to the center of focusRect. Use this flag to
     * do so. Default: ScreenCenter
     */
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
        return nativeMapWindow.worldToScreen(worldPoint.toNative())?.toCommon()
    }

    public actual fun screenToWorld(screenPoint: ScreenPoint): Point? {
        return nativeMapWindow.screenToWorld(screenPoint.toNative())?.toCommon()
    }

    /**
     * Gets the focused region.
     *
     * @return A region that corresponds to the current focusRect or the visible region if
     * focusRect is not set. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded
     * by longitude limits [-180, 180]. If longitude exceeds its limits, we see the world's edge
     * and another instance of the world beyond this edge.
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
        nativeMapWindow.setMaxFps(fps)
    }

    public actual val isValid: Boolean
        get() = nativeMapWindow.isValid

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
