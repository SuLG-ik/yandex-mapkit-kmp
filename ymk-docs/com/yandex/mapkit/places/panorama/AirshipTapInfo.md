---
title: "AirshipTapInfo"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / AirshipTapInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/AirshipTapInfo.html"
---
# AirshipTapInfo

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/AirshipTapInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.AirshipTapInfo

## All Superinterfaces:

*[BaseMetadata](../../BaseMetadata.md)*

`class AirshipTapInfo implements BaseMetadata, Serializable`

## Summary

### Constructors

**Signature and Description**

```java
AirshipTapInfo()
```

Use constructor with parameters in your code.

```java
AirshipTapInfo(@NonNull java.lang.String panoramaId)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getPanoramaId()`<br>Panorama id of the tapped airship. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### AirshipTapInfo

```java
AirshipTapInfo()
```

Use constructor with parameters in your code.

This one is for serialization only!

### AirshipTapInfo

```java
AirshipTapInfo(@NonNull java.lang.String panoramaId)
```

## Methods

### getPanoramaId

```java
@NonNull
java.lang.String getPanoramaId()
```

Panorama id of the tapped airship.

The id may be used to open panorama in the panorama player

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
