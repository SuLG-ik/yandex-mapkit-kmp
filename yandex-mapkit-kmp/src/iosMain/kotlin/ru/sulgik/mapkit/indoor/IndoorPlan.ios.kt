package ru.sulgik.mapkit.indoor

import YandexMapKit.YMKIndoorPlan as NativeIndoorPlan
import YandexMapKit.YMKIndoorLevel as NativeIndoorLevel

private class DeletingIndoorLevel(
    private val native: NativeIndoorPlan,
): IndoorPlan {
    override val levels: List<IndoorLevel>
        get() = native.levels.map { (it as NativeIndoorLevel) .toCommon() }
    override var activeLevelId: String
        get() = native.activeLevelId
        set(value) {
            native.activeLevelId = value
        }
}

public fun NativeIndoorPlan.toCommon(): IndoorPlan {
    return DeletingIndoorLevel(this)
}