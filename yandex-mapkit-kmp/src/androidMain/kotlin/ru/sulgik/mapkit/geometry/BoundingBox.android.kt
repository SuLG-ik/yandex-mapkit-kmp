package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.BoundingBox as NativeBoundingBox

fun BoundingBox.toNative(): NativeBoundingBox {
    return NativeBoundingBox(southWest.toNative(), northEast.toNative())
}

fun NativeBoundingBox.toCommon(): BoundingBox {
    return BoundingBox(
        southWest = southWest.toCommon(),
        northEast = northEast.toCommon(),
    )
}