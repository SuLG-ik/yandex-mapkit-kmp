---
title: "YMKDrivingRestrictedEntry"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingRestrictedEntry"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRestrictedEntry.html"
---
# YMKDrivingRestrictedEntry

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRestrictedEntry.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingRestrictedEntry : NSObject
```

A restricted entry object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingRestrictedEntry *)restrictedEntryWithPosition:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the restricted entry

## Class methods

### restrictedEntryWithPosition:

```objectivec
+ (nonnull YMKDrivingRestrictedEntry *)restrictedEntryWithPosition:(nonnull YMKPolylinePosition *)position;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the restricted entry.
