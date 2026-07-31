---
title: "YMKOverzoomMode"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKOverzoomMode"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOverzoomMode.html"
---
# YMKOverzoomMode

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOverzoomMode.html)

```objectivec
enum YMKOverzoomMode : NSUInteger {}
```

## Summary

### Enum cases

```objectivec
YMKOverzoomModeDisabled
```

Overzoom is fully disabled

```objectivec
YMKOverzoomModeEnabled
```

If a tile is absent or translucent, tiles from lower or higher zooms will be shown

```objectivec
YMKOverzoomModeWithPrefetch
```

Same as Enabled, plus it fetches tiles well below absent or translucent tiles that don't have any overzoom tiles to replace them with

## Enum cases

### YMKOverzoomModeDisabled

```objectivec
YMKOverzoomModeDisabled
```

Overzoom is fully disabled.

### YMKOverzoomModeEnabled

```objectivec
YMKOverzoomModeEnabled
```

If a tile is absent or translucent, tiles from lower or higher zooms will be shown.

### YMKOverzoomModeWithPrefetch

```objectivec
YMKOverzoomModeWithPrefetch
```

Same as Enabled, plus it fetches tiles well below absent or translucent tiles that don't have any overzoom tiles to replace them with.
