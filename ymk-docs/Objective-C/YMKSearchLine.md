---
title: "YMKSearchLine"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchLine"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLine.html"
---
# YMKSearchLine

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLine.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchLine : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchLine *)lineWithName:(nonnull NSString *)name;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Name of the line that the nearest stop is on

## Class methods

### lineWithName:

```objectivec
+ (nonnull YMKSearchLine *)lineWithName:(nonnull NSString *)name;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Name of the line that the nearest stop is on.
