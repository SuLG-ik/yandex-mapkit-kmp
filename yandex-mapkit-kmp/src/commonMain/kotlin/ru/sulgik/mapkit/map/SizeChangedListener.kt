package ru.sulgik.mapkit.map

public expect abstract class SizeChangedListener() {
    public abstract fun onMapWindowSizeChanged(mapWindow: MapWindow, newWidth: Int, newHeight: Int)
}

public inline fun SizeChangedListener(
    crossinline onMapWindowSizeChanged: (mapWindow: MapWindow, newWidth: Int, newHeight: Int) -> Unit,
): SizeChangedListener {
    return object : SizeChangedListener() {
        override fun onMapWindowSizeChanged(mapWindow: MapWindow, newWidth: Int, newHeight: Int) {
            onMapWindowSizeChanged.invoke(mapWindow, newWidth, newHeight)
        }
    }
}
