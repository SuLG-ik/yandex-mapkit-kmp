package ru.sulgik.mapkit.map

import com.yandex.runtime.image.ImageProvider as NativeImageProvider

/**
 * Provides an image to MapKit.
 *
 * Instances come from the `ImageProvider.Companion.fromBitmap` / `fromAsset` / `fromResource` /
 * `fromFile` factories, which also take MapKit's `id` and `isCacheable`.
 */
public actual interface ImageProvider {

    public fun toNative(): NativeImageProvider

    public companion object
}
