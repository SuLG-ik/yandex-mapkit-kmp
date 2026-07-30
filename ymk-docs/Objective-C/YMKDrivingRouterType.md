---
title: "YMKDrivingRouterType"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKDrivingRouterType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRouterType.html"
---
# YMKDrivingRouterType

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRouterType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKDrivingRouterType : NSUInteger {}
```

Driving router type.

## Summary

### Enum cases

```objectivec
YMKDrivingRouterTypeOnline
```

Online driving router

```objectivec
YMKDrivingRouterTypeOffline
```

Offline driving router

```objectivec
YMKDrivingRouterTypeCombined
```

Combined driving router

## Enum cases

### YMKDrivingRouterTypeOnline

```objectivec
YMKDrivingRouterTypeOnline
```

Online driving router. Always tries to use online router even if network is not available.

### YMKDrivingRouterTypeOffline

```objectivec
YMKDrivingRouterTypeOffline
```

Offline driving router. Always tries to use offline router even if network is available.

### YMKDrivingRouterTypeCombined

```objectivec
YMKDrivingRouterTypeCombined
```

Combined driving router. Decision to use online or offline router is based on internal timeout. If server manages to respond within given time, then online router result is returned. Otherwise uses offline router. Will combine online and offline router result in single session (hence the name). Timeout logic is applied on each resubmit until first response from offline router is returned to the listener. After that timeout is reduced to zero for all following resubmits.
