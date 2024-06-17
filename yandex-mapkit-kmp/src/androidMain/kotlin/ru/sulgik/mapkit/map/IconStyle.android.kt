package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.IconStyle as NativeIconStyle

fun IconStyle.toNative(): NativeIconStyle {
    return NativeIconStyle(
        /* anchor = */ null,
        /* rotationType = */ rotationType?.toNative(),
        /* zIndex = */ zIndex,
        /* flat = */ flat,
        /* visible = */ isVisible,
        /* scale = */ scale,
        /* tappableArea = */ null
    )
}

fun NativeIconStyle.toCommon(): IconStyle {
    return IconStyle(
        rotationType = rotationType?.toCommon(),
        zIndex = zIndex,
        flat = flat,
        isVisible = visible,
        scale = scale
    )
}