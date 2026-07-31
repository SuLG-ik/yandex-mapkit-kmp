package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import com.yandex.mapkit.offline_cache.Region as NativeRegion

@OptIn(ExperimentalTime::class)
public fun Region.toNative(): NativeRegion {
    return NativeRegion(
        id,
        name,
        country,
        center.toNative(),
        size.toNative(),
        releaseTime.toEpochMilliseconds(),
        parentId,
    )
}

@OptIn(ExperimentalTime::class)
public fun NativeRegion.toCommon(): Region {
    return Region(
        id = id,
        name = name,
        country = country,
        center = center.toCommon(),
        size = size.toCommon(),
        releaseTime = Instant.fromEpochMilliseconds(releaseTime),
        parentId = parentId,
    )
}
