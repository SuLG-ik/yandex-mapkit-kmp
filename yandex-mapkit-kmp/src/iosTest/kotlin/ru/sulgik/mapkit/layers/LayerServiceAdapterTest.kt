package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.offline_cache.RegionListener
import ru.sulgik.mapkit.traffic.TrafficColor
import ru.sulgik.mapkit.traffic.TrafficLevel
import ru.sulgik.mapkit.traffic.TrafficListener
import ru.sulgik.mapkit.traffic.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertSame
import kotlin.test.assertTrue
import YandexMapKit.YMKGeoObjectTapEvent as NativeGeoObjectTapEvent

public class LayerServiceAdapterTest {

    @Test
    public fun traffic_listener_preserves_unknown_levels_and_loading_states() {
        val events = mutableListOf<String>()
        val levels = mutableListOf<TrafficLevel?>()
        val level = TrafficLevel(color = TrafficColor.YELLOW, level = 6)
        val listener = TrafficListener(
            onTrafficChanged = {
                levels += it
                events += "change"
            },
            onTrafficLoading = { events += "loading" },
            onTrafficExpired = { events += "expired" },
        )
        val adapter = listener.toNative()
        assertSame(adapter, listener.toNative())

        adapter.onTrafficLoading()
        adapter.onTrafficChangedWithTrafficLevel(null)
        adapter.onTrafficChangedWithTrafficLevel(level.toNative())
        adapter.onTrafficExpired()

        assertEquals(listOf("loading", "change", "change", "expired"), events)
        assertEquals(listOf(null, level), levels)
    }

    @Test
    public fun base_map_tap_adapter_returns_the_consumption_decision() {
        val nativeEvent = NativeGeoObjectTapEvent()
        val forwarded = mutableListOf<GeoObjectTapEvent>()
        var consume = false
        val listener = GeoObjectTapListener {
            forwarded += it
            consume
        }
        val adapter = listener.toNative()
        assertSame(adapter, listener.toNative())

        assertFalse(adapter.onObjectTapWithEvent(nativeEvent))
        consume = true
        assertTrue(adapter.onObjectTapWithEvent(nativeEvent))
        assertEquals(2, forwarded.size)
        forwarded.forEach { assertSame(nativeEvent, it.toNative()) }
    }

    @Test
    public fun offline_listener_distinguishes_region_state_from_progress() {
        val events = mutableListOf<Pair<String, Int>>()
        val listener = RegionListener(
            onRegionStateChanged = { events += "state" to it },
            onRegionProgress = { events += "progress" to it },
        )
        val adapter = listener.toNative()
        assertSame(adapter, listener.toNative())

        adapter.onRegionStateChangedWithRegionId(431uL)
        adapter.onRegionProgressWithRegionId(208uL)

        assertEquals(listOf("state" to 431, "progress" to 208), events)
    }
}
