package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.yandex.mapkit.mapview.MapView
import ru.sulgik.mapkit.mapview.MapWindow
import ru.sulgik.mapkit.mapview.toCommon

@Composable
actual fun rememberYandexMapController(): YandexMapController {
    val context = LocalContext.current
    val mapView = remember(context) { MapView(context) }
    return remember { YandexMapController(mapView) }
}

actual class YandexMapController internal constructor(val view: MapView) {

    actual val mapWindow: MapWindow = view.mapWindow.toCommon()

}