package ru.sulgik.mapkit.indoor

import YandexMapKit.YMKIndoorLevel as NativeIndoorLevel

public fun IndoorLevel.toNative(): NativeIndoorLevel {
    return NativeIndoorLevel.indoorLevelWithId(
        id = id,
        name = name,
        isUnderground = isUnderground,
    )
}

public fun NativeIndoorLevel.toCommon(): IndoorLevel {
    return IndoorLevel(
        id = id,
        name = name,
        isUnderground = isUnderground,
    )
}