---
title: "YMKCameraUpdateReason"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKCameraUpdateReason"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCameraUpdateReason.html"
---
# YMKCameraUpdateReason

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCameraUpdateReason.html)

```objectivec
enum YMKCameraUpdateReason : NSUInteger {}
```

The reason of the camera update.

## Summary

### Enum cases

```objectivec
YMKCameraUpdateReasonGestures
```

User manipulation, for example: zoom, scroll, rotate, fling

```objectivec
YMKCameraUpdateReasonApplication
```

Application, by calling the map::move method

## Enum cases

### YMKCameraUpdateReasonGestures

```objectivec
YMKCameraUpdateReasonGestures
```

User manipulation, for example: zoom, scroll, rotate, fling.

### YMKCameraUpdateReasonApplication

```objectivec
YMKCameraUpdateReasonApplication
```

Application, by calling the map::move method.
