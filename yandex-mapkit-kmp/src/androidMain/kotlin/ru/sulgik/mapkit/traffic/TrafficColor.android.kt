package ru.sulgik.mapkit.traffic

import com.yandex.mapkit.traffic.TrafficColor as NativeTrafficColor

public fun TrafficColor.toNative(): NativeTrafficColor {
    return when (this) {
        TrafficColor.RED -> NativeTrafficColor.RED
        TrafficColor.YELLOW -> NativeTrafficColor.YELLOW
        TrafficColor.GREEN -> NativeTrafficColor.GREEN
    }
}

public fun NativeTrafficColor.toCommon(): TrafficColor {
    return when (this) {
        NativeTrafficColor.RED -> TrafficColor.RED
        NativeTrafficColor.YELLOW -> TrafficColor.YELLOW
        NativeTrafficColor.GREEN -> TrafficColor.GREEN
    }
}
