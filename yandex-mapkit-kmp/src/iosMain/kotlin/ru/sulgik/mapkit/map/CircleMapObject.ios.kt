package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKCircleMapObject as NativeCircleMapObject

public actual class CircleMapObject(private val nativeCircleMapObject: NativeCircleMapObject) :
    MapObject(nativeCircleMapObject) {

    override fun toNative(): NativeCircleMapObject {
        return nativeCircleMapObject
    }

    public actual var geometry: Circle
        get() = nativeCircleMapObject.geometry.toCommon()
        set(value) {
            nativeCircleMapObject.geometry = value.toNative()
        }
    public actual var strokeColor: Color
        get() = nativeCircleMapObject.strokeColor.toCommon()
        set(value) {
            nativeCircleMapObject.strokeColor = value.toNative()
        }
    public actual var strokeWidth: Float
        get() = nativeCircleMapObject.strokeWidth
        set(value) {
            nativeCircleMapObject.strokeWidth = value
        }
    public actual var fillColor: Color
        get() = nativeCircleMapObject.fillColor.toCommon()
        set(value) {
            nativeCircleMapObject.fillColor = value.toNative()
        }
    public actual var isGeodesic: Boolean
        get() = nativeCircleMapObject.geodesic
        set(value) {
            nativeCircleMapObject.geodesic = value
        }

}

public fun NativeCircleMapObject.toCommon(): CircleMapObject {
    return CircleMapObject(this)
}