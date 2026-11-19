package ru.sulgik.mapkit.runtime

import YandexMapKit.YRTKeyValuePair as NativeKeyValuePair

public fun KeyValuePair.toNative(): NativeKeyValuePair {
    return NativeKeyValuePair.keyValuePairWithKey(key = key, value = value)
}

public fun NativeKeyValuePair.toCommon(): KeyValuePair {
    return KeyValuePair(key = key, value = value)
}
