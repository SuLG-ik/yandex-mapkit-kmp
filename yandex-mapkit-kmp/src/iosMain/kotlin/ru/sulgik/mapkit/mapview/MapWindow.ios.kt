@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit.mapview

import kotlinx.cinterop.ExperimentalForeignApi
import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.toCommon
import YandexMapKit.YMKMapWindow as NativeMapWindow

actual class MapWindow(private val nativeMapWindow: NativeMapWindow) {
    actual val width: Int
        get() = nativeMapWindow.width().toInt()
    actual val height: Int
        get() = nativeMapWindow.height().toInt()
    actual val map: Map
        get() = nativeMapWindow.map.toCommon()

}