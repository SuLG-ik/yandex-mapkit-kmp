package ru.sulgik.mapkit.geometry.geo

import YandexMapKit.YMKPolylineIndexPriority as NativePriority

public fun Priority.toNative(): NativePriority {
    return when (this) {
        Priority.CLOSEST_TO_RAW_POINT -> NativePriority.YMKPolylineIndexPriorityClosestToRawPoint
        Priority.CLOSEST_TO_START -> NativePriority.YMKPolylineIndexPriorityClosestToStart
    }
}

public fun NativePriority.toCommon(): Priority {
    return when (this) {
        NativePriority.YMKPolylineIndexPriorityClosestToRawPoint -> Priority.CLOSEST_TO_RAW_POINT
        NativePriority.YMKPolylineIndexPriorityClosestToStart -> Priority.CLOSEST_TO_START
        else -> throw IllegalArgumentException("Unknown NativePriority ($this)")
    }
}
