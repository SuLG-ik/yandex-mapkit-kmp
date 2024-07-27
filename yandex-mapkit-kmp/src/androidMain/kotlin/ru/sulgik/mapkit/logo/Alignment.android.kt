package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.Alignment as NativeAlignment

fun Alignment.toNative() : NativeAlignment {
    return NativeAlignment(horizontalAlignment.toNative(), verticalAlignment.toNative())
}

fun NativeAlignment.toCommon(): Alignment {
    return Alignment(
        horizontalAlignment = horizontalAlignment.toCommon(),
        verticalAlignment = verticalAlignment.toCommon(),
    )
}