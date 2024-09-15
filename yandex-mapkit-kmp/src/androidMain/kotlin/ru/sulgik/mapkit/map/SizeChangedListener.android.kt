package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.SizeChangedListener as NativeSizeChangedListener

public actual abstract class SizeChangedListener actual constructor() {

    private val nativeListener =
        NativeSizeChangedListener { mapWindow, newWidth, newHeight ->
            onMapWindowSizeChanged(mapWindow.toCommon(), newWidth, newHeight)
        }

    public fun toNative(): NativeSizeChangedListener {
        return nativeListener
    }

    public actual abstract fun onMapWindowSizeChanged(
        mapWindow: MapWindow,
        newWidth: Int,
        newHeight: Int
    )

}