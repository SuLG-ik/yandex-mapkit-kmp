---
title: "YMKDrivingTollPost"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingTollPost"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingTollPost.html"
---
# YMKDrivingTollPost

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingTollPost.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingTollPost : NSObject
```

A toll post object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingTollPost *)tollPostWithPosition:(nonnull YMKPolylinePosition *)position
                                                  id:(nullable NSNumber *)id
                                   time_with_traffic:(nullable NSNumber *)time_with_traffic
                                    nonTransactional:(nullable NSNumber *)nonTransactional;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *id;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *time_with_traffic;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *nonTransactional;
```

Optional field, can be nil

## Class methods

### tollPostWithPosition:id:time_with_traffic:nonTransactional:

```objectivec
+ (nonnull YMKDrivingTollPost *)tollPostWithPosition:(nonnull YMKPolylinePosition *)position
                                                  id:(nullable NSNumber *)id
                                   time_with_traffic:(nullable NSNumber *)time_with_traffic
                                    nonTransactional:(nullable NSNumber *)nonTransactional;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

### id

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *id;
```

Optional field, can be nil.

### time_with_traffic

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *time_with_traffic;
```

Optional field, can be nil.

### nonTransactional

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *nonTransactional;
```

Optional field, can be nil.
