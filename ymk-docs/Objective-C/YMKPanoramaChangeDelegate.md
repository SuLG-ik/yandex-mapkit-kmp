---
title: "YMKPanoramaChangeDelegate"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaChangeDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaChangeDelegate.html"
---
# YMKPanoramaChangeDelegate

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaChangeDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaChangeDelegate <NSObject>
```

Listener to handle the panorama being opened or changed.

## Summary

### Instance methods

```objectivec
- (void)onPanoramaChangedWithPlayer:(nonnull YMKPanoramaPlayer *)player;
```

Called if the panorama was opened or changed by the user

## Instance methods

### onPanoramaChangedWithPlayer:

```objectivec
- (void)onPanoramaChangedWithPlayer:(nonnull YMKPanoramaPlayer *)player;
```

Called if the panorama was opened or changed by the user. You can get the panoramaId by using the panoramaId() method.

| Parameters |   |
| --- | --- |
| player | Panorama player that sent the event. |
