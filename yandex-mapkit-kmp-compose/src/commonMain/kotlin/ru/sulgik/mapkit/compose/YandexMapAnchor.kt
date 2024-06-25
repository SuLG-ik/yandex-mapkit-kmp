package ru.sulgik.mapkit.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ru.sulgik.mapkit.map.MapWindow

internal class YandexMapAnchor {

    private var mapWindowAnchor: MapWindow? by mutableStateOf(null)

}