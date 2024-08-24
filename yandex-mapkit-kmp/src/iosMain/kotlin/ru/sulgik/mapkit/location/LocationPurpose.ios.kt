package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationPurpose

public fun LocationPurpose.toNative(): YMKLocationPurpose {
    return when (this) {
        LocationPurpose.GENERAL -> YMKLocationPurpose.YMKLocationPurposeGeneral
        LocationPurpose.NAVIGATION -> YMKLocationPurpose.YMKLocationPurposeNavigation
    }
}