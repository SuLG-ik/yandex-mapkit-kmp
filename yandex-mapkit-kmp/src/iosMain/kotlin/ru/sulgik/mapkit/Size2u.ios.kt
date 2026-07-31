package ru.sulgik.mapkit

import YandexMapKit.YMKSize2u as NativeSize2u

public fun Size2u.toNative(): NativeSize2u {
    return NativeSize2u.size2uWithWidth(width = width.toULong(), height = height.toULong())
}

public fun NativeSize2u.toCommon(): Size2u {
    return Size2u(width = width.toInt(), height = height.toInt())
}
