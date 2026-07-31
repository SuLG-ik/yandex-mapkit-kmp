---
title: "YMKClusterListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKClusterListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKClusterListener.html"
---
# YMKClusterListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKClusterListener.html)

```objectivec
@protocol YMKClusterListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)onClusterAddedWithCluster:(nonnull YMKCluster *)cluster;
```

This method is called when a new cluster is added to the collection and should customize cluster appearance based on its content

## Instance methods

### onClusterAddedWithCluster:

```objectivec
- (void)onClusterAddedWithCluster:(nonnull YMKCluster *)cluster;
```

This method is called when a new cluster is added to the collection and should customize cluster appearance based on its content.
