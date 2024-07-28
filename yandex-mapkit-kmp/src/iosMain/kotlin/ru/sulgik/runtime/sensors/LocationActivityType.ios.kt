package ru.sulgik.runtime.sensors

import YandexMapKit.YRTLocationActivityType as NativeLocationActivityType


fun LocationActivityType.toNative(): NativeLocationActivityType {
    return when (this) {
        LocationActivityType.AUTO_DETECT -> NativeLocationActivityType.YRTLocationActivityTypeAutoDetect
        LocationActivityType.CAR -> NativeLocationActivityType.YRTLocationActivityTypeCar
        LocationActivityType.PEDESTRIAN -> NativeLocationActivityType.YRTLocationActivityTypePedestrian
        LocationActivityType.OTHER -> NativeLocationActivityType.YRTLocationActivityTypeOther
    }
}

fun NativeLocationActivityType.toCommon(): LocationActivityType {
    return when (this) {
        NativeLocationActivityType.YRTLocationActivityTypeOther -> LocationActivityType.OTHER
        NativeLocationActivityType.YRTLocationActivityTypeCar -> LocationActivityType.CAR
        NativeLocationActivityType.YRTLocationActivityTypePedestrian -> LocationActivityType.PEDESTRIAN
        NativeLocationActivityType.YRTLocationActivityTypeAutoDetect -> LocationActivityType.AUTO_DETECT
        else -> throw IllegalArgumentException("Unknown NativeLocationActivityType ($this)")
    }
}