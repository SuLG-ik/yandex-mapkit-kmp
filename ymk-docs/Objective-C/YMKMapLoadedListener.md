---
title: "YMKMapLoadedListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMapLoadedListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapLoadedListener.html"
---
# YMKMapLoadedListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapLoadedListener.html)

```objectivec
@protocol YMKMapLoadedListener <NSObject>
```

Listener interface for when the map has finished loading. This occurs after all tiles required to render the map have been fetched, and are ready to be rendered. This event will not fire if the map never loads due to connectivity issues, or if the map is continuously changing and never completes loading due to the user constantly interacting with the map.

## Summary

### Instance methods

```objectivec
- (void)onMapLoadedWithStatistics:(nonnull YMKMapLoadStatistics *)statistics;
```

Called after the map has finished loading all visible tiles

## Instance methods

### onMapLoadedWithStatistics:

```objectivec
- (void)onMapLoadedWithStatistics:(nonnull YMKMapLoadStatistics *)statistics;
```

Called after the map has finished loading all visible tiles. This will only be called once. You must set another listener if you want to be notified again.
