package ru.sulgik.mapkit.indoor

import YandexMapKit.YMKIndoorLevel as NativeIndoorLevel
import YandexMapKit.YMKIndoorPlan as NativeIndoorPlan

public actual class IndoorPlan internal constructor(private val nativeIndoorPlan: NativeIndoorPlan) {

    public fun toNative(): NativeIndoorPlan {
        return nativeIndoorPlan
    }

    /**
     * List of all levels in indoor plan, from bottom to top.
     */
    public actual val levels: List<IndoorLevel>
        @Suppress("UNCHECKED_CAST")
        get() = (nativeIndoorPlan.levels as List<NativeIndoorLevel>).map { it.toCommon() }

    /**
     * Gets/sets active id
     */
    public actual var activeLevelId: String
        get() = nativeIndoorPlan.activeLevelId
        set(value) {
            nativeIndoorPlan.activeLevelId = value
        }
}

public fun NativeIndoorPlan.toCommon(): IndoorPlan {
    return IndoorPlan(this)
}
