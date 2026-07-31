package ru.sulgik.mapkit.compose

import android.graphics.Bitmap
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.unit.Density
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.toImageProvider

public actual fun ImageBitmap.toImageProvider(): ImageProvider {
    return asAndroidBitmap().asArgb8888().toImageProvider()
}

internal actual fun ImageBitmap.toImageProvider(density: Density): ImageProvider {
    return toImageProvider()
}

private fun Bitmap.asArgb8888(): Bitmap {
    if (config == Bitmap.Config.ARGB_8888) return this
    return copy(Bitmap.Config.ARGB_8888, false)
        ?: throw IllegalStateException("Unable to convert $config bitmap to ARGB_8888.")
}
