package ru.sulgik.mapkit.user_location

import YandexMapKit.YMKUserLocationAnchorType as NativeUserLocationAnchorType

fun UserLocationAnchorType.toNative(): NativeUserLocationAnchorType {
    return when (this) {
        UserLocationAnchorType.NORMAL -> NativeUserLocationAnchorType.YMKUserLocationAnchorTypeNormal
        UserLocationAnchorType.COURSE -> NativeUserLocationAnchorType.YMKUserLocationAnchorTypeCourse
    }
}

fun NativeUserLocationAnchorType.toCommon(): UserLocationAnchorType {
    return when (this) {
        NativeUserLocationAnchorType.YMKUserLocationAnchorTypeNormal -> UserLocationAnchorType.NORMAL
        NativeUserLocationAnchorType.YMKUserLocationAnchorTypeCourse -> UserLocationAnchorType.COURSE
        else -> throw IllegalArgumentException("Unknown NativeUserLocationAnchorType ($this)")
    }
}