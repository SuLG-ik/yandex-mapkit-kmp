---
title: "YMKTileDataSource"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTileDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTileDataSource.html"
---
# YMKTileDataSource

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTileDataSource.html)

```objectivec
@interface YMKTileDataSource : YMKBaseDataSource
```

## Summary

### Instance methods

```objectivec
- (void)invalidateWithVersion:(nonnull NSString *)version;
```

Invalidates data source and reloads all tiles

## Instance methods

### invalidateWithVersion:

```objectivec
- (void)invalidateWithVersion:(nonnull NSString *)version;
```

Invalidates data source and reloads all tiles. Must not be called if DataSource does not support versioning: LayerOptions.versionSupport = false;

This method may be called on any thread. Its implementation must be thread-safe.
