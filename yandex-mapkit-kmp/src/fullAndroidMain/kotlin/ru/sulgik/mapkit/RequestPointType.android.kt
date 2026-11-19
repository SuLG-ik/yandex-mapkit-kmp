package ru.sulgik.mapkit

import com.yandex.mapkit.RequestPointType as NativeRequestPointType

public fun RequestPointType.toNative(): NativeRequestPointType {
    return when (this) {
        RequestPointType.WAYPOINT -> NativeRequestPointType.WAYPOINT
        RequestPointType.VIAPOINT -> NativeRequestPointType.VIAPOINT
    }
}

public fun NativeRequestPointType.toCommon(): RequestPointType {
    return when (this) {
        NativeRequestPointType.WAYPOINT -> RequestPointType.WAYPOINT
        NativeRequestPointType.VIAPOINT -> RequestPointType.VIAPOINT
    }
}
