package ru.sulgik.mapkit

import com.yandex.mapkit.Image as NativeImage

public fun Image.toNative(): NativeImage {
    return NativeImage(urlTemplate, sizes.map { it.toNative() }, tags)
}

public fun NativeImage.toCommon(): Image {
    return Image(
        urlTemplate = urlTemplate,
        sizes = sizes.map { it.toCommon() },
        tags = tags,
    )
}

public fun Image.ImageSize.toNative(): NativeImage.ImageSize {
    return NativeImage.ImageSize(size, width, height)
}

public fun NativeImage.ImageSize.toCommon(): Image.ImageSize {
    return Image.ImageSize(size = size, width = width, height = height)
}
