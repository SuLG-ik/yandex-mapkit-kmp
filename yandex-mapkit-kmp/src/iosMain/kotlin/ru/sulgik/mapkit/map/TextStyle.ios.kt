package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKTextStyle as NativeTextStyle
import YandexMapKit.YMKTextStylePlacement as NativeTextStylePlacement

public fun TextStyle.toNative(): NativeTextStyle {
    return NativeTextStyle.textStyleWithSize(
        size = size,
        color = color.toNative(),
        outlineWidth = outlineWidth,
        outlineColor = outlineColor.toNative(),
        placement = placement.toNative(),
        offset = offset,
        offsetFromIcon = offsetFromIcon,
        textOptional = textOptional
    )
}

public fun NativeTextStyle.toCommon(): TextStyle {
    return TextStyle(
        size = size,
        color = color.toCommon(),
        outlineWidth = outlineWidth,
        outlineColor = outlineColor.toCommon(),
        placement = placement.toCommon(),
        offset = offset,
        offsetFromIcon = offsetFromIcon,
        textOptional = textOptional,
    )
}

public fun NativeTextStylePlacement.toCommon(): TextStyle.Placement {
    return when (this) {
        NativeTextStylePlacement.YMKTextStylePlacementTopRight -> TextStyle.Placement.TOP_RIGHT
        NativeTextStylePlacement.YMKTextStylePlacementLeft -> TextStyle.Placement.LEFT
        NativeTextStylePlacement.YMKTextStylePlacementBottomRight -> TextStyle.Placement.BOTTOM_RIGHT
        NativeTextStylePlacement.YMKTextStylePlacementTop -> TextStyle.Placement.TOP
        NativeTextStylePlacement.YMKTextStylePlacementBottom -> TextStyle.Placement.BOTTOM
        NativeTextStylePlacement.YMKTextStylePlacementBottomLeft -> TextStyle.Placement.BOTTOM_LEFT
        NativeTextStylePlacement.YMKTextStylePlacementTopLeft -> TextStyle.Placement.TOP_LEFT
        NativeTextStylePlacement.YMKTextStylePlacementRight -> TextStyle.Placement.RIGHT
        NativeTextStylePlacement.YMKTextStylePlacementCenter -> TextStyle.Placement.CENTER
        else -> throw IllegalArgumentException("Unknown NativeTextStylePlacement ($this)")
    }
}

public fun TextStyle.Placement.toNative(): NativeTextStylePlacement {
    return when (this) {
        TextStyle.Placement.CENTER -> NativeTextStylePlacement.YMKTextStylePlacementCenter
        TextStyle.Placement.LEFT -> NativeTextStylePlacement.YMKTextStylePlacementLeft
        TextStyle.Placement.RIGHT -> NativeTextStylePlacement.YMKTextStylePlacementRight
        TextStyle.Placement.TOP -> NativeTextStylePlacement.YMKTextStylePlacementTop
        TextStyle.Placement.BOTTOM -> NativeTextStylePlacement.YMKTextStylePlacementBottom
        TextStyle.Placement.TOP_LEFT -> NativeTextStylePlacement.YMKTextStylePlacementTopLeft
        TextStyle.Placement.TOP_RIGHT -> NativeTextStylePlacement.YMKTextStylePlacementTopRight
        TextStyle.Placement.BOTTOM_LEFT -> NativeTextStylePlacement.YMKTextStylePlacementBottomLeft
        TextStyle.Placement.BOTTOM_RIGHT -> NativeTextStylePlacement.YMKTextStylePlacementBottomRight
    }
}