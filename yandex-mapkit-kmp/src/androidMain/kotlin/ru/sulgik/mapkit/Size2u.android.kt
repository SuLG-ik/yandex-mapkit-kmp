package ru.sulgik.mapkit

import com.yandex.mapkit.Size2u as NativeSize2u

public fun Size2u.toNative(): NativeSize2u {
    return NativeSize2u(width, height)
}

public fun NativeSize2u.toCommon(): Size2u {
    return Size2u(width = width, height = height)
}
