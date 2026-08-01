package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toGeometry
import ru.sulgik.mapkit.layers.GeoObjectTapListener
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertSame
import kotlin.test.assertTrue

public class LiveMapTest {

    @Test
    public fun `move updates the camera position`() {
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
    public fun `gesture flags round trip through their own native flags`() {
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
    public fun `rendering flags round trip through their own native flags`() {
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
    public fun `indoor flags round trip through their own native flags`() {
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
    public fun `poi limit round trips and clears to null`() {
        LiveMap.onMap { map ->
            map.poiLimit = 7

            assertEquals(7, map.poiLimit)

            map.poiLimit = null

            assertEquals(null, map.poiLimit)
        }
    }

    @Test
    public fun `map type round trips through the enum converter`() {
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
    public fun `mode round trips through the enum converter`() {
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
    public fun `visible region matches the region of the current camera position`() {
        LiveMap.onMap { map ->
            val position = CameraPosition(Point(55.75, 37.61), 10f, 0f, 0f)
            map.move(position)

            assertEquals(map.visibleRegion(position), map.visibleRegion)
        }
    }

    @Test
    public fun `camera position for a geometry frames that geometry`() {
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
    public fun `map objects wraps the root collection of the native map`() {
        LiveMap.onMap { map ->
            assertEquals(map.toNative().mapObjects, map.mapObjects.toNative())
        }
    }

    @Test
    public fun `add map object layer creates an independent collection`() {
        LiveMap.onMap { map ->
            val layer = map.addMapObjectLayer("live-map-test-layer")

            assertTrue(layer.isValid)
            assertNotEquals(layer.toNative(), map.mapObjects.toNative())
        }
    }

    @Test
    public fun `camera listener is added and removed by the same native instance`() {
        LiveMap.onMap { map ->
            val listener = CameraListener { _, _, _, _ -> }

            assertSame(listener.toNative(), listener.toNative())

            map.addCameraListener(listener.asWeakRef())
            map.removeCameraListener(listener.asWeakRef())
        }
    }

    @Test
    public fun `input listener is added and removed by the same native instance`() {
        LiveMap.onMap { map ->
            val listener = InputListener(onMapTap = { _, _ -> }, onMapLongTap = { _, _ -> })

            assertSame(listener.toNative(), listener.toNative())

            map.addInputListener(listener.asWeakRef())
            map.removeInputListener(listener.asWeakRef())
        }
    }

    @Test
    public fun `geo object tap listener is added and removed by the same native instance`() {
        LiveMap.onMap { map ->
            val listener = GeoObjectTapListener { true }

            assertSame(listener.toNative(), listener.toNative())

            map.addTapListener(listener.asWeakRef())
            map.removeTapListener(listener.asWeakRef())
        }
    }

    @Test
    public fun `map loaded listener is set and cleared`() {
        LiveMap.onMap { map ->
            val listener = MapLoadedListener { }

            map.setMapLoadedListener(listener.asWeakRef())
            map.setMapLoadedListener(null)
        }
    }

    @Test
    public fun `logo projection and camera bounds are reachable`() {
        LiveMap.onMap { map ->
            assertTrue(map.logo.isValid)
            assertTrue(map.projection().isValid)
            assertTrue(map.cameraBounds.isValid)
            assertTrue(map.isValid)
        }
    }

    @Test
    public fun `set map style and reset map styles are accepted`() {
        LiveMap.onMap { map ->
            map.setMapStyle("""[{"tags":"landscape","stylers":{"color":"ff0000"}}]""")
            map.setMapStyle(1, """[{"tags":"water","stylers":{"color":"0000ff"}}]""")
            map.resetMapStyles()
        }
    }
}
