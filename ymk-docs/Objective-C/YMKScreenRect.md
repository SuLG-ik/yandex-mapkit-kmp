---
title: "YMKScreenRect"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKScreenRect"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKScreenRect.html"
---
# YMKScreenRect

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKScreenRect.html)

```objectivec
@interface YMKScreenRect : NSObject
```

A rectangle on the device screen.

## Summary

### Class methods

```objectivec
+ (nonnull YMKScreenRect *)screenRectWithTopLeft:(nonnull YMKScreenPoint *)topLeft
                                     bottomRight:(nonnull YMKScreenPoint *)bottomRight;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKScreenPoint *topLeft;
```

The position of the top left corner of the rectangle

```objectivec
@property (nonatomic, readonly, nonnull) YMKScreenPoint *bottomRight;
```

The position of the bottom right corner of the rectangle

## Class methods

### screenRectWithTopLeft:bottomRight:

```objectivec
+ (nonnull YMKScreenRect *)screenRectWithTopLeft:(nonnull YMKScreenPoint *)topLeft
                                     bottomRight:(nonnull YMKScreenPoint *)bottomRight;
```

## Properties

### topLeft

```objectivec
@property (nonatomic, readonly, nonnull) YMKScreenPoint *topLeft;
```

The position of the top left corner of the rectangle.

### bottomRight

```objectivec
@property (nonatomic, readonly, nonnull) YMKScreenPoint *bottomRight;
```

The position of the bottom right corner of the rectangle.
