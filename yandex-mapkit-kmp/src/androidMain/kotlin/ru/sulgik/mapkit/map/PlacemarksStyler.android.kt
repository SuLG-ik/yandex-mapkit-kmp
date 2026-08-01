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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PlacemarksStyler) return false
        if (this::class != other::class) return false
        return nativePlacemarksStyler == other.nativePlacemarksStyler
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativePlacemarksStyler.hashCode()
    }
}

public fun NativePlacemarksStyler.toCommon(): PlacemarksStyler {
    return PlacemarksStyler(this)
}
