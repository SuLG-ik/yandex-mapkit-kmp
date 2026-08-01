package ru.sulgik.mapkit.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.location.DummyLocationQuality
import ru.sulgik.mapkit.location.Location
import ru.sulgik.mapkit.location.LocationSettings
import ru.sulgik.mapkit.location.LocationSimulator
import ru.sulgik.mapkit.location.LocationSimulatorListener
import ru.sulgik.mapkit.location.SimulationSettings
import ru.sulgik.mapkit.location.fineSettings
import ru.sulgik.mapkit.offline_cache.ErrorListener
import ru.sulgik.mapkit.offline_cache.RegionListUpdatesListener
import ru.sulgik.mapkit.offline_cache.RegionListener
import ru.sulgik.mapkit.runtime.i18n.I18nManager
import ru.sulgik.mapkit.runtime.logging.LogListener
import ru.sulgik.mapkit.runtime.logging.Logging
import ru.sulgik.mapkit.storage.StorageErrorListener
import kotlin.time.Clock
import kotlin.time.Duration

@Composable
fun RuntimeScreen(modifier: Modifier = Modifier) {
    val mapKit = rememberAndInitializeMapKit()
    mapKit.bindToLifecycleOwner()
    val log = rememberMapEventLog()

    val facts = remember { runtimeFacts(mapKit) }

    val storageErrorListener = remember {
        StorageErrorListener { log.add("onStorageError $it") }
    }
    val regionListUpdatesListener = remember {
        RegionListUpdatesListener { log.add("onListUpdated ${mapKit.offlineCacheManager.regions().size}") }
    }
    val regionListener = remember {
        RegionListener(
            onRegionStateChanged = { log.add("onRegionStateChanged $it") },
            onRegionProgress = { },
        )
    }
    val offlineErrorListener = remember {
        ErrorListener(
            onError = { log.add("offline onError ${it.description ?: it.error}") },
            onRegionError = { error, regionId ->
                log.add("offline onRegionError $regionId ${error.description ?: error.error}")
            },
        )
    }

    var logMessageCount by remember { mutableStateOf(0) }
    val logListener = remember {
        LogListener {
            logMessageCount++
            if (logMessageCount <= MaxShownLogMessages) {
                log.add("mapkit log ${it.level} [${it.scope}] ${it.message}")
            }
        }
    }
    var simulator by remember { mutableStateOf<LocationSimulator?>(null) }
    val simulatorListener = remember {
        LocationSimulatorListener { log.add("onSimulationFinished") }
    }

    DisposableEffect(mapKit) {
        log.runAndLog("subscribe listeners") {
            mapKit.storageManager.addStorageErrorListener(storageErrorListener.asWeakRef())
            mapKit.offlineCacheManager.addRegionListUpdatesListener(
                regionListUpdatesListener.asWeakRef(),
            )
            mapKit.offlineCacheManager.addRegionListener(regionListener.asWeakRef())
            mapKit.offlineCacheManager.addErrorListener(offlineErrorListener.asWeakRef())
        }
        onDispose {
            log.runAndLog("unsubscribe listeners") {
                mapKit.storageManager.removeStorageErrorListener(storageErrorListener.asWeakRef())
                mapKit.offlineCacheManager.removeRegionListUpdatesListener(
                    regionListUpdatesListener.asWeakRef(),
                )
                mapKit.offlineCacheManager.removeRegionListener(regionListener.asWeakRef())
                mapKit.offlineCacheManager.removeErrorListener(offlineErrorListener.asWeakRef())
            }
        }
    }

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        facts.forEach { (section, values) ->
            Text(section, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            values.forEach { (name, value) ->
                Text("$name = $value", fontSize = 12.sp)
            }
            HorizontalDivider()
        }

        Text("Storage", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        RuntimeActions(
            listOf(
                "Compute size" to {
                    log.runAndLog("computeSize") {
                        mapKit.storageManager.computeSize { bytes, error ->
                            log.add("computeSize -> $bytes bytes, error=$error")
                        }
                    }
                },
                "Max tile size" to {
                    log.runAndLog("maxTileStorageSize") {
                        mapKit.storageManager.maxTileStorageSize { bytes, error ->
                            log.add("maxTileStorageSize -> $bytes bytes, error=$error")
                        }
                    }
                },
                "Set max 64 MB" to {
                    log.runAndLog("setMaxTileStorageSize") {
                        mapKit.storageManager.setMaxTileStorageSize(MaxTileStorageSize) { bytes, error ->
                            log.add("setMaxTileStorageSize -> $bytes bytes, error=$error")
                        }
                    }
                },
                "Reset max" to {
                    log.runAndLog("resetMaxTileStorageSize") {
                        mapKit.storageManager.resetMaxTileStorageSize { bytes, error ->
                            log.add("resetMaxTileStorageSize -> $bytes bytes, error=$error")
                        }
                    }
                },
            ),
        )

        Text("Offline cache", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        RuntimeActions(
            listOf(
                "Regions" to {
                    log.runAndLog("regions") {
                        val regions = mapKit.offlineCacheManager.regions()
                        log.add("regions = ${regions.size}")
                        regions.take(3).forEach {
                            log.add(
                                "region ${it.id} ${it.name}/${it.country} ${it.size.text} " +
                                    "state=${mapKit.offlineCacheManager.getState(it.id)} " +
                                    "progress=${mapKit.offlineCacheManager.getProgress(it.id)} " +
                                    "released=${it.releaseTime}",
                            )
                        }
                    }
                },
                "Cache size" to {
                    log.runAndLog("computeCacheSize") {
                        mapKit.offlineCacheManager.computeCacheSize {
                            log.add("computeCacheSize -> $it bytes")
                        }
                    }
                },
                "Cache path" to {
                    log.runAndLog("requestPath") {
                        mapKit.offlineCacheManager.requestPath { log.add("requestPath -> $it") }
                    }
                },
                "Regions at point" to {
                    log.runAndLog("requestRegionsAtPoint") {
                        mapKit.offlineCacheManager.requestRegionsAtPoint(startPosition.target) { regions, error ->
                            log.add("requestRegionsAtPoint -> $regions, error=${error?.description}")
                        }
                    }
                },
            ),
        )

        Text("Logging", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        RuntimeActions(
            listOf(
                "Subscribe" to {
                    log.runAndLog("Logging.subscribe") {
                        Logging.getLogging().subscribe(logListener.asWeakRef())
                    }
                },
                "Unsubscribe" to {
                    log.runAndLog("Logging.unsubscribe") {
                        Logging.getLogging().unsubscribe(logListener.asWeakRef())
                        log.add("received $logMessageCount messages")
                    }
                },
            ),
        )

        Text("Location", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        RuntimeActions(
            listOf(
                "Start simulation" to {
                    log.runAndLog("startSimulation") {
                        val created = mapKit.createLocationSimulator(polyline)
                        created.speed = SimulationSpeed
                        created.subscribeForSimulatorEvents(simulatorListener.asWeakRef())
                        created.startSimulation(
                            listOf(
                                SimulationSettings(
                                    geometry = polyline,
                                    locationSettings = LocationSettings.fineSettings(),
                                ),
                            ),
                        )
                        simulator = created
                    }
                },
                "Simulator state" to {
                    log.runAndLog("simulator state") {
                        val current = simulator ?: error("simulator is not created")
                        log.add(
                            "isActive=${current.isActive} speed=${current.speed} " +
                                "position=${current.polylinePosition()} legs=${current.settings.size}",
                        )
                    }
                },
                "Stop simulation" to {
                    log.runAndLog("stopSimulation") {
                        val current = simulator ?: error("simulator is not created")
                        current.stopSimulation()
                        current.unsubscribeFromSimulatorEvents(simulatorListener.asWeakRef())
                    }
                },
                "Dummy location" to {
                    log.runAndLog("dummy setLocation") {
                        mapKit.createDummyLocationManager().setLocation(
                            location = Location(
                                position = startPosition.target,
                                accuracy = 10.0,
                                altitude = 5.0,
                                altitudeAccuracy = 1.0,
                                heading = 90.0,
                                speed = 3.0,
                                indoorLevelId = null,
                                absoluteTimestamp = Clock.System.now(),
                                relativeTimestamp = Duration.ZERO,
                            ),
                            quality = DummyLocationQuality.HIGH,
                        )
                    }
                },
                "Clear log" to { log.clear() },
            ),
        )

        MapEventLogPanel(log = log, modifier = Modifier.fillMaxWidth())
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun RuntimeActions(actions: List<Pair<String, () -> Unit>>) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        actions.forEach { (title, onClick) ->
            OutlinedButton(
                onClick = onClick,
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
            ) {
                Text(title, fontSize = 12.sp)
            }
        }
    }
}

private fun runtimeFacts(mapKit: MapKit): List<Pair<String, List<Pair<String, String>>>> {
    return listOf(
        "MapKit" to listOf(
            probe("version") { mapKit.version },
            probe("isValid") { mapKit.isValid },
            probe("storageManager.isValid") { mapKit.storageManager.isValid },
            probe("offlineCacheManager.isValid") { mapKit.offlineCacheManager.isValid },
        ),
        "I18n" to listOf(
            probe("locale") { I18nManager.getLocale() },
            probe("isValid") { I18nManager.getInstance().isValid },
            probe("localizeDistance(1234)") { I18nManager.getInstance().localizeDistance(1234) },
            probe("localizeDuration(3671)") { I18nManager.getInstance().localizeDuration(3671) },
            probe("localizeSpeed(16.7)") { I18nManager.getInstance().localizeSpeed(16.7) },
            probe("localizeDataSize(1234567)") {
                I18nManager.getInstance().localizeDataSize(1234567)
            },
            probe("canonicalSpeed(16.7)") { I18nManager.getInstance().canonicalSpeed(16.7) },
            probe("localizeCanonicalUnit") {
                val manager = I18nManager.getInstance()
                manager.localizeCanonicalUnit(manager.canonicalSpeed(16.7))
            },
            probe("prefs") { I18nManager.getInstance().prefs },
            probe("som") { I18nManager.getInstance().som },
            probe("timeFormat") { I18nManager.getInstance().timeFormat },
        ),
        "Logging" to listOf(
            probe("isValid") { Logging.getLogging().isValid },
        ),
    )
}

private fun probe(name: String, value: () -> Any?): Pair<String, String> {
    return try {
        name to value().toString()
    } catch (error: Throwable) {
        println("RuntimeScreen: $name failed\n${error.stackTraceToString()}")
        name to "FAILED: $error"
    }
}

private const val MaxShownLogMessages = 8
private const val MaxTileStorageSize = 64L * 1024 * 1024
private const val SimulationSpeed = 15.0
