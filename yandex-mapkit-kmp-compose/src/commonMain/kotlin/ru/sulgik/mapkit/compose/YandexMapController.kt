package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import ru.sulgik.mapkit.mapview.MapWindow

/**
 * Create and remember YandexMapController.
 * Don't pass to multiple YandexMap. Don't save it anywhere, contains native references.
 */
@Composable
expect fun rememberYandexMapController(): YandexMapController

/**
 * Contains common implementation of MapWindow, that uses for controlling YandexMap
 */
expect class YandexMapController {

    val mapWindow: MapWindow

}