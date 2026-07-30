---
title: "YMKManeuverStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKManeuverStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKManeuverStyle.html"
---
# YMKManeuverStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKManeuverStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKManeuverStyle : NSObject
```

The style that is used to display maneuvers on the map.

## Summary

### Class methods

```objectivec
+ (nonnull YMKManeuverStyle *)maneuverStyleWithArrow:(nonnull YMKArrowManeuverStyle *)arrow;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKArrowManeuverStyle *arrow;
```

Arrow maneuver style

## Class methods

### maneuverStyleWithArrow:

```objectivec
+ (nonnull YMKManeuverStyle *)maneuverStyleWithArrow:(nonnull YMKArrowManeuverStyle *)arrow;
```

## Properties

### arrow

```objectivec
@property (nonatomic, readonly, nonnull) YMKArrowManeuverStyle *arrow;
```

Arrow maneuver style.
