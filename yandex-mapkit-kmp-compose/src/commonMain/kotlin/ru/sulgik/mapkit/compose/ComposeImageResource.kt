package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import ru.sulgik.mapkit.map.ImageProvider

public expect fun ImageBitmap.toImageProvider(): ImageProvider

@Composable
public fun imageProvider(resource: DrawableResource): ImageProvider {
    val image = imageResource(resource)
    return remember { image.toImageProvider() }
}