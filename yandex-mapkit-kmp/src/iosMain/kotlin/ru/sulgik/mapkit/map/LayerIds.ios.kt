package ru.sulgik.mapkit.map

import YandexMapKit.YMKLayerIds.Companion as NativeLayerIds

public actual object LayerIds {
    public actual val mapLayerId: String
        get() = NativeLayerIds.mapLayerId()

    public actual val jamsLayerId: String
        get() = NativeLayerIds.jamsLayerId()

    public actual val personalizedPoiLayerId: String
        get() = NativeLayerIds.personalizedPoiLayerId()

    public actual val transportLayerId: String
        get() = NativeLayerIds.transportLayerId()

    public actual val searchPinsLayerId: String
        get() = NativeLayerIds.searchPinsLayerId()

    public actual val advertPinsLayerId: String
        get() = NativeLayerIds.advertPinsLayerId()

    public actual val buildingsLayerId: String
        get() = NativeLayerIds.buildingsLayerId()

    public actual val mapObjectsLayerId: String
        get() = NativeLayerIds.mapObjectsLayerId()

    public actual val routeMapObjectsLayerId: String
        get() = NativeLayerIds.routeMapObjectsLayerId()

    public actual val userLocationLayerId: String
        get() = NativeLayerIds.userLocationLayerId()

    public actual val drivingNavigationBaseLayerId: String
        get() = NativeLayerIds.drivingNavigationBaseLayerId()

    public actual val drivingNavigationRoutePinsLayerId: String
        get() = NativeLayerIds.drivingNavigationRoutePinsLayerId()

    public actual val drivingNavigationBalloonsLayerId: String
        get() = NativeLayerIds.drivingNavigationBalloonsLayerId()

    public actual val drivingNavigationUserPlacemarkLayerId: String
        get() = NativeLayerIds.drivingNavigationUserPlacemarkLayerId()

    public actual val roadEventsLayerId: String
        get() = NativeLayerIds.roadEventsLayerId()
}
