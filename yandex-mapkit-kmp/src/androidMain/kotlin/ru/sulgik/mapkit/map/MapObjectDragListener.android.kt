package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.MapObjectDragListener as NativeMapObjectDragListener

actual abstract class MapObjectDragListener : NativeMapObjectDragListener {
    actual abstract fun onMapObjectDragStart(mapObject: MapObject)
    actual abstract fun onMapObjectDrag(
        mapObject: MapObject,
        point: Point,
    )

    actual abstract fun onMapObjectDragEnd(mapObject: MapObject)

    override fun onMapObjectDragStart(p0: com.yandex.mapkit.map.MapObject) {
        onMapObjectDragStart(p0.toCommon())
    }

    override fun onMapObjectDrag(
        p0: com.yandex.mapkit.map.MapObject,
        p1: com.yandex.mapkit.geometry.Point,
    ) {
        onMapObjectDrag(p0.toCommon(), p1.toCommon())
    }

    override fun onMapObjectDragEnd(p0: com.yandex.mapkit.map.MapObject) {
        onMapObjectDragEnd(p0.toCommon())
    }
}