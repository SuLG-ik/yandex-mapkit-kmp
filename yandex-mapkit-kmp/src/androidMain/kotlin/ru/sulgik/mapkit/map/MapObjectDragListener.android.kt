package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.map.MapObject as NativeMapObject
import com.yandex.mapkit.map.MapObjectDragListener as NativeMapObjectDragListener

public actual abstract class MapObjectDragListener actual constructor() {
    private val nativeListener = object : NativeMapObjectDragListener {
        override fun onMapObjectDragStart(p0: NativeMapObject) {
            onMapObjectDragStart(p0.toCommon())
        }

        override fun onMapObjectDrag(p0: NativeMapObject, p1: NativePoint) {
            onMapObjectDrag(p0.toCommon(), p1.toCommon())
        }

        override fun onMapObjectDragEnd(p0: NativeMapObject) {
            onMapObjectDragEnd(p0.toCommon())
        }
    }

    public fun toNative(): NativeMapObjectDragListener {
        return nativeListener
    }

    public actual abstract fun onMapObjectDragStart(mapObject: MapObject)
    public actual abstract fun onMapObjectDrag(mapObject: MapObject, point: Point)
    public actual abstract fun onMapObjectDragEnd(mapObject: MapObject)
}