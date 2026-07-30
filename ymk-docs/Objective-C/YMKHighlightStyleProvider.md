---
title: "YMKHighlightStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKHighlightStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKHighlightStyleProvider.html"
---
# YMKHighlightStyleProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKHighlightStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKHighlightStyleProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (nullable YMKSpeedControlHighlightStyle *)
    provideSpeedControlStyleWithIsNightMode:(BOOL)isNightMode
                              highlightMode:(YMKHighlightMode)highlightMode;
```

## Instance methods

### provideSpeedControlStyleWithIsNightMode:highlightMode:

```objectivec
- (nullable YMKSpeedControlHighlightStyle *)
    provideSpeedControlStyleWithIsNightMode:(BOOL)isNightMode
                              highlightMode:(YMKHighlightMode)highlightMode;
```
