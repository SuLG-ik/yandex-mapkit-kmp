---
title: "YMKClusterTapListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKClusterTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKClusterTapListener.html"
---
# YMKClusterTapListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKClusterTapListener.html)

```objectivec
@protocol YMKClusterTapListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (BOOL)onClusterTapWithCluster:(nonnull YMKCluster *)cluster;
```

Called when cluster is tapped

## Instance methods

### onClusterTapWithCluster:

```objectivec
- (BOOL)onClusterTapWithCluster:(nonnull YMKCluster *)cluster;
```

Called when cluster is tapped. Return true if the event was handled. Otherwise it will be passed to underlying objects.
