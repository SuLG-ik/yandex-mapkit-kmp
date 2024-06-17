package ru.sulgik.mapkit

import com.yandex.mapkit.map.Arrow
import kotlin.time.Duration.Companion.milliseconds
import com.yandex.mapkit.Animation as NativeAnimation

fun Animation.toNative(): NativeAnimation {
    return NativeAnimation(type.toNative(), duration.inWholeMilliseconds / 1000f)
}

fun NativeAnimation.toCommon(): Animation {
    return Animation(type.toCommon(), (duration * 1000).toLong().milliseconds)
}

fun Animation.Type.toNative(): NativeAnimation.Type {
    return when (this) {
        Animation.Type.SMOOTH -> NativeAnimation.Type.SMOOTH
        Animation.Type.LINEAR -> NativeAnimation.Type.LINEAR
    }
}

fun NativeAnimation.Type.toCommon(): Animation.Type {
    return when (this) {
        NativeAnimation.Type.SMOOTH -> Animation.Type.SMOOTH
        NativeAnimation.Type.LINEAR -> Animation.Type.LINEAR
    }
}