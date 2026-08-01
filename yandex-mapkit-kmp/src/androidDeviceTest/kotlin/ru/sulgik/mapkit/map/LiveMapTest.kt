package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toGeometry
import ru.sulgik.mapkit.layers.GeoObjectTapListener
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame
import kotlin.test.assertTrue

public class LiveMapTest {

    @Test
    public fun move_updates_the_camera_position() {
        LiveMap.onMap { map ->
            val position = CameraPosition(Point(55.75, 37.61), 14f, 30f, 20f)

            map.move(position)

            val actual = map.cameraPosition
            assertEquals(position.target.latitude.value, actual.target.latitude.value, 1e-6)
            assertEquals(position.target.longitude.value, actual.target.longitude.value, 1e-6)
            assertEquals(position.zoom, actual.zoom)
            assertEquals(position.azimuth, actual.azimuth)
            assertEquals(position.tilt, actual.tilt)
        }
    }

    @Test
    public fun gesture_flags_round_trip_through_their_own_native_flags() {
        LiveMap.onMap { map ->
            map.isRotateGesturesEnabled = false
            map.isTiltGesturesEnabled = true
            map.isScrollGesturesEnabled = false
            map.isZoomGesturesEnabled = true
            map.isFastTapEnabled = true

            assertEquals(false, map.isRotateGesturesEnabled)
            assertEquals(true, map.isTiltGesturesEnabled)
            assertEquals(false, map.isScrollGesturesEnabled)
            assertEquals(true, map.isZoomGesturesEnabled)
            assertEquals(true, map.isFastTapEnabled)

            map.isRotateGesturesEnabled = true
            map.isTiltGesturesEnabled = false
            map.isScrollGesturesEnabled = true
            map.isZoomGesturesEnabled = false
            map.isFastTapEnabled = false

            assertEquals(true, map.isRotateGesturesEnabled)
            assertEquals(false, map.isTiltGesturesEnabled)
            assertEquals(true, map.isScrollGesturesEnabled)
            assertEquals(false, map.isZoomGesturesEnabled)
            assertEquals(false, map.isFastTapEnabled)
        }
    }

    @Test
    public fun rendering_flags_round_trip_through_their_own_native_flags() {
        LiveMap.onMap { map ->
            map.isNightModeEnabled = true
            map.isHdModeEnabled = true
            map.isAwesomeModelsEnabled = true
            map.isTransparentBackgroundEnabled = true

            assertEquals(true, map.isNightModeEnabled)
            assertEquals(true, map.isHdModeEnabled)
            assertEquals(true, map.isAwesomeModelsEnabled)
            assertEquals(true, map.isTransparentBackgroundEnabled)

            map.isNightModeEnabled = false
            map.isHdModeEnabled = false
            map.isAwesomeModelsEnabled = false
            map.isTransparentBackgroundEnabled = false

            assertEquals(false, map.isNightModeEnabled)
            assertEquals(false, map.isHdModeEnabled)
            assertEquals(false, map.isAwesomeModelsEnabled)
            assertEquals(false, map.isTransparentBackgroundEnabled)
        }
    }

    @Test
    public fun indoor_flags_round_trip_through_their_own_native_flags() {
        LiveMap.onMap { map ->
            map.isIndoorEnabled = true
            map.isBuildingsAboveIndoorEnabled = true

            assertEquals(true, map.isIndoorEnabled)
            assertEquals(true, map.isBuildingsAboveIndoorEnabled)

            map.isIndoorEnabled = false
            map.isBuildingsAboveIndoorEnabled = false

            assertEquals(false, map.isIndoorEnabled)
            assertEquals(false, map.isBuildingsAboveIndoorEnabled)
        }
    }

    @Test
    public fun poi_limit_round_trips_and_clears_to_null() {
        LiveMap.onMap { map ->
            map.poiLimit = 7

            assertEquals(7, map.poiLimit)

            map.poiLimit = null

            assertEquals(null, map.poiLimit)
        }
    }

