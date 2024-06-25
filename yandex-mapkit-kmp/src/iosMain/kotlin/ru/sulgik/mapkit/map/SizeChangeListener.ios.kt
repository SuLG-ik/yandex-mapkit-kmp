package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapWindow
import platform.darwin.NSInteger
import platform.darwin.NSObject
import ru.sulgik.mapkit.mapview.MapWindow
import ru.sulgik.mapkit.mapview.toCommon
import YandexMapKit.YMKMapSizeChangedListenerProtocol as NativeSizeChangeListener

actual class SizeChangeListener actual constructor(
    private val onMapWindowSizeChanged: (mapWindow: MapWindow, newWidth: Int, newHeight: Int) -> Unit,
) :
    NativeSizeChangeListener, NSObject() {

    override fun onMapWindowSizeChangedWithMapWindow(
        mapWindow: YMKMapWindow,
        newWidth: NSInteger,
        newHeight: NSInteger,
    ) {
        onMapWindowSizeChanged.invoke(mapWindow.toCommon(), newWidth.toInt(), newHeight.toInt())
    }

}