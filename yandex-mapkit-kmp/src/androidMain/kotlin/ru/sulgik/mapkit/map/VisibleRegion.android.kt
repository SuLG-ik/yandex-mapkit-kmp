package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.map.VisibleRegion as NativeVisibleRegion

public fun VisibleRegion.toNative(): NativeVisibleRegion {
    return NativeVisibleRegion(
        topLeft.toNative(),
        topRight.toNative(),
        bottomLeft.toNative(),
        bottomRight.toNative()
    )
}

public fun NativeVisibleRegion.toCommon(): VisibleRegion {
    return VisibleRegion(
        topLeft = topLeft.toCommon(),
        topRight = topRight.toCommon(),
        bottomLeft = bottomLeft.toCommon(),
        bottomRight = bottomRight.toCommon()
    )
}