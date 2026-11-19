package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.withContext
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.compose.ClusterGroup
import ru.sulgik.mapkit.compose.Clustering
import ru.sulgik.mapkit.compose.ClusterizingConfig
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
internal const val PlacemarkIconRenderingArgument = "--placemark-image-test"
internal const val ClusterIconRenderingArgument = "--cluster-image-test"

private val iconPoint = Point(55.751225, 37.629540)
private val iconCamera = CameraPosition(iconPoint, zoom = 14f, azimuth = 0f, tilt = 0f)
private val iconStyle = IconStyle(anchor = PointF(0f, 0.5f))
private val iconClustering = ClusterizingConfig(clusterRadius = 60.0, minZoom = 19)
internal val IconRenderingBackdrop = Color(0xFF637D8F)
internal val IconRenderingDensityMark = Color(0xFF8050F0)

internal enum class IconInk(val color: Color) {
    Red(Color.Red),
    Blue(Color.Blue),
    Green(Color.Green),
    Magenta(Color.Magenta),
    Yellow(Color.Yellow),
    Cyan(Color.Cyan),
    Orange(Color(0xFFFF8000)),
}

internal enum class IconRenderingCase(val ink: IconInk?) {
    Empty(null),
    Bitmap(IconInk.Red),
    Narrow(IconInk.Blue),
    DensityOnly(IconInk.Blue),
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
    ;

    val raisesDensity: Boolean
        get() = when (this) {
            DensityOnly, Wide, Hidden, Visible -> true
            else -> false
        }
}

private enum class CoilOutcome {
    Success,
    Failure,
    Cancelled,
}

private class IconRequest(attempts: Int = 1) {
    private val results = List(attempts) { CompletableDeferred<IconInk>() }
    val started = MutableStateFlow(0)
    val outcome = MutableStateFlow<CoilOutcome?>(null)

    suspend fun fetch(): IconInk {
        return withContext(NonCancellable) {
            val index = started.getAndUpdate { it + 1 }
            val attempt = checkNotNull(results.getOrNull(index)) { "Unexpected Coil attempt ${index + 1}" }
            attempt.await()
        }
    }

    fun succeed(ink: IconInk, attempt: Int = 1) {
        results[attempt - 1].complete(ink)
    }

    fun fail() {
        results.first().completeExceptionally(IllegalStateException("Synthetic icon failure"))
    }

    fun dispose() {
        results.forEach { it.cancel() }
    }
}

private class CoilObservation(
    private val request: IconRequest,
    private val attempts: Int = 1,
    private val outcome: CoilOutcome? = null,
) {

    @Composable
    fun status(case: IconRenderingCase): String {
        val started by request.started.collectAsState()
        val reportedOutcome by request.outcome.collectAsState()
        if (started == attempts && (outcome == null || reportedOutcome == outcome)) return case.name
        return "${case.name} pending (attempts=$started/$attempts, outcome=$reportedOutcome)"
    }
}

private class IconRenderingSequence {
    private val retryable = IconRequest(attempts = 2)
    private val older = IconRequest()
    private val newer = IconRequest()
    private val removed = IconRequest()

    var case by mutableStateOf(IconRenderingCase.Empty)
        private set

    fun advance() {
        case = IconRenderingCase.entries[case.ordinal + 1]
        when (case) {
            IconRenderingCase.Failure -> retryable.fail()
            IconRenderingCase.Retried -> retryable.succeed(IconInk.Cyan, attempt = 2)
            IconRenderingCase.Newer -> newer.succeed(IconInk.Green)
            IconRenderingCase.OlderCompleted -> older.succeed(IconInk.Red)
            IconRenderingCase.RemovedRequestCompleted -> removed.succeed(IconInk.Red)
            else -> Unit
        }
    }

    fun currentRequest(): IconRequest? {
        return when (case) {
            IconRenderingCase.Loading,
            IconRenderingCase.Failure,
            IconRenderingCase.Retrying,
            IconRenderingCase.Retried,
            -> retryable

            IconRenderingCase.OlderPending -> older

            IconRenderingCase.Newer, IconRenderingCase.OlderCompleted -> newer

            IconRenderingCase.RemovalPending -> removed

            else -> null
        }
    }

