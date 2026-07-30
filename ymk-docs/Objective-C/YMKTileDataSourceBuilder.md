---
title: "YMKTileDataSourceBuilder"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTileDataSourceBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTileDataSourceBuilder.html"
---
# YMKTileDataSourceBuilder

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTileDataSourceBuilder.html)

```objectivec
@interface YMKTileDataSourceBuilder : YMKBaseDataSourceBuilder
```

## Summary

### Instance methods

```objectivec
- (void)setTileUrlProviderWithUrlProvider:
    (nonnull id<YMKTilesUrlProvider>)urlProvider;
```

The class does not retain the object in the 'urlProvider' parameter

```objectivec
- (void)setTileProviderWithTileProvider:
    (nonnull id<YMKTileProvider>)tileProvider;
```

The class does not retain the object in the 'tileProvider' parameter

```objectivec
- (void)setProjectionWithProjection:(nonnull YMKProjection *)projection;
```

```objectivec
- (void)setZoomRangesWithZoomRanges:
    (nonnull NSArray<YMKZoomRange *> *)zoomRanges;
```

```objectivec
- (void)setTileFormatWithFormat:(YMKTileFormat)format;
```

## Instance methods

### setTileUrlProviderWithUrlProvider:

```objectivec
- (void)setTileUrlProviderWithUrlProvider:
    (nonnull id<YMKTilesUrlProvider>)urlProvider;
```

The class does not retain the object in the 'urlProvider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setTileProviderWithTileProvider:

```objectivec
- (void)setTileProviderWithTileProvider:
    (nonnull id<YMKTileProvider>)tileProvider;
```

The class does not retain the object in the 'tileProvider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setProjectionWithProjection:

```objectivec
- (void)setProjectionWithProjection:(nonnull YMKProjection *)projection;
```

### setZoomRangesWithZoomRanges:

```objectivec
- (void)setZoomRangesWithZoomRanges:
    (nonnull NSArray<YMKZoomRange *> *)zoomRanges;
```

### setTileFormatWithFormat:

```objectivec
- (void)setTileFormatWithFormat:(YMKTileFormat)format;
```
