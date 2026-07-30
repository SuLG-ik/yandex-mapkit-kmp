---
title: "YMKPlacemarkIconType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKPlacemarkIconType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkIconType.html"
---
# YMKPlacemarkIconType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkIconType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKPlacemarkIconType : UInt, @unchecked Sendable
```

Possible placemark icon types

## Summary

### Enum cases

```swift
case none = 0
```

No icon

```swift
case dust = 1
```

Dust

```swift
case dustVisited = 2
```

Dust, search result is already visited

```swift
case icon = 3
```

Icon

```swift
case iconVisited = 4
```

Icon, search result is already visited

```swift
case labelShortLeft = 5
```

One-line label to the left of the icon

```swift
case labelShortRight = 6
```

One-line label to the right of the icon

```swift
case labelDetailedLeft = 7
```

Detailed label to the left of the icon

```swift
case labelDetailedRight = 8
```

Detailed label to the right of the icon

```swift
case selected = 9
```

Search result is selected

## Enum cases

### none

```swift
case none = 0
```

No icon. This type will never be passed to `AssetsProvider` methods.

### dust

```swift
case dust = 1
```

Dust.

### dustVisited

```swift
case dustVisited = 2
```

Dust, search result is already visited.

### icon

```swift
case icon = 3
```

Icon.

### iconVisited

```swift
case iconVisited = 4
```

Icon, search result is already visited.

### labelShortLeft

```swift
case labelShortLeft = 5
```

One-line label to the left of the icon.

### labelShortRight

```swift
case labelShortRight = 6
```

One-line label to the right of the icon.

### labelDetailedLeft

```swift
case labelDetailedLeft = 7
```

Detailed label to the left of the icon.

### labelDetailedRight

```swift
case labelDetailedRight = 8
```

Detailed label to the right of the icon.

### selected

```swift
case selected = 9
```

Search result is selected.
