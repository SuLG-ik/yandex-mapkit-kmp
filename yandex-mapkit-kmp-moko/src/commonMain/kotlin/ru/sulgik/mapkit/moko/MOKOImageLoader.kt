package ru.sulgik.mapkit.moko

import dev.icerock.moko.resources.ImageResource
import ru.sulgik.mapkit.map.ImageProvider

interface MOKOImageLoader {

    fun fromResource(imageResource: ImageResource): ImageProvider

    fun fromResource(imageResource: ImageResource, isCacheable: Boolean): ImageProvider

}