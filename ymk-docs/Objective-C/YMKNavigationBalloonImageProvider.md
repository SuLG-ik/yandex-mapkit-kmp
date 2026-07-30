---
title: "YMKNavigationBalloonImageProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKNavigationBalloonImageProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationBalloonImageProvider.html"
---
# YMKNavigationBalloonImageProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationBalloonImageProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKNavigationBalloonImageProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (nonnull NSArray<YMKBalloonGeometry *> *)
    geometriesForBalloonWithBalloon:(nonnull YMKBalloon *)balloon
                        scaleFactor:(float)scaleFactor
                        isNightMode:(BOOL)isNightMode;
```

returns geometry for all possible anchor placements

```objectivec
- (nonnull UIImage *)createImageWithBalloon:(nonnull YMKBalloon *)balloon
                                     anchor:(nonnull YMKBalloonAnchor *)anchor
                                scaleFactor:(float)scaleFactor
                                isNightMode:(BOOL)isNightMode;
```

## Instance methods

### geometriesForBalloonWithBalloon:scaleFactor:isNightMode:

```objectivec
- (nonnull NSArray<YMKBalloonGeometry *> *)
    geometriesForBalloonWithBalloon:(nonnull YMKBalloon *)balloon
                        scaleFactor:(float)scaleFactor
                        isNightMode:(BOOL)isNightMode;
```

returns geometry for all possible anchor placements

### createImageWithBalloon:anchor:scaleFactor:isNightMode:

```objectivec
- (nonnull UIImage *)createImageWithBalloon:(nonnull YMKBalloon *)balloon
                                     anchor:(nonnull YMKBalloonAnchor *)anchor
                                scaleFactor:(float)scaleFactor
                                isNightMode:(BOOL)isNightMode;
```
