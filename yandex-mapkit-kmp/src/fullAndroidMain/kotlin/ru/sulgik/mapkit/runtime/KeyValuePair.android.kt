package ru.sulgik.mapkit.runtime

import com.yandex.runtime.KeyValuePair as NativeKeyValuePair

public fun KeyValuePair.toNative(): NativeKeyValuePair {
    return NativeKeyValuePair(key, value)
}

public fun NativeKeyValuePair.toCommon(): KeyValuePair {
    return KeyValuePair(key = key, value = value)
}
