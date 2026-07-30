---
title: "YMKBalloonView"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBalloonView"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloonView.html"
---
# YMKBalloonView

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloonView.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKBalloonView : NSObject
```

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKBalloonAnchor *anchor;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKBalloon *balloon;
```

```objectivec
@property (nonatomic, readonly, getter=isIsVisible) BOOL isVisible;
```

True if balloon currently visible on the screen

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isIsEnabled)
    BOOL isEnabled;
```

If 'true', balloons will be shown whenever it possible

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingRoute *hostRoute;
```

The route to which this balloon belongs

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Properties

### anchor

```objectivec
@property (nonatomic, readonly, nonnull) YMKBalloonAnchor *anchor;
```

### balloon

```objectivec
@property (nonatomic, readonly, nonnull) YMKBalloon *balloon;
```

### isVisible

```objectivec
@property (nonatomic, readonly, getter=isIsVisible) BOOL isVisible;
```

True if balloon currently visible on the screen. Always false if balloon disabled

### isEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isIsEnabled)
    BOOL isEnabled;
```

If 'true', balloons will be shown whenever it possible. If 'false', balloons will be always hidden. `BalloonViewListener.onBalloonContentChanged` is called regardless of isEnabled value. `RouteView.showBalloons` call changes this attribute. Enabled by default.

### hostRoute

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingRoute *hostRoute;
```

The route to which this balloon belongs.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
