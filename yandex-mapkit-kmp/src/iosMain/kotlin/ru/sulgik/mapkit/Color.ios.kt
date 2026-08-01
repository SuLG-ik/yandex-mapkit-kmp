package ru.sulgik.mapkit

import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.CoreGraphics.CGFloat
import platform.CoreGraphics.CGFloatVar
import platform.UIKit.UIColor
import kotlin.math.roundToInt

public fun Color.toNative(): UIColor {
    return UIColor.colorWithRed(
        red = ((value shr 16) and 0xff) / 255.0,
        green = ((value shr 8) and 0xff) / 255.0,
        blue = (value and 0xff) / 255.0,
        alpha = ((value shr 24) and 0xff) / 255.0,
    )
}

public fun UIColor.toCommon(): Color {
    return memScoped {
        val red = alloc<CGFloatVar>()
        val green = alloc<CGFloatVar>()
        val blue = alloc<CGFloatVar>()
        val alpha = alloc<CGFloatVar>()
        getRed(red = red.ptr, green = green.ptr, blue = blue.ptr, alpha = alpha.ptr)
        Color.fromArgb(
            (alpha.value.toColorChannel() shl 24) or
                (red.value.toColorChannel() shl 16) or
                (green.value.toColorChannel() shl 8) or
                blue.value.toColorChannel(),
        )
    }
}

private fun CGFloat.toColorChannel(): Int {
    return (this * 255).roundToInt().coerceIn(0, 255)
}
