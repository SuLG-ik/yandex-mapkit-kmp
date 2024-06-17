package ru.sulgik.mapkit

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

    companion object {

        fun setLocale(locale: String?)

        fun setApiKey(apiKey: String)

        fun setUserId(userId: String)

        fun getInstance(): MapKit

    }

}