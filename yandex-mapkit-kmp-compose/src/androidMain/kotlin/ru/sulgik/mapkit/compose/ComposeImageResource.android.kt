package ru.sulgik.mapkit.compose

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.toImageProvider

public actual fun ImageBitmap.toImageProvider(): ImageProvider {
    return asAndroidBitmap().toImageProvider()
}