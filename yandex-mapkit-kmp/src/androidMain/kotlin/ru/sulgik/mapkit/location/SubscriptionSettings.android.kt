package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.SubscriptionSettings as NativeSubscriptionSettings

public fun SubscriptionSettings.toNative(): NativeSubscriptionSettings {
    return NativeSubscriptionSettings(
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
