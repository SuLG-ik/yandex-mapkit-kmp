package ru.sulgik.mapkit.routing

/** The current callback shared by every wrapper of one native routing session. */
internal class RoutingRequestState<Listener : Any> {

    private var current: RoutingRequest<Listener>? = null

    fun replace(next: RoutingRequest<Listener>) {
        cancel()
        current = next
        next.attach(this)
    }

    fun cancel() {
        val previous = current
        current = null
        previous?.dispose()
    }

    fun isCurrent(request: RoutingRequest<Listener>): Boolean {
        return current === request
    }
}
