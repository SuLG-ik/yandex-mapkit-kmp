package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Polyline as NativePolyline

public actual class Polyline internal constructor(private val nativePolyline: NativePolyline) {

    public fun toNative(): NativePolyline {
        return nativePolyline
    }

    override fun toString(): String {
        return "Polyline(points=${points.pointsListToString()})"
    }

    public actual constructor(points: List<Point>) : this(NativePolyline(points.map { it.toNative() }))

    public actual val points: List<Point> by lazy {
        nativePolyline.points.map { it.toCommon() }
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Polyline) return false
        if (this::class != other::class) return false
        return nativePolyline == other.nativePolyline
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativePolyline.hashCode()
    }
}

public fun NativePolyline.toCommon(): Polyline {
    return Polyline(this)
}
