---
title: "YMKMasstransitInclineType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKMasstransitInclineType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitInclineType.html"
---
# YMKMasstransitInclineType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitInclineType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKMasstransitInclineType : UInt, @unchecked Sendable
```

Rough estimate of user experience on a specific section of a fitness route

## Summary

### Enum cases

```swift
case extremeAscent = 0
```

Very quick elevation gain, difficult for any non-athlete

```swift
case moderateAscent = 1
```

Moderate elevation gain, could be difficult for some people

```swift
case plateau = 2
```

No meaningful elevation gain or loss,

```swift
case moderateDescent = 3
```

Moderate elevation loss

```swift
case extremeDescent = 4
```

Very quick elevation loss, could be difficult or dangerous

## Enum cases

### extremeAscent

```swift
case extremeAscent = 0
```

Very quick elevation gain, difficult for any non-athlete

### moderateAscent

```swift
case moderateAscent = 1
```

Moderate elevation gain, could be difficult for some people

### plateau

```swift
case plateau = 2
```

No meaningful elevation gain or loss,

### moderateDescent

```swift
case moderateDescent = 3
```

Moderate elevation loss

### extremeDescent

```swift
case extremeDescent = 4
```

Very quick elevation loss, could be difficult or dangerous
