package ru.sulgik.mapkit.sample

import coil3.request.ImageRequest

actual fun ImageRequest.Builder.allowHardware(enabled: Boolean): ImageRequest.Builder {
    return this
}