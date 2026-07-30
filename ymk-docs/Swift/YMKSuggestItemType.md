---
title: "YMKSuggestItemType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSuggestItemType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestItemType.html"
---
# YMKSuggestItemType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestItemType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKSuggestItemType : UInt, @unchecked Sendable
```

Suggest item type.

## Summary

### Enum cases

```swift
case unknown = 0
```

For backward compatibility in future

```swift
case toponym = 1
```

City, street, house etc

```swift
case business = 2
```

Company with specific location

```swift
case transit = 3
```

Public transport route number or transit-related keyword

```swift
case link = 4
```

Web link or deep link

## Enum cases

### unknown

```swift
case unknown = 0
```

For backward compatibility in future.

### toponym

```swift
case toponym = 1
```

City, street, house etc.

### business

```swift
case business = 2
```

Company with specific location.

### transit

```swift
case transit = 3
```

Public transport route number or transit-related keyword.

### link

```swift
case link = 4
```

Web link or deep link
