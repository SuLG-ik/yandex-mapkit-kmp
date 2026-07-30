---
title: "YMKAnimation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAnimation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAnimation.html"
---
# YMKAnimation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAnimation.html)

```objectivec
@interface YMKAnimation : NSObject
```

The animation that is used to switch between states.

## Summary

### Class methods

```objectivec
+ (nonnull YMKAnimation *)animationWithType:( YMKAnimationType)type
                                   duration:( float)duration;
```

### Instance methods

```objectivec
- (nonnull YMKAnimation *)init;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKAnimationType type;
```

Animation type

```objectivec
@property (nonatomic, readonly) float duration;
```

Animation duration, in seconds

## Class methods

### animationWithType:duration:

```objectivec
+ (nonnull YMKAnimation *)animationWithType:( YMKAnimationType)type
                                   duration:( float)duration;
```

## Instance methods

### init

```objectivec
- (nonnull YMKAnimation *)init;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly) YMKAnimationType type;
```

Animation type.

### duration

```objectivec
@property (nonatomic, readonly) float duration;
```

Animation duration, in seconds.
