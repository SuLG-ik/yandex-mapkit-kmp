package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import ru.sulgik.mapkit.MapKit

@Composable
actual fun rememberAndInitializeMapKit(): MapKit {
    return rememberMapKit()
}