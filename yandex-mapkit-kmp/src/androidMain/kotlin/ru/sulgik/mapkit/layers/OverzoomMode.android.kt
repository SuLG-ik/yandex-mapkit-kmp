package ru.sulgik.mapkit.layers

import com.yandex.mapkit.layers.OverzoomMode as NativeOverzoomMode

public fun OverzoomMode.toNative(): NativeOverzoomMode {
    return when (this) {
        OverzoomMode.DISABLED -> NativeOverzoomMode.DISABLED
        OverzoomMode.ENABLED -> NativeOverzoomMode.ENABLED
        OverzoomMode.WITH_PREFETCH -> NativeOverzoomMode.WITH_PREFETCH
    }
}

public fun NativeOverzoomMode.toCommon(): OverzoomMode {
    return when (this) {
        NativeOverzoomMode.DISABLED -> OverzoomMode.DISABLED
        NativeOverzoomMode.ENABLED -> OverzoomMode.ENABLED
        NativeOverzoomMode.WITH_PREFETCH -> OverzoomMode.WITH_PREFETCH
    }
}
