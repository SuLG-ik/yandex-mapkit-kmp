package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationSubscriptionSettings as NativeSubscriptionSettings

public fun SubscriptionSettings.toNative(): NativeSubscriptionSettings {
    return NativeSubscriptionSettings.subscriptionSettingsWithUseInBackground(
        useInBackground.toNative(),
        purpose.toNative(),
    )
}

public fun NativeSubscriptionSettings.toCommon(): SubscriptionSettings {
    return SubscriptionSettings(
        useInBackground = useInBackground.toCommon(),
        purpose = purpose.toCommon(),
    )
}
