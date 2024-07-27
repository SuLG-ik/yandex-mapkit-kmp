package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.MapObjectTapListener as NativeMapObjectTapListener

actual abstract class MapObjectTapListener actual constructor() {

    private val nativeListener = NativeMapObjectTapListener { mapObject, point ->
        onMapObjectTap(mapObject.toCommon(), point.toCommon())
    }

    fun toNative(): NativeMapObjectTapListener {
        return nativeListener
    }

    actual abstract fun onMapObjectTap(
        mapObject: MapObject,
        point: Point
    ): Boolean
}