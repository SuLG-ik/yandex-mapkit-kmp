package ru.sulgik.mapkit.traffic

import com.yandex.mapkit.traffic.TrafficLevel as NativeTrafficLevel

public fun TrafficLevel.toNative(): NativeTrafficLevel {
    return NativeTrafficLevel(color.toNative(), level)
}

public fun NativeTrafficLevel.toCommon(): TrafficLevel {
    return TrafficLevel(color = color.toCommon(), level = level)
}
