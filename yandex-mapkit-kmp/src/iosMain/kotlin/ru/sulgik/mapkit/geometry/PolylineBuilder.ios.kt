package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPolylineBuilder as NativePolylineBuilder
import YandexMapKit.YMKPolylineBuilderFactory as NativePolylineBuilderFactory

/**
 * Assembles a polyline point by point.
 */
public actual class PolylineBuilder internal constructor(
    private val nativePolylineBuilder: NativePolylineBuilder,
) {

    public fun toNative(): NativePolylineBuilder {
        return nativePolylineBuilder
    }

    /**
     * Appends a polyline.
     */
    public actual fun append(polyline: Polyline) {
        nativePolylineBuilder.appendWithPolyline(polyline.toNative())
    }

    /**
     * Appends a point.
     */
    public actual fun append(point: Point) {
        nativePolylineBuilder.appendWithPoint(point.toNative())
    }

    /**
     * Builds a polyline.
     */
    public actual fun build(): Polyline {
        return nativePolylineBuilder.build().toCommon()
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PolylineBuilder) return false
        if (this::class != other::class) return false
        return nativePolylineBuilder == other.nativePolylineBuilder
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativePolylineBuilder.hashCode()
    }
}

public fun NativePolylineBuilder.toCommon(): PolylineBuilder {
    return PolylineBuilder(this)
}

/**
 * Creates an empty [PolylineBuilder].
 */
public actual fun PolylineBuilder(): PolylineBuilder {
    return NativePolylineBuilderFactory.create().toCommon()
}
