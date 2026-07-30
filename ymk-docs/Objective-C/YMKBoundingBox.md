---
title: "YMKBoundingBox"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBoundingBox"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBoundingBox.html"
---
# YMKBoundingBox

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBoundingBox.html)

```objectivec
@interface YMKBoundingBox : NSObject
```

A rectangular box around the object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBoundingBox *)boundingBoxWithSouthWest:(nonnull YMKPoint *)southWest
                                           northEast:(nonnull YMKPoint *)northEast;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *southWest;
```

The coordinates of the southwest corner of the box

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *northEast;
```

The coordinates of the northeast corner of the box

## Class methods

### boundingBoxWithSouthWest:northEast:

```objectivec
+ (nonnull YMKBoundingBox *)boundingBoxWithSouthWest:(nonnull YMKPoint *)southWest
                                           northEast:(nonnull YMKPoint *)northEast;
```

## Properties

### southWest

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *southWest;
```

The coordinates of the southwest corner of the box.

### northEast

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *northEast;
```

The coordinates of the northeast corner of the box.
