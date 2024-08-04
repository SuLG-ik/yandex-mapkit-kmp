package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKVisibleRegion as NativeVisibleRegion

public fun NativeVisibleRegion.toCommon(): VisibleRegion {
    return VisibleRegion(
        topLeft = topLeft.toCommon(),
        topRight = topRight.toCommon(),
        bottomLeft = bottomLeft.toCommon(),
        bottomRight = bottomRight.toCommon(),
    )
}

public fun VisibleRegion.toNative(): NativeVisibleRegion {
    return NativeVisibleRegion.visibleRegionWithTopLeft(
        topLeft = topLeft.toNative(),
        topRight = topRight.toNative(),
        bottomLeft = bottomLeft.toNative(),
        bottomRight = bottomRight.toNative(),
    )
}