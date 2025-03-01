package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.Purpose as NativeLocationPurpose

public fun LocationPurpose.toNative(): NativeLocationPurpose {
    return when (this) {
        LocationPurpose.GENERAL -> NativeLocationPurpose.GENERAL
        LocationPurpose.AUTOMOTIVE_NAVIGATION -> NativeLocationPurpose.AUTOMOTIVE_NAVIGATION
        LocationPurpose.PEDESTRIAN_NAVIGATION -> NativeLocationPurpose.PEDESTRIAN_NAVIGATION
        LocationPurpose.BICYCLE_NAVIGATION -> NativeLocationPurpose.BICYCLE_NAVIGATION
        LocationPurpose.SCOOTER_NAVIGATION -> NativeLocationPurpose.SCOOTER_NAVIGATION
    }
}

public fun NativeLocationPurpose.toCommon(): LocationPurpose {
    return when (this) {
        NativeLocationPurpose.GENERAL -> LocationPurpose.GENERAL
        NativeLocationPurpose.AUTOMOTIVE_NAVIGATION -> LocationPurpose.AUTOMOTIVE_NAVIGATION
        NativeLocationPurpose.PEDESTRIAN_NAVIGATION -> LocationPurpose.PEDESTRIAN_NAVIGATION
        NativeLocationPurpose.BICYCLE_NAVIGATION -> LocationPurpose.BICYCLE_NAVIGATION
        NativeLocationPurpose.SCOOTER_NAVIGATION -> LocationPurpose.SCOOTER_NAVIGATION
    }
}