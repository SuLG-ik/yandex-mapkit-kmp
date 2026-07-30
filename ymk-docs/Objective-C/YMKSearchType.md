---
title: "YMKSearchType"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSearchType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchType.html"
---
# YMKSearchType

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSearchType : NSUInteger {}
```

Bitmask for requested search types.

## Summary

### Enum cases

```objectivec
YMKSearchTypeNone = 0
```

Default value: all types requested

```objectivec
YMKSearchTypeGeo = 1
```

Toponyms

```objectivec
YMKSearchTypeBiz = 1 << 1
```

Companies

## Enum cases

### YMKSearchTypeNone

```objectivec
YMKSearchTypeNone = 0
```

Default value: all types requested.

### YMKSearchTypeGeo

```objectivec
YMKSearchTypeGeo = 1
```

Toponyms.

### YMKSearchTypeBiz

```objectivec
YMKSearchTypeBiz = 1 << 1
```

Companies.
