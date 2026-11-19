package ru.sulgik.mapkit.transport.masstransit

import platform.Foundation.NSError

internal fun RouteRequest.toNative(): (List<*>?, NSError?) -> Unit {
    return asListener().toNative()
}
