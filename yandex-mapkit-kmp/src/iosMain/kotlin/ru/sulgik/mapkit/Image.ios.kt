package ru.sulgik.mapkit

import YandexMapKit.YMKImage as NativeImage
import YandexMapKit.YMKImageSize as NativeImageSize

public fun Image.toNative(): NativeImage {
    return NativeImage.imageWithUrlTemplate(
        urlTemplate = urlTemplate,
        sizes = sizes.map { it.toNative() },
        tags = tags,
    )
}

@Suppress("UNCHECKED_CAST")
public fun NativeImage.toCommon(): Image {
    return Image(
        urlTemplate = urlTemplate,
        sizes = (sizes as List<NativeImageSize>).map { it.toCommon() },
        tags = tags as List<String>,
    )
}

public fun Image.ImageSize.toNative(): NativeImageSize {
    return NativeImageSize.sizeWithSize(
        size = size,
        width = width?.toNSNumber(),
        height = height?.toNSNumber(),
    )
}

public fun NativeImageSize.toCommon(): Image.ImageSize {
    return Image.ImageSize(
        size = size,
        width = width?.intValue,
        height = height?.intValue,
    )
}
