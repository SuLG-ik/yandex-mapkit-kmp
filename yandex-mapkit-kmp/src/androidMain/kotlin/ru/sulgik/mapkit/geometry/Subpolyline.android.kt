package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Subpolyline as NativeSubpolyline

public fun Subpolyline.toNative(): NativeSubpolyline {
    return NativeSubpolyline(begin.toNative(), end.toNative())
}

public fun NativeSubpolyline.toCommon(): Subpolyline {
    return Subpolyline(begin.toCommon(), end.toCommon())
}