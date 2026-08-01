package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationSettings as NativeLocationSettings
import YandexMapKit.YMKLocationSettingsFactory as NativeLocationSettingsFactory

public fun LocationSettings.toNative(): NativeLocationSettings {
    return NativeLocationSettings.locationSettingsWithProvideAccuracy(
        provideAccuracy = provideAccuracy,
        accuracy = accuracy?.toNative(),
        locationTimeInterval = locationTimeInterval?.toNative(),
        provideSpeed = provideSpeed,
        speed = speed,
        provideHeading = provideHeading,
        headingError = headingError?.toNative(),
        locationError = locationError?.toNative(),
        provideWheelSpeed = provideWheelSpeed,
        wheelSpeedTimeInterval = wheelSpeedTimeInterval?.toNative(),
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

/**
 * The settings of a high accuracy location source.
 */
public actual fun LocationSettings.Companion.fineSettings(): LocationSettings {
    return NativeLocationSettingsFactory.fineSettings().toCommon()
}

/**
 * The settings of a low accuracy location source.
 */
public actual fun LocationSettings.Companion.coarseSettings(): LocationSettings {
    return NativeLocationSettingsFactory.coarseSettings().toCommon()
}
