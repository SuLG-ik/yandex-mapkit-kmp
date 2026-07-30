---
title: "YMKSpan"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSpan"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpan.html"
---
# YMKSpan

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpan.html)

```objectivec
@interface YMKSpan : NSObject
```

The panorama field of view.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSpan *)spanWithHorizontalAngle:( double)horizontalAngle
                               verticalAngle:( double)verticalAngle;
```

### Properties

```objectivec
@property (nonatomic, readonly) double horizontalAngle;
```

The horizontal view angle

```objectivec
@property (nonatomic, readonly) double verticalAngle;
```

The vertical view angle

## Class methods

### spanWithHorizontalAngle:verticalAngle:

```objectivec
+ (nonnull YMKSpan *)spanWithHorizontalAngle:( double)horizontalAngle
                               verticalAngle:( double)verticalAngle;
```

## Properties

### horizontalAngle

```objectivec
@property (nonatomic, readonly) double horizontalAngle;
```

The horizontal view angle.

### verticalAngle

```objectivec
@property (nonatomic, readonly) double verticalAngle;
```

The vertical view angle.
