package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.ScreenPoint
import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

public class LiveMapWindowTest {

    @Test
    public fun scale_factor_writes_reach_the_native_window() {
        LiveMap.onMapWindow { mapWindow ->
            val original = mapWindow.scaleFactor

            mapWindow.scaleFactor = 2f

            assertEquals(2f, mapWindow.scaleFactor)
            assertEquals(2f, mapWindow.toNative().scaleFactor)

            mapWindow.scaleFactor = 3f

            assertEquals(3f, mapWindow.scaleFactor)
            assertEquals(3f, mapWindow.toNative().scaleFactor)
            assertNotEquals(original, mapWindow.scaleFactor)

            mapWindow.scaleFactor = original
        }
    }

    @Test
    public fun width_and_height_report_the_native_window_size() {
        LiveMap.onMapWindow { mapWindow ->
            assertEquals(mapWindow.toNative().width(), mapWindow.width)
            assertEquals(mapWindow.toNative().height(), mapWindow.height)
            assertTrue(mapWindow.width > 0)
            assertTrue(mapWindow.height > 0)
        }
    }

    @Test
    public fun focus_point_round_trips_and_clears_to_null() {
        LiveMap.onMapWindow { mapWindow ->
            mapWindow.focusPoint = ScreenPoint(11f, 22f)

            assertEquals(ScreenPoint(11f, 22f), mapWindow.focusPoint)

            mapWindow.focusPoint = null

            assertEquals(null, mapWindow.focusPoint)
        }
    }

    @Test
    public fun focus_rect_round_trips_and_clears_to_null() {
        LiveMap.onMapWindow { mapWindow ->
            val rect = ScreenRect(ScreenPoint(1f, 2f), ScreenPoint(103f, 204f))

            mapWindow.focusRect = rect

            assertEquals(rect, mapWindow.focusRect)

            mapWindow.focusRect = null

            assertEquals(null, mapWindow.focusRect)
        }
    }

    @Test
    public fun gesture_focus_point_round_trips_and_clears_to_null() {
        LiveMap.onMapWindow { mapWindow ->
            mapWindow.gestureFocusPoint = ScreenPoint(33f, 44f)

            assertEquals(ScreenPoint(33f, 44f), mapWindow.gestureFocusPoint)

            mapWindow.gestureFocusPoint = null

            assertEquals(null, mapWindow.gestureFocusPoint)
        }
    }

    @Test
    public fun gesture_focus_point_mode_round_trips_through_the_enum_converter() {
        LiveMap.onMapWindow { mapWindow ->
            GestureFocusPointMode.entries.forEach { mode ->
                mapWindow.gestureFocusPointMode = mode

                assertEquals(mode, mapWindow.gestureFocusPointMode)
                assertEquals(mode.toNative(), mapWindow.toNative().gestureFocusPointMode)
            }
        }
    }

    @Test
    public fun point_of_view_round_trips_through_the_enum_converter() {
        LiveMap.onMapWindow { mapWindow ->
            PointOfView.entries.forEach { pointOfView ->
                mapWindow.pointOfView = pointOfView

                assertEquals(pointOfView, mapWindow.pointOfView)
                assertEquals(pointOfView.toNative(), mapWindow.toNative().pointOfView)
            }
            mapWindow.pointOfView = PointOfView.SCREEN_CENTER
        }
    }

    @Test
    public fun focus_region_reads_back_the_region_of_the_native_window() {
        LiveMap.onMapWindow { mapWindow ->
            mapWindow.focusRect = null
            mapWindow.map.move(CameraPosition(Point(55.75, 37.61), 10f, 0f, 0f))

            val focusRegion = mapWindow.focusRegion

            assertEquals(mapWindow.toNative().focusRegion.toCommon(), focusRegion)
            assertTrue(focusRegion.topLeft.latitude.value > focusRegion.bottomLeft.latitude.value)
            assertTrue(focusRegion.topRight.longitude.value > focusRegion.topLeft.longitude.value)
        }
    }

    @Test
    public fun world_to_screen_and_screen_to_world_are_inverse() {
        LiveMap.onMapWindow { mapWindow ->
            mapWindow.focusRect = null
            val target = Point(55.75, 37.61)
            mapWindow.map.move(CameraPosition(target, 10f, 0f, 0f))

            val screenPoint = assertNotNull(mapWindow.worldToScreen(target))
            val worldPoint = assertNotNull(mapWindow.screenToWorld(screenPoint))

            assertEquals(target.latitude.value, worldPoint.latitude.value, 1e-4)
            assertEquals(target.longitude.value, worldPoint.longitude.value, 1e-4)
        }
    }

    @Test
    public fun map_wraps_the_native_map_of_the_window() {
        LiveMap.onMapWindow { mapWindow ->
            assertSame(mapWindow.toNative().map, mapWindow.map.toNative())
        }
    }

    @Test
    public fun size_changed_listener_is_added_and_removed_by_the_same_native_instance() {
        LiveMap.onMapWindow { mapWindow ->
            val listener = SizeChangedListener { _, _, _ -> }

            assertSame(listener.toNative(), listener.toNative())

            mapWindow.addSizeChangedListener(listener.asWeakRef())
            mapWindow.removeSizeChangedListener(listener.asWeakRef())
        }
    }

    @Test
    public fun set_max_fps_is_accepted() {
        LiveMap.onMapWindow { mapWindow ->
            mapWindow.setMaxFps(30)
            mapWindow.setMaxFps(0)
        }
    }

    @Test
    public fun is_valid_is_true_for_a_live_window() {
        LiveMap.onMapWindow { mapWindow ->
            assertTrue(mapWindow.isValid)
            assertTrue(mapWindow.toNative().isValid)
        }
    }
}
