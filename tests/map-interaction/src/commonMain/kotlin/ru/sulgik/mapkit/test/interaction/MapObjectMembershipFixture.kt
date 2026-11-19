package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.Circle
import ru.sulgik.mapkit.compose.CircleState
import ru.sulgik.mapkit.compose.ClusterGroup
import ru.sulgik.mapkit.compose.ClusterItem
import ru.sulgik.mapkit.compose.ClusterizingConfig
import ru.sulgik.mapkit.compose.Clustering
import ru.sulgik.mapkit.compose.MapConfig
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.MapListeners
import ru.sulgik.mapkit.compose.MapObjectCollection
import ru.sulgik.mapkit.compose.Placemark
import ru.sulgik.mapkit.compose.PlacemarkState
import ru.sulgik.mapkit.compose.Polygon
import ru.sulgik.mapkit.compose.PolygonState
import ru.sulgik.mapkit.compose.Polyline
import ru.sulgik.mapkit.compose.PolylineState
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.YandexMapComposable
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.toImageProvider
import ru.sulgik.mapkit.geometry.LinearRing
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.CircleMapObject
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.MapObject
import ru.sulgik.mapkit.map.MapObjectVisitor
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.PolygonMapObject
import ru.sulgik.mapkit.map.PolylineMapObject
import kotlin.math.abs
import ru.sulgik.mapkit.geometry.Circle as MapCircle
import ru.sulgik.mapkit.geometry.Polygon as MapPolygon
import ru.sulgik.mapkit.geometry.Polyline as MapPolyline
import ru.sulgik.mapkit.map.Map as MapKitMap
import ru.sulgik.mapkit.map.MapObjectCollection as NativeCollection

internal enum class MembershipStage(
    val target: ShapeKind? = null,
    val shifted: Boolean = true,
    val formerTarget: Boolean = false,
    val childrenVisible: Boolean = true,
    val parentVisible: Boolean = true,
    val reverse: Boolean = false,
    val removed: ShapeKind? = null,
    val isEmpty: Boolean = false,
    val clusterData: String? = null,
    val zoom: Float = 16f,
    val expectedTap: String,
) {
    Initial(ShapeKind.Marker, shifted = false, expectedTap = "marker:initial"),
    ShiftedLine(ShapeKind.Line, expectedTap = "line"),
    FormerLine(ShapeKind.Line, formerTarget = true, expectedTap = "map"),
    CircleCenter(ShapeKind.Circle, expectedTap = "circle"),
    PolygonCenter(ShapeKind.Polygon, expectedTap = "polygon"),
    ChildrenHidden(ShapeKind.Circle, childrenVisible = false, expectedTap = "map"),
    ChildrenShown(ShapeKind.Circle, expectedTap = "circle"),
    ParentHidden(ShapeKind.Polygon, parentVisible = false, expectedTap = "map"),
    Reordered(ShapeKind.Marker, reverse = true, expectedTap = "marker:reordered"),
    ReorderedRemove(ShapeKind.Polygon, reverse = true, removed = ShapeKind.Polygon, expectedTap = "map"),
    Cleared(ShapeKind.Marker, isEmpty = true, expectedTap = "map"),
    Repopulated(ShapeKind.Marker, expectedTap = "marker:repopulated"),
    Clustered(clusterData = "a", zoom = 14f, expectedTap = "cluster:a1,a2"),
    Scattered(clusterData = "a", zoom = 18f, expectedTap = "item:a1"),
    ClusterReplaced(clusterData = "b", zoom = 14f, expectedTap = "cluster:b1,b2"),
    ;

    fun shapes(): List<ShapeKind> {
        if (isEmpty) return emptyList()
        val ordered = if (reverse) ShapeKind.entries.reversed() else ShapeKind.entries
        return ordered.filterNot { it == removed }
    }

    fun camera(): CameraPosition {
        val center = target?.center(shifted && !formerTarget) ?: clusterCenter(checkNotNull(clusterData))
        val point = if (this == Scattered) center.offset(east = -clusterSpacing) else center
        return CameraPosition(point, zoom, 0f, 0f)
    }
}

