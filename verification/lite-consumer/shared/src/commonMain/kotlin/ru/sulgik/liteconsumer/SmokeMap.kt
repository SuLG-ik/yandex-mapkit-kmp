package ru.sulgik.liteconsumer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.Map

public fun initializeSmokeMap(apiKey: String = "mapkit-lite-consumer-smoke") {
    MapKit.setApiKey(apiKey)
}

@Composable
public fun SuggestionsScreen() {
    EditionSuggestionsScreen()
}

@Composable
public fun SmokeMap(onReady: () -> Unit) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val image = smokeImage()
    var readyMap by remember { mutableStateOf<Map?>(null) }
    Box(Modifier.fillMaxSize()) {
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
                verifyRoutingOverlay(map)
                readyMap = map
                onReady()
            }
        }
        readyMap?.let { map ->
            RoutingPreview(map, Modifier.align(Alignment.TopCenter))
        }
    }
}
