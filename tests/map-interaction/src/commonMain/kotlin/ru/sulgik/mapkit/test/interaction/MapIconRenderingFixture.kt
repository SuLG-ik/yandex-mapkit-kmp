package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import coil3.ColorImage
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.decode.DataSource
import coil3.fetch.Fetcher
import coil3.fetch.ImageFetchResult
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.compose.ClusterGroup
import ru.sulgik.mapkit.compose.ClusterizingConfig
import ru.sulgik.mapkit.compose.Clustering
import ru.sulgik.mapkit.compose.MapConfig
import ru.sulgik.mapkit.compose.Placemark
import ru.sulgik.mapkit.compose.PlacemarkState
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.YandexMapComposable
import ru.sulgik.mapkit.compose.YandexMapsComposeExperimentalApi
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberCameraPositionState
import ru.sulgik.mapkit.compose.rememberPlacemarkState
import ru.sulgik.mapkit.compose.toImageProvider
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.MapType

internal const val IconRenderingMap = "icon-rendering-map"
internal const val IconRenderingStatus = "icon-rendering-status"
internal const val AdvanceIconRendering = "Advance icon rendering"

private val iconPoint = Point(55.751225, 37.629540)
private val iconCamera = CameraPosition(iconPoint, zoom = 14f, azimuth = 0f, tilt = 0f)
private val iconStyle = IconStyle(anchor = PointF(0f, 0.5f))
private val iconClustering = ClusterizingConfig(clusterRadius = 60.0, minZoom = 19)
internal val IconRenderingBackdrop = Color(0xFF637D8F)

internal enum class IconInk(val color: Color) {
    Red(Color.Red),
    Blue(Color.Blue),
    Green(Color.Green),
    Magenta(Color.Magenta),
    Yellow(Color.Yellow),
    Cyan(Color.Cyan),
}

internal enum class IconRenderingCase(val ink: IconInk?) {
    Empty(null),
    Bitmap(IconInk.Red),
    Narrow(IconInk.Blue),
    Wide(IconInk.Green),
    Hidden(null),
    Visible(IconInk.Green),
    Loading(IconInk.Magenta),
    Failure(IconInk.Yellow),
    Retrying(IconInk.Magenta),
    Retried(IconInk.Cyan),
    OlderPending(IconInk.Magenta),
    Newer(IconInk.Green),
    OlderCompleted(IconInk.Green),
    RemovalPending(IconInk.Magenta),
    Removed(null),
    RemovedRequestCompleted(null),
    Recreated(IconInk.Blue),
}

private class IconRequest {
    private val result = CompletableDeferred<IconInk>()
    val started = MutableStateFlow(false)
    val settled = MutableStateFlow(false)

    suspend fun fetch(): IconInk {
        return withContext(NonCancellable) {
            started.value = true
            try {
                result.await()
            } finally {
                settled.value = true
            }
        }
    }

    fun succeed(ink: IconInk) {
        result.complete(ink)
    }

    fun fail() {
        result.completeExceptionally(IllegalStateException("Synthetic icon failure"))
    }
}

private class IconRenderingSequence {
    private val failing = IconRequest()
    private val retry = IconRequest()
    private val older = IconRequest()
    private val newer = IconRequest()
    private val removed = IconRequest()

    var case by mutableStateOf(IconRenderingCase.Empty)
        private set

    fun advance() {
        case = IconRenderingCase.entries[case.ordinal + 1]
        when (case) {
            IconRenderingCase.Failure -> failing.fail()
            IconRenderingCase.Retried -> retry.succeed(IconInk.Cyan)
            IconRenderingCase.Newer -> newer.succeed(IconInk.Green)
            IconRenderingCase.OlderCompleted -> older.succeed(IconInk.Red)
            IconRenderingCase.RemovedRequestCompleted -> removed.succeed(IconInk.Red)
            else -> Unit
        }
    }

    fun currentRequest(): IconRequest? {
        return when (case) {
            IconRenderingCase.Loading, IconRenderingCase.Failure -> failing
            IconRenderingCase.Retrying, IconRenderingCase.Retried -> retry
            IconRenderingCase.OlderPending -> older
            IconRenderingCase.Newer, IconRenderingCase.OlderCompleted -> newer
            IconRenderingCase.RemovalPending -> removed
            else -> null
        }
    }

    fun requestToObserve(): IconRequest? {
        return when (case) {
            IconRenderingCase.OlderCompleted -> older
            IconRenderingCase.RemovedRequestCompleted -> removed
            else -> null
        }
    }

    fun dispose() {
        listOf(failing, retry, older, newer, removed).forEach { it.fail() }
    }
}

