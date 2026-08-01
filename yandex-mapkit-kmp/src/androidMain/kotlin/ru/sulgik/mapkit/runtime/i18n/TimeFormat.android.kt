package ru.sulgik.mapkit.runtime.i18n

import com.yandex.runtime.i18n.TimeFormat as NativeTimeFormat

public fun TimeFormat.toNative(): NativeTimeFormat {
    return when (this) {
        TimeFormat.DEFAULT -> NativeTimeFormat.DEFAULT
        TimeFormat.H24 -> NativeTimeFormat.H24
        TimeFormat.H12 -> NativeTimeFormat.H12
    }
}

public fun NativeTimeFormat.toCommon(): TimeFormat {
    return when (this) {
        NativeTimeFormat.DEFAULT -> TimeFormat.DEFAULT
        NativeTimeFormat.H24 -> TimeFormat.H24
        NativeTimeFormat.H12 -> TimeFormat.H12
    }
}
