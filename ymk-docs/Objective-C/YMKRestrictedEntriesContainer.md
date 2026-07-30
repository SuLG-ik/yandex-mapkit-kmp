---
title: "YMKRestrictedEntriesContainer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRestrictedEntriesContainer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRestrictedEntriesContainer.html"
---
# YMKRestrictedEntriesContainer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRestrictedEntriesContainer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKRestrictedEntriesContainer : NSObject
```

Defines a vector of points on a pedestrian path.

## Summary

### Class methods

```objectivec
+ (nonnull YMKRestrictedEntriesContainer *)restrictedEntriesContainerWithEntries:(nonnull NSArray<YMKRestrictedEntry *> *)entries;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKRestrictedEntry *> *entries;
```

Vector of points on a pedestrian path

## Class methods

### restrictedEntriesContainerWithEntries:

```objectivec
+ (nonnull YMKRestrictedEntriesContainer *)restrictedEntriesContainerWithEntries:(nonnull NSArray<YMKRestrictedEntry *> *)entries;
```

## Properties

### entries

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKRestrictedEntry *> *entries;
```

Vector of points on a pedestrian path.
