package ru.sulgik.mapkit

import ru.sulgik.mapkit.location.LocationManager
import ru.sulgik.runtime.sensors.LocationActivityType

expect class MapKit {

    /**
     * Returns the version of the MapKit bundle.
     */
    val version: String


    /**
     * Resets the global location manager to a default one, that is a location manager that is created by createLocationManager() call.
     */
    fun resetLocationManagerToDefault()

    /**
     * Notifies MapKit when the application resumes the foreground state.
     */
    fun onStart()

    /**
     * Notifies MapKit when the application pauses and goes to the background.
     */
    fun onStop()

    /**
     * Sets single global location manager that is used by every module in MapKit by default.
     */
    fun setLocationManager(locationManager: LocationManager)

    /**
     * Creates a manager that allows to listen for device location updates.
     */
    fun createLocationManager(): LocationManager

    /**
     * Creates a manager that allows to listen for device location updates, uses activityType as a hint.
     */
    fun createLocationManager(activityType: LocationActivityType): LocationManager


    companion object {

        fun setLocale(locale: String?)

        fun setApiKey(apiKey: String)

        fun setUserId(userId: String)

        fun getInstance(): MapKit

    }

}