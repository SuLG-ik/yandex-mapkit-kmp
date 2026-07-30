---
title: "YMKPoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPoint.html"
---
# YMKPoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPoint.html)

```objectivec
@interface YMKPoint : NSObject
```

A point at the specified coordinates.

## Summary

### Class methods

```objectivec
+ (nonnull YMKPoint *)pointWithLatitude:( double)latitude
                              longitude:( double)longitude;
```

### Properties

```objectivec
@property (nonatomic, readonly) double latitude;
```

The point's latitude

```objectivec
@property (nonatomic, readonly) double longitude;
```

The point's longitude

## Class methods

### pointWithLatitude:longitude:

```objectivec
+ (nonnull YMKPoint *)pointWithLatitude:( double)latitude
                              longitude:( double)longitude;
```

## Properties

### latitude

```objectivec
@property (nonatomic, readonly) double latitude;
```

The point's latitude.

### longitude

```objectivec
@property (nonatomic, readonly) double longitude;
```

The point's longitude.
