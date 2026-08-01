package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.LinearRing
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.Polyline
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertSame
import kotlin.test.assertTrue

public class LiveMapObjectCollectionTest {

    @Test
    public fun collection_listener_receives_the_added_object_as_its_own_subtype() {
        LiveMap.onMapObjects { collection ->
            val added = mutableListOf<MapObject>()
            val listener = collectionListenerInto(added, mutableListOf())
            collection.addListener(listener.asWeakRef())

            val placemark = collection.addPlacemark()

            assertEquals(1, added.size)
            assertIs<PlacemarkMapObject>(added.single())
            assertEquals(placemark.toNative(), added.single().toNative())
        }
    }

    @Test
    public fun collection_listener_receives_the_removed_object() {
        LiveMap.onMapObjects { collection ->
            val removed = mutableListOf<MapObject>()
            val listener = collectionListenerInto(mutableListOf(), removed)
            collection.addListener(listener.asWeakRef())
            val placemark = collection.addPlacemark()

            collection.remove(placemark)

            assertEquals(1, removed.size)
            assertEquals(placemark.toNative(), removed.single().toNative())
        }
    }

    @Test
    public fun a_removed_collection_listener_stops_receiving_events() {
        LiveMap.onMapObjects { collection ->
            val added = mutableListOf<MapObject>()
            val listener = collectionListenerInto(added, mutableListOf())
            collection.addListener(listener.asWeakRef())
            collection.addPlacemark()
            assertEquals(1, added.size)

            collection.removeListener(listener.asWeakRef())
            collection.addPlacemark()

            assertEquals(1, added.size)
        }
    }

    @Test
    public fun collection_listener_is_added_and_removed_by_the_same_native_instance() {
        val listener = collectionListenerInto(mutableListOf(), mutableListOf())

        assertSame(listener.toNative(), listener.toNative())
    }

    @Test
    public fun add_placemark_with_a_created_callback_invokes_the_callback() {
        LiveMap.onMapObjects { collection ->
            val created = mutableListOf<PlacemarkMapObject>()
            val callback = PlacemarkCreatedCallback { created += it }

            val placemark = collection.addPlacemark(callback)

            assertEquals(1, created.size)
            assertEquals(placemark.toNative(), created.single().toNative())
        }
    }

    @Test
    public fun every_add_method_returns_the_matching_map_object_subtype() {
        LiveMap.onMapObjects { collection ->
            val polyline = collection.addPolyline(Polyline(listOf(Point(0.0, 0.0), Point(1.0, 1.0))))
            val polygon = collection.addPolygon(
                Polygon(LinearRing(listOf(Point(0.0, 0.0), Point(0.0, 1.0), Point(1.0, 1.0))), emptyList()),
            )
            val circle = collection.addCircle(Circle(Point(0.0, 0.0), 100f))
            val nested = collection.addCollection()

            assertTrue(polyline.isValid)
            assertTrue(polygon.isValid)
            assertTrue(circle.isValid)
            assertTrue(nested.isValid)
            assertEquals(collection.toNative(), nested.parent.toNative())
        }
    }

    @Test
    public fun traverse_visits_every_object_as_its_own_subtype() {
        LiveMap.onMapObjects { collection ->
            collection.addPlacemark()
            collection.addPolyline(Polyline(listOf(Point(0.0, 0.0), Point(1.0, 1.0))))
            collection.addCircle(Circle(Point(0.0, 0.0), 100f))
            val visited = mutableListOf<String>()
            val visitor = MapObjectVisitor(
                onPlacemarkVisited = { visited += "placemark" },
                onPolylineVisited = { visited += "polyline" },
                onPolygonVisited = { visited += "polygon" },
                onCircleVisited = { visited += "circle" },
                onCollectionVisitStart = {
                    visited += "collection start"
                    true
                },
                onCollectionVisitEnd = { visited += "collection end" },
                onClusterizedCollectionVisitStart = {
                    visited += "clusterized start"
                    true
                },
                onClusterizedCollectionVisitEnd = { visited += "clusterized end" },
            )

            collection.traverse(visitor.asWeakRef())

            assertContentEquals(
                listOf("collection start", "placemark", "polyline", "circle", "collection end"),
                visited,
            )
        }
    }

    @Test
    public fun clear_empties_the_collection() {
        LiveMap.onMapObjects { collection ->
            collection.addPlacemark()
            collection.addPlacemark()
            assertEquals(2, placemarksIn(collection))

            collection.clear()

            assertEquals(0, placemarksIn(collection))
        }
    }

    @Test
    public fun clusterized_placemark_collection_is_created_with_a_cluster_listener() {
        LiveMap.onMapObjects { collection ->
            val clusterListener = ClusterListener { }

            assertSame(clusterListener.toNative(), clusterListener.toNative())

            val clusterized = collection.addClusterizedPlacemarkCollection(clusterListener.asWeakRef())

            assertTrue(clusterized.isValid)
            assertEquals(collection.toNative(), clusterized.parent.toNative())
        }
    }

    @Test
    public fun placemarks_styler_is_reachable_from_the_collection() {
        LiveMap.onMapObjects { collection ->
            assertTrue(collection.placemarksStyler.isValid)
        }
    }

    @Test
    public fun map_objects_of_the_map_is_a_root_collection() {
        LiveMap.onMap { map ->
            assertIs<RootMapObjectCollection>(map.mapObjects)
            assertTrue(map.mapObjects.isValid)
        }
    }

    private fun placemarksIn(collection: MapObjectCollection): Int {
        var placemarks = 0
        val visitor = MapObjectVisitor(
            onPlacemarkVisited = { placemarks++ },
            onPolylineVisited = { },
            onPolygonVisited = { },
            onCircleVisited = { },
            onCollectionVisitStart = { true },
            onCollectionVisitEnd = { },
            onClusterizedCollectionVisitStart = { true },
            onClusterizedCollectionVisitEnd = { },
        )
        collection.traverse(visitor.asWeakRef())
        return placemarks
    }

    private fun collectionListenerInto(
        added: MutableList<MapObject>,
        removed: MutableList<MapObject>,
    ): MapObjectCollectionListener {
        return MapObjectCollectionListener(
            onMapObjectAdded = { added += it },
            onMapObjectRemoved = { removed += it },
        )
    }
}
