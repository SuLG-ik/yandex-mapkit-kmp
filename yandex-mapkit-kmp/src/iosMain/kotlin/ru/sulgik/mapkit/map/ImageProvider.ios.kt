package ru.sulgik.mapkit.map

import platform.UIKit.UIImage

actual interface ImageProvider {

    fun toNative(): UIImage

    companion object

}

fun ImageProvider.Companion.fromUIImage(uiImage: UIImage): ImageProvider {
    return UIImageImageProvider(uiImage)
}