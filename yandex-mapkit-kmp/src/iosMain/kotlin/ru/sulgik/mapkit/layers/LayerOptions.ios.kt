package ru.sulgik.mapkit.layers

import kotlin.time.Duration.Companion.seconds
import YandexMapKit.YMKLayerOptions as NativeLayerOptions

public fun LayerOptions.toNative(): NativeLayerOptions {
    return NativeLayerOptions.layerOptionsWithActive(
        active = active,
        nightModeAvailable = nightModeAvailable,
        cacheable = cacheable,
        animateOnActivation = animateOnActivation,
        tileAppearingAnimationDuration = tileAppearingAnimationDuration.inWholeMilliseconds / 1000.0,
        overzoomMode = overzoomMode.toNative(),
        transparent = transparent,
        versionSupport = versionSupport,
    )
}

public fun NativeLayerOptions.toCommon(): LayerOptions {
    return LayerOptions(
        active = active,
        nightModeAvailable = nightModeAvailable,
        cacheable = cacheable,
        animateOnActivation = animateOnActivation,
        tileAppearingAnimationDuration = tileAppearingAnimationDuration.seconds,
        overzoomMode = overzoomMode.toCommon(),
        transparent = transparent,
        versionSupport = versionSupport,
    )
}
