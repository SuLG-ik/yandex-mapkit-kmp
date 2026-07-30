---
title: "LocationManagerUtils"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / LocationManagerUtils"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationManagerUtils.html"
---
# LocationManagerUtils

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationManagerUtils.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.LocationManagerUtils

`class LocationManagerUtils`

## Summary

### Constructors

**Signature and Description**

```java
LocationManagerUtils()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native Location` | `getLastKnownLocation()`<br>Last known location, if one was ever received. |

## Constuctors

### LocationManagerUtils

```java
LocationManagerUtils()
```

## Methods

### getLastKnownLocation

```java
@Nullable
Location getLastKnownLocation()
```

Last known location, if one was ever received.

Optional property, can be null.
