package ru.sulgik.mapkit

import YandexMapKit.YMKLocalizedValue as NativeLocalizedValue

public fun LocalizedValue.toNative(): NativeLocalizedValue {
    return NativeLocalizedValue.localizedValueWithValue(value = value, text = text)
}

public fun NativeLocalizedValue.toCommon(): LocalizedValue {
    return LocalizedValue(value = value, text = text)
}
