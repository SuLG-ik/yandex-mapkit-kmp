package ru.sulgik.mapkit.location

import YandexMapKit.YMKPurpose as NativeLocationPurpose

public fun LocationPurpose.toNative(): NativeLocationPurpose {
    return when (this) {
        LocationPurpose.GENERAL -> NativeLocationPurpose.YMKPurposeGeneral
        LocationPurpose.AUTOMOTIVE_NAVIGATION -> NativeLocationPurpose.YMKPurposeAutomotiveNavigation
        LocationPurpose.PEDESTRIAN_NAVIGATION -> NativeLocationPurpose.YMKPurposePedestrianNavigation
        LocationPurpose.BICYCLE_NAVIGATION -> NativeLocationPurpose.YMKPurposeBicycleNavigation
        LocationPurpose.SCOOTER_NAVIGATION -> NativeLocationPurpose.YMKPurposeScooterNavigation
    }
}

public fun NativeLocationPurpose.toCommon(): LocationPurpose {
    return when(this) {
        NativeLocationPurpose.YMKPurposeGeneral -> LocationPurpose.GENERAL
        NativeLocationPurpose.YMKPurposeAutomotiveNavigation -> LocationPurpose.AUTOMOTIVE_NAVIGATION
        NativeLocationPurpose.YMKPurposePedestrianNavigation -> LocationPurpose.PEDESTRIAN_NAVIGATION
        NativeLocationPurpose.YMKPurposeBicycleNavigation -> LocationPurpose.BICYCLE_NAVIGATION
        NativeLocationPurpose.YMKPurposeScooterNavigation -> LocationPurpose.SCOOTER_NAVIGATION
        else -> throw IllegalArgumentException("Unknown YMKPurpose ($this)")
    }
}