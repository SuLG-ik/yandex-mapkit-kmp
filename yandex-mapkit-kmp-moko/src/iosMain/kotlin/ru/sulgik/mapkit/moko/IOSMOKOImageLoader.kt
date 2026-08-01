package ru.sulgik.mapkit.moko

import dev.icerock.moko.resources.ImageResource
import platform.UIKit.UIImage
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.fromUIImage

/**
 * [MOKOImageLoader] backed by the asset catalog an [ImageResource] points at.
 */
public class IOSMOKOImageLoader : MOKOImageLoader {

    /**
     * Returns an [ImageProvider] for the `UIImage` behind [imageResource].
     *
     * @throws IllegalArgumentException if the asset is missing from its bundle.
     */
    override fun fromResource(imageResource: ImageResource): ImageProvider {
        return ImageProvider.fromUIImage(imageResource.requireUIImage())
    }

    /**
     * Returns an [ImageProvider] for the `UIImage` behind [imageResource]. [isCacheable] has no
     * effect on iOS and is accepted only to keep the common interface uniform.
     *
     * @throws IllegalArgumentException if the asset is missing from its bundle.
     */
    override fun fromResource(imageResource: ImageResource, isCacheable: Boolean): ImageProvider {
        return ImageProvider.fromUIImage(imageResource.requireUIImage())
    }
}

private fun ImageResource.requireUIImage(): UIImage {
    return requireNotNull(toUIImage()) {
        "No image named \"$assetImageName\" in bundle $bundle"
    }
}
