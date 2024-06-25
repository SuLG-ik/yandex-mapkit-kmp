package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.MapWindow

expect class MapView {

    val mapWindow: MapWindow

    fun onStart()

    fun onStop()

}