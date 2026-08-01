package ru.sulgik.mapkit.offline_cache

import platform.Foundation.NSDate
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNSNumber
import ru.sulgik.mapkit.toNative
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import YandexMapKit.YMKOfflineCacheRegion as NativeRegion

@OptIn(ExperimentalTime::class)
public fun Region.toNative(): NativeRegion {
    return NativeRegion.regionWithId(
        id = id.toULong(),
        name = name,
        country = country,
        center = center.toNative(),
        size = size.toNative(),
        releaseTime = NSDate.dateWithTimeIntervalSince1970(releaseTime.toEpochMilliseconds() / 1000.0),
        parentId = parentId?.toNSNumber(),
    )
}

@OptIn(ExperimentalTime::class)
public fun NativeRegion.toCommon(): Region {
    return Region(
        id = id.toInt(),
        name = name,
        country = country,
        center = center.toCommon(),
        size = size.toCommon(),
        releaseTime = Instant.fromEpochMilliseconds((releaseTime.timeIntervalSince1970 * 1000).toLong()),
        parentId = parentId?.intValue,
    )
}
