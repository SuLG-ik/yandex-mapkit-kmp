package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.SizeChangeListener

expect class MapWindow {

    val width: Int

    val height: Int

    val map: Map

    fun addSizeChangeListener(listener: SizeChangeListener)

}