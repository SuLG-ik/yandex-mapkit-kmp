---
title: "ParkingAttributes"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / ParkingAttributes"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ParkingAttributes.html"
---
# ParkingAttributes

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ParkingAttributes.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.ParkingAttributes

`class ParkingAttributes implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ParkingAttributes()
```

Use constructor with parameters in your code.

```java
ParkingAttributes(@Nullable java.lang.String orgURI,
                  @Nullable Money firstHourPrice,
                  @Nullable java.lang.Integer placesCount)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getOrgURI()`<br>Parking organization URI. |
| `synchronized Money` | `getFirstHourPrice()`<br>Price of the first hour. |
| `synchronized java.lang.Integer` | `getPlacesCount()`<br>Maximum number of parking places (capacity). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ParkingAttributes

```java
ParkingAttributes()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ParkingAttributes

```java
ParkingAttributes(@Nullable java.lang.String orgURI,
                  @Nullable Money firstHourPrice,
                  @Nullable java.lang.Integer placesCount)
```

## Methods

### getOrgURI

```java
@Nullable
java.lang.String getOrgURI()
```

Parking organization URI.

For example, parking zone or any toll area or inside building parking.

Optional field, can be null.

### getFirstHourPrice

```java
@Nullable
Money getFirstHourPrice()
```

Price of the first hour.

Optional field, can be null.

### getPlacesCount

```java
@Nullable
java.lang.Integer getPlacesCount()
```

Maximum number of parking places (capacity).

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
