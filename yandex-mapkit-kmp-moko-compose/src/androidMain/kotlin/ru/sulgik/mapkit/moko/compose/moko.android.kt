package ru.sulgik.mapkit.moko.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import ru.sulgik.mapkit.moko.AndroidMOKOImageLoader
import ru.sulgik.mapkit.moko.MOKOImageLoader

@Composable
actual fun rememberMOKOImageLoader(): MOKOImageLoader {
    val context = LocalContext.current
    return remember(context) { AndroidMOKOImageLoader(context) }
}