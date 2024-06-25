package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.toCommon
import com.yandex.mapkit.map.PolygonMapObject as NativePolygonMapObject

actual class PolygonMapObject internal constructor(private val nativePolygonMapObject: NativePolygonMapObject) :
    MapObject(nativePolygonMapObject) {
    override fun toNative(): NativePolygonMapObject {
        return nativePolygonMapObject
    }

    actual var geometry: Polygon
        get() = nativePolygonMapObject.geometry.toCommon()
        set(value) {
            nativePolygonMapObject.geometry = value.toNative()
        }
    actual var strokeColor: Color
        get() = nativePolygonMapObject.strokeColor.let(::Color)
        set(value) {
            nativePolygonMapObject.strokeColor = value.value
        }
    actual var strokeWidth: Float
        get() = nativePolygonMapObject.strokeWidth
        set(value) {
            nativePolygonMapObject.strokeWidth = value
        }
    actual var fillColor: Color
        get() = nativePolygonMapObject.fillColor.let(::Color)
        set(value) {
            nativePolygonMapObject.fillColor = value.value
        }
    actual var isGeodesic: Boolean
        get() = nativePolygonMapObject.isGeodesic
        set(value) {
            nativePolygonMapObject.isGeodesic = value
        }

    actual fun setPattern(image: ImageProvider, scale: Float) {
        nativePolygonMapObject.setPattern(image.toNative(), scale)
    }

    actual fun resetPattern() {
        nativePolygonMapObject.resetPattern()
    }

}

fun NativePolygonMapObject.toCommon(): PolygonMapObject {
    return PolygonMapObject(this)
}