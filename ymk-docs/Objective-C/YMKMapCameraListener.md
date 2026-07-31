---
title: "YMKMapCameraListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMapCameraListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapCameraListener.html"
---
# YMKMapCameraListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapCameraListener.html)

```objectivec
@protocol YMKMapCameraListener <NSObject>
```

Listens for updates to the camera position.

## Summary

### Instance methods

```objectivec
- (void)onCameraPositionChangedWithMap:(nonnull YMKMap *)map
                        cameraPosition:
                            (nonnull YMKCameraPosition *)cameraPosition
                    cameraUpdateReason:(YMKCameraUpdateReason)cameraUpdateReason
                              finished:(BOOL)finished;
```

Triggered when the camera position changed

## Instance methods

### onCameraPositionChangedWithMap:cameraPosition:cameraUpdateReason:finished:

```objectivec
- (void)onCameraPositionChangedWithMap:(nonnull YMKMap *)map
                        cameraPosition:
                            (nonnull YMKCameraPosition *)cameraPosition
                    cameraUpdateReason:(YMKCameraUpdateReason)cameraUpdateReason
                              finished:(BOOL)finished;
```

Triggered when the camera position changed.

| Parameters |   |
| --- | --- |
| map | Event source. |
| cameraPosition | Current camera position. |
| cameraUpdateReason | The reason of camera update. |
| finished | True if the camera finished moving, false otherwise. If a movement is cancelled then cameraUpdateReason represents initiator of cancellation. |
