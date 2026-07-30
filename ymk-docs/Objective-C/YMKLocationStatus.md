---
title: "YMKLocationStatus"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKLocationStatus"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationStatus.html"
---
# YMKLocationStatus

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationStatus.html)

```objectivec
enum YMKLocationStatus : NSUInteger {}
```

Defines if the location is available or not.

## Summary

### Enum cases

```objectivec
YMKLocationStatusNotAvailable
```

Location is not available

```objectivec
YMKLocationStatusAvailable
```

Location is available

```objectivec
YMKLocationStatusReset
```

Global location manager has been changed

## Enum cases

### YMKLocationStatusNotAvailable

```objectivec
YMKLocationStatusNotAvailable
```

Location is not available.

### YMKLocationStatusAvailable

```objectivec
YMKLocationStatusAvailable
```

Location is available.

### YMKLocationStatusReset

```objectivec
YMKLocationStatusReset
```

Global location manager has been changed. Clients need to reset any state and checks related to location.
