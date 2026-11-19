package ru.sulgik.mapkit.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.compose.toImageProvider
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.map.MapLoadStatistics
import ru.sulgik.mapkit.map.MapLoadedListener
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import kotlin.math.abs
import kotlin.random.Random
import kotlin.time.TimeSource

private val ProbeCenter = Point(55.751225, 37.629540)
private val ProbeCamera = CameraPosition(ProbeCenter, zoom = 16f, azimuth = 0f, tilt = 0f)
private val ProbeMarkers = listOf(
    Point(55.752225, 37.630540),
    Point(55.750225, 37.628540),
    Point(55.750225, 37.630540),
)
private const val ProbeDeadlineMillis = 30_000L
private const val ProbePlaceholderKey = "00000000-0000-0000-0000-000000000000"

private enum class ReturnCase(val wireName: String) {
    COLD("cold"),
    REOPEN("reopen"),
    RETAINED("retained"),
    RESTART("restart"),
}

private enum class TileMode(val label: String, val wireName: String, val mapType: MapType) {
    VIEW_ONLY("Native view only", "view_only", MapType.NONE),
    REAL("Real tiles (requires a dedicated key)", "real", MapType.VECTOR_MAP),
    MISSING_KEY("Real tiles unavailable", "missing_key", MapType.NONE),
}

@Composable
internal fun ReturnMapMetricsScreen(modifier: Modifier, onExit: () -> Unit) {
    val mapKit = rememberAndInitializeMapKit()
    mapKit.bindToLifecycleOwner()
    val bench = remember(mapKit) { ReturnBench(mapKit.version) }
    val trial = bench.trial

    LaunchedEffect(trial) {
        if (trial != null) {
            delay(ProbeDeadlineMillis)
            bench.finish(trial, expired = true)
        }
    }

    Column(modifier.verticalScroll(rememberScrollState()).padding(12.dp)) {
        OutlinedButton(onClick = onExit, enabled = trial == null) { Text("Back to samples") }
        if (!bench.started) {
            Text("Select the tile mode and the condition of this test install.")
            OutlinedButton(onClick = {
                bench.mode = if (bench.mode == TileMode.VIEW_ONLY) {
                    val key = BuildKonfig.MAPKIT_API_KEY
                    if (key.isBlank() || key == ProbePlaceholderKey) TileMode.MISSING_KEY else TileMode.REAL
                } else {
                    TileMode.VIEW_ONLY
                }
            }) {
                Text(bench.mode.label)
            }
            OutlinedButton(onClick = { bench.start(ReturnCase.COLD) }) { Text("Open on clean install") }
            OutlinedButton(onClick = { bench.start(ReturnCase.RESTART) }) { Text("Open after process restart") }
        } else {
            Box(Modifier.size(260.dp), contentAlignment = Alignment.Center) {
                if (bench.showViewport) {
                    MeasuredViewport(bench, Modifier.matchParentSize())
                }
                if (bench.details != null) {
                    Box(
                        Modifier.matchParentSize().background(MaterialTheme.colorScheme.surface).clickable { },
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(if (bench.details == ReturnCase.RETAINED) "Other tab" else "Details")
                    }
                }
            }
            if (bench.details != null) {
                OutlinedButton(onClick = bench::returnToMap) { Text("Return to map") }
            } else if (trial != null) {
                Text(if (trial.readyMs == null) "Waiting for map projection" else "Tap the map center once")
            } else {
                OutlinedButton(onClick = { bench.openDetails(ReturnCase.REOPEN) }) { Text("Details (unmount map)") }
                OutlinedButton(onClick = { bench.openDetails(ReturnCase.RETAINED) }) { Text("Other tab (retain map)") }
            }
        }
        SelectionContainer {
            Text(bench.results.joinToString("\n"))
        }
    }
}

