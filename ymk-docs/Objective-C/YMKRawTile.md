---
title: "YMKRawTile"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRawTile"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRawTile.html"
---
# YMKRawTile

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRawTile.html)

```objectivec
@interface YMKRawTile : NSObject
```

A raw tile that can be displayed on the map.

## Summary

### Class methods

```objectivec
+ (nonnull YMKRawTile *)rawTileWithVersion:(nonnull YMKVersion *)version
                                  features:(nonnull NSDictionary<NSString *, NSString *> *)features
                                      etag:(nonnull NSString *)etag
                                  useCache:( YMKRawTileUseCache)useCache
                                     state:( YMKRawTileState)state
                                   rawData:(nonnull NSData *)rawData;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKVersion *version;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, NSString *> *features;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSString *etag;
```

```objectivec
@property (nonatomic, readonly) YMKRawTileUseCache useCache;
```

```objectivec
@property (nonatomic, readonly) YMKRawTileState state;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSData *rawData;
```

## Class methods

### rawTileWithVersion:features:etag:useCache:state:rawData:

```objectivec
+ (nonnull YMKRawTile *)rawTileWithVersion:(nonnull YMKVersion *)version
                                  features:(nonnull NSDictionary<NSString *, NSString *> *)features
                                      etag:(nonnull NSString *)etag
                                  useCache:( YMKRawTileUseCache)useCache
                                     state:( YMKRawTileState)state
                                   rawData:(nonnull NSData *)rawData;
```

## Properties

### version

```objectivec
@property (nonatomic, readonly, nonnull) YMKVersion *version;
```

### features

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, NSString *> *features;
```

### etag

```objectivec
@property (nonatomic, readonly, nonnull) NSString *etag;
```

### useCache

```objectivec
@property (nonatomic, readonly) YMKRawTileUseCache useCache;
```

### state

```objectivec
@property (nonatomic, readonly) YMKRawTileState state;
```

### rawData

```objectivec
@property (nonatomic, readonly, nonnull) NSData *rawData;
```
