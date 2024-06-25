package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.mapview.MapWindow
import ru.sulgik.mapkit.mapview.toCommon
import com.yandex.mapkit.map.MapWindow as NatievMapWindow
import com.yandex.mapkit.map.SizeChangedListener as NativeSizeChangedListener

actual class SizeChangeListener actual constructor(
    private val onMapWindowSizeChanged: (mapWindow: MapWindow, newWidth: Int, newHeight: Int) -> Unit,
) :
    NativeSizeChangedListener {
    override fun onMapWindowSizeChanged(p0: NatievMapWindow, p1: Int, p2: Int) {
        onMapWindowSizeChanged.invoke(p0.toCommon(), p1, p2)
    }
}