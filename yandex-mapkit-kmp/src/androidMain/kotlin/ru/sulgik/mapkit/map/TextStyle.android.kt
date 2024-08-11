package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.toColor
import ru.sulgik.mapkit.toArgb
import com.yandex.mapkit.map.TextStyle as NativeTextStyle

public fun TextStyle.toNative(): NativeTextStyle {
    return NativeTextStyle(
        size,
        color?.toArgb(),
        outlineWidth,
        outlineColor?.toArgb(),
        placement.toNative(),
        offset,
        offsetFromIcon,
        textOptional
    )
}

public fun NativeTextStyle.toCommon(): TextStyle {
    return TextStyle(
        size = size,
        color = color?.toColor(),
        outlineWidth = outlineWidth,
        outlineColor = outlineColor?.toColor(),
        placement = placement.toCommon(),
        offset = offset,
        offsetFromIcon = offsetFromIcon,
        textOptional = textOptional,
    )
}

public fun TextStyle.Placement.toNative(): NativeTextStyle.Placement {
    return when (this) {
        TextStyle.Placement.CENTER -> NativeTextStyle.Placement.CENTER
        TextStyle.Placement.LEFT -> NativeTextStyle.Placement.LEFT
        TextStyle.Placement.RIGHT -> NativeTextStyle.Placement.RIGHT
        TextStyle.Placement.TOP -> NativeTextStyle.Placement.TOP
        TextStyle.Placement.BOTTOM -> NativeTextStyle.Placement.BOTTOM
        TextStyle.Placement.TOP_LEFT -> NativeTextStyle.Placement.TOP_LEFT
        TextStyle.Placement.TOP_RIGHT -> NativeTextStyle.Placement.TOP_RIGHT
        TextStyle.Placement.BOTTOM_LEFT -> NativeTextStyle.Placement.BOTTOM_LEFT
        TextStyle.Placement.BOTTOM_RIGHT -> NativeTextStyle.Placement.BOTTOM_RIGHT
    }
}

public fun NativeTextStyle.Placement.toCommon(): TextStyle.Placement {
    return when (this) {
        NativeTextStyle.Placement.CENTER -> TextStyle.Placement.CENTER
        NativeTextStyle.Placement.LEFT -> TextStyle.Placement.LEFT
        NativeTextStyle.Placement.RIGHT -> TextStyle.Placement.RIGHT
        NativeTextStyle.Placement.TOP -> TextStyle.Placement.TOP
        NativeTextStyle.Placement.BOTTOM -> TextStyle.Placement.BOTTOM
        NativeTextStyle.Placement.TOP_LEFT -> TextStyle.Placement.TOP_LEFT
        NativeTextStyle.Placement.TOP_RIGHT -> TextStyle.Placement.TOP_RIGHT
        NativeTextStyle.Placement.BOTTOM_LEFT -> TextStyle.Placement.BOTTOM_LEFT
        NativeTextStyle.Placement.BOTTOM_RIGHT -> TextStyle.Placement.BOTTOM_RIGHT
    }
}