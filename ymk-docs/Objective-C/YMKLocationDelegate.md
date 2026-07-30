---
title: "YMKLocationDelegate"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKLocationDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationDelegate.html"
---
# YMKLocationDelegate

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationDelegate.html)

```objectivec
@protocol YMKLocationDelegate <NSObject>
```

The listener that handles the updates to the device location.

## Summary

### Instance methods

```objectivec
- (void)onLocationUpdatedWithLocation:(nonnull YMKLocation *)location;
```

Handle location update information

```objectivec
- (void)onLocationStatusUpdatedWithStatus:(YMKLocationStatus)status;
```

Handle change in location provider status

## Instance methods

### onLocationUpdatedWithLocation:

```objectivec
- (void)onLocationUpdatedWithLocation:(nonnull YMKLocation *)location;
```

Handle location update information.

### onLocationStatusUpdatedWithStatus:

```objectivec
- (void)onLocationStatusUpdatedWithStatus:(YMKLocationStatus)status;
```

Handle change in location provider status.
