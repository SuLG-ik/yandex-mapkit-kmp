package ru.sulgik.mapkit.sample

import coil3.request.ImageRequest
import coil3.request.allowHardware

actual fun ImageRequest.Builder.allowHardware(enabled: Boolean): ImageRequest.Builder {
    return allowHardware(enabled)
}