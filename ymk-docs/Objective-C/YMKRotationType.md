---
title: "YMKRotationType"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKRotationType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRotationType.html"
---
# YMKRotationType

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRotationType.html)

```objectivec
enum YMKRotationType : NSUInteger {}
```

The way rotation is handled.

## Summary

### Enum cases

```objectivec
YMKRotationTypeNoRotation
```

Ignores the placemark direction; stable in screen space

```objectivec
YMKRotationTypeRotate
```

Follows the placemark direction

## Enum cases

### YMKRotationTypeNoRotation

```objectivec
YMKRotationTypeNoRotation
```

Ignores the placemark direction; stable in screen space.

### YMKRotationTypeRotate

```objectivec
YMKRotationTypeRotate
```

Follows the placemark direction. For non-flat placemarks, the direction vector is projected onto the screen plane.
