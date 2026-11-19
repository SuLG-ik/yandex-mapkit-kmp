package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKMasstransitWayPoint as NativeWayPoint

/** Converts this WayPoint to the native value. */
public fun WayPoint.toNative(): NativeWayPoint {
    return NativeWayPoint.wayPointWithPosition(
        position = position.toNative(),
        selectedArrivalPoint = selectedArrivalPoint?.toNative(),
        selectedDeparturePoint = selectedDeparturePoint?.toNative(),
        context = context,
        levelId = levelId,
        levelName = levelName,
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
