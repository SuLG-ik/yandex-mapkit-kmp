package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.Map

expect class MapWindow {

    val width: Int

    val height: Int

    val map: Map

}