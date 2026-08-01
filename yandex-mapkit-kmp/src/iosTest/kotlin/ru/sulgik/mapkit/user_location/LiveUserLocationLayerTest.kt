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
    public fun `visibility round trips through the native layer`() {
        onUserLocationLayer { layer ->
            layer.isVisible = true

            assertEquals(true, layer.isVisible)
            assertEquals(true, layer.toNative().isVisible())

            layer.isVisible = false

            assertEquals(false, layer.isVisible)
            assertEquals(false, layer.toNative().isVisible())
        }
    }

    @Test
    public fun `heading mode round trips through the native layer`() {
        onUserLocationLayer { layer ->
            layer.isHeadingModeActive = true

            assertEquals(true, layer.isHeadingModeActive)
            assertEquals(true, layer.toNative().headingModeActive)

            layer.isHeadingModeActive = false

            assertEquals(false, layer.isHeadingModeActive)
            assertEquals(false, layer.toNative().headingModeActive)
        }
    }

    @Test
    public fun `auto zoom round trips through the native layer`() {
        onUserLocationLayer { layer ->
            layer.isAutoZoomEnabled = true

            assertEquals(true, layer.isAutoZoomEnabled)
            assertEquals(true, layer.toNative().autoZoomEnabled)

            layer.isAutoZoomEnabled = false

            assertEquals(false, layer.isAutoZoomEnabled)
            assertEquals(false, layer.toNative().autoZoomEnabled)
        }
    }

    @Test
    public fun `set anchor enables anchor mode and reset anchor disables it`() {
        onUserLocationLayer { layer ->
            layer.setAnchor(PointF(100f, 200f), PointF(100f, 120f))

            assertEquals(true, layer.isAnchorEnabled)

            layer.resetAnchor()

            assertEquals(false, layer.isAnchorEnabled)
        }
    }

    @Test
    public fun `camera position is null without a known location`() {
        onUserLocationLayer { layer ->
            assertEquals(null, layer.cameraPosition)
        }
    }

    @Test
    public fun `object listener is set and cleared by the same native instance`() {
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
    public fun `tap listener is set and cleared by the same native instance`() {
        onUserLocationLayer { layer ->
            val listener = UserLocationTapListener { }

            assertSame(listener.toNative(), listener.toNative())

            layer.setTapListener(listener.asWeakRef())
            layer.setTapListener(null)
        }
    }

    @Test
    public fun `default source is accepted and the layer stays valid`() {
        onUserLocationLayer { layer ->
            layer.setDefaultSource()

            assertTrue(layer.isValid)
            assertTrue(layer.toNative().isValid())
        }
    }

    private fun onUserLocationLayer(block: (UserLocationLayer) -> Unit) {
        LiveMap.onUserLocationLayer(block)
    }
}
