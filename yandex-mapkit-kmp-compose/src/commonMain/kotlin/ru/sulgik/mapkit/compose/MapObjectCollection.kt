package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.map.MapObjectVisitor
import ru.sulgik.mapkit.map.PlacemarksStyler

@Composable
public fun rememberMapObjectCollectionState(): MapObjectCollectionState {
    return remember { MapObjectCollectionState() }
}

@Immutable
public class MapObjectCollectionState : MapObjectState<MapObjectCollection>() {

    /**
     * Sets piecewise linear scale of every placemark of the collection, depending on the zoom,
     * with [PlacemarksStyler.setScaleFunction].
     */
    public fun setPlacemarksScaleFunction(points: List<PointF>) {
        mapObject?.placemarksStyler?.setScaleFunction(points)
    }

    /**
     * Visits every object of the collection, including the objects of its nested collections.
     */
    public fun traverse(visitor: MapObjectVisitor) {
        mapObject?.traverse(visitor.asWeakRef())
    }
}

/**
 * Groups the map objects of [content] into a nested [MapObjectCollection].
 *
 * The collection is a map object itself, so hiding it hides everything inside it at once, and its
 * [zIndex] applies to the whole group. Removing the composable from the composition removes the
 * whole group from the map.
 */
@[YandexMapComposable Composable]
public fun MapObjectCollection(
    state: MapObjectCollectionState = rememberMapObjectCollectionState(),
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    userData: Any? = null,
    onTap: ((Point) -> Boolean)? = null,
    content: @[Composable YandexMapComposable] () -> Unit,
) {
    val parent = LocalMapObjectCollection.current
    val collection = remember { parent.addCollection() }
    MapObjectNode(
        state = state,
        visible = visible,
        zIndex = zIndex,
        userData = userData,
        onTap = onTap,
        factory = { MapObjectCollectionNode(collection, onTap) },
        update = { },
    )
    CompositionLocalProvider(LocalMapObjectCollection provides collection) {
        content()
    }
}

internal class MapObjectCollectionNode(
    mapObject: MapObjectCollection,
    tapListener: ((Point) -> Boolean)?,
) : MapObjectNode<MapObjectCollection, MapObjectCollectionState>(mapObject, tapListener)
