package ru.sulgik.mapkit.traffic

import YandexMapKit.YMKTrafficLevel as NativeTrafficLevel

public fun TrafficLevel.toNative(): NativeTrafficLevel {
    return NativeTrafficLevel.trafficLevelWithColor(
        color = color.toNative(),
        level = level.toLong(),
    )
}

public fun NativeTrafficLevel.toCommon(): TrafficLevel {
    return TrafficLevel(color = color.toCommon(), level = level.toInt())
}
