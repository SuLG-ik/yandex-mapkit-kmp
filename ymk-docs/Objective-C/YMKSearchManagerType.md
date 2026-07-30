---
title: "YMKSearchManagerType"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSearchManagerType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchManagerType.html"
---
# YMKSearchManagerType

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchManagerType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSearchManagerType : NSUInteger {}
```

Search manager type. Describes difference in online/offline search handling.

## Summary

### Enum cases

```objectivec
YMKSearchManagerTypeOnline
```

Online search manager

```objectivec
YMKSearchManagerTypeOffline
```

Offline search manager

```objectivec
YMKSearchManagerTypeCombined
```

Combined search manager

## Enum cases

### YMKSearchManagerTypeOnline

```objectivec
YMKSearchManagerTypeOnline
```

Online search manager. Always tries to use online search even if network is not available.

### YMKSearchManagerTypeOffline

```objectivec
YMKSearchManagerTypeOffline
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Offline search manager. Always tries to use offline search even if network is available.

### YMKSearchManagerTypeCombined

```objectivec
YMKSearchManagerTypeCombined
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Combined search manager. Decision to use online or offline search is based on internal timeout. If server manages to respond within given time, then online search result is returned. Otherwise uses offline search. Will combine online and offline search result in single session (hence the name). Timeout logic is applied on each resubmit until first response from offline search is returned to the listener. After that timeout is reduced to zero for all following resubmits.
