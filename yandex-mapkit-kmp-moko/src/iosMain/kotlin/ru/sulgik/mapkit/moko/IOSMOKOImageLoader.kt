package ru.sulgik.mapkit.moko

import dev.icerock.moko.resources.ImageResource
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.fromUIImage

class IOSMOKOImageLoader : MOKOImageLoader {

    override fun fromResource(imageResource: ImageResource): ImageProvider {
        return ImageProvider.fromUIImage(imageResource.toUIImage()!!)
    }

    override fun fromResource(imageResource: ImageResource, isCacheable: Boolean): ImageProvider {
        return ImageProvider.fromUIImage(imageResource.toUIImage()!!)
    }

}