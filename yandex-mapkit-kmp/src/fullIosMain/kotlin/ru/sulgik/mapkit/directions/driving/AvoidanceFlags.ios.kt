package ru.sulgik.mapkit.directions.driving

import YandexMapKit.YMKDrivingAvoidanceFlags as NativeAvoidanceFlags

public fun AvoidanceFlags.toNative(): NativeAvoidanceFlags {
    return NativeAvoidanceFlags.avoidanceFlagsWithAvoidTolls(
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
