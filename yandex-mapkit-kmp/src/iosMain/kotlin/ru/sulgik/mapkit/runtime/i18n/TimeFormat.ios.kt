package ru.sulgik.mapkit.runtime.i18n

import YandexMapKit.YRTTimeFormat as NativeTimeFormat

public fun TimeFormat.toNative(): NativeTimeFormat {
    return when (this) {
        TimeFormat.DEFAULT -> NativeTimeFormat.YRTTimeFormatDefault
        TimeFormat.H24 -> NativeTimeFormat.YRTTimeFormatH24
        TimeFormat.H12 -> NativeTimeFormat.YRTTimeFormatH12
    }
}

public fun NativeTimeFormat.toCommon(): TimeFormat {
    return when (this) {
        NativeTimeFormat.YRTTimeFormatDefault -> TimeFormat.DEFAULT
        NativeTimeFormat.YRTTimeFormatH24 -> TimeFormat.H24
        NativeTimeFormat.YRTTimeFormatH12 -> TimeFormat.H12
        else -> throw IllegalArgumentException("Unknown NativeTimeFormat ($this)")
    }
}
