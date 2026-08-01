package ru.sulgik.mapkit.moko.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import ru.sulgik.mapkit.moko.AndroidMOKOImageLoader
import ru.sulgik.mapkit.moko.MOKOImageLoader

/**
 * Remembers the [MOKOImageLoader] of the current platform, so common Compose code can turn
 * moko-resources images into MapKit image providers without a platform-specific initialization
 * step.
 *
 * On Android the returned loader is bound to the `Context` of the composition and is rebuilt when
 * that context changes.
 */
@Composable
public actual fun rememberMOKOImageLoader(): MOKOImageLoader {
    val context = LocalContext.current
    return remember(context) { AndroidMOKOImageLoader(context) }
}
