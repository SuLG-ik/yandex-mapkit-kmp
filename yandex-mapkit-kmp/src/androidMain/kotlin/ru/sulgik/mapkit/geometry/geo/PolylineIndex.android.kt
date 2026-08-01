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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PolylineIndex) return false
        if (this::class != other::class) return false
        return nativePolylineIndex == other.nativePolylineIndex
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativePolylineIndex.hashCode()
    }
}

public fun NativePolylineIndex.toCommon(): PolylineIndex {
    return PolylineIndex(this)
}
