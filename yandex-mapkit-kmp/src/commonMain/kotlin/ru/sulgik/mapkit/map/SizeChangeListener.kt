package ru.sulgik.mapkit.map

expect abstract class SizeChangeListener() {
    abstract fun onMapWindowSizeChanged(mapWindow: MapWindow, newWidth: Int, newHeight: Int)
}

inline fun SizeChangeListener(
   crossinline onMapWindowSizeChanged: (mapWindow: MapWindow, newWidth: Int, newHeight: Int) -> Unit,
): SizeChangeListener {
    return object : SizeChangeListener() {
        override fun onMapWindowSizeChanged(mapWindow: MapWindow, newWidth: Int, newHeight: Int) {
            onMapWindowSizeChanged.invoke(mapWindow, newWidth, newHeight)
        }
    }
}