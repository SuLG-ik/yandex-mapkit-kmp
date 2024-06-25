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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.YandexMapController
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.imageProvider
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.composeapp.generated.resources.Res
import ru.sulgik.mapkit.composeapp.generated.resources.cluster
import ru.sulgik.mapkit.composeapp.generated.resources.pin_green
import ru.sulgik.mapkit.composeapp.generated.resources.pin_red
import ru.sulgik.mapkit.composeapp.generated.resources.pin_yellow
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.ClusterListener
import ru.sulgik.mapkit.map.ClusterTapListener
import ru.sulgik.mapkit.map.MapObjectTapListener
import ru.sulgik.mapkit.map.getCastedUserData
import ru.sulgik.mapkit.sample.ui.CombinedFilledTonalIconButton
import kotlin.time.Duration.Companion.milliseconds

fun randomPlacemarks(): List<Pair<Point, PlacemarkUserData>> {
    return clusterizedPoints.mapIndexed { index, point ->
        point to PlacemarkUserData(
            type = PlacemarkType.entries.random(),
            name = "point_$index"
        )
    }
}


@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()

    val snackbarHostState = remember { SnackbarHostState() }
    val mapController = rememberYandexMapController()
    val map = mapController.mapWindow.map
    val placemarks = remember { randomPlacemarks() }

    val clusterImage = imageProvider(Res.drawable.cluster)
    val pinRedImage = imageProvider(Res.drawable.pin_red)
    val pinGreenImage = imageProvider(Res.drawable.pin_green)
    val pinYellowImage = imageProvider(Res.drawable.pin_yellow)

    val scope = rememberCoroutineScope()

    val clusterTapListener = remember(scope, snackbarHostState) {
        ClusterTapListener {
            scope.launch {
                snackbarHostState.showSnackbar(
                    "Clicked on cluster with ${it.size} items",
                    withDismissAction = true
                )
            }
            true
        }
    }

    val clusterListener = remember(clusterImage, clusterTapListener) {
        ClusterListener { cluster ->
            // Sets each cluster appearance using the custom view
            // that shows a cluster's pins
            cluster.appearance.setIcon(clusterImage)
            cluster.appearance.zIndex = 100f

            cluster.addClusterTapListener(clusterTapListener)
        }
    }

    val mapObjectTapListener = remember(scope, snackbarHostState) {
        MapObjectTapListener { mapObject, point ->
            scope.launch {
                snackbarHostState.showSnackbar(
                    "MapObject (${mapObject.getCastedUserData<PlacemarkUserData>()}) was tapped (${point})",
                    withDismissAction = true
                )
            }
            true
        }
    }

    LaunchedEffect(map) {
        map.move(startPosition)
    }

    LaunchedEffect(map) {
        val typeToImageMap = mapOf(
            PlacemarkType.YELLOW to pinYellowImage,
            PlacemarkType.RED to pinRedImage,
            PlacemarkType.GREEN to pinGreenImage
        )
        val cluster =
            map.mapObjects.addClusterizedPlacemarkCollection(clusterListener)

        placemarks.forEach { (point, data) ->
            cluster.addPlacemark().apply {
                geometry = point
                setIcon(typeToImageMap[data.type]!!)
                userData = data
                addTapListener(mapObjectTapListener)
            }
        }
        cluster.clusterPlacemarks(60.0, 15)
    }

    Scaffold(
        bottomBar = {
            MapActions(
                mapController = mapController,
                modifier = Modifier.fillMaxWidth(),
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
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