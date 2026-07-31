---
title: "YMKMasstransitTaxi"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTaxi"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTaxi.html"
---
# YMKMasstransitTaxi

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTaxi.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTaxi : NSObject
```

Represents a taxi part of route.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTaxi *)taxiWithJamSegments:(nonnull NSArray<YMKJamSegment *> *)jamSegments;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKJamSegment *> *jamSegments;
```

Traffic conditions on the given part of route

## Class methods

### taxiWithJamSegments:

```objectivec
+ (nonnull YMKMasstransitTaxi *)taxiWithJamSegments:(nonnull NSArray<YMKJamSegment *> *)jamSegments;
```

## Properties

### jamSegments

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKJamSegment *> *jamSegments;
```

Traffic conditions on the given part of route.
