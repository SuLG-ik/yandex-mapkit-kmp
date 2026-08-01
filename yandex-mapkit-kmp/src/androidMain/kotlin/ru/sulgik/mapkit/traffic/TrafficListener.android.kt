package ru.sulgik.mapkit.traffic

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.traffic.TrafficLevel as NativeTrafficLevel
import com.yandex.mapkit.traffic.TrafficListener as NativeTrafficListener

/**
 * Notifies about the state of the traffic layer.
 */
public actual abstract class TrafficListener actual constructor() : NativeConvertible<NativeTrafficListener> {

    private val nativeListener = object : NativeTrafficListener {
        override fun onTrafficChanged(trafficLevel: NativeTrafficLevel?) {
            this@TrafficListener.onTrafficChanged(trafficLevel?.toCommon())
        }

        override fun onTrafficLoading() {
            this@TrafficListener.onTrafficLoading()
        }

        override fun onTrafficExpired() {
            this@TrafficListener.onTrafficExpired()
        }
    }

    override fun toNative(): NativeTrafficListener {
        return nativeListener
    }

    /**
     * Triggered when traffic level changes.
     */
    public actual abstract fun onTrafficChanged(trafficLevel: TrafficLevel?)

    /**
     * Triggered when traffic information is loading.
     */
    public actual abstract fun onTrafficLoading()

    /**
     * Triggered when traffic information expires.
     */
    public actual abstract fun onTrafficExpired()
}
