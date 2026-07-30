---
title: "YMKRestrictedEntry"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRestrictedEntry"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRestrictedEntry.html"
---
# YMKRestrictedEntry

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRestrictedEntry.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKRestrictedEntry : NSObject
```

Defines a point on a pedestrian path.

## Summary

### Class methods

```objectivec
+ (nonnull YMKRestrictedEntry *)restrictedEntryWithPosition:( NSUInteger)position;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger position;
```

Index of the point in the section geometry

## Class methods

### restrictedEntryWithPosition:

```objectivec
+ (nonnull YMKRestrictedEntry *)restrictedEntryWithPosition:( NSUInteger)position;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly) NSUInteger position;
```

Index of the point in the section geometry.
