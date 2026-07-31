---
title: "MapLoadStatistics"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapLoadStatistics"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapLoadStatistics.html"
---
# MapLoadStatistics

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapLoadStatistics.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.MapLoadStatistics

`class MapLoadStatistics implements Serializable`

The time it took to load map elements.

## Summary

### Constructors

**Signature and Description**

```java
MapLoadStatistics(long curZoomGeometryLoaded,
                  long curZoomPlacemarksLoaded,
                  long curZoomLabelsLoaded,
                  long delayedGeometryLoaded,
                  long curZoomModelsLoaded,
                  long fullyLoaded,
                  long fullyAppeared,
                  int renderObjectCount,
                  int tileMemoryUsage)
```

```java
MapLoadStatistics()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `long` | `getCurZoomGeometryLoaded()` |
| `long` | `getCurZoomPlacemarksLoaded()` |
| `long` | `getCurZoomLabelsLoaded()` |
| `long` | `getDelayedGeometryLoaded()`<br>The time it took to load delayed geometry. |
| `long` | `getCurZoomModelsLoaded()`<br>The time it took to load models. |
| `long` | `getFullyLoaded()`<br>The time it took to load all map objects. |
| `long` | `getFullyAppeared()`<br>The time it took for all map objects to appear. |
| `int` | `getRenderObjectCount()` |
| `int` | `getTileMemoryUsage()`<br>Tile memory usage in bytes |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### MapLoadStatistics

```java
MapLoadStatistics(long curZoomGeometryLoaded,
                  long curZoomPlacemarksLoaded,
                  long curZoomLabelsLoaded,
                  long delayedGeometryLoaded,
                  long curZoomModelsLoaded,
                  long fullyLoaded,
                  long fullyAppeared,
                  int renderObjectCount,
                  int tileMemoryUsage)
```

### MapLoadStatistics

```java
MapLoadStatistics()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getCurZoomGeometryLoaded

```java
long getCurZoomGeometryLoaded()
```

### getCurZoomPlacemarksLoaded

```java
long getCurZoomPlacemarksLoaded()
```

### getCurZoomLabelsLoaded

```java
long getCurZoomLabelsLoaded()
```

### getDelayedGeometryLoaded

```java
long getDelayedGeometryLoaded()
```

The time it took to load delayed geometry.

### getCurZoomModelsLoaded

```java
long getCurZoomModelsLoaded()
```

The time it took to load models.

### getFullyLoaded

```java
long getFullyLoaded()
```

The time it took to load all map objects.

### getFullyAppeared

```java
long getFullyAppeared()
```

The time it took for all map objects to appear.

### getRenderObjectCount

```java
int getRenderObjectCount()
```

### getTileMemoryUsage

```java
int getTileMemoryUsage()
```

Tile memory usage in bytes

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
