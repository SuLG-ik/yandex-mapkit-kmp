package ru.sulgik.mapkit.directions.driving

import com.yandex.mapkit.directions.driving.DrivingRouterType as NativeDrivingRouterType

public fun DrivingRouterType.toNative(): NativeDrivingRouterType {
    return when (this) {
        DrivingRouterType.ONLINE -> NativeDrivingRouterType.ONLINE
        DrivingRouterType.OFFLINE -> NativeDrivingRouterType.OFFLINE
        DrivingRouterType.COMBINED -> NativeDrivingRouterType.COMBINED
    }
}

public fun NativeDrivingRouterType.toCommon(): DrivingRouterType {
    return when (this) {
        NativeDrivingRouterType.ONLINE -> DrivingRouterType.ONLINE
        NativeDrivingRouterType.OFFLINE -> DrivingRouterType.OFFLINE
        NativeDrivingRouterType.COMBINED -> DrivingRouterType.COMBINED
    }
}
