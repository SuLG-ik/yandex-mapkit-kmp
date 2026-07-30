---
title: "YMKPanoramaIconMarker"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaIconMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaIconMarker.html"
---
# YMKPanoramaIconMarker

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaIconMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaIconMarker : NSObject
```

Icon marker struct

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaIconMarker *)iconMarkerWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                          iconId:(nonnull NSString *)iconId;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees

```objectivec
@property (nonatomic, readonly, nonnull) NSString *iconId;
```

The marker iconId

## Class methods

### iconMarkerWithAngularPosition:iconId:

```objectivec
+ (nonnull YMKPanoramaIconMarker *)iconMarkerWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                          iconId:(nonnull NSString *)iconId;
```

## Properties

### angularPosition

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees. (bearing, tilt) (0, 0) - (north, horizon)

### iconId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *iconId;
```

The marker iconId. The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider
