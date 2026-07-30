---
title: "YRTFlutterViewFactory"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTFlutterViewFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTFlutterViewFactory.html"
---
# YRTFlutterViewFactory

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTFlutterViewFactory.html)

##@interface *[YRTFlutterViewFactory](YRTFlutterViewFactory.md)*: NSObject

+ (int64_t)getPlatformViewAddress:(UIView*)view;

+ (*[YRTFlutterLifecycleProvider](YRTFlutterLifecycleProvider.md)**)createLifecycleProvider;

+ (UIView*)createPlatformView:(CGRect)frame

            lifecycleProvider:(*[YRTFlutterLifecycleProvider](YRTFlutterLifecycleProvider.md)**)lifecycleProvider;

+ (void)startPlatformView:(UIView*)view

        lifecycleProvider:(*[YRTFlutterLifecycleProvider](YRTFlutterLifecycleProvider.md)**)lifecycleProvider;

@end##

## Summary

### Class methods

```objectivec
+ (int64_t)getPlatformViewAddress:(UIView*)view;
```

```objectivec
+ (YRTFlutterLifecycleProvider*)createLifecycleProvider;
```

```objectivec
+ (UIView*)createPlatformView:(CGRect)frame
            lifecycleProvider:(YRTFlutterLifecycleProvider*)lifecycleProvider;
```

```objectivec
+ (void)startPlatformView:(UIView*)view
        lifecycleProvider:(YRTFlutterLifecycleProvider*)lifecycleProvider;
```

## Class methods

### getPlatformViewAddress:

```objectivec
+ (int64_t)getPlatformViewAddress:(UIView*)view;
```

### createLifecycleProvider

```objectivec
+ (YRTFlutterLifecycleProvider*)createLifecycleProvider;
```

### createPlatformView:lifecycleProvider:

```objectivec
+ (UIView*)createPlatformView:(CGRect)frame
            lifecycleProvider:(YRTFlutterLifecycleProvider*)lifecycleProvider;
```

### startPlatformView:lifecycleProvider:

```objectivec
+ (void)startPlatformView:(UIView*)view
        lifecycleProvider:(YRTFlutterLifecycleProvider*)lifecycleProvider;
```
