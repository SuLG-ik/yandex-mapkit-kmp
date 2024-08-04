package ru.sulgik.mapkit.map

import platform.UIKit.UIImage

public actual interface ImageProvider {

    public fun toNative(): UIImage

    public companion object

}

public fun ImageProvider.Companion.fromUIImage(uiImage: UIImage): ImageProvider {
    return UIImageImageProvider(uiImage)
}