package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.toCommon
import com.yandex.mapkit.map.MapWindow as NativeMapWindow

actual class MapWindow(private val nativeMapWindow: NativeMapWindow) {
    actual val width: Int
        get() = nativeMapWindow.width()
    actual val height: Int
        get() = nativeMapWindow.height()

    actual val map: Map = nativeMapWindow.map.toCommon()

}

fun NativeMapWindow.toCommon(): MapWindow {
    return MapWindow(this)
}

