---
title: "YMKAutomotiveRouteOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAutomotiveRouteOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAutomotiveRouteOptions.html"
---
# YMKAutomotiveRouteOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAutomotiveRouteOptions.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKAutomotiveRouteOptions : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKAutomotiveRouteOptions *)routeOptionsWithInitialAzimuth:(nullable NSNumber *)initialAzimuth
                                                          routesCount:(nullable NSNumber *)routesCount;
```

### Properties

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *initialAzimuth;
```

Optional field, can be nil

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *routesCount;
```

Optional field, can be nil

## Class methods

### routeOptionsWithInitialAzimuth:routesCount:

```objectivec
+ (nonnull YMKAutomotiveRouteOptions *)routeOptionsWithInitialAzimuth:(nullable NSNumber *)initialAzimuth
                                                          routesCount:(nullable NSNumber *)routesCount;
```

## Properties

### initialAzimuth

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *initialAzimuth;
```

Optional field, can be nil.

### routesCount

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *routesCount;
```

Optional field, can be nil.
