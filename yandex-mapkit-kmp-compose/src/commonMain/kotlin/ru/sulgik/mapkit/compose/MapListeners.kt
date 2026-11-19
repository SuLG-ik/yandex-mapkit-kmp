package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.currentComposer
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.composition.MapApplier
import ru.sulgik.mapkit.compose.composition.MapNode
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.indoor.IndoorPlan
import ru.sulgik.mapkit.indoor.IndoorStateListener
import ru.sulgik.mapkit.layers.GeoObjectTapEvent
import ru.sulgik.mapkit.layers.GeoObjectTapListener
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.map.MapLoadStatistics
import ru.sulgik.mapkit.map.MapLoadedListener
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.SizeChangedListener

/**
 * Subscribes to the map events for as long as this composable stays in the composition.
 *
 * Every callback is optional; the matching MapKit listener is attached only when it is not `null`,
 * and the subscription is dropped when the composable leaves the composition.
 *
 * @param onGeoObjectTap Called for a tap on an object of the base map. Return `false` to let the
 * event propagate to the map, which then also reaches [onMapTap].
 */
@[YandexMapComposable Composable]
public fun MapListeners(
    onMapTap: ((Point) -> Unit)? = null,
    onMapLongTap: ((Point) -> Unit)? = null,
    onGeoObjectTap: ((GeoObjectTapEvent) -> Boolean)? = null,
    onMapLoaded: ((MapLoadStatistics) -> Unit)? = null,
    onActivePlanFocused: ((IndoorPlan) -> Unit)? = null,
    onActivePlanLeft: (() -> Unit)? = null,
    onActiveLevelChanged: ((String) -> Unit)? = null,
    onMapWindowSizeChanged: ((width: Int, height: Int) -> Unit)? = null,
) {
    val mapWindow = (currentComposer.applier as? MapApplier)?.mapWindow
        ?: error("MapListeners is not supported outside of YandexMapComposable")
    ComposeNode<MapListenersNode, MapApplier>(
        factory = {
            MapListenersNode(
                mapWindow = mapWindow,
                onMapTap = onMapTap,
                onMapLongTap = onMapLongTap,
                onGeoObjectTap = onGeoObjectTap,
                onMapLoaded = onMapLoaded,
                onActivePlanFocused = onActivePlanFocused,
                onActivePlanLeft = onActivePlanLeft,
                onActiveLevelChanged = onActiveLevelChanged,
                onMapWindowSizeChanged = onMapWindowSizeChanged,
            )
        },
        update = {
            update(onMapTap) { this.onMapTap = it }
            update(onMapLongTap) { this.onMapLongTap = it }
            update(onGeoObjectTap) { this.onGeoObjectTap = it }
            update(onMapLoaded) { this.onMapLoaded = it }
            update(onActivePlanFocused) { this.onActivePlanFocused = it }
            update(onActivePlanLeft) { this.onActivePlanLeft = it }
            update(onActiveLevelChanged) { this.onActiveLevelChanged = it }
            update(onMapWindowSizeChanged) { this.onMapWindowSizeChanged = it }
        },
    )
}

internal class MapListenersNode(
    private val mapWindow: MapWindow,
    onMapTap: ((Point) -> Unit)?,
    onMapLongTap: ((Point) -> Unit)?,
    internal var onGeoObjectTap: ((GeoObjectTapEvent) -> Boolean)?,
    internal var onMapLoaded: ((MapLoadStatistics) -> Unit)?,
    internal var onActivePlanFocused: ((IndoorPlan) -> Unit)?,
    internal var onActivePlanLeft: (() -> Unit)?,
    internal var onActiveLevelChanged: ((String) -> Unit)?,
    internal var onMapWindowSizeChanged: ((width: Int, height: Int) -> Unit)?,
) : MapNode {

    private var isAttached = false
    private var isInputListenerRegistered = false

    internal var onMapTap: ((Point) -> Unit)? = onMapTap
        set(value) {
            field = value
            updateInputListenerRegistration()
        }

    internal var onMapLongTap: ((Point) -> Unit)? = onMapLongTap
        set(value) {
            field = value
            updateInputListenerRegistration()
        }

    private val hasIndoorCallbacks =
        onActivePlanFocused != null || onActivePlanLeft != null || onActiveLevelChanged != null

    private var inputListener: InputListener? = InputListener(
        onMapTap = { _, point -> this.onMapTap?.invoke(point) },
        onMapLongTap = { _, point -> this.onMapLongTap?.invoke(point) },
    )

    private var geoObjectTapListener: GeoObjectTapListener? =
        GeoObjectTapListener { event -> onGeoObjectTap?.invoke(event) ?: false }

    private var mapLoadedListener: MapLoadedListener? =
        MapLoadedListener { statistics -> onMapLoaded?.invoke(statistics) }

    private var indoorStateListener: IndoorStateListener? = IndoorStateListener(
        onActivePlanFocused = { plan -> onActivePlanFocused?.invoke(plan) },
        onActivePlanLeft = { onActivePlanLeft?.invoke() },
        onActiveLevelChanged = { levelId -> onActiveLevelChanged?.invoke(levelId) },
    )

    private var sizeChangedListener: SizeChangedListener? =
        SizeChangedListener { _, width, height -> onMapWindowSizeChanged?.invoke(width, height) }

    private fun updateInputListenerRegistration() {
        val shouldRegister = isAttached && (onMapTap != null || onMapLongTap != null)
        val listener = inputListener ?: return
        if (shouldRegister == isInputListenerRegistered) return

        val map = mapWindow.map
        if (shouldRegister) {
            map.addInputListener(listener.asWeakRef())
        } else {
            map.removeInputListener(listener.asWeakRef())
        }
        isInputListenerRegistered = shouldRegister
    }

    override fun onAttached() {
        isAttached = true
        updateInputListenerRegistration()
        val map = mapWindow.map
        if (onGeoObjectTap != null) {
            geoObjectTapListener?.let { map.addTapListener(it.asWeakRef()) }
        }
        if (onMapLoaded != null) {
            mapLoadedListener?.let { map.setMapLoadedListener(it.asWeakRef()) }
        }
        if (hasIndoorCallbacks) {
            indoorStateListener?.let { map.addIndoorStateListener(it.asWeakRef()) }
        }
        if (onMapWindowSizeChanged != null) {
            sizeChangedListener?.let { mapWindow.addSizeChangedListener(it.asWeakRef()) }
        }
    }

    override fun onRemoved() {
        isAttached = false
        updateInputListenerRegistration()
        val map = mapWindow.map
        if (onGeoObjectTap != null) {
            geoObjectTapListener?.let { map.removeTapListener(it.asWeakRef()) }
        }
        if (onMapLoaded != null) {
            map.setMapLoadedListener(null)
        }
        if (hasIndoorCallbacks) {
            indoorStateListener?.let { map.removeIndoorStateListener(it.asWeakRef()) }
        }
        if (onMapWindowSizeChanged != null) {
            sizeChangedListener?.let { mapWindow.removeSizeChangedListener(it.asWeakRef()) }
        }
    }

    override fun onCleared() {
        isAttached = false
        isInputListenerRegistered = false
        inputListener = null
        geoObjectTapListener = null
        mapLoadedListener = null
        indoorStateListener = null
        sizeChangedListener = null
        onMapTap = null
        onMapLongTap = null
        onGeoObjectTap = null
        onMapLoaded = null
        onActivePlanFocused = null
        onActivePlanLeft = null
        onActiveLevelChanged = null
        onMapWindowSizeChanged = null
    }
}
