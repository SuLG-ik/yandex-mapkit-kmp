---
title: "YMKSuggestItemAction"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSuggestItemAction"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestItemAction.html"
---
# YMKSuggestItemAction

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestItemAction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKSuggestItemAction : UInt, @unchecked Sendable
```

Action to be performed when user selected suggest item.

## Summary

### Enum cases

```swift
case search = 0
```

Immediately search for `text`

```swift
case substitute = 1
```

Substitute query by `text` for further editing

```swift
case followLink = 2
```

Exit suggest session and open link

## Enum cases

### search

```swift
case search = 0
```

Immediately search for `text`.

### substitute

```swift
case substitute = 1
```

Substitute query by `text` for further editing.

### followLink

```swift
case followLink = 2
```

Exit suggest session and open link
