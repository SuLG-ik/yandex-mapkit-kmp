package ru.sulgik.mapkit.geometry.geo

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.geometry.geo.PolylineIndex as NativePolylineIndex

/**
 * A spatial index over a polyline.
 */
public actual class PolylineIndex internal constructor(
    private val nativePolylineIndex: NativePolylineIndex,
) {

    public fun toNative(): NativePolylineIndex {
        return nativePolylineIndex
    }

    public actual fun closestPolylinePosition(
        point: Point,
        priority: Priority,
        maxLocationBias: Double,
    ): PolylinePosition? {
        return nativePolylineIndex
            .closestPolylinePosition(point.toNative(), priority.toNative(), maxLocationBias)
            ?.toCommon()
    }

    public actual fun closestPolylinePosition(
        point: Point,
        positionFrom: PolylinePosition,
        positionTo: PolylinePosition,
        maxLocationBias: Double,
    ): PolylinePosition? {
        return nativePolylineIndex.closestPolylinePosition(
            point.toNative(),
            positionFrom.toNative(),
            positionTo.toNative(),
            maxLocationBias,
        )?.toCommon()
    }
}

public fun NativePolylineIndex.toCommon(): PolylineIndex {
    return PolylineIndex(this)
}