@OptIn(YandexMapsComposeExperimentalApi::class)
@Composable
internal fun MapIconRenderingFixture(
    clustered: Boolean,
    onMapLayout: (LayoutCoordinates) -> Unit = {},
    onAdvanceLayout: (LayoutCoordinates) -> Unit = {},
    onStatus: (String) -> Unit = {},
) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val sequence = remember { IconRenderingSequence() }
    val context = LocalPlatformContext.current
    val loader = remember(context) {
        ImageLoader.Builder(context).components {
            add(Fetcher.Factory<IconRequest> { data, _, _ ->
                Fetcher {
                    val ink = data.fetch()
                    ImageFetchResult(ink.coilImage(), isSampled = false, dataSource = DataSource.MEMORY)
                }
            })
        }.build()
    }
    DisposableEffect(loader) {
        onDispose {
            sequence.dispose()
            loader.shutdown()
        }
    }

    val case = sequence.case
    val request = sequence.currentRequest()
    val observed = sequence.requestToObserve()
    val started = request?.started?.collectAsState()?.value ?: true
    val settled = observed?.settled?.collectAsState()?.value ?: true
    val status = if (started && settled) case.name else "${case.name} pending"
    SideEffect { onStatus(status) }

    val bitmap = remember { bitmapIcon() }
    val backdrop = remember { backdropIcon() }
    val backdropState = rememberPlacemarkState(iconPoint)
    val group = remember(bitmap) {
        ClusterGroup(
            points = listOf(
                Point(iconPoint.latitude.value, iconPoint.longitude.value - 0.00001),
                Point(iconPoint.latitude.value, iconPoint.longitude.value + 0.00001),
            ),
            icon = bitmap,
            iconStyle = iconStyle,
        )
    }
    val placemark = rememberPlacemarkState(iconPoint)
    val camera = rememberCameraPositionState { position = iconCamera }
    val density = LocalDensity.current
    val wide = when (case) {
        IconRenderingCase.Wide, IconRenderingCase.Hidden, IconRenderingCase.Visible -> true
        else -> false
    }

    Column {
        Box(
            Modifier.size(260.dp)
                .onGloballyPositioned(onMapLayout)
                .semantics { contentDescription = IconRenderingMap },
        ) {
            CompositionLocalProvider(LocalDensity provides if (wide) {
                Density(density.density * 1.5f, density.fontScale)
            } else {
                density
            }) {
                YandexMap(
                    cameraPositionState = camera,
                    modifier = Modifier.fillMaxSize(),
                    config = MapConfig(mapType = MapType.NONE, isNightModeEnabled = false),
                ) {
                    Placemark(backdropState, icon = backdrop, zIndex = -1f)
                    when (case) {
                        IconRenderingCase.Empty,
                        IconRenderingCase.Removed,
                        IconRenderingCase.RemovedRequestCompleted,
                        -> Unit

                        IconRenderingCase.Bitmap -> BitmapMapIcon(clustered, placemark, group, bitmap)
                        else -> RenderedMapIcon(clustered, placemark, group, case != IconRenderingCase.Hidden) {
                            if (request == null) {
                                PaintedStripe(checkNotNull(case.ink), wide)
                            } else {
                                CoilStripe(loader, request)
                            }
                        }
                    }
                }
            }
        }
        BasicText(
            text = AdvanceIconRendering,
            modifier = Modifier.onGloballyPositioned(onAdvanceLayout)
                .clickable(enabled = case != IconRenderingCase.Recreated, role = Role.Button) {
                    sequence.advance()
                },
        )
        BasicText(status, Modifier.testTag(IconRenderingStatus))
    }
}

@YandexMapComposable
@Composable
private fun BitmapMapIcon(clustered: Boolean, placemark: PlacemarkState, group: ClusterGroup, bitmap: ImageProvider) {
    if (clustered) {
        Clustering(group, icon = bitmap, iconStyle = iconStyle, config = iconClustering)
    } else {
        Placemark(placemark, icon = bitmap, iconStyle = iconStyle)
    }
}

@OptIn(YandexMapsComposeExperimentalApi::class)
@YandexMapComposable
@Composable
private fun RenderedMapIcon(
    clustered: Boolean,
    placemark: PlacemarkState,
    group: ClusterGroup,
    visible: Boolean,
    content: @Composable () -> Unit,
) {
    if (clustered) {
        Clustering(group, iconStyle = iconStyle, config = iconClustering, visible = visible) { info ->
            check(info.size == 2) { "Expected a two-marker cluster, got ${info.size}" }
            content()
        }
    } else {
        Placemark(placemark, iconStyle = iconStyle, visible = visible, content = content)
    }
}

@Composable
private fun PaintedStripe(ink: IconInk, wide: Boolean) {
    Box(Modifier.size(width = if (wide) 64.dp else 32.dp, height = 24.dp)) {
        Box(Modifier.offset(x = 8.dp).size(width = if (wide) 56.dp else 24.dp, height = 24.dp).background(ink.color))
    }
}

@Composable
private fun CoilStripe(loader: ImageLoader, icon: IconRequest) {
    val context = LocalPlatformContext.current
    val request = remember(context, icon) {
        ImageRequest.Builder(context)
            .data(icon)
            .size(24, 24)
            .memoryCachePolicy(CachePolicy.DISABLED)
            .diskCachePolicy(CachePolicy.DISABLED)
            .networkCachePolicy(CachePolicy.DISABLED)
            .placeholder(IconInk.Magenta.coilImage())
            .error(IconInk.Yellow.coilImage())
            .build()
    }
    val painter = rememberAsyncImagePainter(request, imageLoader = loader, contentScale = ContentScale.FillBounds)
    Box(Modifier.size(32.dp, 24.dp)) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.offset(x = 8.dp).size(24.dp),
            contentScale = ContentScale.FillBounds,
        )
    }
}

private fun IconInk.coilImage(): ColorImage {
    return ColorImage(color.toArgb(), width = 24, height = 24)
}

private fun bitmapIcon(): ImageProvider {
    val bitmap = ImageBitmap(32, 24)
    Canvas(bitmap).drawRect(Rect(8f, 0f, 32f, 24f), Paint().apply { color = IconInk.Red.color })
    return bitmap.toImageProvider()
}

private fun backdropIcon(): ImageProvider {
    val bitmap = ImageBitmap(48, 48)
    Canvas(bitmap).drawRect(Rect(0f, 0f, 48f, 48f), Paint().apply { color = IconRenderingBackdrop })
    return bitmap.toImageProvider()
}
