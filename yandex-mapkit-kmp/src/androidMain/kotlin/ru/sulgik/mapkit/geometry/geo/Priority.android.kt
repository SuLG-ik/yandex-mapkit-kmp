package ru.sulgik.mapkit.geometry.geo

import com.yandex.mapkit.geometry.geo.PolylineIndex as NativePolylineIndex

public fun Priority.toNative(): NativePolylineIndex.Priority {
    return when (this) {
        Priority.CLOSEST_TO_RAW_POINT -> NativePolylineIndex.Priority.CLOSEST_TO_RAW_POINT
        Priority.CLOSEST_TO_START -> NativePolylineIndex.Priority.CLOSEST_TO_START
    }
}

public fun NativePolylineIndex.Priority.toCommon(): Priority {
    return when (this) {
        NativePolylineIndex.Priority.CLOSEST_TO_RAW_POINT -> Priority.CLOSEST_TO_RAW_POINT
        NativePolylineIndex.Priority.CLOSEST_TO_START -> Priority.CLOSEST_TO_START
    }
}
