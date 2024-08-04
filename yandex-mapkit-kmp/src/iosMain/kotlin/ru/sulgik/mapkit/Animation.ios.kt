package ru.sulgik.mapkit

import kotlin.time.Duration.Companion.milliseconds
import YandexMapKit.YMKAnimation as NativeAnimation
import YandexMapKit.YMKAnimationType as NativeAnimationType


public fun NativeAnimation.toCommon(): Animation {
    return Animation(type = type.toCommon(), duration = (duration * 1000).toLong().milliseconds)
}

private fun NativeAnimationType.toCommon(): Animation.Type {
    return when (this) {
        NativeAnimationType.YMKAnimationTypeLinear -> Animation.Type.LINEAR
        NativeAnimationType.YMKAnimationTypeSmooth -> Animation.Type.SMOOTH
        else -> throw IllegalArgumentException("Unknown NativeAnimationType ($this)")
    }
}

public fun Animation.toNative(): NativeAnimation {
    return NativeAnimation.animationWithType(
        type = type.toNative(),
        duration = duration.inWholeMilliseconds / 1000f
    )
}

private fun Animation.Type.toNative(): NativeAnimationType {
    return when (this) {
        Animation.Type.SMOOTH -> NativeAnimationType.YMKAnimationTypeSmooth
        Animation.Type.LINEAR -> NativeAnimationType.YMKAnimationTypeLinear
    }
}
