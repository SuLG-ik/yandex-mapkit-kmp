package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.MapWindow

public expect class MapView {

    public val mapWindow: MapWindow

    public fun onStart()

    public fun onStop()

    public fun setNonInteractive(value: Boolean)

}