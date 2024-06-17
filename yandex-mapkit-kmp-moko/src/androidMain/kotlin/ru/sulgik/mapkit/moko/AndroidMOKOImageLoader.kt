package ru.sulgik.mapkit.moko

import android.content.Context
import dev.icerock.moko.resources.ImageResource
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.fromResource

class AndroidMOKOImageLoader(private val context: Context) : MOKOImageLoader {

    override fun fromResource(imageResource: ImageResource): ImageProvider {
        return ImageProvider.fromResource(context, imageResource.drawableResId)
    }

    override fun fromResource(imageResource: ImageResource, isCacheable: Boolean): ImageProvider {
        return ImageProvider.fromResource(context, imageResource.drawableResId, isCacheable)
    }

}