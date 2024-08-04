package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.ClusterListener
import ru.sulgik.mapkit.map.ClusterizedPlacemarkCollection
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.MapObjectTapListener
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.TextStyle

internal class ClusterNode(
    groups: List<ClusterGroup>,
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

    init {
        if (groups.isNotEmpty()) {
            groups.forEach(::addGroup)
            mapObject.clusterPlacemarks(info.config.clusterRadius, info.config.minZoom)
        }
    }

    var groups: List<ClusterGroup> = groups
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

    private fun updateNativeCluster(cluster: Cluster?, info: ClusterInfo) {
        if (cluster == null) return
        cluster.appearance.setIcon(info.icon, info.iconStyle)
        if (info.text != null) {
            cluster.appearance.setText(info.text, info.textStyle)
        }
    }

    private fun addGroup(group: ClusterGroup) {
        mapObject.addPlacemarks(group.placemarks.map { it.geometry }, group.icon, group.iconStyle)
            .forEach {
                it.setIcon(group.icon, group.iconStyle)
                if (group.text != null) {
                    it.setText(group.text, group.textStyle)
                }
                it.addTapListener(nativeItemTapListener)
            }
    }

    private fun updateItems(groups: List<ClusterGroup>) {
        mapObject.clear()
        groups.forEach(::addGroup)
        clusterPlacemarks(info.config)
    }

    private fun clusterPlacemarks(config: ClusterizingConfig) {
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

public data class ClusterGroup(
    val placemarks: ImmutableList<ClusterItem>,
    val icon: ImageProvider,
    val iconStyle: IconStyle = IconStyle(),
    val text: String? = null,
    val textStyle: TextStyle = TextStyle(),
)

public data class ClusterInfo(
    val icon: ImageProvider,
    val config: ClusterizingConfig = ClusterizingConfig(),
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
    group: ClusterGroup,
    info: ClusterInfo,
    onItemTap: ((ClusterItem) -> Boolean)? = null,
    onClusterTap: ((Point) -> Boolean)? = null,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
) {
    Clustering(
        groups = persistentListOf(group),
        info = info,
        onItemTap = onItemTap,
        onClusterTap = onClusterTap,
        visible = visible,
        zIndex = zIndex,
    )
}

@YandexMapComposable
@Composable
public fun Clustering(
    groups: ImmutableList<ClusterGroup>,
    info: ClusterInfo,
    onItemTap: ((ClusterItem) -> Boolean)? = null,
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
                groups = groups,
                info = info,
                mapObject = collection.addClusterizedPlacemarkCollection(listener),
                tapListener = onClusterTap,
                clusterItemTapListener = onItemTap,
            ).apply { nativeCluster = cluster }
            node
        },
        update = {
            update(onItemTap) { this.clusterItemTapListener = onItemTap }
            update(groups) { this.groups = groups }
            update(info) { this.info = info }
        }
    )
}

private const val DefaultClusterRadius = 60.0
private const val DefaultMinZoom = 15