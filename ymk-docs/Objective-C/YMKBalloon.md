---
title: "YMKBalloon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloon.html"
---
# YMKBalloon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKBalloon : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKBalloon *)balloonWithManoeuvre:(nonnull YMKManoeuvreBalloon *)manoeuvre;
```

```objectivec
+ (nonnull YMKBalloon *)balloonWithManoeuvreWithLaneSign:(nonnull YMKManoeuvreWithLaneSignBalloon *)manoeuvreWithLaneSign;
```

```objectivec
+ (nonnull YMKBalloon *)balloonWithLaneSign:(nonnull YMKLaneSignBalloon *)laneSign;
```

```objectivec
+ (nonnull YMKBalloon *)balloonWithRouteSummary:(nonnull YMKRouteSummaryBalloon *)routeSummary;
```

```objectivec
+ (nonnull YMKBalloon *)balloonWithAlternative:(nonnull YMKAlternativeBalloon *)alternative;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKManoeuvreBalloon *manoeuvre
```

```objectivec
@property (nonatomic, readonly, nullable) YMKManoeuvreWithLaneSignBalloon *manoeuvreWithLaneSign
```

```objectivec
@property (nonatomic, readonly, nullable) YMKLaneSignBalloon *laneSign
```

```objectivec
@property (nonatomic, readonly, nullable) YMKRouteSummaryBalloon *routeSummary
```

```objectivec
@property (nonatomic, readonly, nullable) YMKAlternativeBalloon *alternative
```

## Class methods

### balloonWithManoeuvre:

```objectivec
+ (nonnull YMKBalloon *)balloonWithManoeuvre:(nonnull YMKManoeuvreBalloon *)manoeuvre;
```

### balloonWithManoeuvreWithLaneSign:

```objectivec
+ (nonnull YMKBalloon *)balloonWithManoeuvreWithLaneSign:(nonnull YMKManoeuvreWithLaneSignBalloon *)manoeuvreWithLaneSign;
```

### balloonWithLaneSign:

```objectivec
+ (nonnull YMKBalloon *)balloonWithLaneSign:(nonnull YMKLaneSignBalloon *)laneSign;
```

### balloonWithRouteSummary:

```objectivec
+ (nonnull YMKBalloon *)balloonWithRouteSummary:(nonnull YMKRouteSummaryBalloon *)routeSummary;
```

### balloonWithAlternative:

```objectivec
+ (nonnull YMKBalloon *)balloonWithAlternative:(nonnull YMKAlternativeBalloon *)alternative;
```

## Properties

### manoeuvre

```objectivec
@property (nonatomic, readonly, nullable) YMKManoeuvreBalloon *manoeuvre
```

### manoeuvreWithLaneSign

```objectivec
@property (nonatomic, readonly, nullable) YMKManoeuvreWithLaneSignBalloon *manoeuvreWithLaneSign
```

### laneSign

```objectivec
@property (nonatomic, readonly, nullable) YMKLaneSignBalloon *laneSign
```

### routeSummary

```objectivec
@property (nonatomic, readonly, nullable) YMKRouteSummaryBalloon *routeSummary
```

### alternative

```objectivec
@property (nonatomic, readonly, nullable) YMKAlternativeBalloon *alternative
```
