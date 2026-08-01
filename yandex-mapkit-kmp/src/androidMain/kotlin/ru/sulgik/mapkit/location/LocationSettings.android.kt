package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.LocationSettings as NativeLocationSettings
import com.yandex.mapkit.location.LocationSettingsFactory as NativeLocationSettingsFactory

public fun LocationSettings.toNative(): NativeLocationSettings {
    return NativeLocationSettings(
        provideAccuracy,
        accuracy?.toNative(),
        locationTimeInterval?.toNative(),
        provideSpeed,
        speed,
        provideHeading,
        headingError?.toNative(),
        locationError?.toNative(),
        provideWheelSpeed,
        wheelSpeedTimeInterval?.toNative(),
    )
}

public fun NativeLocationSettings.toCommon(): LocationSettings {
    return LocationSettings(
        provideAccuracy = provideAccuracy,
        accuracy = accuracy?.toCommon(),
        locationTimeInterval = locationTimeInterval?.toCommon(),
        provideSpeed = provideSpeed,
        speed = speed,
        provideHeading = provideHeading,
        headingError = headingError?.toCommon(),
        locationError = locationError?.toCommon(),
        provideWheelSpeed = provideWheelSpeed,
        wheelSpeedTimeInterval = wheelSpeedTimeInterval?.toCommon(),
    )
}

public actual fun LocationSettings.Companion.fineSettings(): LocationSettings {
    return NativeLocationSettingsFactory.fineSettings().toCommon()
}

public actual fun LocationSettings.Companion.coarseSettings(): LocationSettings {
    return NativeLocationSettingsFactory.coarseSettings().toCommon()
}
