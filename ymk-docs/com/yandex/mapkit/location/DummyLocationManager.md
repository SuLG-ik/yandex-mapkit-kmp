---
title: "DummyLocationManager"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / DummyLocationManager"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/DummyLocationManager.html"
---
# DummyLocationManager

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/DummyLocationManager.html)

**Package** com.yandex.mapkit.location

## All Superinterfaces:

*[LocationManager](LocationManager.md)*

`interface DummyLocationManager extends LocationManager`

Provides the ability to set any location and notify all consumers of this location.

This is a very simple location manager that is responsible for passing any locations via setLocation method and notifying all consumers.

> [!NOTE] Примечание
> The main reason why we need this class is to allow the user to set this LocationManager to Guide via setLocationManager, just to correct any desirable location via Guide.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setLocation(@NonNull Location location, @NonNull DummyLocationQuality quality)`<br>Sets a location and notifies all consumers of this location. |

## Methods

### setLocation

```java
void setLocation(@NonNull Location location,
                 @NonNull DummyLocationQuality quality)
```

Sets a location and notifies all consumers of this location.

| Parameters |   |
| --- | --- |
| `location` | Any desirable location that we would like to provide. |
