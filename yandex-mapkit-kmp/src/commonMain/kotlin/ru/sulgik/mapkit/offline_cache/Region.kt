package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.LocalizedValue
import ru.sulgik.mapkit.geometry.Point
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * A region of the map that can be downloaded for offline use.
 */
@OptIn(ExperimentalTime::class)
public data class Region(
    /**
     * Region ID.
     */
    val id: Int,
    /**
     * Name of the region.
     */
    val name: String,
    /**
     * Country of the region.
     */
    val country: String,
    /**
     * Center point.
     */
    val center: Point,
    /**
     * Region size.
     */
    val size: LocalizedValue,
    /**
     * The region creation time.
     */
    val releaseTime: Instant,
    /**
     * Region id of the parent region.
     */
    val parentId: Int?,
)
