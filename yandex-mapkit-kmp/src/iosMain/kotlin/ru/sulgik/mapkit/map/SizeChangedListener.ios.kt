package ru.sulgik.mapkit.map

import platform.darwin.NSInteger
import platform.darwin.NSObject
import YandexMapKit.YMKMapSizeChangedListenerProtocol as NativeSizeChangeListener
import YandexMapKit.YMKMapWindow as NativeMapWindow

public actual abstract class SizeChangedListener actual constructor() {
    private val nativeListener = object : NativeSizeChangeListener, NSObject() {
        override fun onMapWindowSizeChangedWithMapWindow(
            mapWindow: NativeMapWindow,
            newWidth: NSInteger,
            newHeight: NSInteger,
        ) {
            onMapWindowSizeChanged(mapWindow.toCommon(), newWidth.toInt(), newHeight.toInt())
        }
    }

    public fun toNative(): NativeSizeChangeListener {
        return nativeListener
    }

    public actual abstract fun onMapWindowSizeChanged(
        mapWindow: MapWindow,
        newWidth: Int,
        newHeight: Int
    )
}