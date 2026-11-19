package ru.sulgik.mapkit.routing

/** A callback that can also receive a synchronous result before the native session is returned. */
internal abstract class RoutingRequest<Listener : Any>(private var listener: Listener?) {

    private var state: RoutingRequestState<Listener>? = null

    protected fun currentListener(): Listener? {
        return if (state?.isCurrent(this) == false) null else listener
    }

    fun attach(state: RoutingRequestState<Listener>) {
        this.state = state
    }

    fun dispose() {
        listener = null
        state = null
    }
}
