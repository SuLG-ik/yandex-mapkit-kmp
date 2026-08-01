package ru.sulgik.mapkit.sample

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ru.sulgik.mapkit.Animation
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.RawTile
import ru.sulgik.mapkit.ZoomRange
import ru.sulgik.mapkit.compose.Circle
import ru.sulgik.mapkit.compose.CircleState
import ru.sulgik.mapkit.compose.MapConfig
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.MapListeners
import ru.sulgik.mapkit.compose.MapObjectCollection
import ru.sulgik.mapkit.compose.MapObjectCollectionState
import ru.sulgik.mapkit.compose.MapObjectLayer
import ru.sulgik.mapkit.compose.Placemark
import ru.sulgik.mapkit.compose.PlacemarkState
import ru.sulgik.mapkit.compose.Polygon
import ru.sulgik.mapkit.compose.PolygonState
import ru.sulgik.mapkit.compose.Polyline
import ru.sulgik.mapkit.compose.PolylineState
import ru.sulgik.mapkit.compose.TileLayer
import ru.sulgik.mapkit.compose.TrafficLayer
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.YandexMapComposable
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.imageProvider
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberCameraPositionState
import ru.sulgik.mapkit.compose.rememberCircleState
import ru.sulgik.mapkit.compose.rememberMapObjectCollectionState
import ru.sulgik.mapkit.compose.rememberPlacemarkState
import ru.sulgik.mapkit.compose.rememberPolygonState
import ru.sulgik.mapkit.compose.rememberPolylineState
import ru.sulgik.mapkit.composeapp.generated.resources.Res
import ru.sulgik.mapkit.composeapp.generated.resources.pin_green
import ru.sulgik.mapkit.composeapp.generated.resources.pin_red
import ru.sulgik.mapkit.composeapp.generated.resources.pin_yellow
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.geo.Projections
import ru.sulgik.mapkit.layers.LayerOptions
import ru.sulgik.mapkit.layers.TileFormat
import ru.sulgik.mapkit.map.AnimatedImageProvider
import ru.sulgik.mapkit.map.Callback
import ru.sulgik.mapkit.map.GeoObjectSelectionMetadata
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.MapObjectVisitor
import ru.sulgik.mapkit.map.getCastedUserData
import ru.sulgik.mapkit.tiles.TileProvider
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AdvancedMapScreen(modifier: Modifier = Modifier) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val cameraPositionState = rememberCameraPositionState { position = startPosition }
    val log = rememberMapEventLog()
    val state = rememberAdvancedMapState()

    val groupState = rememberMapObjectCollectionState()
    val polylineState = rememberPolylineState(polyline)
    val polygonState = rememberPolygonState(polygon)
    val placemarkState = rememberPlacemarkState(composablePlacemark)
    val layerCircleState = rememberCircleState(layerCircle)
    val groupPlacemarks = remember { randomPlacemarks() }

    val tileBytes by produceState<ByteArray?>(null) { value = Res.readBytes(TilePath) }
    val patternBytes by produceState<ByteArray?>(null) { value = Res.readBytes(PatternPath) }
    val animatedPattern = remember(patternBytes) {
        patternBytes?.let { AnimatedImageProvider.fromByteArray(it) }
    }
    val tileProvider = remember(tileBytes) {
        val bytes = tileBytes
        TileProvider { _, version, _, _ ->
            RawTile(
                version = version,
                features = emptyMap(),
                etag = TileEtag,
                useCache = RawTile.UseCache.NO,
                state = if (bytes == null) RawTile.State.ERROR else RawTile.State.OK,
                rawData = bytes ?: ByteArray(0),
            )
        }
    }

    var selection by remember { mutableStateOf<GeoObjectSelectionMetadata?>(null) }

    val visited = remember { mutableListOf<String>() }
    val visitor = remember {
        MapObjectVisitor(
            onPlacemarkVisited = {
                visited.add("placemark(${it.getCastedUserData<MapObjectUserData>()?.name})")
            },
            onPolylineVisited = { visited.add("polyline") },
            onPolygonVisited = { visited.add("polygon") },
            onCircleVisited = { visited.add("circle") },
            onCollectionVisitStart = {
                visited.add("collection(${it.userData}) {")
                true
            },
            onCollectionVisitEnd = { visited.add("}") },
            onClusterizedCollectionVisitStart = {
                visited.add("clusterized {")
                true
            },
            onClusterizedCollectionVisitEnd = { visited.add("}") },
        )
    }

    val pinRed = imageProvider(Res.drawable.pin_red)
    val pinGreen = imageProvider(Res.drawable.pin_green)
    val pinYellow = imageProvider(Res.drawable.pin_yellow)
    val icons = remember(pinRed, pinGreen, pinYellow) {
        mapOf(
            MapObjectType.RED to pinRed,
            MapObjectType.GREEN to pinGreen,
            MapObjectType.YELLOW to pinYellow,
        )
    }

    Scaffold(
        bottomBar = {
            AdvancedMapActions(
                actions = advancedMapActions(
                    state = state,
                    log = log,
                    groupState = groupState,
                    polylineState = polylineState,
                    polygonState = polygonState,
                    placemarkState = placemarkState,
                    visitor = visitor,
                    visited = visited,
                    animatedPattern = animatedPattern,
                    layerCircleState = layerCircleState,
                    iconImage = pinGreen,
                    badgeImage = pinRed,
                    onDeselect = { selection = null },
                ),
                modifier = Modifier.fillMaxWidth(),
            )
        },
        modifier = modifier,
    ) { _ ->
        Box(modifier = Modifier.fillMaxSize()) {
            YandexMap(
                cameraPositionState = cameraPositionState,
                config = MapConfig(isNightModeEnabled = isSystemInDarkTheme()),
                modifier = Modifier.fillMaxSize(),
            ) {
                MapListeners(
                    onMapTap = { log.add("onMapTap $it") },
                    onMapLongTap = { log.add("onMapLongTap $it") },
                    onGeoObjectTap = { event ->
                        val geoObject = event.geoObject
                        log.add("onGeoObjectTap ${geoObject.name}")
                        log.add("  tags=${geoObject.tags?.tags}")
                        log.add("  uris=${geoObject.uriMetadata?.uris?.map { it.value }}")
                        log.add("  inspection=${geoObject.inspectionMetadata}")
                        log.add("  poi=${geoObject.personalizedPoiMetadata?.data}")
                        log.add("  selection=${geoObject.selectionMetadata}")
                        selection = geoObject.selectionMetadata
                        selection != null
                    },
                    onMapLoaded = {
                        log.add("onMapLoaded objects=${it.renderObjectCount} in ${it.fullyLoaded}")
                    },
                    onActivePlanFocused = { log.add("onActivePlanFocused ${it.activeLevelId}") },
                    onActivePlanLeft = { log.add("onActivePlanLeft") },
                    onActiveLevelChanged = { log.add("onActiveLevelChanged $it") },
                    onMapWindowSizeChanged = { width, height ->
                        log.add("onMapWindowSizeChanged $width x $height")
                    },
                )

                MapEffect(selection) { map ->
                    val current = selection
                    if (current != null) {
                        map.selectGeoObject(current)
                    } else {
                        map.deselectGeoObject()
                    }
                }

                MapEffect(Unit) {
                    log.add(
                        "bound in composition: " + boundStates(
                            groupState,
                            polylineState,
                            polygonState,
                            placemarkState,
                            layerCircleState,
                        ),
                    )
                }

                if (state.isTrafficEnabled) {
                    TrafficLayer(
                        onTrafficChanged = { log.add("onTrafficChanged ${it?.level} ${it?.color}") },
                        onTrafficLoading = { log.add("onTrafficLoading") },
                        onTrafficExpired = { log.add("onTrafficExpired") },
                    )
                }

                if (state.isTileLayerEnabled && tileBytes != null) {
                    TileLayer(
                        layerId = TileLayerId,
                        options = LayerOptions(transparent = true, cacheable = false),
                        onLayerLoaded = { log.add("onLayerLoaded $TileLayerId") },
                        onDataSourceUpdated = { log.add("onDataSourceUpdated $TileLayerId") },
                        createTileDataSource = { builder ->
                            builder.setTileProvider(tileProvider)
                            builder.setTileFormat(TileFormat.PNG)
                            builder.setProjection(Projections.wgs84Mercator)
                            builder.setZoomRanges(listOf(ZoomRange(0, 20)))
                        },
                    )
                }

                if (state.isObjectLayerEnabled) {
                    MapObjectLayer(ObjectLayerId) {
                        Circle(
                            state = layerCircleState,
                            color = Color.Magenta.copy(alpha = 0.25f),
                            strokeColor = Color.Magenta,
                            strokeWidth = 3f,
                            userData = ObjectLayerId,
                            onTap = {
                                log.add("layer circle tap $it")
                                true
                            },
                        )
                    }
                }

                MapObjectCollection(
                    state = groupState,
                    visible = state.isGroupVisible,
                    zIndex = state.groupZIndex,
                    userData = GroupUserData,
                ) {
                    GroupPlacemarks(
                        placemarks = groupPlacemarks,
                        icons = icons,
                        log = log,
                    )
                }

                Polyline(
                    state = polylineState,
                    strokeColor = Color.Blue,
                    strokeWidth = 6f,
                    outlineColor = Color.White,
                    outlineWidth = 1f,
                    userData = "polyline",
                    onTap = {
                        log.add("polyline tap $it")
                        true
                    },
                )

                Polygon(
                    state = polygonState,
                    color = Color.Cyan.copy(alpha = 0.25f),
                    strokeColor = Color.Blue,
                    strokeWidth = 3f,
                    userData = "polygon",
                    onTap = {
                        log.add("polygon tap $it")
                        true
                    },
                )

                Placemark(
                    state = placemarkState,
                    icon = pinYellow,
                    iconStyle = IconStyle(scale = 1.5f),
                    userData = "solo-placemark",
                    onTap = {
                        log.add("solo placemark tap $it")
                        true
                    },
                )
            }
            MapEventLogPanel(
                log = log,
                modifier = Modifier.align(Alignment.TopStart).padding(8.dp),
            )
        }
    }
}

