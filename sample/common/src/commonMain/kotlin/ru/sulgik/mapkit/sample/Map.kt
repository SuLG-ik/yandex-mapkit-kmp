package ru.sulgik.mapkit.sample

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.YandexMapController
import ru.sulgik.mapkit.compose.rememberYandexMapController


@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    val mapController = rememberYandexMapController()
    LaunchedEffect(mapController) {
        mapController.mapWindow.map.move(startPosition)
    }
    Scaffold(
        bottomBar = {
            MapActions(
                mapController = mapController,
                modifier = Modifier.fillMaxWidth(),
            )
        },
        modifier = modifier,
    ) { _ ->
        YandexMap(
            controller = mapController,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
fun MapActions(
    mapController: YandexMapController,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState())
            .padding(horizontal = 10.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedButton(
            onClick = {
                mapController.mapWindow.map.move(cameraPosition = startPosition)
            },
        ) {
            Text("To start position")
        }
    }
}