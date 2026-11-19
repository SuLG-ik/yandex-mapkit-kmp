package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.annotations.AnnotationLanguage
import kotlin.time.Instant

/** Starting heading, number of alternatives, departure time, annotation language and road preferences. */
public data class DrivingOptions(
    public val initialAzimuth: Double? = null,
    public val routesCount: Int? = null,
    public val departureTime: Instant? = null,
    public val annotationLanguage: AnnotationLanguage? = null,
    public val avoidanceFlags: AvoidanceFlags? = null,
)
