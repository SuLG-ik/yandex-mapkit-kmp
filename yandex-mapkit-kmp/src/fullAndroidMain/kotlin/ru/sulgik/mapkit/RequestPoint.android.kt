package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.RequestPoint as NativeRequestPoint

public fun RequestPoint.toNative(): NativeRequestPoint {
    return NativeRequestPoint(
        point.toNative(),
        type.toNative(),
        pointContext,
        drivingArrivalPointId,
        indoorLevelId,
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
