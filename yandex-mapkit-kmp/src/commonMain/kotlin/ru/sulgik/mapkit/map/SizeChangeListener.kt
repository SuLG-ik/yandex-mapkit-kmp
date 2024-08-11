package ru.sulgik.mapkit.map

public expect abstract class SizeChangeListener() {
    public abstract fun onMapWindowSizeChanged(mapWindow: MapWindow, newWidth: Int, newHeight: Int)
}

public inline fun SizeChangeListener(
   crossinline onMapWindowSizeChanged: (mapWindow: MapWindow, newWidth: Int, newHeight: Int) -> Unit,
): SizeChangeListener {
    return object : SizeChangeListener() {
        override fun onMapWindowSizeChanged(mapWindow: MapWindow, newWidth: Int, newHeight: Int) {
            onMapWindowSizeChanged.invoke(mapWindow, newWidth, newHeight)
        }
    }
}