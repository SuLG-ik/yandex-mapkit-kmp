package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKRequestPoint as NativeRequestPoint

public fun RequestPoint.toNative(): NativeRequestPoint {
    return NativeRequestPoint.requestPointWithPoint(
        point = point.toNative(),
        type = type.toNative(),
        pointContext = pointContext,
        drivingArrivalPointId = drivingArrivalPointId,
        indoorLevelId = indoorLevelId,
    )
}

public fun NativeRequestPoint.toCommon(): RequestPoint {
    return RequestPoint(
        point = point.toCommon(),
        type = type.toCommon(),
        pointContext = pointContext,
        drivingArrivalPointId = drivingArrivalPointId,
        indoorLevelId = indoorLevelId,
    )
}
