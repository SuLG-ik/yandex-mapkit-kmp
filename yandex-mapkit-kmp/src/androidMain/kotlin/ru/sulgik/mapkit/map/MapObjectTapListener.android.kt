package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.MapObjectTapListener as NativeMapObjectTapListener

actual class MapObjectTapListener actual constructor(
    private val onMapObjectTap: (mapObject: MapObject, point: Point) -> Boolean,
) : NativeMapObjectTapListener {

    override fun onMapObjectTap(
        p0: com.yandex.mapkit.map.MapObject,
        p1: com.yandex.mapkit.geometry.Point,
    ): Boolean {
        return onMapObjectTap(p0.toCommon(), p1.toCommon())
    }
}