    @Test
    public fun map_type_round_trips_through_the_enum_converter() {
        LiveMap.onMap { map ->
            listOf(MapType.NONE, MapType.MAP, MapType.VECTOR_MAP).forEach { mapType ->
                map.mapType = mapType

                assertEquals(mapType, map.mapType)
                assertEquals(mapType.toNative(), map.toNative().mapType)
            }
            map.mapType = MapType.VECTOR_MAP
        }
    }

    @Test
    public fun mode_round_trips_through_the_enum_converter() {
        LiveMap.onMap { map ->
            MapMode.entries.forEach { mode ->
                map.mode = mode

                assertEquals(mode, map.mode)
                assertEquals(mode.toNative(), map.toNative().mode)
            }
            map.mode = MapMode.MAP
        }
    }

    @Test
    public fun visible_region_matches_the_region_of_the_current_camera_position() {
        LiveMap.onMap { map ->
            val position = CameraPosition(Point(55.75, 37.61), 10f, 0f, 0f)
            map.move(position)

            assertEquals(map.visibleRegion(position), map.visibleRegion)
        }
    }

    @Test
    public fun camera_position_for_a_geometry_frames_that_geometry() {
        LiveMap.onMap { map ->
            val boundingBox = BoundingBox(Point(55.7, 37.5), Point(55.8, 37.7))

            val position = map.cameraPosition(boundingBox.toGeometry(), azimuth = 0f, tilt = 0f)

            assertEquals(55.75, position.target.latitude.value, 1e-2)
            assertEquals(37.6, position.target.longitude.value, 1e-2)
            assertEquals(0f, position.azimuth)
            assertEquals(0f, position.tilt)
            assertTrue(position.zoom > 0f)
        }
    }

    @Test
    public fun map_objects_wraps_the_root_collection_of_the_native_map() {
        LiveMap.onMap { map ->
            assertSame(map.toNative().mapObjects, map.mapObjects.toNative())
        }
    }

    @Test
    public fun add_map_object_layer_creates_an_independent_collection() {
        LiveMap.onMap { map ->
            val layer = map.addMapObjectLayer("live-map-test-layer")

            assertTrue(layer.isValid)
            assertTrue(layer.toNative() !== map.mapObjects.toNative())
        }
    }

    @Test
    public fun camera_listener_is_added_and_removed_by_the_same_native_instance() {
        LiveMap.onMap { map ->
            val listener = CameraListener { _, _, _, _ -> }

            assertSame(listener.toNative(), listener.toNative())

            map.addCameraListener(listener.asWeakRef())
            map.removeCameraListener(listener.asWeakRef())
        }
    }

    @Test
    public fun input_listener_is_added_and_removed_by_the_same_native_instance() {
        LiveMap.onMap { map ->
            val listener = InputListener(onMapTap = { _, _ -> }, onMapLongTap = { _, _ -> })

            assertSame(listener.toNative(), listener.toNative())

            map.addInputListener(listener.asWeakRef())
            map.removeInputListener(listener.asWeakRef())
        }
    }

    @Test
    public fun geo_object_tap_listener_is_added_and_removed_by_the_same_native_instance() {
        LiveMap.onMap { map ->
            val listener = GeoObjectTapListener { true }

            assertSame(listener.toNative(), listener.toNative())

            map.addTapListener(listener.asWeakRef())
            map.removeTapListener(listener.asWeakRef())
        }
    }

    @Test
    public fun map_loaded_listener_is_set_and_cleared() {
        LiveMap.onMap { map ->
            val listener = MapLoadedListener { }

            map.setMapLoadedListener(listener.asWeakRef())
            map.setMapLoadedListener(null)
        }
    }

    @Test
    public fun logo_projection_and_camera_bounds_are_reachable() {
        LiveMap.onMap { map ->
            assertTrue(map.logo.isValid)
            assertTrue(map.projection().isValid)
            assertTrue(map.cameraBounds.isValid)
            assertTrue(map.isValid)
        }
    }

    @Test
    public fun set_map_style_and_reset_map_styles_are_accepted() {
        LiveMap.onMap { map ->
            map.setMapStyle("""[{"tags":"landscape","stylers":{"color":"ff0000"}}]""")
            map.setMapStyle(1, """[{"tags":"water","stylers":{"color":"0000ff"}}]""")
            map.resetMapStyles()
        }
    }
}
