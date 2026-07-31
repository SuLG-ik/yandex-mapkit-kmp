---
title: "YMKBalloonViewListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKBalloonViewListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloonViewListener.html"
---
# YMKBalloonViewListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloonViewListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKBalloonViewListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)onBalloonViewsChangedWithRoute:(nonnull YMKRouteView *)route;
```

```objectivec
- (void)onBalloonViewTapWithBalloon:(nonnull YMKBalloonView *)balloon;
```

```objectivec
- (void)onBalloonVisibilityChangedWithBalloon:(nonnull YMKBalloonView *)balloon;
```

```objectivec
- (void)onBalloonContentChangedWithBalloon:(nonnull YMKBalloonView *)balloon;
```

called on BalloonView

## Instance methods

### onBalloonViewsChangedWithRoute:

```objectivec
- (void)onBalloonViewsChangedWithRoute:(nonnull YMKRouteView *)route;
```

### onBalloonViewTapWithBalloon:

```objectivec
- (void)onBalloonViewTapWithBalloon:(nonnull YMKBalloonView *)balloon;
```

### onBalloonVisibilityChangedWithBalloon:

```objectivec
- (void)onBalloonVisibilityChangedWithBalloon:(nonnull YMKBalloonView *)balloon;
```

### onBalloonContentChangedWithBalloon:

```objectivec
- (void)onBalloonContentChangedWithBalloon:(nonnull YMKBalloonView *)balloon;
```

called on BalloonView.balloon changing
