package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.toColor
import ru.sulgik.mapkit.toArgb
import com.yandex.mapkit.map.PolygonMapObject as NativePolygonMapObject

public actual class PolygonMapObject internal constructor(private val nativePolygonMapObject: NativePolygonMapObject) :
    MapObject(nativePolygonMapObject) {
    override fun toNative(): NativePolygonMapObject {
        return nativePolygonMapObject
    }

    public actual var geometry: Polygon
        get() = nativePolygonMapObject.geometry.toCommon()
        set(value) {
            nativePolygonMapObject.geometry = value.toNative()
        }
    public actual var strokeColor: Color
        get() = nativePolygonMapObject.strokeColor.toColor()
        set(value) {
            nativePolygonMapObject.strokeColor = value.toArgb()
        }
    public actual var strokeWidth: Float
        get() = nativePolygonMapObject.strokeWidth
        set(value) {
            nativePolygonMapObject.strokeWidth = value
        }
    public actual var fillColor: Color
        get() = nativePolygonMapObject.fillColor.toColor()
        set(value) {
            nativePolygonMapObject.fillColor = value.toArgb()
        }
    public actual var isGeodesic: Boolean
        get() = nativePolygonMapObject.isGeodesic
        set(value) {
            nativePolygonMapObject.isGeodesic = value
        }

    public actual fun setPattern(image: ImageProvider, scale: Float) {
        nativePolygonMapObject.setPattern(image.toNative(), scale)
    }

    public actual fun resetPattern() {
        nativePolygonMapObject.resetPattern()
    }

}

public fun NativePolygonMapObject.toCommon(): PolygonMapObject {
    return PolygonMapObject(this)
}