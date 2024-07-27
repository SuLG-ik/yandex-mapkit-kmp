package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.map.InputListener as NativeInputListener
import com.yandex.mapkit.map.Map as NativeMap

actual abstract class InputListener actual constructor() {
    private val nativeListener = object : NativeInputListener {
        override fun onMapTap(p0: NativeMap, p1: NativePoint) {
            onMapTap(p0.toCommon(), p1.toCommon())
        }

        override fun onMapLongTap(p0: NativeMap, p1: NativePoint) {
            onMapLongTap(p0.toCommon(), p1.toCommon())
        }
    }

    fun toNative(): NativeInputListener {
        return nativeListener
    }

    actual abstract fun onMapTap(
        map: Map,
        point: Point,
    )

    actual abstract fun onMapLongTap(
        map: Map,
        point: Point,
    )
}