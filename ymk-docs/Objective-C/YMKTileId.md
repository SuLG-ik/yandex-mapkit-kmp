---
title: "YMKTileId"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTileId"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTileId.html"
---
# YMKTileId

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTileId.html)

```objectivec
@interface YMKTileId : NSObject
```

The ID of a tile on the map.

## Summary

### Class methods

```objectivec
+ (nonnull YMKTileId *)tileIdWithX:( NSUInteger)x
                                 y:( NSUInteger)y
                                 z:( NSUInteger)z;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger x;
```

The number of the tile horizontally

```objectivec
@property (nonatomic, readonly) NSUInteger y;
```

The number of the tile vertically

```objectivec
@property (nonatomic, readonly) NSUInteger z;
```

The number of columns and rows to split the map into

## Class methods

### tileIdWithX:y:z:

```objectivec
+ (nonnull YMKTileId *)tileIdWithX:( NSUInteger)x
                                 y:( NSUInteger)y
                                 z:( NSUInteger)z;
```

## Properties

### x

```objectivec
@property (nonatomic, readonly) NSUInteger x;
```

The number of the tile horizontally.

### y

```objectivec
@property (nonatomic, readonly) NSUInteger y;
```

The number of the tile vertically.

### z

```objectivec
@property (nonatomic, readonly) NSUInteger z;
```

The number of columns and rows to split the map into.
