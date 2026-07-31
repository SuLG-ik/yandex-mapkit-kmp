package ru.sulgik.mapkit.map

import kotlin.time.Duration.Companion.milliseconds
import com.yandex.runtime.image.Frame as NativeFrame

public fun Frame.toNative(): NativeFrame {
    return NativeFrame(image.toNative(), duration.inWholeMilliseconds)
}

public fun NativeFrame.toCommon(): Frame {
    return Frame(
        image = image.toCommon(),
        duration = duration.milliseconds,
    )
}
