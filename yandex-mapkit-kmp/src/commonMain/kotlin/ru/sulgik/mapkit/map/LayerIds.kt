package ru.sulgik.mapkit.map

public expect object LayerIds {
    public val mapLayerId: String
    public val jamsLayerId: String
    public val personalizedPoiLayerId: String
    public val transportLayerId: String
    public val searchPinsLayerId: String
    public val advertPinsLayerId: String
    public val buildingsLayerId: String
    public val mapObjectsLayerId: String
    public val routeMapObjectsLayerId: String
    public val userLocationLayerId: String
    public val drivingNavigationBaseLayerId: String
    public val drivingNavigationRoutePinsLayerId: String
    public val drivingNavigationBalloonsLayerId: String
    public val drivingNavigationUserPlacemarkLayerId: String
    public val roadEventsLayerId: String
}