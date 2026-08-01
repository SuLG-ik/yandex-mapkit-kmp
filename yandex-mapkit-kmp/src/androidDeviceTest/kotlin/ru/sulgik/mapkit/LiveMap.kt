package ru.sulgik.mapkit

import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.toCommon
import ru.sulgik.mapkit.user_location.UserLocationLayer
import com.yandex.mapkit.mapview.MapView as NativeMapView

internal object LiveMap {

    private const val TEST_API_KEY = "yandex-mapkit-kmp-instrumentation-test"
    private const val TEST_LOCALE = "ru_RU"

    private var nativeMapView: NativeMapView? = null
    private var userLocationLayer: UserLocationLayer? = null

    fun <T> onMapWindow(block: (MapWindow) -> T): T {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        var outcome: Result<T>? = null
        instrumentation.runOnMainSync {
            outcome = runCatching { block(mapView().mapWindow.toCommon()) }
        }
        return checkNotNull(outcome).getOrThrow()
    }

    fun <T> onMap(block: (Map) -> T): T {
        return onMapWindow { mapWindow -> block(mapWindow.map) }
    }

    fun <T> onMapObjects(block: (MapObjectCollection) -> T): T {
        return onMap { map ->
            val collection = map.mapObjects.addCollection()
            try {
                block(collection)
            } finally {
                map.mapObjects.remove(collection)
            }
        }
    }

    fun <T> onUserLocationLayer(block: (UserLocationLayer) -> T): T {
        return onMapWindow { mapWindow ->
            block(userLocationLayer ?: mapKit().createUserLocationLayer(mapWindow).also { userLocationLayer = it })
        }
    }

    fun mapKit(): MapKit {
        return MapKit.getInstance()
    }

    private fun mapView(): NativeMapView {
        return nativeMapView ?: createMapView().also { nativeMapView = it }
    }

    private fun createMapView(): NativeMapView {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        MapKit.setApiKey(TEST_API_KEY)
        MapKit.setLocale(TEST_LOCALE)
        MapKit.initialize(context)
        return NativeMapView(context)
    }
}
