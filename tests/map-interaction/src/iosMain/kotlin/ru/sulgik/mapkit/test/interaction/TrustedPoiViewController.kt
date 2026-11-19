@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController
import platform.darwin.NSObject
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.layers.GeoObjectTapListener
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.GeoObjectSelectionMetadata
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.MapWindow
import YandexMapKit.YMKGeoObjectSelectionMetadata as NativePoiSelection
import YandexMapKit.YMKGeoObjectTapEvent as NativePoiTapEvent
import YandexMapKit.YMKGeometry as NativeGeometry
import YandexMapKit.YMKLayersGeoObjectTapListenerProtocol as NativePoiTapListener
import YandexMapKit.YMKMap as NativeMap
import YandexMapKit.YMKMapInputListenerProtocol as NativeInputListener
import YandexMapKit.YMKMapLoadStatistics as NativeMapLoadStatistics
import YandexMapKit.YMKMapLoadedListenerProtocol as NativeMapLoadedListener
import YandexMapKit.YMKPoint as NativePoint

public fun trustedPoiViewController(apiKey: String): UIViewController {
    MapKit.setApiKey(apiKey)
    return ComposeUIViewController { TrustedPoiFixture() }
}

@Composable
private fun TrustedPoiFixture() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val controller = rememberYandexMapController()
    val scenario = remember { TrustedPoiScenario() }
    Column {
        YandexMap(
            controller = controller,
            modifier = Modifier.width(260.dp).height(300.dp)
                .testTag("trusted-poi-map")
                .semantics { contentDescription = "trusted-poi-map" },
        )
        BasicText(
            text = "Arm POI callback case",
            modifier = Modifier.clickable(role = Role.Button) { scenario.armNext() },
        )
        BasicText(
            text = scenario.events.joinToString("\n"),
            modifier = Modifier.testTag("trusted-poi-trace"),
        )
    }
    MapControllerEffect(controller, dispose = { scenario.detach(it) }) { scenario.attach(it) }
}

private enum class PoiPhase {
    Discover,
    Consume,
    Propagate,
}

private data class PoiReference(
    val selection: GeoObjectSelectionMetadata,
    val latitude: Double,
    val longitude: Double,
)

private class TrustedPoiScenario {

    val events = mutableStateListOf<String>()
    private var phase = PoiPhase.Discover
    private var reference: PoiReference? = null
    private var window: MapWindow? = null

    private val mapLoaded = object : NSObject(), NativeMapLoadedListener {
        override fun onMapLoadedWithStatistics(statistics: NativeMapLoadStatistics) {
            events += "native viewport loaded"
        }
    }

    private val nativeProbe = object : NSObject(), NativePoiTapListener {
        override fun onObjectTapWithEvent(event: NativePoiTapEvent): Boolean {
            if (phase != PoiPhase.Discover) {
                events += "retired native POI listener called"
                return false
            }
            if (reference != null) {
                events += "duplicate native POI hit"
                return true
            }
            if (!event.isValid()) {
                return false
            }
            val value = event.geoObject
            val metadata = value.metadataContainer.getItemOfClass(NativePoiSelection) as? NativePoiSelection ?: return false
            val point = value.geometry.filterIsInstance<NativeGeometry>().firstNotNullOfOrNull { it.point } ?: return false
            if (metadata.objectId.isBlank() || metadata.dataSourceName.isBlank() || metadata.layerId.isBlank()) {
                return false
            }

            reference = PoiReference(
                selection = GeoObjectSelectionMetadata(
                    objectId = metadata.objectId,
                    dataSourceName = metadata.dataSourceName,
                    layerId = metadata.layerId,
                    groupId = metadata.groupId?.longLongValue,
                ),
                latitude = point.latitude,
                longitude = point.longitude,
            )
            events += "native POI found"
            return true
        }
    }

    private val nativeProbeInput = object : NSObject(), NativeInputListener {
        override fun onMapTapWithMap(map: NativeMap, point: NativePoint) {
            if (phase != PoiPhase.Discover) {
                events += "retired native input listener called"
                return
            }
            val current = window?.toNative()
            val screen = current?.worldToScreenWithWorldPoint(point)
            if (current == null || screen == null || current.width() == 0uL || current.height() == 0uL) {
                events += "native miss projection missing"
            } else {
                events += "native miss ${screen.x / current.width().toFloat()} ${screen.y / current.height().toFloat()}"
            }
        }

        override fun onMapLongTapWithMap(map: NativeMap, point: NativePoint) {
            events += "unexpected native long tap"
        }
    }

    private val wrapperPoi = GeoObjectTapListener { event ->
        val expected = reference
        val matches = event.isValid && expected != null &&
            event.geoObject.selectionMetadata == expected.selection &&
            event.geoObject.geometry.any { geometry ->
                val point = geometry.point
                point != null && point.latitude.value == expected.latitude && point.longitude.value == expected.longitude
            }
        if (!matches) {
            events += "wrapper POI shape mismatch"
        } else {
            events += if (phase == PoiPhase.Consume) "consumed POI" else "declined POI"
        }
        phase == PoiPhase.Consume
    }

    private val mapInput = InputListener(
        onMapTap = { _, point ->
            val current = window
            val screen = current?.worldToScreen(point)
            if (current == null || screen == null || current.width <= 0 || current.height <= 0) {
                events += "map tap projection missing"
            } else {
                events += "map tap ${screen.x / current.width} ${screen.y / current.height}"
            }
        },
        onMapLongTap = { _, _ -> events += "unexpected long tap" },
    )

    fun attach(attached: MapWindow) {
        window = attached
        val map = attached.map
        val nativeMap = map.toNative()
        nativeMap.setMapLoadedListenerWithMapLoadedListener(mapLoaded)
        nativeMap.addTapListenerWithTapListener(nativeProbe)
        nativeMap.addInputListenerWithInputListener(nativeProbeInput)
        map.mapType = MapType.VECTOR_MAP
        map.isFastTapEnabled = true
        map.move(CameraPosition(Point(55.75, 37.61), 16.5f, 0f, 0f))
    }

    fun armNext() {
        val map = window?.map ?: return
        when (phase) {
            PoiPhase.Discover -> {
                if (reference == null) {
                    return
                }
                val nativeMap = map.toNative()
                nativeMap.removeTapListenerWithTapListener(nativeProbe)
                nativeMap.removeInputListenerWithInputListener(nativeProbeInput)
                nativeMap.setMapLoadedListenerWithMapLoadedListener(null)
                phase = PoiPhase.Consume
                map.addTapListener(wrapperPoi.asWeakRef())
                map.addInputListener(mapInput.asWeakRef())
                events += "consume armed"
            }

            PoiPhase.Consume -> {
                phase = PoiPhase.Propagate
                events += "propagate armed"
            }

            PoiPhase.Propagate -> Unit
        }
    }

    fun detach(attached: MapWindow) {
        window = null
        if (!attached.isValid || !attached.map.isValid) {
            return
        }
        val map = attached.map
        if (phase == PoiPhase.Discover) {
            val nativeMap = map.toNative()
            nativeMap.removeTapListenerWithTapListener(nativeProbe)
            nativeMap.removeInputListenerWithInputListener(nativeProbeInput)
            nativeMap.setMapLoadedListenerWithMapLoadedListener(null)
        } else {
            map.removeTapListener(wrapperPoi.asWeakRef())
            map.removeInputListener(mapInput.asWeakRef())
        }
    }
}
