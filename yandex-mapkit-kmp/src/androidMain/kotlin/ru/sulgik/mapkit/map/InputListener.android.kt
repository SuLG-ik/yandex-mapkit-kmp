package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.map.InputListener as NativeInputListener
import com.yandex.mapkit.map.Map as NativeMap

actual class InputListener actual constructor(
    private val onMapTap: (map: Map, point: Point) -> Unit,
    private val onMapLongTap: (map: Map, point: Point) -> Unit,
) : NativeInputListener {
    override fun onMapTap(p0: NativeMap, p1: NativePoint) {
        onMapTap.invoke(p0.toCommon(), p1.toCommon())
    }

    override fun onMapLongTap(p0: NativeMap, p1: NativePoint) {
        onMapLongTap.invoke(p0.toCommon(), p1.toCommon())
    }
}