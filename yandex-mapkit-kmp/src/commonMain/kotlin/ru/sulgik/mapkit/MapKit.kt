package ru.sulgik.mapkit

import ru.sulgik.mapkit.location.LocationManager
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.user_location.UserLocationLayer

public expect class MapKit {

    /**
     * Returns the version of the MapKit bundle.
     */
    public val version: String


    /**
     * Resets the global location manager to a default one, that is a location manager that is created by createLocationManager() call.
     */
    public fun resetLocationManagerToDefault()

    /**
     * Notifies MapKit when the application resumes the foreground state.
     */
    public fun onStart()

    /**
     * Notifies MapKit when the application pauses and goes to the background.
     */
    public fun onStop()

    /**
     * Sets single global location manager that is used by every module in MapKit by default.
     */
    public fun setLocationManager(locationManager: LocationManager)

    /**
     * Creates a manager that allows to listen for device location updates.
     */
    public fun createLocationManager(): LocationManager

    /**
     * Create layer with the user location icon.
     */
    public fun createUserLocationLayer(mapWindow: MapWindow): UserLocationLayer

    public companion object {

        public fun setLocale(locale: String?)

        public fun setApiKey(apiKey: String)

        public fun setUserId(userId: String)

        public fun getInstance(): MapKit

    }

}