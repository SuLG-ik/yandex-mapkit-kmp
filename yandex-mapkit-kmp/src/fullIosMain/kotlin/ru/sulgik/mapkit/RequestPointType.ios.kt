package ru.sulgik.mapkit

import YandexMapKit.YMKRequestPointType as NativeRequestPointType

public fun RequestPointType.toNative(): NativeRequestPointType {
    return when (this) {
        RequestPointType.WAYPOINT -> NativeRequestPointType.YMKRequestPointTypeWaypoint
        RequestPointType.VIAPOINT -> NativeRequestPointType.YMKRequestPointTypeViapoint
    }
}

public fun NativeRequestPointType.toCommon(): RequestPointType {
    return when (this) {
        NativeRequestPointType.YMKRequestPointTypeWaypoint -> RequestPointType.WAYPOINT
        NativeRequestPointType.YMKRequestPointTypeViapoint -> RequestPointType.VIAPOINT
        else -> throw IllegalArgumentException("Unknown NativeRequestPointType ($this)")
    }
}
