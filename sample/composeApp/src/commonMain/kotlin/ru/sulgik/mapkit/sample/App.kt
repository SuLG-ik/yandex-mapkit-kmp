package ru.sulgik.mapkit.sample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sulgik.mapkit.MapKit

fun initMapKit(): MapKit {
    MapKit.setApiKey(BuildKonfig.MAPKIT_API_KEY)
    return MapKit.getInstance()
}

@Composable
fun App() {
    MapScreen(modifier = Modifier.fillMaxSize())
}