@Composable
private fun MeasuredViewport(bench: ReturnBench, modifier: Modifier) {
    val controller = rememberYandexMapController()
    var attachment by remember { mutableStateOf<MeasuredAttachment?>(null) }
    val trial = bench.trial
    val current = attachment

    YandexMap(controller = controller, modifier = modifier)
    MapControllerEffect(controller, dispose = {
        attachment?.dispose()
        attachment = null
    }) { window ->
        val attached = MeasuredAttachment(bench, window)
        attachment = attached
        attached.configure()
    }

    LaunchedEffect(current, trial) {
        if (current != null && trial != null) {
            do {
                withFrameNanos { }
            } while (!current.hasProjection())
            bench.ready(trial, current.window)
        }
    }
}

private class MeasuredAttachment(private val bench: ReturnBench, val window: MapWindow) {

    private val map = window.map
    private val initialTrial = bench.trial
    private val inputListener = InputListener(
        onMapTap = { _, point ->
            if (point.isNearProbeCenter()) bench.tapped()
        },
        onMapLongTap = { _, _ -> },
    )
    private val loadedListener = MapLoadedListener { statistics ->
        if (initialTrial != null && hasProjection()) {
            bench.tilesLoaded(initialTrial, statistics)
        }
    }

    fun configure() {
        bench.attached()
        map.mapType = bench.mode.mapType
        map.isNightModeEnabled = false
        map.isZoomGesturesEnabled = false
        map.isScrollGesturesEnabled = false
        map.isRotateGesturesEnabled = false
        map.isTiltGesturesEnabled = false
        map.isFastTapEnabled = true
        map.addInputListener(inputListener.asWeakRef())
        map.move(ProbeCamera)
        if (bench.mode == TileMode.REAL) {
            map.setMapLoadedListener(loadedListener.asWeakRef())
        }

        val bitmap = ImageBitmap(24, 24)
        Canvas(bitmap).drawCircle(Offset(12f, 12f), 10f, Paint().apply { color = Color.Red })
        val icon = bitmap.toImageProvider()
        for (point in ProbeMarkers) {
            val placemark = map.mapObjects.addPlacemark()
            placemark.geometry = point
            placemark.setIcon(icon)
        }
        bench.overlaysApplied()
    }

    fun hasProjection(): Boolean {
        if (!window.isValid || !map.isValid || window.width == 0 || window.height == 0) return false
        val camera = map.cameraPosition
        return abs(camera.zoom - ProbeCamera.zoom) < 0.01f &&
            camera.target.isNearProbeCenter() &&
            window.worldToScreen(ProbeCenter) != null
    }

    fun dispose() {
        if (map.isValid) {
            map.removeInputListener(inputListener.asWeakRef())
            if (bench.mode == TileMode.REAL) map.setMapLoadedListener(null)
        }
    }
}

private class ReturnBench(private val sdkVersion: String) {

    var mode by mutableStateOf(TileMode.VIEW_ONLY)
    var started by mutableStateOf(false)
        private set
    var details by mutableStateOf<ReturnCase?>(null)
        private set
    var trial by mutableStateOf<ReturnTrial?>(null)
        private set
    val results = mutableStateListOf<String>()
    val showViewport: Boolean
        get() = details == null || details == ReturnCase.RETAINED

    private val processId = Random.nextLong().toULong().toString(16)
    private var sequence = 0
    private var currentCounts = ReturnCounts()
    private var departureCounts = currentCounts

    fun start(case: ReturnCase) {
        trial = ReturnTrial("$processId-${++sequence}", case, departureCounts)
        started = true
    }

    fun openDetails(next: ReturnCase) {
        departureCounts = currentCounts
        details = next
    }

    fun returnToMap() {
        val next = checkNotNull(details)
        start(next)
        details = null
    }

    fun attached() {
        currentCounts = currentCounts.copy(mounts = currentCounts.mounts + 1)
        trial?.let { if (it.mountMs == null) it.mountMs = it.elapsed() }
    }

    fun overlaysApplied() {
        currentCounts = currentCounts.copy(
            markers = currentCounts.markers + ProbeMarkers.size,
            icons = currentCounts.icons + 1,
        )
        trial?.let { if (it.overlayMs == null) it.overlayMs = it.elapsed() }
    }

