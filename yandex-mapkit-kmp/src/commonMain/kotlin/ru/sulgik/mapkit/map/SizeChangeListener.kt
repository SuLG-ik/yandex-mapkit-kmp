package ru.sulgik.mapkit.map

expect class SizeChangeListener(
    onMapWindowSizeChanged: (mapWindow: MapWindow, newWidth: Int, newHeight: Int) -> Unit,
)