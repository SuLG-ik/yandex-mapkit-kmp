package ru.sulgik.mapkit.map

import platform.UIKit.UIImage

/**
 * Provides an image to MapKit.
 *
 * iOS MapKit takes a plain `UIImage`, so there is nothing to cache or identify here: instances come
 * from `ImageProvider.Companion.fromUIImage`.
 */
public actual interface ImageProvider {

    public fun toNative(): UIImage

    public companion object
}

public fun ImageProvider.Companion.fromUIImage(uiImage: UIImage): ImageProvider {
    return UIImageImageProvider(uiImage)
}
