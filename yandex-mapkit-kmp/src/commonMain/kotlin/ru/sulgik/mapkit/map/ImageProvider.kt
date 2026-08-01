package ru.sulgik.mapkit.map

/**
 * Provides an image to MapKit.
 *
 * The image itself is a platform type — `android.graphics.Bitmap` and `UIImage` have nothing in
 * common — so this interface stays empty in common code and every member lives in the platform
 * source sets: `toNative()`, the `fromBitmap` / `fromAsset` / `fromResource` / `fromFile` factories
 * on Android and `fromUIImage` on iOS. MapKit's own `id` and `isCacheable` exist on Android only
 * and are passed to those factories.
 *
 * Implement it from `androidMain` or `iosMain` to plug in a custom image source; it is not
 * implementable from common code.
 */
public expect interface ImageProvider
