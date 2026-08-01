package ru.sulgik.mapkit

import kotlinx.cinterop.staticCFunction
import platform.CoreGraphics.CGRectMake
import platform.Foundation.NSDate
import platform.Foundation.NSDefaultRunLoopMode
import platform.Foundation.NSRunLoop
import platform.Foundation.dateWithTimeIntervalSinceNow
import platform.Foundation.runMode
import platform.posix._exit
import platform.posix.atexit
import platform.posix.fflush
import ru.sulgik.mapkit.map.Map
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.toCommon
import ru.sulgik.mapkit.user_location.UserLocationLayer
import kotlin.time.Duration
import YandexMapKit.YMKMapView as NativeMapView

internal object LiveMap {

    private const val TEST_API_KEY = "yandex-mapkit-kmp-simulator-test"
    private const val TEST_LOCALE = "ru_RU"

    private var nativeMapView: NativeMapView? = null
    private var userLocationLayer: UserLocationLayer? = null

    fun <T> onMapWindow(block: (MapWindow) -> T): T {
        return block(checkNotNull(mapView().mapWindow).toCommon())
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

    fun drainMainQueue(timeout: Duration) {
        check(nativeMapView == null) {
            "The main queue still holds the activation block of the YMKMapView that LiveMap created, " +
                "and draining it starts the renderer, which crashes without a window server. " +
                "Run the tests that drain the main queue before the ones that ask LiveMap for a map."
        }
        NSRunLoop.currentRunLoop.runMode(
            NSDefaultRunLoopMode,
            beforeDate = NSDate.dateWithTimeIntervalSinceNow(timeout.inWholeMilliseconds / 1000.0),
        )
    }

    private fun mapView(): NativeMapView {
        return nativeMapView ?: createMapView().also { nativeMapView = it }
    }

    private fun createMapView(): NativeMapView {
        MapKit.setApiKey(TEST_API_KEY)
        MapKit.setLocale(TEST_LOCALE)
        MapKit.getInstance()
        atexit(staticCFunction(::exitBeforeMapKitJoinsItsRenderThread))
        return NativeMapView(frame = CGRectMake(0.0, 0.0, 320.0, 480.0))
    }
}

private fun exitBeforeMapKitJoinsItsRenderThread() {
    fflush(null)
    _exit(0)
}
