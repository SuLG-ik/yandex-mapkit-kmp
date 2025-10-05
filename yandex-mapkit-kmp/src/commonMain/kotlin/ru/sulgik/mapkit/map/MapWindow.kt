package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.geometry.Point

public expect class MapWindow {

    /**
     * Window height in physical pixels
     */
    public val width: Int

    /**
     * Window width in physical pixels
     */
    public val height: Int

    /**
     * Gets the map interface.
     */
    public val map: Map

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
    public var focusRect: ScreenRect?

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
    public var focusPoint: ScreenPoint?

    /**
     * Defines the focus point of gestures.
     *
     * Actual behaviour depends on gestureFocusPointMode. If the point is not set, the source point
     * of the gesture will be used as the focus point. Default: none.
     *
     * Optional property, can be null.
     */
    public var gestureFocusPoint: ScreenPoint?

    /**
     * Specifies the way provided gesture focus point affects gestures.
     *
     * Default: TapGestures.
     */
    public var gestureFocusPointMode: GestureFocusPointMode

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
    public var pointOfView: PointOfView

    /**
     * Gets the focused region.
     *
     * @return A region that corresponds to the current focusRect or the visible region if
     * focusRect is not set. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded
     * by longitude limits [-180, 180]. If longitude exceeds its limits, we see the world's edge
     * and another instance of the world beyond this edge.
     */
    public val focusRegion: VisibleRegion

    public var scaleFactor: Float

    /**
     * Adds a SizeChangedListener.
     *
     * The class does not retain the object in the 'sizeChangedListener' parameter. It is your
     * responsibility to maintain a strong reference to the target object while it is
     * attached to a class.
     */
    public fun addSizeChangeListener(listener: SizeChangedListener)

    /**
     * Removes a SizeChangedListener.
     */
    public fun removeSizeChangeListener(listener: SizeChangedListener)

    public fun convertWorldToScreen(worldPoint: Point): ScreenPoint?

    public fun convertScreenToWorld(screenPoint: ScreenPoint): Point?

    /**
     * Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable.
     *
     * Valid range: (0, 60]. Default: 60.
     */
    public fun setMapFps(fps: Float)

    public val isValid: Boolean

}