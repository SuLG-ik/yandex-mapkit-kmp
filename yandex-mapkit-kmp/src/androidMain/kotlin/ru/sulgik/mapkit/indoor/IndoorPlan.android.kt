package ru.sulgik.mapkit.indoor

import com.yandex.mapkit.indoor.IndoorPlan as NativeIndoorPlan

private class DeletingIndoorLevel(
    private val native: NativeIndoorPlan,
): IndoorPlan {
    override val levels: List<IndoorLevel>
        get() = native.levels.map { it.toCommon() }
    override var activeLevelId: String
        get() = native.activeLevelId
        set(value) {
            native.activeLevelId = value
        }
}

public fun NativeIndoorPlan.toCommon(): IndoorPlan {
    return DeletingIndoorLevel(this)
}