package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.PolylineBuilder as NativePolylineBuilder
import com.yandex.mapkit.geometry.PolylineBuilderFactory as NativePolylineBuilderFactory

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
        nativePolylineBuilder.append(polyline.toNative())
    }

    /**
     * Appends a point.
     */
    public actual fun append(point: Point) {
        nativePolylineBuilder.append(point.toNative())
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
