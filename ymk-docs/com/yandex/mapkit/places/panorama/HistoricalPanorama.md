---
title: "HistoricalPanorama"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / HistoricalPanorama"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/HistoricalPanorama.html"
---
# HistoricalPanorama

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/HistoricalPanorama.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.HistoricalPanorama

`class HistoricalPanorama implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
HistoricalPanorama(@NonNull java.lang.String name,
                   @NonNull java.lang.String panoramaId,
                   long timestamp)
```

```java
HistoricalPanorama()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getName()` |
| `java.lang.String` | `getPanoramaId()` |
| `long` | `getTimestamp()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### HistoricalPanorama

```java
HistoricalPanorama(@NonNull java.lang.String name,
                   @NonNull java.lang.String panoramaId,
                   long timestamp)
```

### HistoricalPanorama

```java
HistoricalPanorama()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getName

```java
@NonNull
java.lang.String getName()
```

### getPanoramaId

```java
@NonNull
java.lang.String getPanoramaId()
```

### getTimestamp

```java
long getTimestamp()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
