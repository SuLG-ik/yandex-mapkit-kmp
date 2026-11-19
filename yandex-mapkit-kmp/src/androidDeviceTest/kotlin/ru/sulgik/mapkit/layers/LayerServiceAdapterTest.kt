package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.MapKitRuntime
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
import com.yandex.mapkit.GeoObject as NativeGeoObject
import com.yandex.mapkit.layers.GeoObjectTapEvent as NativeGeoObjectTapEvent

public class LayerServiceAdapterTest {

    @Test
    public fun traffic_listener_preserves_unknown_levels_and_loading_states() {
        MapKitRuntime.ensureLoaded()
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
        adapter.onTrafficChanged(null)
        adapter.onTrafficChanged(level.toNative())
        adapter.onTrafficExpired()

        assertEquals(listOf("loading", "change", "change", "expired"), events)
        assertEquals(listOf(null, level), levels)
    }

    @Test
    public fun base_map_tap_adapter_returns_the_consumption_decision() {
        val nativeEvent = object : NativeGeoObjectTapEvent {
            override fun getGeoObject(): NativeGeoObject {
                error("The tap adapter must not resolve metadata")
            }

            override fun isValid(): Boolean {
                return true
            }
        }
        val forwarded = mutableListOf<GeoObjectTapEvent>()
        var consume = false
        val listener = GeoObjectTapListener {
            forwarded += it
            consume
        }
        val adapter = listener.toNative()
        assertSame(adapter, listener.toNative())

        assertFalse(adapter.onObjectTap(nativeEvent))
        consume = true
        assertTrue(adapter.onObjectTap(nativeEvent))
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

        adapter.onRegionStateChanged(431)
        adapter.onRegionProgress(208)

        assertEquals(listOf("state" to 431, "progress" to 208), events)
    }
}
