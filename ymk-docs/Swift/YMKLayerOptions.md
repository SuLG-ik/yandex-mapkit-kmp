---
title: "YMKLayerOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLayerOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLayerOptions.html"
---
# YMKLayerOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLayerOptions.html)

```swift
class YMKLayerOptions : NSObject
```

Options that are used when adding a layer to the map.

## Summary

### Class methods

```swift
 init(active: Bool,
 nightModeAvailable: Bool,
   cacheable: Bool,
 animateOnActivation: Bool,
 tileAppearingAnimationDuration: TimeInterval,
 overzoomMode: YMKOverzoomMode,
 transparent: Bool,
 versionSupport: Bool)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var active: Bool { get set }
```

Inactive layers are not displayed on the map and do not request any tiles from TileProvider

```swift
var nightModeAvailable: Bool { get set }
```

Indicates the availability of night mode for this layer (for example, night mode is disabled for the satellite layer)

```swift
var cacheable: Bool { get set }
```

Determines whether tiles are cached on persistent storage or not

```swift
var animateOnActivation: Bool { get set }
```

Indicates whether layer activation/deactivation should be animated

```swift
var tileAppearingAnimationDuration: TimeInterval { get set }
```

Specifies duration of tile appearing animation

```swift
var overzoomMode: YMKOverzoomMode { get set }
```

Whether to render tiles from adjacent zoom levels in place of absent or translucent tiles

```swift
var transparent: Bool { get set }
```

Set this flag if layer is transparent, that is parts of underlying layers can be seen through it

```swift
var versionSupport: Bool { get set }
```

Determines if layer supports versioning

## Class methods

### init(active:nightModeAvailable:cacheable:animateOnActivation:tileAppearingAnimationDuration:overzoomMode:transparent:versionSupport:)

```swift
 init(active: Bool,
 nightModeAvailable: Bool,
   cacheable: Bool,
 animateOnActivation: Bool,
 tileAppearingAnimationDuration: TimeInterval,
 overzoomMode: YMKOverzoomMode,
 transparent: Bool,
 versionSupport: Bool)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### active

```swift
var active: Bool { get set }
```

Inactive layers are not displayed on the map and do not request any tiles from TileProvider.

### nightModeAvailable

```swift
var nightModeAvailable: Bool { get set }
```

Indicates the availability of night mode for this layer (for example, night mode is disabled for the satellite layer). Default: true.

### cacheable

```swift
var cacheable: Bool { get set }
```

Determines whether tiles are cached on persistent storage or not.

### animateOnActivation

```swift
var animateOnActivation: Bool { get set }
```

Indicates whether layer activation/deactivation should be animated.

### tileAppearingAnimationDuration

```swift
var tileAppearingAnimationDuration: TimeInterval { get set }
```

Specifies duration of tile appearing animation. Can be set to 0 to disable animation. Default: 400 ms

### overzoomMode

```swift
var overzoomMode: YMKOverzoomMode { get set }
```

Whether to render tiles from adjacent zoom levels in place of absent or translucent tiles.

### transparent

```swift
var transparent: Bool { get set }
```

Set this flag if layer is transparent, that is parts of underlying layers can be seen through it. This will disable some rendering optimizations that take advantage of layer opacity.

### versionSupport

```swift
var versionSupport: Bool { get set }
```

Determines if layer supports versioning
