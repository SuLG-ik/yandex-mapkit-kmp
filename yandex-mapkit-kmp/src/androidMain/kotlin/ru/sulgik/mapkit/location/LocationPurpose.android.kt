package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.Purpose as NativePurpose

public fun LocationPurpose.toNative(): NativePurpose {
    return when (this) {
        LocationPurpose.GENERAL -> NativePurpose.GENERAL
        LocationPurpose.NAVIGATION -> NativePurpose.NAVIGATION
    }
}

public fun NativePurpose.toCommon(): LocationPurpose {
    return when (this) {
        NativePurpose.GENERAL -> LocationPurpose.GENERAL
        NativePurpose.NAVIGATION -> LocationPurpose.NAVIGATION
    }
}