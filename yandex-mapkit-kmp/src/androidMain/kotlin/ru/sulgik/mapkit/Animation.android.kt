package ru.sulgik.mapkit

import kotlin.time.Duration.Companion.milliseconds
import com.yandex.mapkit.Animation as NativeAnimation

public fun Animation.toNative(): NativeAnimation {
    return NativeAnimation(type.toNative(), duration.inWholeMilliseconds / 1000f)
}

public fun NativeAnimation.toCommon(): Animation {
    return Animation(type.toCommon(), (duration * 1000).toLong().milliseconds)
}

public fun Animation.Type.toNative(): NativeAnimation.Type {
    return when (this) {
        Animation.Type.SMOOTH -> NativeAnimation.Type.SMOOTH
        Animation.Type.LINEAR -> NativeAnimation.Type.LINEAR
    }
}

public fun NativeAnimation.Type.toCommon(): Animation.Type {
    return when (this) {
        NativeAnimation.Type.SMOOTH -> Animation.Type.SMOOTH
        NativeAnimation.Type.LINEAR -> Animation.Type.LINEAR
    }
}