    fun ready(sample: ReturnTrial, window: MapWindow) {
        if (trial !== sample || sample.readyMs != null) return
        sample.width = window.width
        sample.height = window.height
        sample.readyMs = sample.elapsed()
        if (sample.overlayMs == null && sample.case == ReturnCase.RETAINED) {
            sample.overlayMs = sample.readyMs
        }
        finish(sample)
    }

    fun tapped() {
        val sample = trial ?: return
        if (sample.readyMs != null && sample.tapMs == null) {
            sample.tapMs = sample.elapsed()
            finish(sample)
        }
    }

    fun tilesLoaded(sample: ReturnTrial, statistics: MapLoadStatistics) {
        if (trial === sample && sample.statistics == null) {
            sample.tileMs = sample.elapsed()
            sample.statistics = statistics
            finish(sample)
        }
    }

    fun finish(sample: ReturnTrial, expired: Boolean = false) {
        if (trial !== sample) return
        val needsTiles = mode == TileMode.REAL && sample.case != ReturnCase.RETAINED
        if (!expired && (sample.readyMs == null || sample.tapMs == null || (needsTiles && sample.tileMs == null))) {
            return
        }

        val tiles = when {
            mode == TileMode.MISSING_KEY -> "missing_key"
            mode == TileMode.VIEW_ONLY -> "disabled"
            !needsTiles -> "retained"
            sample.statistics == null -> "timeout"
            else -> "loaded"
        }
        val stats = sample.statistics
        val fields = listOf(
            "id=${sample.id}",
            "case=${sample.case.wireName}",
            "mode=${mode.wireName}",
            "sdk=$sdkVersion",
            "viewport=${sample.width}x${sample.height}",
            "mount_ms=${sample.mountMs ?: "na"}",
            "overlay_ms=${sample.overlayMs ?: "na"}",
            "ready_ms=${sample.readyMs ?: "na"}",
            "tap_ms=${sample.tapMs ?: "na"}",
            "tile_ms=${sample.tileMs ?: "na"}",
            "tiles=$tiles",
            "end=${if (expired) "deadline" else "complete"}",
            "mounts=${currentCounts.mounts - sample.before.mounts}",
            "markers=${currentCounts.markers - sample.before.markers}",
            "icons=${currentCounts.icons - sample.before.icons}",
            "geometry_ms=${stats?.curZoomGeometryLoaded?.inWholeMilliseconds ?: "na"}",
            "placemarks_ms=${stats?.curZoomPlacemarksLoaded?.inWholeMilliseconds ?: "na"}",
            "labels_ms=${stats?.curZoomLabelsLoaded?.inWholeMilliseconds ?: "na"}",
            "delayed_geometry_ms=${stats?.delayedGeometryLoaded?.inWholeMilliseconds ?: "na"}",
            "models_ms=${stats?.curZoomModelsLoaded?.inWholeMilliseconds ?: "na"}",
            "fully_loaded_ms=${stats?.fullyLoaded?.inWholeMilliseconds ?: "na"}",
            "fully_appeared_ms=${stats?.fullyAppeared?.inWholeMilliseconds ?: "na"}",
            "render_objects=${stats?.renderObjectCount ?: "na"}",
            "tile_bytes=${stats?.tileMemoryUsage ?: "na"}",
        )
        val row = "MAPKIT_RETURN_METRIC|" + fields.joinToString("|")
        println(row)
        results.add(row)
        trial = null
    }
}

private data class ReturnCounts(val mounts: Int = 0, val markers: Int = 0, val icons: Int = 0)

private class ReturnTrial(val id: String, val case: ReturnCase, val before: ReturnCounts) {

    private val startedAt = TimeSource.Monotonic.markNow()
    var mountMs: Long? = null
    var overlayMs: Long? = null
    var readyMs: Long? by mutableStateOf(null)
    var tapMs: Long? = null
    var tileMs: Long? = null
    var statistics: MapLoadStatistics? = null
    var width = 0
    var height = 0

    fun elapsed(): Long {
        return startedAt.elapsedNow().inWholeMilliseconds
    }
}

private fun Point.isNearProbeCenter(): Boolean {
    return abs(latitude.value - ProbeCenter.latitude.value) < 0.00035 &&
        abs(longitude.value - ProbeCenter.longitude.value) < 0.00035
}
