package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.transport.masstransit.WayPoint as NativeWayPoint

/** Converts this WayPoint to the native value. */
public fun WayPoint.toNative(): NativeWayPoint {
    return NativeWayPoint(
        position.toNative(),
        selectedArrivalPoint?.toNative(),
        selectedDeparturePoint?.toNative(),
        context,
        levelId,
        levelName,
    )
}

/** Reads this native WayPoint. */
public fun NativeWayPoint.toCommon(): WayPoint {
    return WayPoint(
        position = position.toCommon(),
        selectedArrivalPoint = selectedArrivalPoint?.toCommon(),
        selectedDeparturePoint = selectedDeparturePoint?.toCommon(),
        context = context,
        levelId = levelId,
        levelName = levelName,
    )
}
