---
title: "YMKPanoramaDirectionChangeDelegate"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaDirectionChangeDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaDirectionChangeDelegate.html"
---
# YMKPanoramaDirectionChangeDelegate

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaDirectionChangeDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaDirectionChangeDelegate <NSObject>
```

Listener to handle the change in panorama direction.

## Summary

### Instance methods

```objectivec
- (void)onPanoramaDirectionChangedWithPlayer:
    (nonnull YMKPanoramaPlayer *)player;
```

Called if the panorama direction was changed by the user or by the setDirection() method

## Instance methods

### onPanoramaDirectionChangedWithPlayer:

```objectivec
- (void)onPanoramaDirectionChangedWithPlayer:
    (nonnull YMKPanoramaPlayer *)player;
```

Called if the panorama direction was changed by the user or by the setDirection() method.

| Parameters |   |
| --- | --- |
| player | Panorama player that sent the event. |
