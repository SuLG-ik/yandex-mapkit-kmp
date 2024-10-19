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

@Deprecated(
    "SizeChangeListener renamed to SizeChangedListener as in original API.",
    replaceWith = ReplaceWith(expression = "ru.sulgik.mapkit.map.SizeChangedListener")
)
public typealias SizeChangeListener = SizeChangedListener

@Deprecated(
    "SizeChangeListener renamed to SizeChangedListener as in original API.",
    replaceWith = ReplaceWith(expression = "ru.sulgik.mapkit.map.SizeChangedListener(onMapWindowSizeChanged = onMapWindowSizeChanged)")
)
public inline fun SizeChangeListener(
    crossinline onMapWindowSizeChanged: (mapWindow: MapWindow, newWidth: Int, newHeight: Int) -> Unit,
): SizeChangedListener {
    return SizeChangedListener(onMapWindowSizeChanged)
}
