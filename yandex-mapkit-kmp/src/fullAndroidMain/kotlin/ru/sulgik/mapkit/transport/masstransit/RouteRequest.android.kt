package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.Session.RouteListener as NativeRouteListener

internal fun RouteRequest.toNative(): NativeRouteListener {
    return asListener().toNative()
}
