package ru.sulgik.mapkit

import com.yandex.mapkit.LocalizedValue as NativeLocalizedValue

public fun LocalizedValue.toNative(): NativeLocalizedValue {
    return NativeLocalizedValue(value, text)
}

public fun NativeLocalizedValue.toCommon(): LocalizedValue {
    return LocalizedValue(value = value, text = text)
}
