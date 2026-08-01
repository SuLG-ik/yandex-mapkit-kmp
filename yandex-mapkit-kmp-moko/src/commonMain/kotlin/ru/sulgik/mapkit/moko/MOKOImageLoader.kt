package ru.sulgik.mapkit.moko

import dev.icerock.moko.resources.ImageResource
import ru.sulgik.mapkit.map.ImageProvider

public interface MOKOImageLoader {

    public fun fromResource(imageResource: ImageResource): ImageProvider

    public fun fromResource(imageResource: ImageResource, isCacheable: Boolean): ImageProvider
}
