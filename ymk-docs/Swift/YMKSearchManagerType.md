---
title: "YMKSearchManagerType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSearchManagerType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchManagerType.html"
---
# YMKSearchManagerType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchManagerType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKSearchManagerType : UInt, @unchecked Sendable
```

Search manager type. Describes difference in online/offline search handling.

## Summary

### Enum cases

```swift
case online = 0
```

Online search manager

```swift
case offline = 1
```

Offline search manager

```swift
case combined = 2
```

Combined search manager

## Enum cases

### online

```swift
case online = 0
```

Online search manager. Always tries to use online search even if network is not available.

### offline

```swift
case offline = 1
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Offline search manager. Always tries to use offline search even if network is available.

### combined

```swift
case combined = 2
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Combined search manager. Decision to use online or offline search is based on internal timeout. If server manages to respond within given time, then online search result is returned. Otherwise uses offline search. Will combine online and offline search result in single session (hence the name). Timeout logic is applied on each resubmit until first response from offline search is returned to the listener. After that timeout is reduced to zero for all following resubmits.
