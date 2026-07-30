---
title: "YMKMasstransitAnnotation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitAnnotation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitAnnotation.html"
---
# YMKMasstransitAnnotation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitAnnotation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitAnnotation : NSObject
```

Contains info about actions on part of route. Either `action` or `landmark` should be non-empty.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitAnnotation *)annotationWithPosition:(nonnull YMKPolylinePosition *)position
                                                      action:(nullable NSNumber *)action
                                                    landmark:(nullable NSNumber *)landmark
                                                     toponym:(nullable YMKMasstransitToponym *)toponym;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

Position of annotation on part of route

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *action;
```

Action

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *landmark;
```

Landmark

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitToponym *toponym;
```

The toponym of the location

## Class methods

### annotationWithPosition:action:landmark:toponym:

```objectivec
+ (nonnull YMKMasstransitAnnotation *)annotationWithPosition:(nonnull YMKPolylinePosition *)position
                                                      action:(nullable NSNumber *)action
                                                    landmark:(nullable NSNumber *)landmark
                                                     toponym:(nullable YMKMasstransitToponym *)toponym;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

Position of annotation on part of route

### action

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *action;
```

Action

Optional field, can be nil.

### landmark

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *landmark;
```

Landmark

Optional field, can be nil.

### toponym

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitToponym *toponym;
```

The toponym of the location.

Optional field, can be nil.
