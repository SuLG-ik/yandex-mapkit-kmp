---
title: "YMKPanoramaCompanyTapDelegate"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaCompanyTapDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaCompanyTapDelegate.html"
---
# YMKPanoramaCompanyTapDelegate

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaCompanyTapDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaCompanyTapDelegate <NSObject>
```

Listener to handle the taps on company text and icon.

## Summary

### Instance methods

```objectivec
- (void)onCompanyTapWithPlayer:(nonnull YMKPanoramaPlayer *)player
                          info:(nonnull YMKCompanyTapInfo *)info;
```

Called if the user tapped on company icon or text below it

## Instance methods

### onCompanyTapWithPlayer:info:

```objectivec
- (void)onCompanyTapWithPlayer:(nonnull YMKPanoramaPlayer *)player
                          info:(nonnull YMKCompanyTapInfo *)info;
```

Called if the user tapped on company icon or text below it.

| Parameters |   |
| --- | --- |
| player | Panorama player that sent the event. |
| info | Information about tapped company. |
