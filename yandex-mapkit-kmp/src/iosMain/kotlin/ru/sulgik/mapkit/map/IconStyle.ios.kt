package ru.sulgik.mapkit.map

import YandexMapKit.YMKIconStyle
import platform.Foundation.NSNumber
import platform.Foundation.numberWithBool
import platform.Foundation.numberWithFloat
import platform.Foundation.numberWithInt

fun IconStyle.toNative(): YMKIconStyle {
    return YMKIconStyle.iconStyleWithAnchor(
        anchor = null,
        rotationType = rotationType?.ordinal?.let(NSNumber.Companion::numberWithInt),
        zIndex = zIndex?.let(NSNumber.Companion::numberWithFloat),
        flat = flat?.let(NSNumber.Companion::numberWithBool),
        visible = isVisible?.let(NSNumber.Companion::numberWithBool),
        scale = scale?.let(NSNumber.Companion::numberWithFloat),
        tappableArea = null,
    )
}

fun YMKIconStyle.toCommon(): IconStyle {
    return IconStyle(
        rotationType = rotationType?.let { RotationType.entries[it.intValue()] },
        zIndex = zIndex?.floatValue,
        flat = flat?.boolValue,
        isVisible = visible?.boolValue,
        scale = scale?.floatValue,
    )
}