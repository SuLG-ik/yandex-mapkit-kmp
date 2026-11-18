package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import ru.sulgik.mapkit.map.ImageProvider

/** Creates a MapKit image provider from a Compose Multiplatform drawable resource. */
@Composable
public fun imageProvider(resource: DrawableResource): ImageProvider {
    val image = imageResource(resource)
    return remember(image) { image.toImageProvider() }
}
