package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.IconStyle as NativeIconStyle

fun IconStyle.toNative(): NativeIconStyle {
    return NativeIconStyle(
        /* anchor = */ anchor?.toNative(),
        /* rotationType = */ rotationType?.toNative(),
        /* zIndex = */ zIndex,
        /* flat = */ flat,
        /* visible = */ isVisible,
        /* scale = */ scale,
        /* tappableArea = */ tappableArea?.toNative(),
    )
}

fun NativeIconStyle.toCommon(): IconStyle {
    return IconStyle(
        anchor = anchor?.toCommon(),
        rotationType = rotationType?.toCommon(),
        zIndex = zIndex,
        flat = flat,
        isVisible = visible,
        scale = scale,
        tappableArea = tappableArea?.toCommon()
    )
}