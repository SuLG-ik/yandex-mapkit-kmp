package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.asWeakRef
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame
import kotlin.test.assertTrue

public class LiveUserLocationLayerTest {

    @Test
    public fun visibility_round_trips_through_the_native_layer() {
        onUserLocationLayer { layer ->
            layer.isVisible = true

            assertEquals(true, layer.isVisible)
            assertEquals(true, layer.toNative().isVisible)

            layer.isVisible = false

            assertEquals(false, layer.isVisible)
            assertEquals(false, layer.toNative().isVisible)
        }
    }

    @Test
    public fun heading_mode_round_trips_through_the_native_layer() {
        onUserLocationLayer { layer ->
            layer.isHeadingModeActive = true

            assertEquals(true, layer.isHeadingModeActive)
            assertEquals(true, layer.toNative().isHeadingModeActive)

            layer.isHeadingModeActive = false

            assertEquals(false, layer.isHeadingModeActive)
            assertEquals(false, layer.toNative().isHeadingModeActive)
        }
    }

    @Test
    public fun auto_zoom_round_trips_through_the_native_layer() {
        onUserLocationLayer { layer ->
            layer.isAutoZoomEnabled = true

            assertEquals(true, layer.isAutoZoomEnabled)
            assertEquals(true, layer.toNative().isAutoZoomEnabled)

            layer.isAutoZoomEnabled = false

            assertEquals(false, layer.isAutoZoomEnabled)
            assertEquals(false, layer.toNative().isAutoZoomEnabled)
        }
    }

    @Test
    public fun set_anchor_enables_anchor_mode_and_reset_anchor_disables_it() {
        onUserLocationLayer { layer ->
            layer.setAnchor(PointF(100f, 200f), PointF(100f, 120f))

            assertEquals(true, layer.isAnchorEnabled)

            layer.resetAnchor()

            assertEquals(false, layer.isAnchorEnabled)
        }
    }

    @Test
    public fun camera_position_is_null_without_a_known_location() {
        onUserLocationLayer { layer ->
            assertEquals(null, layer.cameraPosition)
        }
    }

    @Test
    public fun object_listener_is_set_and_cleared_by_the_same_native_instance() {
        onUserLocationLayer { layer ->
            val listener = UserLocationObjectListener(
                onObjectAdded = {},
                onObjectRemoved = {},
                onObjectUpdated = { _, _ -> },
            )

            assertSame(listener.toNative(), listener.toNative())

            layer.setObjectListener(listener.asWeakRef())
            layer.setObjectListener(null)
        }
    }

    @Test
    public fun tap_listener_is_set_and_cleared_by_the_same_native_instance() {
        onUserLocationLayer { layer ->
            val listener = UserLocationTapListener { }

            assertSame(listener.toNative(), listener.toNative())

            layer.setTapListener(listener.asWeakRef())
            layer.setTapListener(null)
        }
    }

    @Test
    public fun default_source_is_accepted_and_the_layer_stays_valid() {
        onUserLocationLayer { layer ->
            layer.setDefaultSource()

            assertTrue(layer.isValid)
            assertTrue(layer.toNative().isValid)
        }
    }

    private fun onUserLocationLayer(block: (UserLocationLayer) -> Unit) {
        LiveMap.onUserLocationLayer(block)
    }
}
