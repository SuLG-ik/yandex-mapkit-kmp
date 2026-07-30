---
title: "YMKDrivingEvent"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingEvent.html"
---
# YMKDrivingEvent

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingEvent.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingEvent : NSObject
```

Road event.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingEvent *)eventWithPolylinePosition:(nonnull YMKPolylinePosition *)polylinePosition
                                               eventId:(nonnull NSString *)eventId
                                       descriptionText:(nullable NSString *)descriptionText
                                                  tags:(nonnull NSArray<NSNumber *> *)tags
                                              location:(nonnull YMKPoint *)location
                                            speedLimit:(nullable NSNumber *)speedLimit;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *polylinePosition;
```

The position of the polyline

```objectivec
@property (nonatomic, readonly, nonnull) NSString *eventId;
```

The unique ID of the event

```objectivec
@property (nonatomic, readonly, nullable) NSString *descriptionText;
```

The description of the event

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tags;
```

The types of the road event

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *location;
```

The location of the road event

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *speedLimit;
```

The speed limit on the road

## Class methods

### eventWithPolylinePosition:eventId:descriptionText:tags:location:speedLimit:

```objectivec
+ (nonnull YMKDrivingEvent *)eventWithPolylinePosition:(nonnull YMKPolylinePosition *)polylinePosition
                                               eventId:(nonnull NSString *)eventId
                                       descriptionText:(nullable NSString *)descriptionText
                                                  tags:(nonnull NSArray<NSNumber *> *)tags
                                              location:(nonnull YMKPoint *)location
                                            speedLimit:(nullable NSNumber *)speedLimit;
```

## Properties

### polylinePosition

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *polylinePosition;
```

The position of the polyline.

### eventId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *eventId;
```

The unique ID of the event.

### descriptionText

```objectivec
@property (nonatomic, readonly, nullable) NSString *descriptionText;
```

The description of the event.

Optional field, can be nil.

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tags;
```

The types of the road event.

### location

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *location;
```

The location of the road event.

### speedLimit

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *speedLimit;
```

The speed limit on the road. Valid only for cameras.

Optional field, can be nil.
