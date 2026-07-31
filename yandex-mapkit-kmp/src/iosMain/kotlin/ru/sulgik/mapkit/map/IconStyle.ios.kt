package ru.sulgik.mapkit.map

import platform.Foundation.NSValue
import platform.UIKit.valueWithCGPoint
import ru.sulgik.mapkit.toNSNumber
import ru.sulgik.mapkit.toNative
import ru.sulgik.mapkit.toPointF
import YandexMapKit.YMKIconStyle as NativeIconStyle
import YandexMapKit.YMKRotationType as NativeRotationType

public fun IconStyle.toNative(): NativeIconStyle {
    return NativeIconStyle.iconStyleWithAnchor(
        anchor = anchor?.let { NSValue.valueWithCGPoint(it.toNative()) },
        rotationType = rotationType?.toNative()?.value?.toLong()?.toNSNumber(),
        zIndex = zIndex?.toNSNumber(),
        flat = flat?.toNSNumber(),
        visible = isVisible?.toNSNumber(),
        scale = scale?.toNSNumber(),
        opacity = opacity,
        tappableArea = tappableArea?.toNative(),
    )
}

public fun NativeIconStyle.toCommon(): IconStyle {
    return IconStyle(
        anchor = anchor?.toPointF(),
        rotationType = rotationType?.let { NativeRotationType.byValue(it.unsignedLongValue).toCommon() },
        zIndex = zIndex?.floatValue,
        flat = flat?.boolValue,
        isVisible = visible?.boolValue,
        scale = scale?.floatValue,
        opacity = opacity,
        tappableArea = tappableArea?.toCommon(),
    )
}
