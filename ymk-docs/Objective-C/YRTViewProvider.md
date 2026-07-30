---
title: "YRTViewProvider"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTViewProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTViewProvider.html"
---
# YRTViewProvider

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTViewProvider.html)

```objectivec
@interface YRTViewProvider : NSObject {
  BOOL _cacheable;
}
```

This class can be used to associate any custom view with PlacemarkMapObject. Snapshot of provided view is taken in constructor and updated any time snapshot method is called by user.

## Summary

### Instance methods

```objectivec
- (id)initWithUIView:(UIView *)view cacheable:(BOOL)cacheable;
```

Constructor of YRTViewProvider

```objectivec
- (id)initWithUIView:(UIView *)view;
```

Constructor of YRTViewProvider

```objectivec
- (void)snapshot;
```

Takes a snapshot of the given view

### Instance variables

```objectivec
BOOL _cacheable
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL cacheable;
```

True if view provider is cacheable

## Instance methods

### initWithUIView:cacheable:

```objectivec
- (id)initWithUIView:(UIView *)view cacheable:(BOOL)cacheable;
```

Constructor of YRTViewProvider. Attention: This blocks the UI via executing snapshot function.

### initWithUIView:

```objectivec
- (id)initWithUIView:(UIView *)view;
```

Constructor of YRTViewProvider. Cacheable flag will have YES value by default. Attention: This blocks the UI via executing snapshot function.

### snapshot

```objectivec
- (void)snapshot;
```

Takes a snapshot of the given view. Attention: This blocks the UI.

## Instance variables

### _cacheable

```objectivec
BOOL _cacheable
```

## Properties

### cacheable

```objectivec
@property (nonatomic, readonly) BOOL cacheable;
```

True if view provider is cacheable. False otherwise.
