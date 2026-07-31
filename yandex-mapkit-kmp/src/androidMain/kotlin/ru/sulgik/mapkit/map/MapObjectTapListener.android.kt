package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.MapObjectTapListener as NativeMapObjectTapListener

public actual abstract class MapObjectTapListener actual constructor() : NativeConvertible<NativeMapObjectTapListener> {

    private val nativeListener = NativeMapObjectTapListener { mapObject, point ->
        onMapObjectTap(mapObject.toCommon(), point.toCommon())
    }

    override fun toNative(): NativeMapObjectTapListener {
        return nativeListener
    }

    public actual abstract fun onMapObjectTap(
        mapObject: MapObject,
        point: Point,
    ): Boolean
}
