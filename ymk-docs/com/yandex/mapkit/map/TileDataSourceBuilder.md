---
title: "TileDataSourceBuilder"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / TileDataSourceBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/TileDataSourceBuilder.html"
---
# TileDataSourceBuilder

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/TileDataSourceBuilder.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[BaseDataSourceBuilder](BaseDataSourceBuilder.md)*

`interface TileDataSourceBuilder extends BaseDataSourceBuilder`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setTileUrlProvider(@NonNull UrlProvider urlProvider)`<br>The class does not retain the object in the 'urlProvider' parameter. |
| `void` | `setTileProvider(@NonNull TileProvider tileProvider)`<br>The class does not retain the object in the 'tileProvider' parameter. |
| `void` | `setProjection(@NonNull Projection projection)` |
| `void` | `setZoomRanges(@NonNull java.util.List<ZoomRange> zoomRanges)` |
| `void` | `setTileFormat(@NonNull TileFormat format)` |

## Methods

### setTileUrlProvider

```java
void setTileUrlProvider(@NonNull UrlProvider urlProvider)
```

The class does not retain the object in the 'urlProvider' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setTileProvider

```java
void setTileProvider(@NonNull TileProvider tileProvider)
```

The class does not retain the object in the 'tileProvider' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setProjection

```java
void setProjection(@NonNull Projection projection)
```

### setZoomRanges

```java
void setZoomRanges(@NonNull java.util.List<ZoomRange> zoomRanges)
```

### setTileFormat

```java
void setTileFormat(@NonNull TileFormat format)
```
