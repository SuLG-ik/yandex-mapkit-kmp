package ru.sulgik.mapkit.layers

import YandexMapKit.YMKOverzoomMode as NativeOverzoomMode

public fun OverzoomMode.toNative(): NativeOverzoomMode {
    return when (this) {
        OverzoomMode.DISABLED -> NativeOverzoomMode.YMKOverzoomModeDisabled
        OverzoomMode.ENABLED -> NativeOverzoomMode.YMKOverzoomModeEnabled
        OverzoomMode.WITH_PREFETCH -> NativeOverzoomMode.YMKOverzoomModeWithPrefetch
    }
}

public fun NativeOverzoomMode.toCommon(): OverzoomMode {
    return when (this) {
        NativeOverzoomMode.YMKOverzoomModeDisabled -> OverzoomMode.DISABLED
        NativeOverzoomMode.YMKOverzoomModeEnabled -> OverzoomMode.ENABLED
        NativeOverzoomMode.YMKOverzoomModeWithPrefetch -> OverzoomMode.WITH_PREFETCH
        else -> throw IllegalArgumentException("Unknown NativeOverzoomMode ($this)")
    }
}
