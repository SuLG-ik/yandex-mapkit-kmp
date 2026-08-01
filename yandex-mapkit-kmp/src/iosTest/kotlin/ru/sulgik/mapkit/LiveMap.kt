package ru.sulgik.mapkit

import kotlinx.cinterop.staticCFunction
import platform.CoreGraphics.CGRectMake
import platform.Foundation.NSDate
import platform.Foundation.NSDefaultRunLoopMode
import platform.Foundation.NSRunLoop
import platform.Foundation.dateWithTimeIntervalSinceNow
import platform.Foundation.runMode
import platform.UIKit.UIScreen
import platform.darwin.NSObject
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
import YandexMapKit.YRTLifecycleListenerProtocol as NativeLifecycleListener
import YandexMapKit.YRTLifecycleProviderProtocol as NativeLifecycleProvider

internal object LiveMap {

    private const val TEST_API_KEY = "yandex-mapkit-kmp-simulator-test"
    private const val TEST_LOCALE = "ru_RU"
    private const val MAP_VIEW_WIDTH = 320.0
    private const val MAP_VIEW_HEIGHT = 480.0

    private val lifecycleProvider = NeverActivatingLifecycleProvider()

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
        return NativeMapView(
            frame = CGRectMake(0.0, 0.0, MAP_VIEW_WIDTH, MAP_VIEW_HEIGHT),
            scaleFactor = UIScreen.mainScreen.scale.toFloat(),
            vulkanPreferred = false,
            lifecycleProvider = lifecycleProvider,
            transparencySupport = false,
        )
    }
}

private class NeverActivatingLifecycleProvider :
    NSObject(),
    NativeLifecycleProvider {

    override fun setListener(listener: NativeLifecycleListener?) {
    }

    override fun reset() {
    }

    override fun isActive(): Boolean {
        return false
    }
}

private fun exitBeforeMapKitJoinsItsRenderThread() {
    fflush(null)
    _exit(0)
}
