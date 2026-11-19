package ru.sulgik.mapkit.directions.driving

import com.yandex.mapkit.directions.driving.AvoidanceFlags as NativeAvoidanceFlags

public fun AvoidanceFlags.toNative(): NativeAvoidanceFlags {
    return NativeAvoidanceFlags(
        avoidTolls,
        avoidUnpaved,
        avoidPoorCondition,
        avoidRailwayCrossing,
        avoidBoatFerry,
        avoidFordCrossing,
        avoidTunnel,
        avoidHighway,
    )
}

public fun NativeAvoidanceFlags.toCommon(): AvoidanceFlags {
    return AvoidanceFlags(
        avoidTolls = avoidTolls,
        avoidUnpaved = avoidUnpaved,
        avoidPoorCondition = avoidPoorCondition,
        avoidRailwayCrossing = avoidRailwayCrossing,
        avoidBoatFerry = avoidBoatFerry,
        avoidFordCrossing = avoidFordCrossing,
        avoidTunnel = avoidTunnel,
        avoidHighway = avoidHighway,
    )
}
