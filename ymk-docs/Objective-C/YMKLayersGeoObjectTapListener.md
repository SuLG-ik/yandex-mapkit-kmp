---
title: "YMKLayersGeoObjectTapListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKLayersGeoObjectTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLayersGeoObjectTapListener.html"
---
# YMKLayersGeoObjectTapListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLayersGeoObjectTapListener.html)

```objectivec
@protocol YMKLayersGeoObjectTapListener <NSObject>
```

Retrieves the brief geoObject info when an object is tapped.

## Summary

### Instance methods

```objectivec
- (BOOL)onObjectTapWithEvent:(nonnull YMKGeoObjectTapEvent *)event;
```

Listener that retrieves brief geoObject info for the tapped object

## Instance methods

### onObjectTapWithEvent:

```objectivec
- (BOOL)onObjectTapWithEvent:(nonnull YMKGeoObjectTapEvent *)event;
```

Listener that retrieves brief geoObject info for the tapped object. Returns false if the event wasn't handled. The event will be propagated to the map.
