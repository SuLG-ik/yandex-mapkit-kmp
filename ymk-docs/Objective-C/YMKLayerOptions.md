---
title: "YMKLayerOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLayerOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLayerOptions.html"
---
# YMKLayerOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLayerOptions.html)

```objectivec
@interface YMKLayerOptions : NSObject
```

Options that are used when adding a layer to the map.

## Summary

### Class methods

```objectivec
+ (nonnull YMKLayerOptions *)layerOptionsWithActive:( BOOL)active
                                 nightModeAvailable:( BOOL)nightModeAvailable
                                          cacheable:( BOOL)cacheable
                                animateOnActivation:( BOOL)animateOnActivation
                     tileAppearingAnimationDuration:( NSTimeInterval)tileAppearingAnimationDuration
                                       overzoomMode:( YMKOverzoomMode)overzoomMode
                                        transparent:( BOOL)transparent
                                     versionSupport:( BOOL)versionSupport;
```

### Instance methods

```objectivec
- (nonnull YMKLayerOptions *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL active;
```

Inactive layers are not displayed on the map and do not request any tiles from TileProvider

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL nightModeAvailable;
```

Indicates the availability of night mode for this layer (for example, night mode is disabled for the satellite layer)

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL cacheable;
```

Determines whether tiles are cached on persistent storage or not

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL animateOnActivation;
```

Indicates whether layer activation/deactivation should be animated

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    NSTimeInterval tileAppearingAnimationDuration;
```

Specifies duration of tile appearing animation

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKOverzoomMode overzoomMode;
```

Whether to render tiles from adjacent zoom levels in place of absent or translucent tiles

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL transparent;
```

Set this flag if layer is transparent, that is parts of underlying layers can be seen through it

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL versionSupport;
```

Determines if layer supports versioning

## Class methods

### layerOptionsWithActive:nightModeAvailable:cacheable:animateOnActivation:tileAppearingAnimationDuration:overzoomMode:transparent:versionSupport:

```objectivec
+ (nonnull YMKLayerOptions *)layerOptionsWithActive:( BOOL)active
                                 nightModeAvailable:( BOOL)nightModeAvailable
                                          cacheable:( BOOL)cacheable
                                animateOnActivation:( BOOL)animateOnActivation
                     tileAppearingAnimationDuration:( NSTimeInterval)tileAppearingAnimationDuration
                                       overzoomMode:( YMKOverzoomMode)overzoomMode
                                        transparent:( BOOL)transparent
                                     versionSupport:( BOOL)versionSupport;
```

## Instance methods

### init

```objectivec
- (nonnull YMKLayerOptions *)init;
```

## Properties

### active

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL active;
```

Inactive layers are not displayed on the map and do not request any tiles from TileProvider.

### nightModeAvailable

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL nightModeAvailable;
```

Indicates the availability of night mode for this layer (for example, night mode is disabled for the satellite layer). Default: true.

### cacheable

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL cacheable;
```

Determines whether tiles are cached on persistent storage or not.

### animateOnActivation

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL animateOnActivation;
```

Indicates whether layer activation/deactivation should be animated.

### tileAppearingAnimationDuration

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    NSTimeInterval tileAppearingAnimationDuration;
```

Specifies duration of tile appearing animation. Can be set to 0 to disable animation. Default: 400 ms

### overzoomMode

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKOverzoomMode overzoomMode;
```

Whether to render tiles from adjacent zoom levels in place of absent or translucent tiles.

### transparent

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL transparent;
```

Set this flag if layer is transparent, that is parts of underlying layers can be seen through it. This will disable some rendering optimizations that take advantage of layer opacity.

### versionSupport

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL versionSupport;
```

Determines if layer supports versioning
