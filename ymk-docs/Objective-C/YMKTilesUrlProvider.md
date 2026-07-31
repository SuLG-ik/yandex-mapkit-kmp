---
title: "YMKTilesUrlProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKTilesUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTilesUrlProvider.html"
---
# YMKTilesUrlProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTilesUrlProvider.html)

```objectivec
@protocol YMKTilesUrlProvider <NSObject>
```

Provides a formatted URL.

## Summary

### Instance methods

```objectivec
- (nonnull NSString *)
    formatUrlWithTileId:(nonnull YMKTileId *)tileId
                version:(nonnull YMKVersion *)version
               features:
                   (nonnull NSDictionary<NSString *, NSString *> *)features;
```

Create s a URL based on the tile ID, version, and features

## Instance methods

### formatUrlWithTileId:version:features:

```objectivec
- (nonnull NSString *)
    formatUrlWithTileId:(nonnull YMKTileId *)tileId
                version:(nonnull YMKVersion *)version
               features:
                   (nonnull NSDictionary<NSString *, NSString *> *)features;
```

Create s a URL based on the tile ID, version, and features. Features are some layer customisations. Tiles with appropriate features are prioretized over tiles without them when loading.

This method may be called on any thread. Its implementation must be thread-safe.
