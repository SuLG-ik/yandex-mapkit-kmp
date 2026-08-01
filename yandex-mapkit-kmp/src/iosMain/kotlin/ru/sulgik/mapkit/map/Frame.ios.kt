package ru.sulgik.mapkit.map

import kotlin.time.Duration.Companion.seconds
import YandexMapKit.YRTFrame as NativeFrame

public fun Frame.toNative(): NativeFrame {
    return NativeFrame(image.toNative(), duration.inWholeMilliseconds / 1000.0)
}

public fun NativeFrame.toCommon(): Frame {
    return Frame(
        image = ImageProvider.fromUIImage(requireNotNull(image())),
        duration = duration().seconds,
    )
}
