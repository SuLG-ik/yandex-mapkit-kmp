package ru.sulgik.mapkit.map

import kotlin.time.Duration.Companion.milliseconds
import com.yandex.mapkit.map.MapLoadStatistics as NativeMapLoadStatistics

public fun MapLoadStatistics.toNative(): NativeMapLoadStatistics {
    return NativeMapLoadStatistics(
        curZoomGeometryLoaded.inWholeMilliseconds,
        curZoomPlacemarksLoaded.inWholeMilliseconds,
        curZoomLabelsLoaded.inWholeMilliseconds,
        delayedGeometryLoaded.inWholeMilliseconds,
        curZoomModelsLoaded.inWholeMilliseconds,
        fullyLoaded.inWholeMilliseconds,
        fullyAppeared.inWholeMilliseconds,
        renderObjectCount,
        tileMemoryUsage,
    )
}

public fun NativeMapLoadStatistics.toCommon(): MapLoadStatistics {
    return MapLoadStatistics(
        curZoomGeometryLoaded = curZoomGeometryLoaded.milliseconds,
        curZoomPlacemarksLoaded = curZoomPlacemarksLoaded.milliseconds,
        curZoomLabelsLoaded = curZoomLabelsLoaded.milliseconds,
        delayedGeometryLoaded = delayedGeometryLoaded.milliseconds,
        curZoomModelsLoaded = curZoomModelsLoaded.milliseconds,
        fullyLoaded = fullyLoaded.milliseconds,
        fullyAppeared = fullyAppeared.milliseconds,
        renderObjectCount = renderObjectCount,
        tileMemoryUsage = tileMemoryUsage,
    )
}
