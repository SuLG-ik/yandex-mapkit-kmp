package ru.sulgik.mapkit.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import ru.sulgik.mapkit.compose.Circle
import ru.sulgik.mapkit.compose.ClusterGroup
import ru.sulgik.mapkit.compose.ClusterItem
import ru.sulgik.mapkit.compose.Clustering
import ru.sulgik.mapkit.compose.MapConfig
import ru.sulgik.mapkit.compose.MapLogoConfig
import ru.sulgik.mapkit.compose.Placemark
import ru.sulgik.mapkit.compose.Polygon
import ru.sulgik.mapkit.compose.Polyline
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.YandexMapComposable
import ru.sulgik.mapkit.compose.YandexMapsComposeExperimentalApi
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.imageProvider
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberCameraPositionState
import ru.sulgik.mapkit.compose.rememberCircleState
import ru.sulgik.mapkit.compose.rememberPlacemarkState
import ru.sulgik.mapkit.compose.rememberPolygonState
import ru.sulgik.mapkit.compose.rememberPolylineState
import ru.sulgik.mapkit.composeapp.generated.resources.Res
import ru.sulgik.mapkit.composeapp.generated.resources.cluster
import ru.sulgik.mapkit.composeapp.generated.resources.pin_green
import ru.sulgik.mapkit.composeapp.generated.resources.pin_red
import ru.sulgik.mapkit.composeapp.generated.resources.pin_yellow
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.logo.LogoAlignment
import ru.sulgik.mapkit.logo.LogoHorizontalAlignment
import ru.sulgik.mapkit.logo.LogoVerticalAlignment