@[YandexMapComposable Composable]
private fun GroupPlacemarks(
    placemarks: List<Pair<Point, MapObjectUserData>>,
    icons: Map<MapObjectType, ImageProvider>,
    log: MapEventLog,
) {
    placemarks.forEach { (point, data) ->
        Placemark(
            state = rememberPlacemarkState(geometry = point, key = data.name),
            icon = icons.getValue(data.type),
            userData = data,
            onTap = {
                log.add("group placemark ${data.name} tap")
                true
            },
        )
    }
}

private fun advancedMapActions(
    state: AdvancedMapState,
    log: MapEventLog,
    groupState: MapObjectCollectionState,
    polylineState: PolylineState,
    polygonState: PolygonState,
    placemarkState: PlacemarkState,
    visitor: MapObjectVisitor,
    visited: MutableList<String>,
    animatedPattern: AnimatedImageProvider?,
    layerCircleState: CircleState,
    iconImage: ImageProvider,
    badgeImage: ImageProvider,
    onDeselect: () -> Unit,
): List<Pair<String, () -> Unit>> {
    return listOf(
        "Traffic: ${state.isTrafficEnabled.asSwitch()}" to {
            state.isTrafficEnabled = !state.isTrafficEnabled
        },
        "Tiles: ${state.isTileLayerEnabled.asSwitch()}" to {
            state.isTileLayerEnabled = !state.isTileLayerEnabled
        },
        "Obj layer: ${state.isObjectLayerEnabled.asSwitch()}" to {
            state.isObjectLayerEnabled = !state.isObjectLayerEnabled
        },
        "Group: ${state.isGroupVisible.asSwitch()}" to {
            state.isGroupVisible = !state.isGroupVisible
        },
        "Group z=${state.groupZIndex}" to {
            state.groupZIndex = if (state.groupZIndex == 0f) 100f else 0f
        },
        "Group fade" to {
            log.runAndLog("group setVisible") {
                groupState.setVisible(
                    visible = !state.isGroupVisible,
                    animation = Animation(Animation.Type.SMOOTH, 1.seconds),
                    onFinished = Callback { log.add("group fade finished") },
                )
            }
        },
        "Group scale fn" to {
            log.runAndLog("group setPlacemarksScaleFunction") {
                groupState.setPlacemarksScaleFunction(
                    listOf(PointF(14f, 0.5f), PointF(18f, 2f)),
                )
            }
        },
        "Traverse" to {
            log.runAndLog("traverse") {
                visited.clear()
                groupState.traverse(visitor)
                log.add("traversed ${visited.size}: ${visited.take(4).joinToString(" ")}")
            }
        },
        "Line select" to {
            log.runAndLog("polyline select") {
                polylineState.select(
                    color = Color.Magenta,
                    subpolyline = Subpolyline(
                        begin = PolylinePosition(0, 0.0),
                        end = PolylinePosition(1, 0.5),
                    ),
                )
            }
        },
        "Line hide" to {
            log.runAndLog("polyline hide") {
                polylineState.hide(
                    Subpolyline(
                        begin = PolylinePosition(2, 0.5),
                        end = PolylinePosition(3, 1.0),
                    ),
                )
            }
        },
        "Line colors" to {
            log.runAndLog("polyline setStrokeColors") {
                polylineState.setStrokeColors(
                    listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow),
                )
                log.add("segment 0 color = ${polylineState.getStrokeColor(0)}")
            }
        },
        "Line palette" to {
            log.runAndLog("polyline setPaletteColor") {
                polylineState.setPaletteColor(0, Color.Cyan)
                log.add("palette 0 = ${polylineState.getPaletteColor(0)}")
            }
        },
        "Line arrow" to {
            log.runAndLog("polyline addArrow") {
                polylineState.addArrow(
                    position = PolylinePosition(1, 0.5),
                    length = 30f,
                    fillColor = Color.Black,
                )
                log.add("arrows = ${polylineState.arrows.size}")
            }
        },
        "Pin scale fn" to {
            log.runAndLog("placemark setScaleFunction") {
                placemarkState.setScaleFunction(
                    listOf(PointF(14f, 0.5f), PointF(18f, 3f)),
                )
            }
        },
        "Pin text" to {
            log.runAndLog("placemark text") {
                placemarkState.text.text = "Solo pin"
                log.add("text = ${placemarkState.text.text}")
            }
        },
        "Pin icon" to {
            log.runAndLog("placemark useIcon") {
                placemarkState.useIcon().setImage(
                    image = iconImage,
                    style = IconStyle(scale = 2f),
                    onFinished = Callback { log.add("useIcon applied") },
                )
            }
        },
        "Pin composite" to {
            log.runAndLog("placemark useCompositeIcon") {
                val composite = placemarkState.useCompositeIcon()
                composite.setIcon("base", iconImage, IconStyle(scale = 1.5f))
                composite.setIcon(
                    name = "badge",
                    image = badgeImage,
                    style = IconStyle(scale = 0.7f, anchor = PointF(0f, 1f)),
                )
            }
        },
        "Pin animate" to {
            log.runAndLog("placemark useAnimation") {
                val pattern = animatedPattern ?: error("animated pattern is not loaded")
                val animation = placemarkState.useAnimation()
                animation.setIcon(pattern, IconStyle(scale = 2f))
                animation.play(Callback { log.add("animation finished") })
            }
        },
        "Pin model" to {
            log.runAndLog("placemark useModel") {
                placemarkState.useModel()
            }
        },
        "Poly pattern" to {
            log.runAndLog("polygon setPattern") {
                val pattern = animatedPattern ?: error("animated pattern is not loaded")
                polygonState.setPattern(pattern, 1f)
            }
        },
        "Poly reset" to {
            log.runAndLog("polygon resetPattern") {
                polygonState.resetPattern()
            }
        },
        "Deselect" to onDeselect,
        "Bound?" to {
            log.add(
                "bound now: " + boundStates(
                    groupState,
                    polylineState,
                    polygonState,
                    placemarkState,
                    layerCircleState,
                ),
            )
        },
        "Clear log" to { log.clear() },
    )
}

private fun boundStates(
    groupState: MapObjectCollectionState,
    polylineState: PolylineState,
    polygonState: PolygonState,
    placemarkState: PlacemarkState,
    layerCircleState: CircleState,
): String {
    return "group=${groupState.isValid} line=${polylineState.isValid} " +
        "polygon=${polygonState.isValid} pin=${placemarkState.isValid} " +
        "layerCircle=${layerCircleState.isValid}"
}

private fun Boolean.asSwitch(): String {
    return if (this) "on" else "off"
}

private val layerCircle = Circle(Point(59.941026, 30.324789), 250f)

private const val GroupUserData = "placemark-group"
private const val TileLayerId = "sample_tiles"
private const val ObjectLayerId = "sample_objects"
private const val TileEtag = "sample-tile"
private const val TilePath = "files/tile.png"
private const val PatternPath = "files/pattern.gif"
