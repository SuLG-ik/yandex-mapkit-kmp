package ru.sulgik.mapkit.moko.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import ru.sulgik.mapkit.moko.IOSMOKOImageLoader
import ru.sulgik.mapkit.moko.MOKOImageLoader

@Composable
actual fun rememberMOKOImageLoader(): MOKOImageLoader {
    return remember { IOSMOKOImageLoader() }
}