    fun observeCoil(): CoilObservation? {
        return when (case) {
            IconRenderingCase.Loading -> CoilObservation(retryable)
            IconRenderingCase.Failure -> CoilObservation(retryable, outcome = CoilOutcome.Failure)
            IconRenderingCase.Retrying -> CoilObservation(retryable, attempts = 2)
            IconRenderingCase.Retried -> CoilObservation(retryable, attempts = 2, outcome = CoilOutcome.Success)
            IconRenderingCase.OlderPending -> CoilObservation(older)
            IconRenderingCase.Newer -> CoilObservation(newer, outcome = CoilOutcome.Success)
            IconRenderingCase.OlderCompleted -> CoilObservation(older, outcome = CoilOutcome.Cancelled)
            IconRenderingCase.RemovalPending -> CoilObservation(removed)
            IconRenderingCase.RemovedRequestCompleted -> CoilObservation(removed, outcome = CoilOutcome.Cancelled)
            else -> null
        }
    }

    fun dispose() {
        listOf(retryable, older, newer, removed).forEach(IconRequest::dispose)
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
            add(
                Fetcher.Factory<IconRequest> { data, _, _ ->
                    Fetcher {
                        val ink = data.fetch()
                        ImageFetchResult(ink.coilImage(), isSampled = false, dataSource = DataSource.MEMORY)
                    }
                },
            )
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
    val status = sequence.observeCoil()?.status(case) ?: case.name
    SideEffect { onStatus(status) }

    val bitmap = remember { bitmapIcon(IconInk.Red) }
    val backdrop = remember { backdropIcon() }
    val backdropState = rememberPlacemarkState(iconPoint)
    val group = remember {
        ClusterGroup(
            points = listOf(
                Point(iconPoint.latitude.value, iconPoint.longitude.value - 0.00001),
                Point(iconPoint.latitude.value, iconPoint.longitude.value + 0.00001),
            ),
            icon = bitmapIcon(IconInk.Orange),
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
    val retry = case == IconRenderingCase.Retrying || case == IconRenderingCase.Retried

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier.size(240.dp)
                .onGloballyPositioned(onMapLayout)
                .semantics { contentDescription = IconRenderingMap },
        ) {
            CompositionLocalProvider(
                LocalDensity provides if (case.raisesDensity) {
                    Density(density.density * 1.5f, density.fontScale)
                } else {
                    density
                },
            ) {
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
                                val paint = if (case == IconRenderingCase.Hidden) IconInk.Green else checkNotNull(case.ink)
                                PaintedStripe(paint, wide, density.density)
                            } else {
                                CoilStripe(loader, request, retry)
                            }
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier.widthIn(min = 180.dp)
                .heightIn(min = 48.dp)
                .testTag(AdvanceIconRendering)
                .onGloballyPositioned(onAdvanceLayout)
                .clickable(enabled = case != IconRenderingCase.Recreated, role = Role.Button) {
                    sequence.advance()
                },
            contentAlignment = Alignment.Center,
        ) {
            BasicText(AdvanceIconRendering, maxLines = 1)
        }
        BasicText(
            text = status,
            modifier = Modifier.testTag(IconRenderingStatus),
            style = TextStyle(fontSize = 14.sp, lineHeight = 18.sp),
            maxLines = 2,
        )
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
private fun PaintedStripe(ink: IconInk, wide: Boolean, baseDensity: Float) {
    val width = if (wide) 56.dp else 24.dp
    Box(Modifier.size(width = width + 8.dp, height = 24.dp)) {
        Box(Modifier.offset(x = 8.dp).size(width, 24.dp).background(ink.color)) {
            if (LocalDensity.current.density > baseDensity * 1.25f) {
                Box(
                    Modifier.offset(x = width * 0.14f, y = 4.dp)
                        .size(width * 0.22f, 5.dp)
                        .background(IconRenderingDensityMark),
                )
            }
        }
    }
}

@Composable
private fun CoilStripe(loader: ImageLoader, icon: IconRequest, retry: Boolean) {
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
            .listener(
                onCancel = { icon.outcome.value = CoilOutcome.Cancelled },
                onError = { _, _ -> icon.outcome.value = CoilOutcome.Failure },
                onSuccess = { _, _ -> icon.outcome.value = CoilOutcome.Success },
            )
            .build()
    }
    val painter = rememberAsyncImagePainter(request, imageLoader = loader, contentScale = ContentScale.FillBounds)
    LaunchedEffect(painter, retry) {
        if (retry) painter.restart()
    }
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

private fun bitmapIcon(ink: IconInk): ImageProvider {
    val bitmap = ImageBitmap(32, 24)
    Canvas(bitmap).drawRect(Rect(8f, 0f, 32f, 24f), Paint().apply { color = ink.color })
    return bitmap.toImageProvider()
}

private fun backdropIcon(): ImageProvider {
    val bitmap = ImageBitmap(48, 48)
    Canvas(bitmap).drawRect(Rect(0f, 0f, 48f, 48f), Paint().apply { color = IconRenderingBackdrop })
    return bitmap.toImageProvider()
}
