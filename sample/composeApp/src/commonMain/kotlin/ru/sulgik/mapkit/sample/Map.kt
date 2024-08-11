package ru.sulgik.mapkit.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.imageProvider
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.composeapp.generated.resources.Res
import ru.sulgik.mapkit.composeapp.generated.resources.cluster
import ru.sulgik.mapkit.composeapp.generated.resources.pin_green
import ru.sulgik.mapkit.composeapp.generated.resources.pin_red
import ru.sulgik.mapkit.composeapp.generated.resources.pin_yellow
import ru.sulgik.mapkit.map.ClusterListener
import ru.sulgik.mapkit.map.ClusterTapListener
import ru.sulgik.mapkit.map.MapObjectTapListener
import ru.sulgik.mapkit.map.getCastedUserData
import ru.sulgik.mapkit.sample.ui.CombinedFilledTonalIconButton
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()

    val snackbarHostState = remember { SnackbarHostState() }
    val mapController = rememberYandexMapController()
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
                    "MapObject (${mapObject.getCastedUserData<MapObjectUserData>()}) was tapped (${point})",
                    withDismissAction = true
                )
            }
            true
        }
    }

    MapControllerEffect(mapController) { mapWindow ->
        mapWindow.map.move(startPosition)
    }

    MapControllerEffect(mapController) { mapWindow ->
        val typeToImageMap = mapOf(
            MapObjectType.YELLOW to pinYellowImage,
            MapObjectType.RED to pinRedImage,
            MapObjectType.GREEN to pinGreenImage
        )
        val cluster =
            mapWindow.map.mapObjects.addClusterizedPlacemarkCollection(clusterListener)

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

    var zoomFactor by remember { mutableStateOf(0f) }
    LaunchedEffect(mapController.mapWindow, zoomFactor) {
        val mapWindow = mapController.mapWindow
        while (zoomFactor != 0f) {
            if (mapWindow != null) {
                val cameraPosition = mapWindow.map.cameraPosition
                mapWindow.map.move(
                    cameraPosition.copy(zoom = cameraPosition.zoom + zoomFactor),
                    Animation(Animation.Type.LINEAR, 100.milliseconds),
                )
            }
            delay(100)
        }
    }
    Scaffold(
        bottomBar = {
            MapActions(
                onStartPosition = {
                    mapController.mapWindow?.map?.move(cameraPosition = startPosition)
                },
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
                onZoomIn = {
                    zoomFactor = 0.25f
                },
                onZoomOut = {
                    zoomFactor = -0.25f
                },
                onZoomStop = {
                    zoomFactor = 0f
                },
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}

@Composable
fun MapControl(
    onZoomIn: () -> Unit,
    onZoomOut: () -> Unit,
    onZoomStop: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        CombinedFilledTonalIconButton(
            onPress = onZoomIn,
            onPressRelease = onZoomStop,
        ) {
            Text("+", color = Color.Black, fontSize = 20.sp)
        }
        CombinedFilledTonalIconButton(
            onPress = onZoomOut,
            onPressRelease = onZoomStop,
        ) {
            Text("–", color = Color.Black, fontSize = 20.sp)
        }
    }
}