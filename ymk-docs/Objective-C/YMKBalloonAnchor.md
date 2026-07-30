---
title: "YMKBalloonAnchor"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBalloonAnchor"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloonAnchor.html"
---
# YMKBalloonAnchor

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloonAnchor.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKBalloonAnchor : NSObject
```

BalloonAnchor represents where balloon image has a leg

## Summary

### Class methods

```objectivec
+ (nonnull YMKBalloonAnchor *)balloonAnchorWithVertical:( YMKVerticalPosition)vertical
                                             horizontal:( YMKHorizontalPosition)horizontal;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKVerticalPosition vertical;
```

```objectivec
@property (nonatomic, readonly) YMKHorizontalPosition horizontal;
```

## Class methods

### balloonAnchorWithVertical:horizontal:

```objectivec
+ (nonnull YMKBalloonAnchor *)balloonAnchorWithVertical:( YMKVerticalPosition)vertical
                                             horizontal:( YMKHorizontalPosition)horizontal;
```

## Properties

### vertical

```objectivec
@property (nonatomic, readonly) YMKVerticalPosition vertical;
```

### horizontal

```objectivec
@property (nonatomic, readonly) YMKHorizontalPosition horizontal;
```
