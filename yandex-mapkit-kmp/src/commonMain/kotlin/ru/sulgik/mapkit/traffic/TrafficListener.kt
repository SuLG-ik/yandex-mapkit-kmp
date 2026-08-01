package ru.sulgik.mapkit.traffic

/**
 * Notifies about the state of the traffic layer.
 */
public expect abstract class TrafficListener() {

    /**
     * Triggered when traffic level changes.
     */
    public abstract fun onTrafficChanged(trafficLevel: TrafficLevel?)

    /**
     * Triggered when traffic information is loading.
     */
    public abstract fun onTrafficLoading()

    /**
     * Triggered when traffic information expires.
     */
    public abstract fun onTrafficExpired()
}

public inline fun TrafficListener(
    crossinline onTrafficChanged: (trafficLevel: TrafficLevel?) -> Unit,
    crossinline onTrafficLoading: () -> Unit = {},
    crossinline onTrafficExpired: () -> Unit = {},
): TrafficListener {
    return object : TrafficListener() {
        override fun onTrafficChanged(trafficLevel: TrafficLevel?) {
            onTrafficChanged.invoke(trafficLevel)
        }

        override fun onTrafficLoading() {
            onTrafficLoading.invoke()
        }

        override fun onTrafficExpired() {
            onTrafficExpired.invoke()
        }
    }
}
