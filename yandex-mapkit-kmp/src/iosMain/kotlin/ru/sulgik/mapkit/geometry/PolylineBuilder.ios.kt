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
