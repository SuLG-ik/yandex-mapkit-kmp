package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertSame
import kotlin.test.assertTrue

public class LivePlacemarkMapObjectTest {

    @Test
    public fun geometry_round_trips_through_the_native_placemark() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()

            placemark.geometry = Point(55.75, 37.61)

            assertEquals(55.75, placemark.geometry.latitude.value, 1e-9)
            assertEquals(37.61, placemark.geometry.longitude.value, 1e-9)
            assertEquals(placemark.toNative().geometry.toCommon(), placemark.geometry)
        }
    }

    @Test
    public fun direction_and_opacity_round_trip_through_their_own_native_fields() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()

            placemark.direction = 42f
            placemark.opacity = 0.25f

            assertEquals(42f, placemark.direction)
            assertEquals(0.25f, placemark.opacity)
            assertEquals(42f, placemark.toNative().direction)
            assertEquals(0.25f, placemark.toNative().opacity)
        }
    }

    @Test
    public fun map_object_flags_round_trip_through_their_own_native_fields() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()

            placemark.isVisible = false
            placemark.isDraggable = true
            placemark.zIndex = 5f
            placemark.userData = "payload"

            assertEquals(false, placemark.isVisible)
            assertEquals(true, placemark.isDraggable)
            assertEquals(5f, placemark.zIndex)
            assertEquals("payload", placemark.userData)

            placemark.isVisible = true
            placemark.isDraggable = false
            placemark.userData = null

            assertEquals(true, placemark.isVisible)
            assertEquals(false, placemark.isDraggable)
            assertEquals(null, placemark.userData)
        }
    }

    @Test
    public fun set_text_reaches_the_placemark_text() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()

            placemark.setText("live map test")

            assertEquals("live map test", placemark.text.text)
            assertTrue(placemark.text.isValid)
        }
    }

    @Test
    public fun set_text_style_and_scale_function_are_accepted() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()

            placemark.setText("styled", TextStyle(size = 12f))
            placemark.setTextStyle(TextStyle(size = 16f))
            placemark.setScaleFunction(listOf(PointF(0f, 1f), PointF(20f, 2f)))

            assertEquals("styled", placemark.text.text)
        }
    }

    @Test
    public fun use_icon_model_and_animation_return_live_handles() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()

            assertTrue(placemark.useIcon().isValid)
            assertTrue(placemark.useCompositeIcon().isValid)
            assertTrue(placemark.useModel().isValid)
            assertTrue(placemark.useAnimation().isValid)
        }
    }

    @Test
    public fun parent_is_the_collection_that_created_the_placemark() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()

            assertEquals(collection.toNative(), placemark.parent.toNative())
            assertIs<MapObjectCollection>(placemark.parent)
        }
    }

    @Test
    public fun tap_listener_is_added_and_removed_by_the_same_native_instance() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()
            val listener = MapObjectTapListener { _, _ -> true }

            assertSame(listener.toNative(), listener.toNative())

            placemark.addTapListener(listener.asWeakRef())
            placemark.removeTapListener(listener.asWeakRef())
        }
    }

    @Test
    public fun drag_listener_is_set_and_cleared_by_the_same_native_instance() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()
            val listener = MapObjectDragListener(
                onMapObjectDragStart = {},
                onMapObjectDrag = { _, _ -> },
                onMapObjectDragEnd = {},
            )

            assertSame(listener.toNative(), listener.toNative())

            placemark.setDragListener(listener.asWeakRef())
            placemark.setDragListener(null)
        }
    }

    @Test
    public fun traverse_hands_back_the_native_instance_that_add_placemark_returned() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()
            placemark.userData = "identity payload"

            val revisited = singlePlacemarkIn(collection)

            assertSame(placemark.toNative(), revisited.toNative())
            assertEquals("identity payload", revisited.userData)
        }
    }

    @Test
    public fun a_collection_listener_reports_the_native_instance_that_add_placemark_returned() {
        LiveMap.onMapObjects { collection ->
            val added = mutableListOf<MapObject>()
            val listener = MapObjectCollectionListener(
                onMapObjectAdded = { added += it },
                onMapObjectRemoved = { },
            )
            collection.addListener(listener.asWeakRef())

            val placemark = collection.addPlacemark()
            placemark.userData = "identity payload"

            val reported = added.single()
            assertSame(placemark.toNative(), reported.toNative())
            assertEquals("identity payload", reported.userData)
        }
    }

    @Test
    public fun user_data_written_through_one_wrapper_is_visible_through_another() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()
            val revisited = singlePlacemarkIn(collection)

            revisited.userData = "written through the revisited wrapper"

            assertEquals("written through the revisited wrapper", placemark.userData)
            assertEquals(placemark.toNative().userData, revisited.toNative().userData)
        }
    }

    @Test
    public fun is_valid_is_true_for_a_live_placemark() {
        LiveMap.onMapObjects { collection ->
            val placemark = collection.addPlacemark()

            assertTrue(placemark.isValid)
            assertTrue(placemark.toNative().isValid)
        }
    }

    private fun singlePlacemarkIn(collection: MapObjectCollection): PlacemarkMapObject {
        val visited = mutableListOf<PlacemarkMapObject>()
        val visitor = MapObjectVisitor(
            onPlacemarkVisited = { visited += it },
            onPolylineVisited = { },
            onPolygonVisited = { },
            onCircleVisited = { },
            onCollectionVisitStart = { true },
            onCollectionVisitEnd = { },
            onClusterizedCollectionVisitStart = { true },
            onClusterizedCollectionVisitEnd = { },
        )
        collection.traverse(visitor.asWeakRef())
        return visited.single()
    }
}
