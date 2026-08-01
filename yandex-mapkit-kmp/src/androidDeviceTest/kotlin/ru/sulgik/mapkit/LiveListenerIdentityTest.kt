package ru.sulgik.mapkit

import ru.sulgik.mapkit.indoor.IndoorStateListener
import ru.sulgik.mapkit.layers.GeoObjectTapListener
import ru.sulgik.mapkit.map.Callback
import ru.sulgik.mapkit.map.CameraCallback
import ru.sulgik.mapkit.map.CameraListener
import ru.sulgik.mapkit.map.ClusterListener
import ru.sulgik.mapkit.map.ClusterTapListener
import ru.sulgik.mapkit.map.InputListener
import ru.sulgik.mapkit.map.MapLoadedListener
import ru.sulgik.mapkit.map.MapObjectCollectionListener
import ru.sulgik.mapkit.map.MapObjectDragListener
import ru.sulgik.mapkit.map.MapObjectTapListener
import ru.sulgik.mapkit.map.PlacemarkCreatedCallback
import ru.sulgik.mapkit.map.SizeChangedListener
import ru.sulgik.mapkit.user_location.UserLocationObjectListener
import ru.sulgik.mapkit.user_location.UserLocationTapListener
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertSame

public class LiveListenerIdentityTest {

    @BeforeTest
    public fun setUp() {
        MapKitRuntime.ensureLoaded()
    }

    @Test
    public fun map_listeners_keep_one_native_instance() {
        assertNativeInstanceIsStable(SizeChangedListener { _, _, _ -> })
        assertNativeInstanceIsStable(CameraListener { _, _, _, _ -> })
        assertNativeInstanceIsStable(InputListener(onMapTap = { _, _ -> }, onMapLongTap = { _, _ -> }))
        assertNativeInstanceIsStable(GeoObjectTapListener { true })
        assertNativeInstanceIsStable(MapLoadedListener { })
        assertNativeInstanceIsStable(
            IndoorStateListener(
                onActivePlanFocused = {},
                onActivePlanLeft = {},
                onActiveLevelChanged = {},
            ),
        )
    }

    @Test
    public fun map_object_listeners_keep_one_native_instance() {
        assertNativeInstanceIsStable(MapObjectTapListener { _, _ -> true })
        assertNativeInstanceIsStable(
            MapObjectDragListener(
                onMapObjectDragStart = {},
                onMapObjectDrag = { _, _ -> },
                onMapObjectDragEnd = {},
            ),
        )
        assertNativeInstanceIsStable(
            MapObjectCollectionListener(onMapObjectAdded = {}, onMapObjectRemoved = {}),
        )
        assertNativeInstanceIsStable(ClusterListener { })
        assertNativeInstanceIsStable(ClusterTapListener { true })
    }

    @Test
    public fun user_location_listeners_keep_one_native_instance() {
        assertNativeInstanceIsStable(
            UserLocationObjectListener(
                onObjectAdded = {},
                onObjectRemoved = {},
                onObjectUpdated = { _, _ -> },
            ),
        )
        assertNativeInstanceIsStable(UserLocationTapListener { })
    }

    @Test
    public fun callbacks_keep_one_native_instance() {
        val callback = Callback { }
        val cameraCallback = CameraCallback { }
        val placemarkCreatedCallback = PlacemarkCreatedCallback { }

        assertSame(callback.toNative(), callback.toNative())
        assertSame(cameraCallback.toNative(), cameraCallback.toNative())
        assertSame(placemarkCreatedCallback.toNative(), placemarkCreatedCallback.toNative())
    }

    @Test
    public fun a_weak_ref_unwraps_to_the_listener_it_was_created_from() {
        val listener = SizeChangedListener { _, _, _ -> }

        val weakRef = listener.asWeakRef()

        assertSame(listener, weakRef.get())
        assertSame(listener.toNative(), weakRef.toNative().get())
    }

    private fun <N : Any, T> assertNativeInstanceIsStable(listener: T) where T : Any, T : NativeConvertible<N> {
        assertSame(listener.toNative(), listener.toNative())
        assertSame(listener.toNative(), listener.asWeakRef().toNative().get())
    }
}
