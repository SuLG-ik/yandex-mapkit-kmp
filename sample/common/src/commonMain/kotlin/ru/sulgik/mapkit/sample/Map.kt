package ru.sulgik.mapkit.sample

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.YandexMapController
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.sample.ui.CombinedFilledTonalIconButton
import kotlin.time.Duration.Companion.milliseconds


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
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            YandexMap(
                controller = mapController,
                modifier = Modifier.fillMaxSize(),
            )
            MapControl(
                mapController = mapController,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
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

@Composable
fun MapControl(
    mapController: YandexMapController,
    modifier: Modifier = Modifier,
) {
    var zoomFactor by remember { mutableStateOf(0f) }
    LaunchedEffect(zoomFactor) {
        while (zoomFactor != 0f) {
            val cameraPosition = mapController.mapWindow.map.cameraPosition
            mapController.mapWindow.map.move(
                cameraPosition.copy(zoom = cameraPosition.zoom + zoomFactor),
                Animation(Animation.Type.LINEAR, 100.milliseconds),
            )
            delay(100.milliseconds)
        }
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        CombinedFilledTonalIconButton(
            onPress = { zoomFactor = 0.25f },
            onPressRelease = { zoomFactor = 0f },
        ) {
            Text("+", color = Color.Black, fontSize = 20.sp)
        }
        CombinedFilledTonalIconButton(
            onPress = { zoomFactor = -0.25f },
            onPressRelease = { zoomFactor = 0f },
        ) {
            Text("–", color = Color.Black, fontSize = 20.sp)
        }
    }
}