internal enum class ShapeKind(val id: String, private val east: Double) {
    Marker("marker", 0.0),
    Line("line", 0.005),
    Circle("circle", 0.010),
    Polygon("polygon", 0.015),
    ;

    fun center(shifted: Boolean): Point {
        return origin.offset(east = east + if (shifted) 0.02 else 0.0)
    }
}

internal class MapObjectMembershipTrace {
    val events = mutableStateListOf<String>()
    var stage by mutableStateOf(MembershipStage.Initial)
        private set
    var mapCenter: Offset? = null
    private var originalHandles: Map<String, MapObject> = emptyMap()
    private var repopulatedHandles: Map<String, MapObject> = emptyMap()
    private var originalParent: NativeCollection? = null

    fun advance() {
        stage = MembershipStage.entries[stage.ordinal + 1]
    }

    fun recordTap(name: String) {
        events.add("tap ${stage.name} $name")
    }

    fun mismatch(map: MapKitMap, expected: MembershipStage): String? {
        val snapshot = readMembership(map)
        val clusterData = expected.clusterData
        if (clusterData != null) {
            val expectedIds = listOf("${clusterData}1", "${clusterData}2")
            if (snapshot.clusterCollections != 1 || snapshot.ids != expectedIds || snapshot.parent != null) {
                return "expected cluster $expectedIds, got ${snapshot.ids}, clusters=${snapshot.clusterCollections}"
            }
            if (repopulatedHandles.values.any { it.isValid }) return "retired shape still valid in cluster stage"
            return null
        }

        val parent = snapshot.parent ?: return "missing parent collection"
        val order = expected.shapes()
        val expectedIds = order.map { it.id }.sorted()
        if (snapshot.ids != expectedIds || snapshot.clusterCollections != 0) {
            return "expected children $expectedIds, got ${snapshot.ids}"
        }
        if (parent.isVisible != expected.parentVisible) return "wrong parent visibility"
        if (originalParent != null && parent != originalParent) return "parent changed identity"

        val handles = snapshot.objects.associateBy { it.userData as String }
        for ((index, kind) in order.withIndex()) {
            val shape = handles.getValue(kind.id)
            if (!shape.isValid) return "invalid surviving handle for ${kind.id}"
            if (shape.parent != parent || shape.zIndex != index.toFloat()) return "wrong parent or z-index for ${kind.id}"
            if (expected.parentVisible && shape.isVisible != expected.childrenVisible) {
                return "wrong visibility for ${kind.id}"
            }
            if (!matchesGeometry(shape, kind.center(expected.shifted))) return "wrong geometry for ${kind.id}"
            val previous = originalHandles[kind.id]
            if (previous != null && (shape == previous) == (expected == MembershipStage.Repopulated)) {
                return "wrong object identity for ${kind.id}"
            }
        }
        expected.removed?.let { kind ->
            if (originalHandles.getValue(kind.id).isValid) return "removed handle still valid for ${kind.id}"
        }
        val isAfterClear = expected == MembershipStage.Cleared || expected == MembershipStage.Repopulated
        if (isAfterClear && originalHandles.values.any { it.isValid }) return "a cleared handle is still valid"

        if (expected == MembershipStage.Initial) {
            originalHandles = handles
            originalParent = parent
        } else if (expected == MembershipStage.Repopulated) {
            repopulatedHandles = handles
        }
        return null
    }
}

