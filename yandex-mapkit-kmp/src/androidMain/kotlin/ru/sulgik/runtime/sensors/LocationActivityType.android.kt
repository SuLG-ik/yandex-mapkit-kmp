package ru.sulgik.runtime.sensors

import com.yandex.runtime.sensors.LocationActivityType as NativeLocationActivityType

fun LocationActivityType.toNative(): NativeLocationActivityType {
    return when (this) {
        LocationActivityType.AUTO_DETECT -> NativeLocationActivityType.AUTO_DETECT
        LocationActivityType.CAR -> NativeLocationActivityType.CAR
        LocationActivityType.PEDESTRIAN -> NativeLocationActivityType.PEDESTRIAN
        LocationActivityType.OTHER -> NativeLocationActivityType.OTHER
    }
}

fun NativeLocationActivityType.toCommon(): LocationActivityType {
    return when (this) {
        NativeLocationActivityType.AUTO_DETECT -> LocationActivityType.AUTO_DETECT
        NativeLocationActivityType.CAR -> LocationActivityType.CAR
        NativeLocationActivityType.PEDESTRIAN -> LocationActivityType.PEDESTRIAN
        NativeLocationActivityType.OTHER -> LocationActivityType.OTHER
    }
}