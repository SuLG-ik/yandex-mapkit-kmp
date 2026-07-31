---
title: "YMKPanoramaIconImageFactory"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaIconImageFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaIconImageFactory.html"
---
# YMKPanoramaIconImageFactory

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaIconImageFactory.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaIconImageFactory <NSObject>
```

## Summary

### Instance methods

```objectivec
- (nullable UIImage *)loadWithIconId:(nonnull NSString *)iconId
                               scale:(double)scale;
```

Called once the icon is visible in view frustum If the icon can't be loaded, empty value must be returned

## Instance methods

### loadWithIconId:scale:

```objectivec
- (nullable UIImage *)loadWithIconId:(nonnull NSString *)iconId
                               scale:(double)scale;
```

Called once the icon is visible in view frustum If the icon can't be loaded, empty value must be returned. Scale - scale factor. mdpi: 1.0 , xhdpi: 2.0, etc. If you have image resources for different pixel densities, just ignore this parameter.

This method will be called on a background thread.
