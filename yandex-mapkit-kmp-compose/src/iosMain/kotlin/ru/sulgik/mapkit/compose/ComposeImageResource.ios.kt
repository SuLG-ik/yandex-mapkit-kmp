package ru.sulgik.mapkit.compose

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asSkiaBitmap
import androidx.compose.ui.unit.Density
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.ColorAlphaType
import org.jetbrains.skia.ColorSpace
import org.jetbrains.skia.ColorType
import org.jetbrains.skia.ImageInfo
import platform.CoreGraphics.CGBitmapContextCreate
import platform.CoreGraphics.CGBitmapContextCreateImage
import platform.CoreGraphics.CGColorSpaceCreateDeviceRGB
import platform.CoreGraphics.CGColorSpaceRelease
import platform.CoreGraphics.CGContextRelease
import platform.CoreGraphics.CGImageAlphaInfo
import platform.CoreGraphics.CGImageRelease
import platform.UIKit.UIImage
import platform.UIKit.UIImageOrientation
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.fromUIImage

public actual fun ImageBitmap.toImageProvider(): ImageProvider {
    return ImageProvider.fromUIImage(asSkiaBitmap().toUIImage())
}

internal actual fun ImageBitmap.toImageProvider(density: Density): ImageProvider {
    return ImageProvider.fromUIImage(asSkiaBitmap().toUIImage(scale = density.density.toDouble()))
}

/**
 * Converts bitmap to [UIImage] with given [scale].
 *
 * [scale] is a number of bitmap pixels per point, so bitmap rendered for `40x40` points on a
 * screen with `3.0` density should be converted with `scale = 3.0`.
 */
@OptIn(ExperimentalForeignApi::class)
public fun Bitmap.toUIImage(scale: Double = 1.0): UIImage {
    val rowBytes = width * BytesPerPixel
    val pixels = readPixels(
        dstInfo = ImageInfo(
            width = width,
            height = height,
            colorType = ColorType.RGBA_8888,
            alphaType = ColorAlphaType.PREMUL,
            colorSpace = ColorSpace.sRGB,
        ),
        dstRowBytes = rowBytes,
        srcX = 0,
        srcY = 0,
    ) ?: throw IllegalArgumentException("Bitmap does not contain pixel data.")
    val colorSpace = CGColorSpaceCreateDeviceRGB()
    try {
        return pixels.usePinned { pinnedPixels ->
            val context = CGBitmapContextCreate(
                data = pinnedPixels.addressOf(0),
                width = width.toULong(),
                height = height.toULong(),
                bitsPerComponent = 8u,
                bytesPerRow = rowBytes.toULong(),
                space = colorSpace,
                bitmapInfo = CGImageAlphaInfo.kCGImageAlphaPremultipliedLast.value,
            ) ?: throw IllegalStateException("Unable to create context for ${width}x$height bitmap.")
            try {
                val cgImage = CGBitmapContextCreateImage(context)
                    ?: throw IllegalStateException("Unable to create image from bitmap context.")
                try {
                    UIImage.imageWithCGImage(
                        cgImage = cgImage,
                        scale = scale,
                        orientation = UIImageOrientation.UIImageOrientationUp,
                    )
                } finally {
                    CGImageRelease(cgImage)
                }
            } finally {
                CGContextRelease(context)
            }
        }
    } finally {
        CGColorSpaceRelease(colorSpace)
    }
}

private const val BytesPerPixel = 4
