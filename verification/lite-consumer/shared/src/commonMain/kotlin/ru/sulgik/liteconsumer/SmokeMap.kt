package ru.sulgik.liteconsumer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.geometry.Point

public fun initializeSmokeMap(apiKey: String = "mapkit-lite-consumer-smoke") {
    MapKit.setApiKey(apiKey)
}

@Composable
public fun SmokeMap(onReady: () -> Unit) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
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
            verifySearchManager()
            onReady()
        }
    }
}
