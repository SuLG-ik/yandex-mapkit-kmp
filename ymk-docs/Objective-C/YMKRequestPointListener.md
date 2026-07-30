---
title: "YMKRequestPointListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKRequestPointListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRequestPointListener.html"
---
# YMKRequestPointListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRequestPointListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKRequestPointListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)onRequestPointsChanged;
```

```objectivec
- (void)onRequestPointTapWithRequestPointIndex:(NSUInteger)requestPointIndex;
```

## Instance methods

### onRequestPointsChanged

```objectivec
- (void)onRequestPointsChanged;
```

### onRequestPointTapWithRequestPointIndex:

```objectivec
- (void)onRequestPointTapWithRequestPointIndex:(NSUInteger)requestPointIndex;
```
