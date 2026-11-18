package ru.sulgik.liteconsumer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.geometry.Point

public fun initializeSmokeMap() {
    MapKit.setApiKey("mapkit-lite-consumer-smoke")
}

@Composable
public fun SmokeMap(onReady: () -> Unit) {
    val image = smokeImage()
    YandexMap(modifier = Modifier.fillMaxSize()) {
        MapEffect(Unit) { map ->
            check(map.isValid)
            val placemark = map.mapObjects.addPlacemark()
            placemark.geometry = Point(55.75, 37.62)
            if (image != null) {
                placemark.setIcon(image)
            }
            check(placemark.isValid)
            onReady()
        }
    }
}
