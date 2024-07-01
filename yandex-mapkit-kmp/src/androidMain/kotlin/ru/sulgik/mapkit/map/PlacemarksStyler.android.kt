package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.PlacemarksStyler as NativePlacemarksStyler

actual class PlacemarksStyler internal constructor(private val nativePlacemarksStyler: NativePlacemarksStyler) {

    fun toNative(): NativePlacemarksStyler {
        return nativePlacemarksStyler
    }

    actual fun setScaleFunction(points: List<PointF>) {
        nativePlacemarksStyler.setScaleFunction(points.map { it.toNative() })
    }

}

fun NativePlacemarksStyler.toCommon(): PlacemarksStyler {
    return PlacemarksStyler(this)
}