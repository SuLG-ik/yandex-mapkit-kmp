package ru.sulgik.mapkit.traffic

import YandexMapKit.YMKTrafficColor as NativeTrafficColor

public fun TrafficColor.toNative(): NativeTrafficColor {
    return when (this) {
        TrafficColor.RED -> NativeTrafficColor.YMKTrafficColorRed
        TrafficColor.YELLOW -> NativeTrafficColor.YMKTrafficColorYellow
        TrafficColor.GREEN -> NativeTrafficColor.YMKTrafficColorGreen
    }
}

public fun NativeTrafficColor.toCommon(): TrafficColor {
    return when (this) {
        NativeTrafficColor.YMKTrafficColorRed -> TrafficColor.RED
        NativeTrafficColor.YMKTrafficColorYellow -> TrafficColor.YELLOW
        NativeTrafficColor.YMKTrafficColorGreen -> TrafficColor.GREEN
        else -> throw IllegalArgumentException("Unknown NativeTrafficColor ($this)")
    }
}
