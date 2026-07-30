---
title: "PanoramaDescription"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / PanoramaDescription"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaDescription.html"
---
# PanoramaDescription

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaDescription.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.PanoramaDescription

`class PanoramaDescription implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
PanoramaDescription()
```

Use constructor with parameters in your code.

```java
PanoramaDescription(@NonNull java.lang.String panoramaId,
                    @Nullable Position position,
                    @NonNull AngularBoundingBox angularBBox,
                    @NonNull ImageSize tileSize,
                    @NonNull java.util.List<TileLevel> tileLevels,
                    @NonNull java.util.List<IconMarker> iconMarkers,
                    @NonNull java.util.List<TextMarker> textMarkers,
                    @NonNull java.util.List<CompanyMarker> companyMarkers,
                    @NonNull java.util.List<IconConnection> iconConnections,
                    @NonNull java.util.List<ArrowConnection> arrowConnections,
                    @NonNull Direction direction,
                    @NonNull Span span,
                    @Nullable Attribution attribution)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getPanoramaId()`<br>panoramaId is passed as a parameter to the TileImageFactory or to the TileUrlProvider |
| `synchronized Position` | `getPosition()`<br>Geo position. |
| `synchronized AngularBoundingBox` | `getAngularBBox()`<br>The angularBBox field sets how the tile tilelevels oriented in space. |
| `synchronized ImageSize` | `getTileSize()`<br>Any tile level imageSize width must be multiple of the tileSize width. |
| `synchronized java.util.List<TileLevel>` | `getTileLevels()`<br>The tileLevels is a set of the TileLevel structs. |
| `synchronized java.util.List<IconMarker>` | `getIconMarkers()`<br>Add marker icons to the panorama |
| `synchronized java.util.List<TextMarker>` | `getTextMarkers()`<br>Add marker text to the panorama |
| `synchronized java.util.List<CompanyMarker>` | `getCompanyMarkers()`<br>Add company icons and labels to the panorama |
| `synchronized java.util.List<IconConnection>` | `getIconConnections()`<br>Add icons with interaction |
| `synchronized java.util.List<ArrowConnection>` | `getArrowConnections()`<br>Add standard player arrow connections |
| `synchronized Direction` | `getDirection()`<br>Suggest where to look at once panorama is opened. |
| `synchronized Span` | `getSpan()`<br>Suggest view area span. |
| `synchronized Attribution` | `getAttribution()`<br>Panorama author information. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### PanoramaDescription

```java
PanoramaDescription()
```

Use constructor with parameters in your code.

This one is for serialization only!

### PanoramaDescription

```java
PanoramaDescription(@NonNull java.lang.String panoramaId,
                    @Nullable Position position,
                    @NonNull AngularBoundingBox angularBBox,
                    @NonNull ImageSize tileSize,
                    @NonNull java.util.List<TileLevel> tileLevels,
                    @NonNull java.util.List<IconMarker> iconMarkers,
                    @NonNull java.util.List<TextMarker> textMarkers,
                    @NonNull java.util.List<CompanyMarker> companyMarkers,
                    @NonNull java.util.List<IconConnection> iconConnections,
                    @NonNull java.util.List<ArrowConnection> arrowConnections,
                    @NonNull Direction direction,
                    @NonNull Span span,
                    @Nullable Attribution attribution)
```

## Methods

### getPanoramaId

```java
@NonNull
java.lang.String getPanoramaId()
```

panoramaId is passed as a parameter to the TileImageFactory or to the TileUrlProvider

### getPosition

```java
@Nullable
Position getPosition()
```

Geo position.

Optional field, can be null.

### getAngularBBox

```java
@NonNull
AngularBoundingBox getAngularBBox()
```

The angularBBox field sets how the tile tilelevels oriented in space.

Direction + span will be limited between top and bottom The recommendation for initializing angular bbox: (right - left) == 360. Non 360 degrees panoramas are not supported yet. (top - bottom) = 180 The angular aspect ratio must be the same as any tileLevel aspect ratio. (right - left)/(top - bottom) == tileLevel[i].width/tileLevel[i].height

### getTileSize

```java
@NonNull
ImageSize getTileSize()
```

Any tile level imageSize width must be multiple of the tileSize width.

Only 256x256 and 512x512 tiles are supported.

### getTileLevels

```java
@NonNull
java.util.List<TileLevel> getTileLevels()
```

The tileLevels is a set of the TileLevel structs.

Tile levels can be added in any order. It's recommended to have at least 2 tile levels: - low quality zoom. For example 512x200 - high quality zoom. For axample 20480x8000

It can be useful to have several tile levels for huge images to save network traffic and reduce memory and power consumption. So the final tile levels list may look like that: level, width, height 0, 512, 200 1, 2048, 800 2, 5120, 2000 6, 10240, 4000 9, 20480, 8000

Player takes into account the view area size and available tile levels and downloads the most suitable level.

The tileLevels[i] aspect ratio must be the same. At first low quality zoom is loaded. Once it's done, the panorama player notifies that the panorama is opened and starts loading high quality zoom tiles.

### getIconMarkers

```java
@NonNull
java.util.List<IconMarker> getIconMarkers()
```

Add marker icons to the panorama

### getTextMarkers

```java
@NonNull
java.util.List<TextMarker> getTextMarkers()
```

Add marker text to the panorama

### getCompanyMarkers

```java
@NonNull
java.util.List<CompanyMarker> getCompanyMarkers()
```

Add company icons and labels to the panorama

### getIconConnections

```java
@NonNull
java.util.List<IconConnection> getIconConnections()
```

Add icons with interaction

### getArrowConnections

```java
@NonNull
java.util.List<ArrowConnection> getArrowConnections()
```

Add standard player arrow connections

### getDirection

```java
@NonNull
Direction getDirection()
```

Suggest where to look at once panorama is opened.

It's just a recommendation because it depends on angularBBox and span.

### getSpan

```java
@NonNull
Span getSpan()
```

Suggest view area span.

It's just a recommendation because it depends on angularBBox and direction.

### getAttribution

```java
@Nullable
Attribution getAttribution()
```

Panorama author information.

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
