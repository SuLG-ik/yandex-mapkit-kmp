---
title: "YMKNavigationUserPlacemarkStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKNavigationUserPlacemarkStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationUserPlacemarkStyleProvider.html"
---
# YMKNavigationUserPlacemarkStyleProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationUserPlacemarkStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKNavigationUserPlacemarkStyleProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)provideStyleWithScaleFactor:(float)scaleFactor
                        isNightMode:(BOOL)isNightMode
                navigationLayerMode:(YMKNavigationLayerMode)navigationLayerMode
                              style:(nonnull YMKPlacemarkStyle *)style;
```

## Instance methods

### provideStyleWithScaleFactor:isNightMode:navigationLayerMode:style:

```objectivec
- (void)provideStyleWithScaleFactor:(float)scaleFactor
                        isNightMode:(BOOL)isNightMode
                navigationLayerMode:(YMKNavigationLayerMode)navigationLayerMode
                              style:(nonnull YMKPlacemarkStyle *)style;
```