@Composable
internal fun MapObjectMembershipFixture(trace: MapObjectMembershipTrace = remember { MapObjectMembershipTrace() }) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val stage = trace.stage
    val icon = remember {
        val bitmap = ImageBitmap(40, 40)
        Canvas(bitmap).drawCircle(Offset(20f, 20f), 17f, Paint().apply { color = Color.Red })
        bitmap.toImageProvider()
    }
    Column {
        BasicText(
            "Next object case",
            modifier = Modifier.clickable(role = Role.Button) {
                if (stage != MembershipStage.ClusterReplaced) trace.advance()
            },
        )
        YandexMap(
            modifier = Modifier.size(260.dp)
                .onGloballyPositioned { trace.mapCenter = it.boundsInWindow().center }
                .semantics { contentDescription = "fixture-object-map" },
            config = MapConfig(mapType = MapType.NONE, isFastTapEnabled = true),
        ) {
            MapListeners(onMapTap = { trace.recordTap("map") })
            val clusterData = stage.clusterData
            if (clusterData == null) {
                MapObjectCollection(userData = parentTag, visible = stage.parentVisible) {
                    stage.shapes().forEachIndexed { index, kind ->
                        key(kind) {
                            MembershipShape(kind, stage, index.toFloat(), icon, trace)
                        }
                    }
                }
            } else {
                val group = remember(clusterData, icon) {
                    val center = clusterCenter(clusterData)
                    ClusterGroup(
                        placemarks = listOf(
                            ClusterItem(center.offset(east = -clusterSpacing), "${clusterData}1"),
                            ClusterItem(center.offset(east = clusterSpacing), "${clusterData}2"),
                        ).toPersistentList(),
                        icon = icon,
                    )
                }
                Clustering(
                    group = group,
                    icon = icon,
                    config = ClusterizingConfig(clusterRadius = 80.0, minZoom = 15),
                    onItemTap = {
                        trace.recordTap("item:${it.data}")
                        true
                    },
                    onClusterTap = {
                        val members = it.placemarks.map { placemark -> placemark.userData.toString() }.sorted()
                        trace.recordTap("cluster:${members.joinToString(",")}")
                        true
                    },
                )
            }
            MapEffect(stage) { map ->
                val expectedCamera = stage.camera()
                map.move(expectedCamera)
                var diagnostic = "waiting for map layout"
                val ready = withTimeoutOrNull(5_000) {
                    do {
                        withFrameNanos { }
                        val actual = map.cameraPosition
                        val cameraMatches = near(actual.target, expectedCamera.target) &&
                            abs(actual.zoom - expectedCamera.zoom) < 0.01
                        diagnostic = if (trace.mapCenter == null || !cameraMatches) {
                            "layout or camera has not reached $expectedCamera"
                        } else {
                            trace.mismatch(map, stage).orEmpty()
                        }
                    } while (diagnostic.isNotEmpty())
                    withFrameNanos { }
                    true
                } == true
                trace.events.add(if (ready) "ready ${stage.name}" else "failed ${stage.name}: $diagnostic")
            }
        }
        BasicText(
            trace.events.takeLast(8).joinToString("\n"),
            modifier = Modifier.testTag("fixture-object-trace"),
        )
    }
}

@[YandexMapComposable Composable]
private fun MembershipShape(
    kind: ShapeKind,
    stage: MembershipStage,
    zIndex: Float,
    icon: ImageProvider,
    trace: MapObjectMembershipTrace,
) {
    val center = kind.center(stage.shifted)
    val tapName = when {
        kind != ShapeKind.Marker -> kind.id
        stage == MembershipStage.Reordered -> "marker:reordered"
        stage == MembershipStage.Repopulated -> "marker:repopulated"
        else -> "marker:initial"
    }
    val onTap: (Point) -> Boolean = {
        trace.recordTap(tapName)
        true
    }
    when (kind) {
        ShapeKind.Marker -> {
            val state = remember { PlacemarkState(center) }
            LaunchedEffect(center) { state.geometry = center }
            Placemark(state, icon, onTap = onTap, visible = stage.childrenVisible, userData = kind.id, zIndex = zIndex)
        }
        ShapeKind.Line -> {
            val state = remember { PolylineState(lineAt(center)) }
            LaunchedEffect(center) { state.geometry = lineAt(center) }
            Polyline(
                state, strokeWidth = 8f, onTap = onTap, visible = stage.childrenVisible, userData = kind.id, zIndex = zIndex,
            )
        }
        ShapeKind.Circle -> {
            val state = remember { CircleState(circleAt(center)) }
            LaunchedEffect(center) { state.geometry = circleAt(center) }
            Circle(state, onTap = onTap, visible = stage.childrenVisible, userData = kind.id, zIndex = zIndex)
        }
        ShapeKind.Polygon -> {
            val state = remember { PolygonState(polygonAt(center)) }
            LaunchedEffect(center) { state.geometry = polygonAt(center) }
            Polygon(state, onTap = onTap, visible = stage.childrenVisible, userData = kind.id, zIndex = zIndex)
        }
    }
}

