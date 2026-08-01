package ru.sulgik.mapkit.location

/**
 * What the simulated location manager reports.
 */
public data class LocationSettings(
    /**
     * Flag whether to provide accuracy value.
     */
    val provideAccuracy: Boolean = false,
    /**
     * Location accuracy range in meters.
     */
    val accuracy: Range? = null,
    /**
     * Location time interval.
     */
    val locationTimeInterval: TimeInterval? = null,
    /**
     * Flag whether to provide speed value.
     */
    val provideSpeed: Boolean = false,
    /**
     * The speed in meters per second.
     */
    val speed: Double = 0.0,
    /**
     * Flag whether to provide error of heading.
     */
    val provideHeading: Boolean = false,
    /**
     * The current heading error range in degrees relative to true heading, clockwise.
     */
    val headingError: Range? = null,
    val locationError: LocationError? = null,
    /**
     * Flag whether to provide wheel speed value.
     */
    val provideWheelSpeed: Boolean = false,
    /**
     * Time interval of getting the wheel speed.
     */
    val wheelSpeedTimeInterval: TimeInterval? = null,
) {

    public companion object
}

/**
 * The settings of a high accuracy location source.
 */
public expect fun LocationSettings.Companion.fineSettings(): LocationSettings

/**
 * The settings of a low accuracy location source.
 */
public expect fun LocationSettings.Companion.coarseSettings(): LocationSettings
