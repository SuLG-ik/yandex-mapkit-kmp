package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.geometry.Point

public expect class MapWindow {

    public val width: Int

    public val height: Int

    public val map: Map

    public var focusRect: ScreenRect?

    public var focusPoint: ScreenPoint?

    public var gestureFocusPoint: ScreenPoint?

    public var gestureFocusPointMode: GestureFocusPointMode

    public var pointOfView: PointOfView

    public var scaleFactor: Float

    public fun addSizeChangeListener(listener: SizeChangedListener)

    public fun removeSizeChangeListener(listener: SizeChangedListener)

    public fun convertWorldToScreen(worldPoint: Point): ScreenPoint?

    public fun convertScreenToWorld(screenPoint: ScreenPoint): Point?

}