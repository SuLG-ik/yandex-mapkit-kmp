package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.map.CircleMapObject as NativeCircleMapObject

actual class CircleMapObject(private val nativeCircleMapObject: NativeCircleMapObject) :
    MapObject(nativeCircleMapObject) {

    override fun toNative(): NativeCircleMapObject {
        return nativeCircleMapObject
    }

    actual var geometry: Circle
        get() = nativeCircleMapObject.geometry.toCommon()
        set(value) {
            nativeCircleMapObject.geometry = value.toNative()
        }
    actual var strokeColor: Color
        get() = nativeCircleMapObject.strokeColor.let(::Color)
        set(value) {
            nativeCircleMapObject.strokeColor = value.value
        }
    actual var strokeWidth: Float
        get() = nativeCircleMapObject.strokeWidth
        set(value) {
            nativeCircleMapObject.strokeWidth = value
        }
    actual var fillColor: Color
        get() = nativeCircleMapObject.fillColor.let(::Color)
        set(value) {
            nativeCircleMapObject.fillColor = value.value
        }
    actual var isGeodesic: Boolean
        get() = nativeCircleMapObject.isGeodesic
        set(value) {
            nativeCircleMapObject.isGeodesic = value
        }

}

fun NativeCircleMapObject.toCommon(): CircleMapObject {
    return CircleMapObject(this)
}