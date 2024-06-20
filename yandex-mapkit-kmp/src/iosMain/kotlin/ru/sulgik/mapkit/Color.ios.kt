package ru.sulgik.mapkit

import platform.UIKit.UIColor

fun Color.toNative(): UIColor {
    return UIColor.colorWithRed(
        red = ((value shr 16) and 0xff) / 255.0,
        green = ((value shr 8) and 0xff) / 255.0,
        blue = (value and 0xff) / 255.0,
        alpha = ((value shr 24) and 0xff) / 255.0,
    )
}

fun UIColor.toCommon(): Color {
    val red = (CIColor.red * 255).toInt()
    val green = (CIColor.green * 255).toInt()
    val blue = (CIColor.blue * 255).toInt()
    val alpha = (CIColor.alpha * 255).toInt()
    return Color(
        value = (alpha shl 24) or (red shl 16) or (green shl 8) or (blue)
    )
}