---
title: "YMKSearchPanorama"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchPanorama"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPanorama.html"
---
# YMKSearchPanorama

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPanorama.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchPanorama : NSObject
```

Panorama info.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchPanorama *)panoramaWithId:(nonnull NSString *)id
                                    direction:(nonnull YMKDirection *)direction
                                         span:(nonnull YMKSpan *)span
                                        point:(nonnull YMKPoint *)point;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Machine readable panorama identifier

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *direction;
```

Direction of the panorama center

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpan *span;
```

H-Span and V-Span hints for the panorama player

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

Panorama point

## Class methods

### panoramaWithId:direction:span:point:

```objectivec
+ (nonnull YMKSearchPanorama *)panoramaWithId:(nonnull NSString *)id
                                    direction:(nonnull YMKDirection *)direction
                                         span:(nonnull YMKSpan *)span
                                        point:(nonnull YMKPoint *)point;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Machine readable panorama identifier.

### direction

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *direction;
```

Direction of the panorama center.

### span

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpan *span;
```

H-Span and V-Span hints for the panorama player.

### point

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

Panorama point.
