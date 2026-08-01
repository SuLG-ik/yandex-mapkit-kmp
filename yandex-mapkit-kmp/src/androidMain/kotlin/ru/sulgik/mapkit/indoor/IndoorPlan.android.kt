package ru.sulgik.mapkit.indoor

import com.yandex.mapkit.indoor.IndoorPlan as NativeIndoorPlan

/**
 * Describes indoor plan of building.
 *
 * Use activeLevelId property to select active level
 */
public actual class IndoorPlan internal constructor(private val nativeIndoorPlan: NativeIndoorPlan) {

    public fun toNative(): NativeIndoorPlan {
        return nativeIndoorPlan
    }

    /**
     * List of all levels in indoor plan, from bottom to top.
     */
    public actual val levels: List<IndoorLevel>
        get() = nativeIndoorPlan.levels.map { it.toCommon() }

    /**
     * Gets/sets active id
     */
    public actual var activeLevelId: String
        get() = nativeIndoorPlan.activeLevelId
        set(value) {
            nativeIndoorPlan.activeLevelId = value
        }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IndoorPlan) return false
        if (this::class != other::class) return false
        return nativeIndoorPlan == other.nativeIndoorPlan
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeIndoorPlan.hashCode()
    }
}

public fun NativeIndoorPlan.toCommon(): IndoorPlan {
    return IndoorPlan(this)
}
