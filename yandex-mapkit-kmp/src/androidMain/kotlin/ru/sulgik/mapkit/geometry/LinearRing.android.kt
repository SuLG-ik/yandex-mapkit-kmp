package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.LinearRing as NativeLinearRing

public actual class LinearRing internal constructor(private val nativeLinearRing: NativeLinearRing) {

    public fun toNative(): NativeLinearRing {
        return nativeLinearRing
    }

    override fun toString(): String {
        return "LinearRing(points=${points.pointsListToString()})"
    }

    public actual constructor(points: List<Point>) : this(NativeLinearRing(points.map { it.toNative() }))

    public actual val points: List<Point> by lazy { nativeLinearRing.points.map { it.toCommon() } }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LinearRing) return false
        if (this::class != other::class) return false
        return nativeLinearRing == other.nativeLinearRing
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeLinearRing.hashCode()
    }
}

public fun NativeLinearRing.toCommon(): LinearRing {
    return LinearRing(this)
}
