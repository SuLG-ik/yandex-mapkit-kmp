package ru.sulgik.mapkit

import com.yandex.mapkit.ZoomRange as NativeZoomRange

public fun ZoomRange.toNative(): NativeZoomRange {
    return NativeZoomRange(zMin, zMax)
}

public fun NativeZoomRange.toCommon(): ZoomRange {
    return ZoomRange(zMin = zMin, zMax = zMax)
}
