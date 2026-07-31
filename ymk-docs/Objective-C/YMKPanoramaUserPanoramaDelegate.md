---
title: "YMKPanoramaUserPanoramaDelegate"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaUserPanoramaDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaUserPanoramaDelegate.html"
---
# YMKPanoramaUserPanoramaDelegate

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaUserPanoramaDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaUserPanoramaDelegate <NSObject>
```

Listener to handle event from user panoramas

## Summary

### Instance methods

```objectivec
- (void)onPanoramaChangeIntentWithPanoramaId:(nonnull NSString *)panoramaId;
```

Called when user presses to the arrow or icon connection

## Instance methods

### onPanoramaChangeIntentWithPanoramaId:

```objectivec
- (void)onPanoramaChangeIntentWithPanoramaId:(nonnull NSString *)panoramaId;
```

Called when user presses to the arrow or icon connection. It's a good place to handle panoramaId and call openPanorama...

| Parameters |   |
| --- | --- |
| panoramaId | The clicked connection panoramaId |
