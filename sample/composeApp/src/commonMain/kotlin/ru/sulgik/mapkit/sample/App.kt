package ru.sulgik.mapkit.sample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sulgik.mapkit.MapKit

fun initMapKit() {
    MapKit.setApiKey(BuildKonfig.MAPKIT_API_KEY)
}

@Composable
fun App() {
    NewMapScreen(modifier = Modifier.fillMaxSize())
}