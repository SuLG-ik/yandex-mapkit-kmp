package ru.sulgik.mapkit.indoor

import com.yandex.mapkit.indoor.IndoorLevel as NativeIndoorLevel

public fun IndoorLevel.toNative(): NativeIndoorLevel {
    return NativeIndoorLevel(
        id,
        name,
        isUnderground,
    )
}

public fun NativeIndoorLevel.toCommon(): IndoorLevel {
    return IndoorLevel(
        id = id,
        name = name,
        isUnderground = isUnderground,
    )
}