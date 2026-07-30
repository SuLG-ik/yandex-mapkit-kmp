---
title: "YMKTileProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKTileProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTileProvider.html"
---
# YMKTileProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTileProvider.html)

```objectivec
@protocol YMKTileProvider <NSObject>
```

Generates tiles.

## Summary

### Instance methods

```objectivec
- (nonnull YMKRawTile *)
    loadWithTileId:(nonnull YMKTileId *)tileId
           version:(nonnull YMKVersion *)version
          features:(nonnull NSDictionary<NSString *, NSString *> *)features
              etag:(nonnull NSString *)etag;
```

Generates tile

## Instance methods

### loadWithTileId:version:features:etag:

```objectivec
- (nonnull YMKRawTile *)
    loadWithTileId:(nonnull YMKTileId *)tileId
           version:(nonnull YMKVersion *)version
          features:(nonnull NSDictionary<NSString *, NSString *> *)features
              etag:(nonnull NSString *)etag;
```

Generates tile.

This method will be called on a background thread.
