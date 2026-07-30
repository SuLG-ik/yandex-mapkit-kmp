---
title: "YMKPanoramaIconUrlProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaIconUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaIconUrlProvider.html"
---
# YMKPanoramaIconUrlProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaIconUrlProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaIconUrlProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (nonnull NSString *)formatUrlWithIconId:(nonnull NSString *)iconId
                                    scale:(double)scale;
```

Called once the icon is visible in view frustum Scale - scale factor

## Instance methods

### formatUrlWithIconId:scale:

```objectivec
- (nonnull NSString *)formatUrlWithIconId:(nonnull NSString *)iconId
                                    scale:(double)scale;
```

Called once the icon is visible in view frustum Scale - scale factor. mdpi: 1.0 , xhdpi: 2.0 etc.

This method may be called on any thread. Its implementation must be thread-safe.
