---
title: "YMKModelStyleUnitType"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKModelStyleUnitType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKModelStyleUnitType.html"
---
# YMKModelStyleUnitType

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKModelStyleUnitType.html)

```objectivec
enum YMKModelStyleUnitType : NSUInteger {}
```

## Summary

### Enum cases

```objectivec
YMKModelStyleUnitTypeUnit
```

The model is given in units

```objectivec
YMKModelStyleUnitTypeNormalized
```

Scale model proportionally to fit into 1x1x1 box

```objectivec
YMKModelStyleUnitTypeMeter
```

The model is given in meters

## Enum cases

### YMKModelStyleUnitTypeUnit

```objectivec
YMKModelStyleUnitTypeUnit
```

The model is given in units. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### YMKModelStyleUnitTypeNormalized

```objectivec
YMKModelStyleUnitTypeNormalized
```

Scale model proportionally to fit into 1x1x1 box.

> [!CAUTION] Внимание
> Use UnitType.Unit instead.

### YMKModelStyleUnitTypeMeter

```objectivec
YMKModelStyleUnitTypeMeter
```

The model is given in meters.
