---
title: "LocationManager"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / LocationManager"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationManager.html"
---
# LocationManager

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationManager.html)

**Package** com.yandex.mapkit.location

## All known Subinterfaces:

*[DummyLocationManager](DummyLocationManager.md)*, *[LocationSimulator](LocationSimulator.md)*

`interface LocationManager`

Handles location updates and changes.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `subscribeForLocationUpdates(@NonNull SubscriptionSettings subscriptionSettings, @NonNull java.lang.ref.WeakReference<LocationListener> locationListener)`<br>Subscribe for location update events. |
| `void` | `requestSingleUpdate(@NonNull java.lang.ref.WeakReference<LocationListener> locationListener)`<br>Subscribe to a single location update. |
| `void` | `unsubscribe(@NonNull java.lang.ref.WeakReference<LocationListener> locationListener)`<br>Unsubscribe from location update events. |
| `void` | `suspend()`<br>Stops updates for all subscriptions until resume() is called. |
| `void` | `resume()`<br>Resumes updates stopped by a suspend() call. |

## Methods

### subscribeForLocationUpdates

```java
void subscribeForLocationUpdates(@NonNull SubscriptionSettings subscriptionSettings,
                                 @NonNull java.lang.ref.WeakReference<LocationListener> locationListener)
```

Subscribe for location update events.

If the listener was already subscribed to updates from the LocationManager, subscription settings will be updated.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `subscriptionSettings` | Subscription settings. |
| `locationListener` | Location update listener. |

### requestSingleUpdate

```java
void requestSingleUpdate(@NonNull java.lang.ref.WeakReference<LocationListener> locationListener)
```

Subscribe to a single location update.

If the listener was already subscribed to location updates, the previous subscription will be removed.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `locationListener` | Location update listener. |

### unsubscribe

```java
void unsubscribe(@NonNull java.lang.ref.WeakReference<LocationListener> locationListener)
```

Unsubscribe from location update events.

Can be called for either [mapkit.location.LocationManager#subscribeForLocationUpdates(SubscriptionSettings,
java.lang.ref.WeakReference)](./LocationManager.md#subscribeforlocationupdatessubscriptionsettings-
javalangrefweakreferencelocationlistener) or [mapkit.location.LocationManager#requestSingleUpdate(java.lang.ref.WeakReference)](LocationManager.md#requestsingleupdatejavalangrefweakreferencelocationlistener). For [mapkit.location.LocationManager#requestSingleUpdate(java.lang.ref.WeakReference)](LocationManager.md#requestsingleupdatejavalangrefweakreferencelocationlistener), if an event was already received, [mapkit.location.LocationManager#unsubscribe(java.lang.ref.WeakReference)](LocationManager.md#unsubscribejavalangrefweakreferencelocationlistener) does not have any effect. If the listener is already unsubscribed, the method call is ignored.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `locationListener` | Listener passed to either [mapkit.location.LocationManager#subscribeForLocationUpdates(SubscriptionSettings,<br>java.lang.ref.WeakReference)](./LocationManager.md#subscribeforlocationupdatessubscriptionsettings-<br>javalangrefweakreferencelocationlistener) or [mapkit.location.LocationManager#requestSingleUpdate(java.lang.ref.WeakReference)](LocationManager.md#requestsingleupdatejavalangrefweakreferencelocationlistener). |

### suspend

```java
void suspend()
```

Stops updates for all subscriptions until resume() is called.

### resume

```java
void resume()
```

Resumes updates stopped by a suspend() call.