private class MembershipSnapshot {
    val objects = mutableListOf<MapObject>()
    val ids: List<String> get() = objects.map { it.userData.toString() }.sorted()
    var parent: NativeCollection? = null
    var clusterCollections: Int = 0
}

private fun readMembership(map: MapKitMap): MembershipSnapshot {
    val snapshot = MembershipSnapshot()
    val visitor = MapObjectVisitor(
        onPlacemarkVisited = { snapshot.objects.add(it) },
        onPolylineVisited = { snapshot.objects.add(it) },
        onPolygonVisited = { snapshot.objects.add(it) },
        onCircleVisited = { snapshot.objects.add(it) },
        onCollectionVisitStart = {
            if (it.userData == parentTag) snapshot.parent = it
            true
        },
        onCollectionVisitEnd = {},
        onClusterizedCollectionVisitStart = {
            snapshot.clusterCollections++
            true
        },
        onClusterizedCollectionVisitEnd = {},
    )
    map.mapObjects.traverse(visitor.asWeakRef())
    return snapshot
}

private fun matchesGeometry(shape: MapObject, center: Point): Boolean {
    return when (shape) {
        is PlacemarkMapObject -> near(shape.geometry, center)
        is PolylineMapObject -> {
            val points = shape.geometry.points
            val expected = lineAt(center).points
            points.size == expected.size && points.zip(expected).all { (actual, wanted) -> near(actual, wanted) }
        }
        is CircleMapObject -> near(shape.geometry.center, center) && abs(shape.geometry.radius - 45f) < 0.01
        is PolygonMapObject -> {
            val points = shape.geometry.outerRing.points
            val expected = polygonAt(center).outerRing.points
            points.size == expected.size && expected.all { wanted -> points.any { near(it, wanted) } }
        }
        else -> false
    }
}

private fun clusterCenter(data: String): Point {
    return origin.offset(east = if (data == "a") 0.0 else 0.015)
}

private fun Point.offset(north: Double = 0.0, east: Double = 0.0): Point {
    return Point(latitude.value + north, longitude.value + east)
}

private fun near(actual: Point, expected: Point): Boolean {
    return abs(actual.latitude.value - expected.latitude.value) < 0.000001 &&
        abs(actual.longitude.value - expected.longitude.value) < 0.000001
}

private fun lineAt(center: Point): MapPolyline {
    return MapPolyline(listOf(center.offset(east = -0.001), center.offset(east = 0.001)))
}

private fun circleAt(center: Point): MapCircle {
    return MapCircle(center, 45f)
}

private fun polygonAt(center: Point): MapPolygon {
    val ring = LinearRing(
        listOf(
            center.offset(north = -0.0005, east = -0.0005),
            center.offset(north = -0.0005, east = 0.0005),
            center.offset(north = 0.0005, east = 0.0005),
            center.offset(north = 0.0005, east = -0.0005),
        ),
    )
    return MapPolygon(ring, emptyList())
}

private val origin = Point(55.751225, 37.629540)
private const val parentTag = "fixture-shape-collection"
private const val clusterSpacing = 0.0006
