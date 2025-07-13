package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.LayerIds as NativeLayerIds

public actual object LayerIds {
    public actual val mapLayerId: String
        get() = NativeLayerIds.getMapLayerId()

    public actual val jamsLayerId: String
        get() = NativeLayerIds.getJamsLayerId()

    public actual val personalizedPoiLayerId: String
        get() = NativeLayerIds.getPersonalizedPoiLayerId()

    public actual val transportLayerId: String
        get() = NativeLayerIds.getTransportLayerId()

    public actual val searchPinsLayerId: String
        get() = NativeLayerIds.getSearchPinsLayerId()

    public actual val advertPinsLayerId: String
        get() = NativeLayerIds.getAdvertPinsLayerId()

    public actual val buildingsLayerId: String
        get() = NativeLayerIds.getBuildingsLayerId()

    public actual val mapObjectsLayerId: String
        get() = NativeLayerIds.getMapObjectsLayerId()

    public actual val routeMapObjectsLayerId: String
        get() = NativeLayerIds.getRouteMapObjectsLayerId()

    public actual val userLocationLayerId: String
        get() = NativeLayerIds.getUserLocationLayerId()

    public actual val drivingNavigationBaseLayerId: String
        get() = NativeLayerIds.getDrivingNavigationBaseLayerId()

    public actual val drivingNavigationRoutePinsLayerId: String
        get() = NativeLayerIds.getDrivingNavigationRoutePinsLayerId()

    public actual val drivingNavigationBalloonsLayerId: String
        get() = NativeLayerIds.getDrivingNavigationBalloonsLayerId()

    public actual val drivingNavigationUserPlacemarkLayerId: String
        get() = NativeLayerIds.getDrivingNavigationUserPlacemarkLayerId()

    public actual val roadEventsLayerId: String
        get() = NativeLayerIds.getRoadEventsLayerId()
}