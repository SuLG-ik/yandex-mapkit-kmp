package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.RawTile
import ru.sulgik.mapkit.ZoomRange
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.geo.Projections
import ru.sulgik.mapkit.layers.Layer
import ru.sulgik.mapkit.layers.LayerLoadedListener
import ru.sulgik.mapkit.layers.LayerOptions
import ru.sulgik.mapkit.layers.TileFormat
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.tiles.TileProvider
import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.AtomicInt
import kotlin.concurrent.atomics.AtomicReference
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.io.encoding.Base64

internal const val PendingTileTraceTag = "pending-tile-layer-trace"
internal const val PendingTileWorkerTimeoutMillis = 5_000L
private const val renderTimeoutMillis = 8_000L
private const val finishedEvent = "finished"
private val tilePng = Base64.decode(
    "iVBORw0KGgoAAAANSUhEUgAAAQAAAAEAAQAAAAB0CZXLAAAAM0lEQVR42u3KoQEAAAwCIP9/Wk9YXYBMeoggCIIgCIIgCIIgCIIgCIIgCIIgCIIgCMLvMPPS4dI8z/G7AAAAAElFTkSuQmCC",
)

internal enum class TileWorkerResult {
    Released,
    TimedOut,
    MainThread,
    Interrupted,
}

internal interface TileWorkerGate {
    fun awaitRelease(): TileWorkerResult
    fun release()
}

internal class PendingTileLayerTrace {
    val events = mutableStateListOf<String>()
}

@Composable
internal fun PendingTileLayerFixture(
    gate: TileWorkerGate,
    trace: PendingTileLayerTrace = remember { PendingTileLayerTrace() },
) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val controller = rememberYandexMapController()
    val scenario = remember(gate, trace) { PendingTileLayerScenario(gate, trace) }
    DisposableEffect(gate) {
        onDispose { gate.release() }
    }

    Column {
        YandexMap(controller = controller, modifier = Modifier.size(260.dp))
        BasicText(text = trace.events.joinToString("\n"), modifier = Modifier.testTag(PendingTileTraceTag))
    }

    val window = controller.mapWindow
    LaunchedEffect(window) {
        if (window != null) {
            scenario.run(window)
        }
    }
}

@OptIn(ExperimentalAtomicApi::class)
private class PendingTileLayerScenario(
    private val gate: TileWorkerGate,
    private val trace: PendingTileLayerTrace,
) {
    private val firstRequestEntered = AtomicBoolean(false)
    private val pendingResponses = AtomicInt(0)
    private val workerFailure = AtomicReference<TileWorkerResult?>(null)
    private val replacementRequested = AtomicBoolean(false)
    private val replacementLoaded = AtomicBoolean(false)
    private val retiredCallbackDelivered = AtomicBoolean(false)

    private val heldProvider = TileProvider { _, version, features, _ ->
        pendingResponses.addAndFetch(1)
        firstRequestEntered.store(true)
        try {
            val outcome = gate.awaitRelease()
            if (outcome != TileWorkerResult.Released && workerFailure.compareAndSet(null, outcome)) {
                gate.release()
            }
            if (workerFailure.load() == null) {
                RawTile(version, features, "held-png", RawTile.UseCache.NO, RawTile.State.OK, tilePng)
            } else {
                RawTile(version, features, "", RawTile.UseCache.NO, RawTile.State.ERROR, byteArrayOf())
            }
        } finally {
            pendingResponses.addAndFetch(-1)
        }
    }
    private val replacementProvider = TileProvider { _, version, features, _ ->
        replacementRequested.store(true)
        RawTile(version, features, "replacement-png", RawTile.UseCache.NO, RawTile.State.OK, tilePng)
    }
    private val heldListener = LayerLoadedListener { retiredCallbackDelivered.store(true) }
    private val replacementListener = LayerLoadedListener { replacementLoaded.store(true) }

    suspend fun run(window: MapWindow) {
        if (!awaitNative { window.isValid && window.width > 0 && window.height > 0 }) {
            trace.events += "failed waiting for the map window"
            return
        }

        val map = window.map
        map.mapType = MapType.NONE
        map.move(CameraPosition(Point(55.75, 37.61), 10f, 0f, 0f))
        if (!removePendingLayer(map)) {
            return
        }
        if (!awaitNative { pendingResponses.load() == 0 || workerFailure.load() != null } || workerFailure.load() != null) {
            trace.events += "failed waiting for tile responses pending=${pendingResponses.load()} workerFailure=${workerFailure.load()}"
            return
        }
        trace.events += "workers released"

        val replacement = map.addLocalTiles("pending-tile-replacement", replacementProvider)
        try {
            replacement.dataSourceLayer().setLayerLoadedListener(replacementListener.asWeakRef())
            if (!awaitNative(followUpFrames = 2) { replacementRequested.load() && replacementLoaded.load() }) {
                trace.events += "failed waiting for replacement rendering requested=${replacementRequested.load()} loaded=${replacementLoaded.load()}"
                return
            }
            if (workerFailure.load() != null || retiredCallbackDelivered.load() || !replacement.isValid || !map.isValid) {
                trace.events += "failed after replacement rendering workerFailure=${workerFailure.load()} retiredCallback=${retiredCallbackDelivered.load()} replacementValid=${replacement.isValid} mapValid=${map.isValid}"
                return
            }
            trace.events += "replacement layer loaded"
            trace.events += finishedEvent
        } finally {
            if (replacement.isValid && map.isValid) {
                replacement.remove()
            }
        }
    }

    private suspend fun removePendingLayer(map: Map): Boolean {
        var heldLayer: Layer? = null
        try {
            val activeLayer = map.addLocalTiles("pending-tile-held", heldProvider)
            heldLayer = activeLayer
            activeLayer.dataSourceLayer().setLayerLoadedListener(heldListener.asWeakRef())
            if (!awaitNative { firstRequestEntered.load() }) {
                trace.events += "failed waiting for renderer to request a tile"
                return false
            }

            if (pendingResponses.load() == 0 || workerFailure.load() != null || retiredCallbackDelivered.load()) {
                trace.events += "failed to hold requests before removal pending=${pendingResponses.load()} workerFailure=${workerFailure.load()} callback=${retiredCallbackDelivered.load()}"
                return false
            }
            trace.events += "native request entered"
            activeLayer.remove()
            if (pendingResponses.load() == 0 || workerFailure.load() != null || activeLayer.isValid || retiredCallbackDelivered.load()) {
                trace.events += "failed to remove pending tile layer pending=${pendingResponses.load()} workerFailure=${workerFailure.load()} layerValid=${activeLayer.isValid} callback=${retiredCallbackDelivered.load()}"
                return false
            }
            trace.events += "layer removed while pending"
            return true
        } finally {
            gate.release()
            if (heldLayer?.isValid == true && map.isValid) {
                heldLayer.remove()
            }
        }
    }
}

private suspend fun awaitNative(followUpFrames: Int = 0, condition: () -> Boolean): Boolean {
    return withTimeoutOrNull(renderTimeoutMillis) {
        while (!condition()) {
            withFrameNanos { }
        }
        repeat(followUpFrames) { withFrameNanos { } }
        true
    } == true
}

private fun Map.addLocalTiles(id: String, provider: TileProvider): Layer {
    return addTileLayer(id, LayerOptions(cacheable = false, animateOnActivation = false)) { builder ->
        builder.setTileProvider(provider)
        builder.setProjection(Projections.wgs84Mercator)
        builder.setZoomRanges(listOf(ZoomRange(zMin = 0, zMax = 19)))
        builder.setTileFormat(TileFormat.PNG)
    }
}
