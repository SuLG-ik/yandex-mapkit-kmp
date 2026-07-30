---
title: "YMKNavigationFactory"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationFactory.html"
---
# YMKNavigationFactory

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationFactory.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationFactory : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKNavigation *)createNavigationWithType:(YMKDrivingRouterType)type;
```

Creates navigation engine with given options

## Class methods

### createNavigationWithType:

```objectivec
+ (nonnull YMKNavigation *)createNavigationWithType:(YMKDrivingRouterType)type;
```

Creates navigation engine with given options. Each call returns new independent instance of Navigation. Navigation will be in the suspended mode.
