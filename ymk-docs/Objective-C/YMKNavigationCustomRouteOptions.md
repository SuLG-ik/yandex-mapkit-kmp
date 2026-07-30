---
title: "YMKNavigationCustomRouteOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationCustomRouteOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationCustomRouteOptions.html"
---
# YMKNavigationCustomRouteOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationCustomRouteOptions.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationCustomRouteOptions : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKNavigationCustomRouteOptions *)customRouteOptionsWithAllowMoreUturns:(nullable NSNumber *)allowMoreUturns;
```

### Properties

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *allowMoreUturns;
```

Enabling this option will reduce the total route mileage but will include more u-turns along the route

Optional field, can be nil

## Class methods

### customRouteOptionsWithAllowMoreUturns:

```objectivec
+ (nonnull YMKNavigationCustomRouteOptions *)customRouteOptionsWithAllowMoreUturns:(nullable NSNumber *)allowMoreUturns;
```

## Properties

### allowMoreUturns

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *allowMoreUturns;
```

Enabling this option will reduce the total route mileage but will include more u-turns along the route

Optional field, can be nil.
