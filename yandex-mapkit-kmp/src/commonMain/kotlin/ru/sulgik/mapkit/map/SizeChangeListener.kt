package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.mapview.MapWindow

expect class SizeChangeListener(
    onMapWindowSizeChanged: (mapWindow: MapWindow, newWidth: Int, newHeight: Int) -> Unit,
)