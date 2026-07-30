---
title: "YMKOverzoomMode"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKOverzoomMode"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOverzoomMode.html"
---
# YMKOverzoomMode

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOverzoomMode.html)

```swift
enum YMKOverzoomMode : UInt, @unchecked Sendable
```

## Summary

### Enum cases

```swift
case disabled = 0
```

Overzoom is fully disabled

```swift
case enabled = 1
```

If a tile is absent or translucent, tiles from lower or higher zooms will be shown

```swift
case withPrefetch = 2
```

Same as Enabled, plus it fetches tiles well below absent or translucent tiles that don't have any overzoom tiles to replace them with

## Enum cases

### disabled

```swift
case disabled = 0
```

Overzoom is fully disabled.

### enabled

```swift
case enabled = 1
```

If a tile is absent or translucent, tiles from lower or higher zooms will be shown.

### withPrefetch

```swift
case withPrefetch = 2
```

Same as Enabled, plus it fetches tiles well below absent or translucent tiles that don't have any overzoom tiles to replace them with.
