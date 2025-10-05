package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.PlacemarksStyler as NativePlacemarksStyler

public actual class PlacemarksStyler internal constructor(private val nativePlacemarksStyler: NativePlacemarksStyler) {

    public fun toNative(): NativePlacemarksStyler {
        return nativePlacemarksStyler
    }

    public actual fun setScaleFunction(points: List<PointF>) {
        nativePlacemarksStyler.setScaleFunction(points.map { it.toNative() })
    }

    public actual val isValid: Boolean
        get() = nativePlacemarksStyler.isValid
}

public fun NativePlacemarksStyler.toCommon(): PlacemarksStyler {
    return PlacemarksStyler(this)
}