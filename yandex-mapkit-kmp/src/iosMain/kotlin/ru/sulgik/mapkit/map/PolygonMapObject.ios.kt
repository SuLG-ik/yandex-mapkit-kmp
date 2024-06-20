package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKPolygonMapObject as NativePolygonMapObject

actual class PolygonMapObject(private val nativePolygonMapObject: NativePolygonMapObject) :
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
        get() = nativePolygonMapObject.strokeColor.toCommon()
        set(value) {
            nativePolygonMapObject.strokeColor = value.toNative()
        }
    actual var strokeWidth: Float
        get() = nativePolygonMapObject.strokeWidth
        set(value) {
            nativePolygonMapObject.strokeWidth = value
        }
    actual var fillColor: Color
        get() = nativePolygonMapObject.fillColor.toCommon()
        set(value) {
            nativePolygonMapObject.fillColor = value.toNative()
        }
    actual var isGeodesic: Boolean
        get() = nativePolygonMapObject.isGeodesic()
        set(value) {
            nativePolygonMapObject.setGeodesic(value)
        }

    actual fun setPattern(image: ImageProvider, scale: Float) {
        nativePolygonMapObject.setPatternWithImage(image.toNative(), scale)
    }

    actual fun resetPattern() {
        nativePolygonMapObject.resetPattern()
    }

}

fun NativePolygonMapObject.toCommon(): PolygonMapObject {
    return PolygonMapObject(this)
}