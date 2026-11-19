package ru.sulgik.mapkit.directions.driving

import YandexMapKit.YMKDrivingRouterType as NativeDrivingRouterType

public fun DrivingRouterType.toNative(): NativeDrivingRouterType {
    return when (this) {
        DrivingRouterType.ONLINE -> NativeDrivingRouterType.YMKDrivingRouterTypeOnline
        DrivingRouterType.OFFLINE -> NativeDrivingRouterType.YMKDrivingRouterTypeOffline
        DrivingRouterType.COMBINED -> NativeDrivingRouterType.YMKDrivingRouterTypeCombined
    }
}

public fun NativeDrivingRouterType.toCommon(): DrivingRouterType {
    return when (this) {
        NativeDrivingRouterType.YMKDrivingRouterTypeOnline -> DrivingRouterType.ONLINE
        NativeDrivingRouterType.YMKDrivingRouterTypeOffline -> DrivingRouterType.OFFLINE
        NativeDrivingRouterType.YMKDrivingRouterTypeCombined -> DrivingRouterType.COMBINED
        else -> throw IllegalArgumentException("Unknown NativeDrivingRouterType ($this)")
    }
}
