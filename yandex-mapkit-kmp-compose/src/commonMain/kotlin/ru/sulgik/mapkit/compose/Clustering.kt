package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import kotlinx.collections.immutable.ImmutableList
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.ClusterListener
import ru.sulgik.mapkit.map.ClusterizedPlacemarkCollection
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.MapObjectCollectionListener
import ru.sulgik.mapkit.map.MapObjectTapListener
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.TextStyle

internal class ClusterNode(
    items: ClusterItems,
    info: ClusterInfo,
    mapObject: ClusterizedPlacemarkCollection,
    tapListener: ((Point) -> Boolean)?,
    var clusterItemTapListener: ((ClusterItem) -> Boolean)? = null,
) : MapObjectNode<ClusterizedPlacemarkCollection>(mapObject, tapListener) {

    private val nativeItemTapListener = MapObjectTapListener { mapObject, point ->
        clusterItemTapListener?.let {
            mapObject as PlacemarkMapObject
            it(ClusterItem(mapObject.geometry, mapObject.userData))
        } == true
    }
    private val collectionListener = MapObjectCollectionListener(
        onMapObjectAdded = {
            it as PlacemarkMapObject
            it.setIcon(items.icon, items.iconStyle)
            if (items.text != null) {
                it.setText(items.text, items.textStyle)
            }
            it.addTapListener(nativeItemTapListener)
        },
        onMapObjectRemoved = {}
    )

    init {
        mapObject.addListener(collectionListener)
        if (items.placemarks.isNotEmpty()) {
            mapObject.addPlacemarks(
                points = items.placemarks.map { it.geometry },
                image = items.icon,
                style = items.iconStyle,
            )
            mapObject.clusterPlacemarks(info.config.clusterRadius, info.config.minZoom)
        }
    }

    var items: ClusterItems = items
        set(value) {
            updateItems(value)
            field = value
        }

    var info: ClusterInfo = info
        set(value) {
            clusterPlacemarks(value.config)
            field = value
        }

    var nativeCluster: Cluster? = null
        set(value) {
            updateNativeCluster(value, info)
            field = value
        }

    fun updateNativeCluster(cluster: Cluster?, info: ClusterInfo) {
        if (cluster == null) return
        cluster.appearance.setIcon(info.icon, info.iconStyle)
        if (info.text != null) {
            cluster.appearance.setText(info.text, info.textStyle)
        }
    }

    fun updateItems(items: ClusterItems) {
        mapObject.clear()
        mapObject.addPlacemarks(items.placemarks.map { it.geometry }, items.icon, items.iconStyle)
        clusterPlacemarks(info.config)
    }

    fun clusterPlacemarks(config: ClusterizingConfig) {
        mapObject.clusterPlacemarks(config.clusterRadius, config.minZoom)
    }

    override fun onCleared() {
        super.onCleared()
    }

    override fun onAttached() {
        super.onAttached()
    }

    override fun onRemoved() {
        mapObject.clear()
        mapObject.parent.remove(mapObject)
    }
}

public data class ClusterItem(
    val geometry: Point,
    val data: Any?
)

public data class ClusterItems(
    val placemarks: ImmutableList<ClusterItem>,
    val icon: ImageProvider,
    val iconStyle: IconStyle = IconStyle(),
    val text: String? = null,
    val textStyle: TextStyle = TextStyle(),
)

public data class ClusterInfo(
    val config: ClusterizingConfig,
    val icon: ImageProvider,
    val iconStyle: IconStyle = IconStyle(),
    val text: String? = null,
    val textStyle: TextStyle = TextStyle(),
)

public data class ClusterizingConfig(
    val clusterRadius: Double = DefaultClusterRadius,
    val minZoom: Int = DefaultMinZoom,
)

@YandexMapComposable
@Composable
public fun Clustering(
    items: ClusterItems,
    info: ClusterInfo,
    onItemTap: ((ClusterItem) -> Boolean)?,
    onClusterTap: ((Point) -> Boolean)? = null,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
) {
    val collection = LocalMapObjectCollection.current
    MapObjectNode(
        visible = visible,
        onTap = onClusterTap,
        zIndex = zIndex,
        factory = {
            var cluster: Cluster? = null
            var node: ClusterNode? = null
            val listener = ClusterListener {
                cluster = it
                node?.nativeCluster = it
            }
            node = ClusterNode(
                items = items,
                info = info,
                mapObject = collection.addClusterizedPlacemarkCollection(listener),
                tapListener = onClusterTap,
                clusterItemTapListener = onItemTap,
            ).apply { nativeCluster = cluster }
            node
        },
        update = {
            update(onItemTap) { this.clusterItemTapListener = onItemTap }
            update(items) { this.items = items }
            update(info) { this.info = info }
        }
    )
}

private const val DefaultClusterRadius = 25.0
private const val DefaultMinZoom = 25