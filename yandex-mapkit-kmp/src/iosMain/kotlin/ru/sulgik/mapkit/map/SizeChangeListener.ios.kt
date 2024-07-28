package ru.sulgik.mapkit.map

import platform.darwin.NSInteger
import platform.darwin.NSObject
import YandexMapKit.YMKMapSizeChangedListenerProtocol as NativeSizeChangeListener
import YandexMapKit.YMKMapWindow as NativeMapWindow

actual abstract class SizeChangeListener actual constructor() {
    private val nativeListener = object : NativeSizeChangeListener, NSObject() {
        override fun onMapWindowSizeChangedWithMapWindow(
            mapWindow: NativeMapWindow,
            newWidth: NSInteger,
            newHeight: NSInteger,
        ) {
            onMapWindowSizeChanged(mapWindow.toCommon(), newWidth.toInt(), newHeight.toInt())
        }
    }

    fun toNative(): NativeSizeChangeListener {
        return nativeListener
    }

    actual abstract fun onMapWindowSizeChanged(
        mapWindow: MapWindow,
        newWidth: Int,
        newHeight: Int
    )
}