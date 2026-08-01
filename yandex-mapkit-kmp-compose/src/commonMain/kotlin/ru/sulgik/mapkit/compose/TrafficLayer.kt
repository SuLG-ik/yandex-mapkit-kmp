package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.currentComposer
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.composition.MapApplier
import ru.sulgik.mapkit.compose.composition.MapNode
import ru.sulgik.mapkit.traffic.TrafficLayer
import ru.sulgik.mapkit.traffic.TrafficLevel
import ru.sulgik.mapkit.traffic.TrafficListener

/**
 * Shows the traffic layer for as long as this composable stays in the composition.
 *
 * @param style JSON style transformations applied to the layer.
 * @param onTrafficChanged Called with the current traffic level, or `null` while it is unknown.
 */
@[YandexMapComposable Composable]
public fun TrafficLayer(
    visible: Boolean = true,
    style: String? = null,
    onTrafficChanged: ((TrafficLevel?) -> Unit)? = null,
    onTrafficLoading: (() -> Unit)? = null,
    onTrafficExpired: (() -> Unit)? = null,
) {
    val mapApplier = currentComposer.applier as? MapApplier
        ?: error("TrafficLayer is not supported outside of YandexMapComposable")
    ComposeNode<TrafficLayerNode, MapApplier>(
        factory = {
            val layer = MapKit.getInstance().createTrafficLayer(mapApplier.mapWindow)
            layer.isTrafficVisible = visible
            if (style != null) {
                layer.setTrafficStyle(style)
            }
            TrafficLayerNode(
                layer = layer,
                onTrafficChanged = onTrafficChanged,
                onTrafficLoading = onTrafficLoading,
                onTrafficExpired = onTrafficExpired,
            )
        },
        update = {
            update(visible) { this.layer.isTrafficVisible = it }
            update(style) { this.setStyle(it) }
            update(onTrafficChanged) { this.onTrafficChanged = it }
            update(onTrafficLoading) { this.onTrafficLoading = it }
            update(onTrafficExpired) { this.onTrafficExpired = it }
        },
    )
}

internal class TrafficLayerNode(
    val layer: TrafficLayer,
    internal var onTrafficChanged: ((TrafficLevel?) -> Unit)?,
    internal var onTrafficLoading: (() -> Unit)?,
    internal var onTrafficExpired: (() -> Unit)?,
) : MapNode {

    private var trafficListener: TrafficListener? = TrafficListener(
        onTrafficChanged = { level -> onTrafficChanged?.invoke(level) },
        onTrafficLoading = { onTrafficLoading?.invoke() },
        onTrafficExpired = { onTrafficExpired?.invoke() },
    )

    fun setStyle(style: String?) {
        if (style == null) {
            layer.resetTrafficStyles()
        } else {
            layer.setTrafficStyle(style)
        }
    }

    override fun onAttached() {
        trafficListener?.let { layer.addTrafficListener(it.asWeakRef()) }
    }

    override fun onRemoved() {
        trafficListener?.let { layer.removeTrafficListener(it.asWeakRef()) }
        layer.isTrafficVisible = false
    }

    override fun onCleared() {
        trafficListener = null
        onTrafficChanged = null
        onTrafficLoading = null
        onTrafficExpired = null
    }
}
