package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.offline_cache.RegionListener
import ru.sulgik.mapkit.traffic.TrafficColor
import ru.sulgik.mapkit.traffic.TrafficLevel
import ru.sulgik.mapkit.traffic.TrafficListener
import ru.sulgik.mapkit.traffic.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

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
