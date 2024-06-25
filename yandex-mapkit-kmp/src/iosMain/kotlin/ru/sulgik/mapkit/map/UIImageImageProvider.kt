package ru.sulgik.mapkit.map

import platform.UIKit.UIImage

class UIImageImageProvider internal constructor(private val uiImage: UIImage) : ImageProvider {
    override fun toNative(): UIImage {
        return uiImage
    }
}