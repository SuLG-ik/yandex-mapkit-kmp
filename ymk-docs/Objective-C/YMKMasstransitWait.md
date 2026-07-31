---
title: "YMKMasstransitWait"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitWait"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitWait.html"
---
# YMKMasstransitWait

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitWait.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitWait : NSObject
```

Represents a 'wait until suitable tranport arrives' section of a route.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitWait *)waitWithDummy:( NSUInteger)dummy;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger dummy;
```

Dummy object

## Class methods

### waitWithDummy:

```objectivec
+ (nonnull YMKMasstransitWait *)waitWithDummy:( NSUInteger)dummy;
```

## Properties

### dummy

```objectivec
@property (nonatomic, readonly) NSUInteger dummy;
```

Dummy object.
