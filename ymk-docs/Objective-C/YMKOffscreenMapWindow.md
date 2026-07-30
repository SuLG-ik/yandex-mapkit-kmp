---
title: "YMKOffscreenMapWindow"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKOffscreenMapWindow"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOffscreenMapWindow.html"
---
# YMKOffscreenMapWindow

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOffscreenMapWindow.html)

```objectivec
@interface YMKOffscreenMapWindow : NSObject
```

Wraps YMKMapWindow without its own view to render. Allows to render map on additional surfaces in separate processes without having to create MapView control in the main process.

## Summary

### Instance methods

```objectivec
- (nonnull UIImage *)captureScreenshot;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMapWindow *mapWindow;
```

## Instance methods

### captureScreenshot

```objectivec
- (nonnull UIImage *)captureScreenshot;
```

## Properties

### mapWindow

```objectivec
@property (nonatomic, readonly, nonnull) YMKMapWindow *mapWindow;
```
