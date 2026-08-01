package ru.sulgik.mapkit.map

import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import YandexMapKit.YMKMapLoadStatistics as NativeMapLoadStatistics

public fun MapLoadStatistics.toNative(): NativeMapLoadStatistics {
    return NativeMapLoadStatistics.mapLoadStatisticsWithCurZoomGeometryLoaded(
        curZoomGeometryLoaded = curZoomGeometryLoaded.toSeconds(),
        curZoomPlacemarksLoaded = curZoomPlacemarksLoaded.toSeconds(),
        curZoomLabelsLoaded = curZoomLabelsLoaded.toSeconds(),
        delayedGeometryLoaded = delayedGeometryLoaded.toSeconds(),
        curZoomModelsLoaded = curZoomModelsLoaded.toSeconds(),
        fullyLoaded = fullyLoaded.toSeconds(),
        fullyAppeared = fullyAppeared.toSeconds(),
        renderObjectCount = renderObjectCount.toLong(),
        tileMemoryUsage = tileMemoryUsage.toULong(),
    )
}

public fun NativeMapLoadStatistics.toCommon(): MapLoadStatistics {
    return MapLoadStatistics(
        curZoomGeometryLoaded = curZoomGeometryLoaded.seconds,
        curZoomPlacemarksLoaded = curZoomPlacemarksLoaded.seconds,
        curZoomLabelsLoaded = curZoomLabelsLoaded.seconds,
        delayedGeometryLoaded = delayedGeometryLoaded.seconds,
        curZoomModelsLoaded = curZoomModelsLoaded.seconds,
        fullyLoaded = fullyLoaded.seconds,
        fullyAppeared = fullyAppeared.seconds,
        renderObjectCount = renderObjectCount.toInt(),
        tileMemoryUsage = tileMemoryUsage.toInt(),
    )
}

private fun Duration.toSeconds(): Double {
    return inWholeMilliseconds / 1000.0
}
