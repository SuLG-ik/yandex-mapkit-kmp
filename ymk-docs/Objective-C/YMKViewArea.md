---
title: "YMKViewArea"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKViewArea"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKViewArea.html"
---
# YMKViewArea

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKViewArea.html)

```objectivec
@interface YMKViewArea : NSObject
```

Defines the visible area.

## Summary

### Class methods

```objectivec
+ (nonnull YMKViewArea *)viewAreaWithLengthwise:( double)lengthwise
                                     transverse:( double)transverse;
```

### Properties

```objectivec
@property (nonatomic, readonly) double lengthwise;
```

The length of the view area in meters

```objectivec
@property (nonatomic, readonly) double transverse;
```

The width of the view area from center in meters

## Class methods

### viewAreaWithLengthwise:transverse:

```objectivec
+ (nonnull YMKViewArea *)viewAreaWithLengthwise:( double)lengthwise
                                     transverse:( double)transverse;
```

## Properties

### lengthwise

```objectivec
@property (nonatomic, readonly) double lengthwise;
```

The length of the view area in meters.

### transverse

```objectivec
@property (nonatomic, readonly) double transverse;
```

The width of the view area from center in meters.
