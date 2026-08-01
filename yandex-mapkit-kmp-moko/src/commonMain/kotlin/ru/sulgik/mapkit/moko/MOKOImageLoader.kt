package ru.sulgik.mapkit.moko

import dev.icerock.moko.resources.ImageResource
import ru.sulgik.mapkit.map.ImageProvider

/**
 * Turns a [moko-resources](https://github.com/icerockdev/moko-resources) [ImageResource] into an
 * [ImageProvider] that map objects accept as an icon.
 *
 * Implementations are platform specific: `AndroidMOKOImageLoader` needs an Android `Context`,
 * `IOSMOKOImageLoader` needs nothing. In Compose code use `rememberMOKOImageLoader()` from
 * `yandex-mapkit-kmp-moko-compose` instead of instantiating them by hand.
 */
public interface MOKOImageLoader {

    /**
     * Returns an [ImageProvider] that draws [imageResource].
     *
     * @param imageResource the moko-resources image to draw.
     */
    public fun fromResource(imageResource: ImageResource): ImageProvider

    /**
     * Returns an [ImageProvider] that draws [imageResource], letting MapKit keep the decoded image
     * in its own cache.
     *
     * @param imageResource the moko-resources image to draw.
     * @param isCacheable honoured on Android only. The iOS implementation builds the provider from
     * a `UIImage` and has no caching to control, so it ignores this flag and behaves exactly like
     * [fromResource].
     */
    public fun fromResource(imageResource: ImageResource, isCacheable: Boolean): ImageProvider
}
