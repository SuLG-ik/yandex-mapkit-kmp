package ru.sulgik.mapkit.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sulgik.mapkit.compose.CameraPositionState
import ru.sulgik.mapkit.compose.Placemark
import ru.sulgik.mapkit.compose.PlacemarkState
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.imageProvider
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberCameraPositionState
import ru.sulgik.mapkit.composeapp.generated.resources.Res
import ru.sulgik.mapkit.composeapp.generated.resources.pin_green
import ru.sulgik.mapkit.composeapp.generated.resources.pin_red
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition

@Composable
internal fun ReturnToMapScreen(onExit: () -> Unit, modifier: Modifier = Modifier) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val defaultIcon = imageProvider(Res.drawable.pin_red)
    val selectedIcon = imageProvider(Res.drawable.pin_green)

    ReturnMapRoutes(onExit = onExit, modifier = modifier) { camera, markers, selectedId, onSelect, mapModifier ->
        YandexMap(cameraPositionState = camera, modifier = mapModifier) {
            for (marker in markers) {
                key(marker.id) {
                    val state = remember(marker.point) { PlacemarkState(marker.point) }
                    Placemark(
                        state = state,
                        icon = if (marker.id == selectedId) selectedIcon else defaultIcon,
                        onTap = {
                            onSelect(marker.id)
                            true
                        },
                    )
                }
            }
        }
    }
}

@Composable
internal fun ReturnMapRoutes(
    onExit: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (
        CameraPositionState,
        List<ReturnMapMarker>,
        String?,
        (String) -> Unit,
        Modifier,
    ) -> Unit,
) {
    var tabName by rememberSaveable { mutableStateOf(ReturnMapTab.A.name) }
    val tab = ReturnMapTab.valueOf(tabName)
    val routes = rememberSaveableStateHolder()

    Column(modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            OutlinedButton(onClick = { tabName = ReturnMapTab.A.name }, enabled = tab != ReturnMapTab.A) {
                Text("Tab A")
            }
            OutlinedButton(onClick = { tabName = ReturnMapTab.B.name }, enabled = tab != ReturnMapTab.B) {
                Text("Tab B")
            }
            OutlinedButton(onClick = onExit) {
                Text("Exit example")
            }
        }

        routes.SaveableStateProvider(tab.name) {
            val camera = rememberCameraPositionState { position = tab.initialCamera }
            var selectedId by rememberSaveable { mutableStateOf<String?>(null) }
            var isShowingDetails by rememberSaveable { mutableStateOf(false) }
            var isMoved by rememberSaveable { mutableStateOf(false) }
            var isRemoved by rememberSaveable { mutableStateOf(false) }
            val markers = remember(tab, isMoved, isRemoved) {
                buildList {
                    if (!isRemoved) {
                        add(
                            if (isMoved) {
                                tab.editableMarker.copy(point = tab.movedPoint)
                            } else {
                                tab.editableMarker
                            },
                        )
                    }
                    add(tab.referenceMarker)
                }
            }
            val selected = markers.firstOrNull { it.id == selectedId }

            if (isShowingDetails) {
                Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(selected?.id ?: "Marker no longer in catalog")
                    Button(
                        onClick = { isMoved = true },
                        enabled = selected?.id == tab.editableMarker.id && !isMoved,
                    ) {
                        Text("Move marker")
                    }
                    OutlinedButton(
                        onClick = {
                            isRemoved = true
                            selectedId = null
                        },
                        enabled = selected?.id == tab.editableMarker.id,
                    ) {
                        Text("Remove marker")
                    }
                    OutlinedButton(onClick = { isShowingDetails = false }) {
                        Text("Back to map")
                    }
                }
            } else {
                Text("Selected marker: ${selected?.id ?: "none"}", Modifier.padding(horizontal = 8.dp))
                Button(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    onClick = { isShowingDetails = true },
                    enabled = selected != null,
                ) {
                    Text("Open details")
                }
                content(
                    camera,
                    markers,
                    selected?.id,
                    { selectedId = it },
                    Modifier.fillMaxWidth().weight(1f),
                )
            }
        }
    }
}

internal data class ReturnMapMarker(val id: String, val point: Point)

internal enum class ReturnMapTab(
    center: Point,
    val editableMarker: ReturnMapMarker,
    val referenceMarker: ReturnMapMarker,
    val movedPoint: Point,
) {
    A(
        center = Point(55.7558, 37.6176),
        editableMarker = ReturnMapMarker("A-1", Point(55.7547, 37.6156)),
        referenceMarker = ReturnMapMarker("A-2", Point(55.7574, 37.6185)),
        movedPoint = Point(55.7552, 37.6199),
    ),
    B(
        center = Point(59.9398, 30.3149),
        editableMarker = ReturnMapMarker("B-1", Point(59.9406, 30.3126)),
        referenceMarker = ReturnMapMarker("B-2", Point(59.9390, 30.3169)),
        movedPoint = Point(59.9387, 30.3153),
    ),
    ;

    val initialCamera: CameraPosition = CameraPosition(center, zoom = 15f, azimuth = 0f, tilt = 0f)
}
