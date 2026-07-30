---
title: "YMKUserLocationTapListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKUserLocationTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserLocationTapListener.html"
---
# YMKUserLocationTapListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserLocationTapListener.html)

```objectivec
@protocol YMKUserLocationTapListener <NSObject>
```

Triggered by a tap on the user location icon.

## Summary

### Instance methods

```objectivec
- (void)onUserLocationObjectTapWithPoint:(nonnull YMKPoint *)point;
```

Called when the user taps a location object

## Instance methods

### onUserLocationObjectTapWithPoint:

```objectivec
- (void)onUserLocationObjectTapWithPoint:(nonnull YMKPoint *)point;
```

Called when the user taps a location object.
