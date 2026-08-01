package ru.sulgik.mapkit.moko

import android.content.Context
import dev.icerock.moko.resources.ImageResource
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.fromResource

/**
 * [MOKOImageLoader] backed by the drawable resources of [context].
 *
 * @param context used to resolve the drawable behind an [ImageResource]; an application context is
 * enough and avoids leaking an activity into a long-lived loader.
 */
public class AndroidMOKOImageLoader(private val context: Context) : MOKOImageLoader {

    /** Returns an [ImageProvider] for the drawable behind [imageResource]. */
    override fun fromResource(imageResource: ImageResource): ImageProvider {
        return ImageProvider.fromResource(context, imageResource.drawableResId)
    }

    /**
     * Returns an [ImageProvider] for the drawable behind [imageResource], caching the decoded image
     * in MapKit when [isCacheable] is `true`.
     */
    override fun fromResource(imageResource: ImageResource, isCacheable: Boolean): ImageProvider {
        return ImageProvider.fromResource(context, imageResource.drawableResId, isCacheable)
    }
}
