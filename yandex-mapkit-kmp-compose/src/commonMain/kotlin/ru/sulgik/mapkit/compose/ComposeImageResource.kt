package ru.sulgik.mapkit.compose

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.Density
import ru.sulgik.mapkit.map.ImageProvider

public expect fun ImageBitmap.toImageProvider(): ImageProvider

internal expect fun ImageBitmap.toImageProvider(density: Density): ImageProvider
