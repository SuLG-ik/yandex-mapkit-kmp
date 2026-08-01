package ru.sulgik.mapkit.layers

import kotlin.time.Duration.Companion.milliseconds
import com.yandex.mapkit.layers.LayerOptions as NativeLayerOptions

public fun LayerOptions.toNative(): NativeLayerOptions {
    return NativeLayerOptions(
        active,
        nightModeAvailable,
        cacheable,
        animateOnActivation,
        tileAppearingAnimationDuration.inWholeMilliseconds,
        overzoomMode.toNative(),
        transparent,
        versionSupport,
    )
}

public fun NativeLayerOptions.toCommon(): LayerOptions {
    return LayerOptions(
        active = active,
        nightModeAvailable = nightModeAvailable,
        cacheable = cacheable,
        animateOnActivation = animateOnActivation,
        tileAppearingAnimationDuration = tileAppearingAnimationDuration.milliseconds,
        overzoomMode = overzoomMode.toCommon(),
        transparent = transparent,
        versionSupport = versionSupport,
    )
}
