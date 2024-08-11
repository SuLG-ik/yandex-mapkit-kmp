package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import ru.sulgik.mapkit.MapKit

@Composable
public actual fun rememberAndInitializeMapKit(): MapKit {
    return rememberMapKit()
}