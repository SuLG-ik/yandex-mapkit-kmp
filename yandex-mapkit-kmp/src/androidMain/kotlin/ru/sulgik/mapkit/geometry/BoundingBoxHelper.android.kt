package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.BoundingBoxHelper as NativeBoundingBoxHelper

public actual fun BoundingBox.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

public actual fun Point.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

public actual fun Polyline.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

public actual fun LinearRing.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

public actual fun Polygon.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

public actual fun BoundingBox.getBounds(second: BoundingBox): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative(), second.toNative()).toCommon()
}
