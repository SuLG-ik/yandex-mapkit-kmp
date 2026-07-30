---
title: "YMKMasstransitBoardingOptionsBoardingArea"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitBoardingOptionsBoardingArea"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitBoardingOptionsBoardingArea.html"
---
# YMKMasstransitBoardingOptionsBoardingArea

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitBoardingOptionsBoardingArea.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitBoardingOptionsBoardingArea : NSObject
```

Area recommended for boarding: wagon, sector, etc.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitBoardingOptionsBoardingArea *)boardingAreaWithId:(nullable NSString *)id;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *id;
```

Machine-readable non-localisable boarding area identifier

## Class methods

### boardingAreaWithId:

```objectivec
+ (nonnull YMKMasstransitBoardingOptionsBoardingArea *)boardingAreaWithId:(nullable NSString *)id;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nullable) NSString *id;
```

Machine-readable non-localisable boarding area identifier.

Optional field, can be nil.
