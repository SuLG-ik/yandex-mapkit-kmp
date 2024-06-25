package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.geometry.Point

expect class MapWindow {

    val width: Int

    val height: Int

    val map: Map

    var focusRect: ScreenRect?

    var focusPoint: ScreenPoint?

    var gestureFocusPoint: ScreenPoint?

    var gestureFocusPointMode: GestureFocusPointMode

    var pointOfView: PointOfView

    var scaleFactor: Float

    fun addSizeChangeListener(listener: SizeChangeListener)

    fun removeSizeChangeListener(listener: SizeChangeListener)

    fun convertWorldToScreen(worldPoint: Point): ScreenPoint?

    fun convertScreenToWorld(screenPoint: ScreenPoint): Point?

}