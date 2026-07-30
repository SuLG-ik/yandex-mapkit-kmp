---
title: "YMKBicycleRestrictedEntry"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleRestrictedEntry"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleRestrictedEntry.html"
---
# YMKBicycleRestrictedEntry

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleRestrictedEntry.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleRestrictedEntry : NSObject
```

Special point on the route (like gates).

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleRestrictedEntry *)restrictedEntryWithPosition:(nonnull YMKPolylinePosition *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

Entry position on the route polyline

## Class methods

### restrictedEntryWithPosition:

```objectivec
+ (nonnull YMKBicycleRestrictedEntry *)restrictedEntryWithPosition:(nonnull YMKPolylinePosition *)position;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

Entry position on the route polyline.
