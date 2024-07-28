package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.SizeChangedListener as NativeSizeChangedListener

actual abstract class SizeChangeListener actual constructor() {

    private val nativeListener =
        NativeSizeChangedListener { mapWindow, newWidth, newHeight ->
            onMapWindowSizeChanged(mapWindow.toCommon(), newWidth, newHeight)
        }

    fun toNative(): NativeSizeChangedListener {
        return nativeListener
    }

    actual abstract fun onMapWindowSizeChanged(
        mapWindow: MapWindow,
        newWidth: Int,
        newHeight: Int
    )

}