@OptIn(YandexMapsComposeExperimentalApi::class)
@Composable
fun NewMapScreen(modifier: Modifier = Modifier) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val cameraPositionState = rememberCameraPositionState { position = startPosition }
    val snackbarHostState = remember { SnackbarHostState() }
    val placemarks = remember { randomPlacemarks() }
    val circles = remember { randomCircles() }

    val scope = rememberCoroutineScope()

    val mapActionsState = rememberMapActionsState()

    val showMessage: (String) -> Unit = {
        scope.launch {
            snackbarHostState.showSnackbar(it, withDismissAction = true)
        }
    }
    var clicksCount by remember { mutableStateOf(0) }
    val density = LocalDensity.current
    val contentSize =
        with(density) { DpSize(75.dp, 10.dp + 12.sp.toDp()) }
    val clicksImage = imageProvider(size = contentSize, clicksCount) {
        Box(
            modifier = Modifier
                .background(Color.LightGray, MaterialTheme.shapes.medium)
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.outline,
                    MaterialTheme.shapes.medium
                )
                .padding(vertical = 5.dp, horizontal = 10.dp)
        ) {
            Text("clicks: $clicksCount", fontSize = 12.sp)
        }
    }
    Scaffold(
        bottomBar = {
            MapActions(
                state = mapActionsState,
                onStartPosition = {
                    cameraPositionState.position = startPosition
                },
                modifier = Modifier.fillMaxWidth(),
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        modifier = modifier,
    ) { _ ->
        YandexMap(
            cameraPositionState = cameraPositionState,
            config = MapConfig(
                isNightModeEnabled = isSystemInDarkTheme(),
                logo = MapLogoConfig(
                    alignment = LogoAlignment(
                        horizontal = LogoHorizontalAlignment.LEFT,
                        vertical = LogoVerticalAlignment.TOP,
                    )
                )
            ),
            modifier = Modifier.fillMaxSize(),
        ) {
            if (mapActionsState.isPlacemarksEnabled) {
                if (mapActionsState.isPlacemarksClsuteringEnabled) {
                    PlacemarksCluster(placemarks, mapActionsState.isComposableContentEnabled)
                } else {
                    Placemarks(
                        placemarks,
                        mapActionsState = mapActionsState,
                        onShowMessage = showMessage,
                    )
                }
            }
            if (mapActionsState.isCirclesEnabled) {
                Circles(
                    circles = circles,
                    onShowMessage = showMessage,
                )
            }
            if (mapActionsState.isPolygonsEnabled) {
                Polygons(onShowMessage = showMessage)
            }
            if (mapActionsState.isPolylinesEnabled) {
                Polylines(onShowMessage = showMessage)
            }
            if (mapActionsState.isComposableContentEnabled) {
                Placemark(
                    icon = clicksImage,
                    state = rememberPlacemarkState(composablePlacemark),
                    onTap = {
                        clicksCount++
                        true
                    }
                )
            }
        }
    }
}

@Composable
fun Map(modifier: Modifier = Modifier) {

}

@Composable
fun Polygons(
    onShowMessage: (String) -> Unit,
) {
    Polygon(
        state = rememberPolygonState(polygon),
        onTap = {
            onShowMessage("Tap on Polygon")
            true
        }
    )
}

@Composable
fun Polylines(
    onShowMessage: (String) -> Unit,
) {
    Polyline(
        state = rememberPolylineState(polyline),
        outlineColor = Color.DarkGray.copy(alpha = 0.4f),
        strokeColor = Color.Gray.copy(alpha = 0.4f)
    )
}

@YandexMapComposable
@Composable
fun Circles(
    circles: List<Pair<Circle, MapObjectUserData>>,
    onShowMessage: (String) -> Unit,
) {
    val typeToColor = mapOf(
        MapObjectType.YELLOW to Color.Yellow.copy(alpha = 0.6f),
        MapObjectType.RED to Color.Red.copy(alpha = 0.6f),
        MapObjectType.GREEN to Color.Green.copy(alpha = 0.6f)
    )
    circles.forEach {
        Circle(
            state = rememberCircleState(it.first),
            color = typeToColor[it.second.type]!!,
            strokeWidth = 2.5f,
            onTap = { point ->
                onShowMessage("Tap on ${it.second.name} point $point")
                true
            }
        )
    }
}

@YandexMapComposable
@Composable
fun Placemarks(
    placemarks: List<Pair<Point, MapObjectUserData>>,
    mapActionsState: MapActionsState,
    onShowMessage: (String) -> Unit,
) {
    val pinRedImage = imageProvider(Res.drawable.pin_red)
    val pinGreenImage = imageProvider(Res.drawable.pin_green)
    val pinYellowImage = imageProvider(Res.drawable.pin_yellow)
    val typeToImageMap = mapOf(
        MapObjectType.YELLOW to pinYellowImage,
        MapObjectType.RED to pinRedImage,
        MapObjectType.GREEN to pinGreenImage
    )
    placemarks.forEach {
        Placemark(
            state = rememberPlacemarkState(it.first),
            icon = typeToImageMap[it.second.type]!!,
            draggable = mapActionsState.isDragEnabled,
            onTap = if (mapActionsState.isDragEnabled) null else { point ->
                onShowMessage("Tap on ${it.second.name} point $point")
                true
            }
        )
    }
}

@YandexMapComposable
@Composable
fun PlacemarksCluster(
    placemarks: List<Pair<Point, MapObjectUserData>>,
    isComposableContentEnabled: Boolean,
) {
    val pinRedImage = imageProvider(Res.drawable.pin_red)
    val pinGreenImage = imageProvider(Res.drawable.pin_green)
    val pinYellowImage = imageProvider(Res.drawable.pin_yellow)
    val clusterIcon = imageProvider(Res.drawable.cluster)

    val redPlacemarks = placemarks.asSequence().filter { it.second.type == MapObjectType.RED }.map {
        ClusterItem(it.first, it.second)
    }.toImmutableList()

    val greenPlacemarks =
        placemarks.asSequence().filter { it.second.type == MapObjectType.GREEN }.map {
            ClusterItem(it.first, it.second)
        }.toImmutableList()
    val yellowPlacemarks =
        placemarks.asSequence().filter { it.second.type == MapObjectType.YELLOW }.map {
            ClusterItem(it.first, it.second)
        }.toImmutableList()
    if (isComposableContentEnabled) {
//        Clustering(
//            groups = persistentListOf(
//                ClusterGroup(
//                    placemarks = redPlacemarks,
//                    icon = pinRedImage,
//                ),
//                ClusterGroup(
//                    placemarks = greenPlacemarks,
//                    icon = pinGreenImage,
//                ),
//                ClusterGroup(
//                    placemarks = yellowPlacemarks,
//                    icon = pinYellowImage,
//                ),
//            ),
//            content = {
//                Box(
//                    modifier = Modifier
//                        .background(Color.LightGray, MaterialTheme.shapes.medium)
//                        .border(
//                            1.dp,
//                            MaterialTheme.colorScheme.outline,
//                            MaterialTheme.shapes.medium
//                        )
//                        .padding(vertical = 5.dp, horizontal = 10.dp)
//                ) {
//                    Text("${it.size}")
//                }
//            }
//        )
    } else {
        Clustering(
            groups = persistentListOf(
                ClusterGroup(
                    placemarks = redPlacemarks,
                    icon = pinRedImage,
                ),
                ClusterGroup(
                    placemarks = greenPlacemarks,
                    icon = pinGreenImage,
                ),
                ClusterGroup(
                    placemarks = yellowPlacemarks,
                    icon = pinYellowImage,
                ),
            ),
            icon = clusterIcon,
        )
    }
}