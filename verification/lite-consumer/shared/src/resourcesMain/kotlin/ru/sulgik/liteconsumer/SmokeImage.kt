package ru.sulgik.liteconsumer

import androidx.compose.runtime.Composable
import ru.sulgik.liteconsumer.generated.resources.Res
import ru.sulgik.liteconsumer.generated.resources.marker
import ru.sulgik.mapkit.compose.imageProvider
import ru.sulgik.mapkit.map.ImageProvider

@Composable
internal fun smokeImage(): ImageProvider {
    return imageProvider(Res.drawable.marker)
}
