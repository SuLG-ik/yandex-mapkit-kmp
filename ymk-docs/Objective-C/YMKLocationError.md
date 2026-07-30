---
title: "YMKLocationError"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLocationError"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationError.html"
---
# YMKLocationError

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationError.html)

```objectivec
@interface YMKLocationError : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKLocationError *)locationErrorWithLateralErrorRange:(nonnull YMKRange *)lateralErrorRange
                                          longitudinalErrorRange:(nonnull YMKRange *)longitudinalErrorRange;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKRange *lateralErrorRange;
```

The error of spreading locations across the route

```objectivec
@property (nonatomic, readonly, nonnull) YMKRange *longitudinalErrorRange;
```

The error of spreading locations along the route

## Class methods

### locationErrorWithLateralErrorRange:longitudinalErrorRange:

```objectivec
+ (nonnull YMKLocationError *)locationErrorWithLateralErrorRange:(nonnull YMKRange *)lateralErrorRange
                                          longitudinalErrorRange:(nonnull YMKRange *)longitudinalErrorRange;
```

## Properties

### lateralErrorRange

```objectivec
@property (nonatomic, readonly, nonnull) YMKRange *lateralErrorRange;
```

The error of spreading locations across the route.

### longitudinalErrorRange

```objectivec
@property (nonatomic, readonly, nonnull) YMKRange *longitudinalErrorRange;
```

The error of spreading locations along the route.
