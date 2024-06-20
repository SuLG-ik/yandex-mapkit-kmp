package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKBoundingBox as NativeBoundingBox

fun BoundingBox.toNative(): NativeBoundingBox {
    return NativeBoundingBox.boundingBoxWithSouthWest(
        southWest = southWest.toNative(),
        northEast = northEast.toNative(),
    )
}

fun NativeBoundingBox.toCommon(): BoundingBox {
    return BoundingBox(
        southWest = southWest.toCommon(),
        northEast = northEast.toCommon(),
    )
}