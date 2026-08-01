package ru.sulgik.mapkit

import ru.sulgik.mapkit.indoor.IndoorStateListener
import ru.sulgik.mapkit.layers.GeoObjectTapListener
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
import kotlin.test.Test
import kotlin.test.assertSame

public class LiveListenerIdentityTest {

    @Test
    public fun `map listeners keep one native instance`() {
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
    public fun `map object listeners keep one native instance`() {
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
    public fun `user location listeners keep one native instance`() {
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
    public fun `the placemark created callback keeps one native instance`() {
        val placemarkCreatedCallback = PlacemarkCreatedCallback { }

        assertSame(placemarkCreatedCallback.toNative(), placemarkCreatedCallback.toNative())
    }

    @Test
    public fun `a weak ref unwraps to the listener it was created from`() {
        val listener = SizeChangedListener { _, _, _ -> }

        val weakRef = listener.asWeakRef()

        assertSame(listener, weakRef.get())
        assertSame(listener.toNative(), weakRef.toNative())
    }

    private fun <N : Any, T> assertNativeInstanceIsStable(listener: T) where T : Any, T : NativeConvertible<N> {
        assertSame(listener.toNative(), listener.toNative())
        assertSame(listener.toNative(), listener.asWeakRef().toNative())
    }
}
