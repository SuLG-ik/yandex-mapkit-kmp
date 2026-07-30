---
title: "YMKRouteViewListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKRouteViewListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteViewListener.html"
---
# YMKRouteViewListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteViewListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKRouteViewListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)onRouteViewsChanged;
```

```objectivec
- (void)onRouteViewTapWithRoute:(nonnull YMKRouteView *)route;
```

## Instance methods

### onRouteViewsChanged

```objectivec
- (void)onRouteViewsChanged;
```

### onRouteViewTapWithRoute:

```objectivec
- (void)onRouteViewTapWithRoute:(nonnull YMKRouteView *)route;
```
