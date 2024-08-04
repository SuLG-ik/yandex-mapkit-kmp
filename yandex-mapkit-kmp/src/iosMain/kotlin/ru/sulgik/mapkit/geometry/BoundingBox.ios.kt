package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKBoundingBox as NativeBoundingBox

public fun BoundingBox.toNative(): NativeBoundingBox {
    return NativeBoundingBox.boundingBoxWithSouthWest(
        southWest = southWest.toNative(),
        northEast = northEast.toNative(),
    )
}

public fun NativeBoundingBox.toCommon(): BoundingBox {
    return BoundingBox(
        southWest = southWest.toCommon(),
        northEast = northEast.toCommon(),
    )
}