---
title: "YMKNavigationStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKNavigationStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationStyleProvider.html"
---
# YMKNavigationStyleProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKNavigationStyleProvider <NSObject>
```

Provides default style and icons when for navigation_layer objects when their look is refreshed (for example on creation or on night mode switch).

## Summary

### Instance methods

```objectivec
- (nonnull id<YMKNavigationRouteViewStyleProvider>)routeViewStyleProvider;
```

```objectivec
- (nonnull id<YMKNavigationBalloonImageProvider>)balloonImageProvider;
```

```objectivec
- (nonnull id<YMKNavigationRequestPointStyleProvider>)requestPointStyleProvider;
```

```objectivec
- (nonnull id<YMKNavigationUserPlacemarkStyleProvider>)
    userPlacemarkStyleProvider;
```

```objectivec
- (nonnull id<YMKNavigationRoutePinsStyleProvider>)routePinsStyleProvider;
```

```objectivec
- (nonnull id<YMKHighlightStyleProvider>)highlightStyleProvider;
```

## Instance methods

### routeViewStyleProvider

```objectivec
- (nonnull id<YMKNavigationRouteViewStyleProvider>)routeViewStyleProvider;
```

### balloonImageProvider

```objectivec
- (nonnull id<YMKNavigationBalloonImageProvider>)balloonImageProvider;
```

### requestPointStyleProvider

```objectivec
- (nonnull id<YMKNavigationRequestPointStyleProvider>)requestPointStyleProvider;
```

### userPlacemarkStyleProvider

```objectivec
- (nonnull id<YMKNavigationUserPlacemarkStyleProvider>)
    userPlacemarkStyleProvider;
```

### routePinsStyleProvider

```objectivec
- (nonnull id<YMKNavigationRoutePinsStyleProvider>)routePinsStyleProvider;
```

### highlightStyleProvider

```objectivec
- (nonnull id<YMKHighlightStyleProvider>)highlightStyleProvider;
```
