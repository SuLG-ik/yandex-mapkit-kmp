---
title: "LayerOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / LayerOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/LayerOptions.html"
---
# LayerOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/LayerOptions.html)

**Package** com.yandex.mapkit.layers

java.lang.Object
↳ com.yandex.mapkit.layers.LayerOptions

`final class LayerOptions implements Serializable`

Options that are used when adding a layer to the map.

## Summary

### Constructors

**Signature and Description**

```java
LayerOptions(boolean active,
             boolean nightModeAvailable,
             boolean cacheable,
             boolean animateOnActivation,
             long tileAppearingAnimationDuration,
             @NonNull OverzoomMode overzoomMode,
             boolean transparent,
             boolean versionSupport)
```

```java
LayerOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getActive()`<br>Inactive layers are not displayed on the map and do not request any tiles from TileProvider. |
| `LayerOptions` | `setActive(boolean active)`<br>See **#getActive()**. |
| `boolean` | `getNightModeAvailable()`<br>Indicates the availability of night mode for this layer (for example, night mode is disabled for the satellite layer). |
| `LayerOptions` | `setNightModeAvailable(boolean nightModeAvailable)`<br>See **#getNightModeAvailable()**. |
| `boolean` | `getCacheable()`<br>Determines whether tiles are cached on persistent storage or not. |
| `LayerOptions` | `setCacheable(boolean cacheable)`<br>See **#getCacheable()**. |
| `boolean` | `getAnimateOnActivation()`<br>Indicates whether layer activation/deactivation should be animated. |
| `LayerOptions` | `setAnimateOnActivation(boolean animateOnActivation)`<br>See **#getAnimateOnActivation()**. |
| `long` | `getTileAppearingAnimationDuration()`<br>Specifies duration of tile appearing animation. |
| `LayerOptions` | `setTileAppearingAnimationDuration(long tileAppearingAnimationDuration)`<br>See **#getTileAppearingAnimationDuration()**. |
| `OverzoomMode` | `getOverzoomMode()`<br>Whether to render tiles from adjacent zoom levels in place of absent or translucent tiles. |
| `LayerOptions` | `setOverzoomMode(@NonNull OverzoomMode overzoomMode)`<br>See **#getOverzoomMode()**. |
| `boolean` | `getTransparent()`<br>Set this flag if layer is transparent, that is parts of underlying layers can be seen through it. |
| `LayerOptions` | `setTransparent(boolean transparent)`<br>See **#getTransparent()**. |
| `boolean` | `getVersionSupport()`<br>Determines if layer supports versioning |
| `LayerOptions` | `setVersionSupport(boolean versionSupport)`<br>See **#getVersionSupport()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### LayerOptions

```java
LayerOptions(boolean active,
             boolean nightModeAvailable,
             boolean cacheable,
             boolean animateOnActivation,
             long tileAppearingAnimationDuration,
             @NonNull OverzoomMode overzoomMode,
             boolean transparent,
             boolean versionSupport)
```

### LayerOptions

```java
LayerOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getActive

```java
boolean getActive()
```

Inactive layers are not displayed on the map and do not request any tiles from TileProvider.

### setActive

```java
LayerOptions setActive(boolean active)
```

See **#getActive()**.

### getNightModeAvailable

```java
boolean getNightModeAvailable()
```

Indicates the availability of night mode for this layer (for example, night mode is disabled for the satellite layer).

Default: true.

### setNightModeAvailable

```java
LayerOptions setNightModeAvailable(boolean nightModeAvailable)
```

See **#getNightModeAvailable()**.

### getCacheable

```java
boolean getCacheable()
```

Determines whether tiles are cached on persistent storage or not.

### setCacheable

```java
LayerOptions setCacheable(boolean cacheable)
```

See **#getCacheable()**.

### getAnimateOnActivation

```java
boolean getAnimateOnActivation()
```

Indicates whether layer activation/deactivation should be animated.

### setAnimateOnActivation

```java
LayerOptions setAnimateOnActivation(boolean animateOnActivation)
```

See **#getAnimateOnActivation()**.

### getTileAppearingAnimationDuration

```java
long getTileAppearingAnimationDuration()
```

Specifies duration of tile appearing animation.

Can be set to 0 to disable animation. Default: 400 ms

### setTileAppearingAnimationDuration

```java
LayerOptions setTileAppearingAnimationDuration(long tileAppearingAnimationDuration)
```

See **#getTileAppearingAnimationDuration()**.

### getOverzoomMode

```java
@NonNull
OverzoomMode getOverzoomMode()
```

Whether to render tiles from adjacent zoom levels in place of absent or translucent tiles.

### setOverzoomMode

```java
LayerOptions setOverzoomMode(@NonNull OverzoomMode overzoomMode)
```

See **#getOverzoomMode()**.

### getTransparent

```java
boolean getTransparent()
```

Set this flag if layer is transparent, that is parts of underlying layers can be seen through it.

This will disable some rendering optimizations that take advantage of layer opacity.

### setTransparent

```java
LayerOptions setTransparent(boolean transparent)
```

See **#getTransparent()**.

### getVersionSupport

```java
boolean getVersionSupport()
```

Determines if layer supports versioning

### setVersionSupport

```java
LayerOptions setVersionSupport(boolean versionSupport)
```

See **#getVersionSupport()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
