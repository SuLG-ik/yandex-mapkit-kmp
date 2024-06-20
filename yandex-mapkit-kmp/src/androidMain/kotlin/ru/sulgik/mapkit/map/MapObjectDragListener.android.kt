package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.map.MapObject as NativeMapObject
import com.yandex.mapkit.map.MapObjectDragListener as NativeMapObjectDragListener

actual class MapObjectDragListener actual constructor(
    private val onMapObjectDragStart: (mapObject: MapObject) -> Unit,
    private val onMapObjectDrag: (mapObject: MapObject, point: Point) -> Unit,
    private val onMapObjectDragEnd: (mapObject: MapObject) -> Unit,
) : NativeMapObjectDragListener {
    override fun onMapObjectDragStart(p0: NativeMapObject) {
        onMapObjectDragStart(p0.toCommon())
    }

    override fun onMapObjectDrag(
        p0: NativeMapObject,
        p1: NativePoint,
    ) {
        onMapObjectDrag(p0.toCommon(), p1.toCommon())
    }

    override fun onMapObjectDragEnd(p0: NativeMapObject) {
        onMapObjectDragEnd(p0.toCommon())
    }
}