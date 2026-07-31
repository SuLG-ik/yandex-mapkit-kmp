package ru.sulgik.mapkit.uri

import YandexMapKit.YMKUri as NativeUri

public fun Uri.toNative(): NativeUri {
    return NativeUri.uriWithValue(value)
}

public fun NativeUri.toCommon(): Uri {
    return Uri(value = value)
}
