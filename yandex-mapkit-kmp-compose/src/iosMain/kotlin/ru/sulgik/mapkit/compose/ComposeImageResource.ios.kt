package ru.sulgik.mapkit.compose

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asSkiaBitmap
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.refTo
import org.jetbrains.skia.Bitmap
import platform.CoreGraphics.CGBitmapContextCreate
import platform.CoreGraphics.CGBitmapContextCreateImage
import platform.CoreGraphics.CGColorSpaceCreateDeviceRGB
import platform.CoreGraphics.CGImageAlphaInfo
import platform.UIKit.UIImage
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.fromUIImage

public actual fun ImageBitmap.toImageProvider(): ImageProvider {
    return ImageProvider.fromUIImage(asSkiaBitmap().toUIImage())
}

@OptIn(ExperimentalForeignApi::class)
public fun Bitmap.toUIImage(): UIImage {
    val bgrBytes = readPixels() ?: throw IllegalArgumentException("Bitmap does not contain pixel data.")
    val rgbBytes = convertBgraToRgba(bgrBytes, width, height)
    val colorSpace = CGColorSpaceCreateDeviceRGB()
    val context = CGBitmapContextCreate(
        data = rgbBytes.refTo(0),
        width = width.toULong(),
        height = height.toULong(),
        bitsPerComponent = 8u,
        bytesPerRow = (4 * width).toULong(),
        space = colorSpace,
        bitmapInfo = CGImageAlphaInfo.kCGImageAlphaPremultipliedLast.value,
    )
    val cgImage = CGBitmapContextCreateImage(context)
    return cgImage.let { UIImage.imageWithCGImage(it) }
}

private fun convertBgraToRgba(bgraBytes: ByteArray, width: Int, height: Int): ByteArray {
    if (bgraBytes.size != width * height * 4) {
        throw IllegalArgumentException("Invalid byte array size for BGRA 32-bit image. Expected ${width * height * 4} bytes, but got ${bgraBytes.size}.")
    }
    val rgbaBytes = ByteArray(bgraBytes.size)
    var i = 0
    while (i < bgraBytes.size) {
        val blue = bgraBytes[i]
        val green = bgraBytes[i + 1]
        val red = bgraBytes[i + 2]
        val alpha = bgraBytes[i + 3]
        rgbaBytes[i] = red // Red
        rgbaBytes[i + 1] = green // Green
        rgbaBytes[i + 2] = blue // Blue
        rgbaBytes[i + 3] = alpha // Alpha
        i += 4
    }
    return rgbaBytes
}